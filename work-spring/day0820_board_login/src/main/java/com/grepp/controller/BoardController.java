package com.grepp.controller;

import com.grepp.controller.util.MyPageInfo;
import com.grepp.model.dto.BoardDTO;
import com.grepp.model.service.BoardService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.sql.SQLException;
import java.util.List;

// /board/~~~.do 는 여기로 실행되겠네요.
public class BoardController implements MyController{
    private BoardService service = BoardService.getInstance();

    @Override
    public Object handleRequest(HttpServletRequest req, HttpServletResponse resp) throws SQLException {
        String url = req.getServletPath();
        if("/board/list.do".equals(url)){ // 목록보기
            List<BoardDTO> boardList = service.getBoards();
            req.setAttribute("bList", boardList); // bList라는 데이터 jsp한테 보낼거에염
            return new MyPageInfo(true, "/list"); // /WEB-INF/views/list.jsp
        }else if("/board/read.do".equals(url)){ // 상세내용 보기
            int no = Integer.parseInt(req.getParameter("no"));
            req.setAttribute("bbb", service.read(no)); // 모델한테 일시키기. bbb라는 데이터를 보내자!
            return new MyPageInfo(true, "/view"); // /WEB-INF/views/view.jsp
        } else if("/board/writeForm.do".equals(url)){ // 글 작성하러 가기
            return new MyPageInfo(true, "/write_form");
        } else if("/board/write.do".equals(url)){ // 글 작성 완료
            String title = req.getParameter("title");
            String content = req.getParameter("content");
            String writer = (String)req.getSession().getAttribute("loginId"); // 로그인 안한 사용자는 MainServlet쪽에서 걸러져서 이 컨트롤러 못옴.
            service.write(new BoardDTO(title, content, writer));
//            return new MyPageInfo(true, "/main"); // 이렇게 forward 하는 경우 기존 req가 직전 요청이 되고 새로고침 하면 같은게 또 write 됨.
            return new MyPageInfo(false, "/main.do");
        }
        return null;
    }
}
