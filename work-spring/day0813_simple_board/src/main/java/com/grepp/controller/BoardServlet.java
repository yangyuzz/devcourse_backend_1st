package com.grepp.controller;

import com.grepp.model.BoardDTO;
import com.grepp.model.BoardRepository;
import com.grepp.model.BoardRepositoryMysql;
import com.grepp.model.BoardService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet("/board.do")
public class BoardServlet extends HttpServlet {
    // DB 작업하는 repo를 직접 호출하지 않고, 비즈니스 로직 처리까지 진행하는 service를 의존함.
//    private BoardRepository repo = BoardRepositoryMysql.getInstance();
    private BoardService service = BoardService.getInstance();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");

        // 클라이언트가 어떤 링크를 클릭했는지에 따라 다른 행동을 해줘야 함.
        try {
            if ("list".equals(action)) {
//                List<BoardDTO> boardList = repo.selectAll(); // SQL 무조건 실행시키지 말고
                List<BoardDTO> boardList = service.getBoards();
//                System.out.println(boardList);
                req.setAttribute("bList", boardList);
                req.getRequestDispatcher("/WEB-INF/views/list.jsp").forward(req,resp);
            } else if ("writeForm".equals(action)) { // 글 쓰고 싶다고 하네??
                req.getRequestDispatcher("/WEB-INF/views/writeForm.jsp").forward(req,resp); // html 화면 만들어 줘라~~ 글 쓸수 있게~~
            } else if("view".equals(action)){
                String noParam = req.getParameter("no"); // "1" 이렇게 스트링으로 전달됨.
                int no = Integer.parseInt(noParam);

//                BoardDTO board = repo.selectOne(no); // DB에서 해당 게시글을 가져옴.  // SQL 무조건 실행시키지 말고
                BoardDTO board = service.read(no); // service가 뭔가 검사하거나 채워넣거나 암튼 로직 수행한 결과로 가져다 쓰자.
                req.setAttribute("bbb", board);
                req.getRequestDispatcher("/WEB-INF/views/view.jsp").forward(req, resp);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            req.getRequestDispatcher("/WEB-INF/views/common/error.jsp").forward(req,resp);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String title = req.getParameter("tttt");
        String content = req.getParameter("cccc");
        String writer = req.getParameter("wwww");

        BoardDTO boardDTO = new BoardDTO(title,content,writer);
        try {
//            int result = repo.insert(boardDTO);// SQL 무조건 실행시키지 말고
            int result = service.write(boardDTO);
//            if(result == 1){
//                req.getRequestDispatcher("/WEB-INF/views/success.jsp").forward(req, resp); // html 만들어라. 성공
//            }else{
//                req.getRequestDispatcher("/WEB-INF/views/fail.jsp").forward(req, resp); // html 만들어라. 실패
//            }
            if(result==1){
                resp.sendRedirect(req.getContextPath()+"/alert.do"); // 이러면 새로운 req가 생성될거니까 기존 req를 재사용 하는 상황은 막을수 있지. 다만 alert.do처리가 또 필요하지.
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
}


















