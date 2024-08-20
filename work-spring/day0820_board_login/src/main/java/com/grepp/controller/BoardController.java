package com.grepp.controller;

import com.grepp.controller.util.MyPageInfo;
import com.grepp.model.dto.BoardDTO;
import com.grepp.model.service.BoardService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.sql.SQLException;
import java.util.List;

// /board.do 는 여기로 실행되겠네요.
public class BoardController implements MyController{
    private BoardService service = BoardService.getInstance();

    @Override
    public Object handleRequest(HttpServletRequest req, HttpServletResponse resp) throws SQLException {
        String url = req.getServletPath();
        if("/board/write.do".equals(url)){
            return new MyPageInfo(true, "/write"); // /WEB-INF/views/write.jsp
        }else if("/board/list.do".equals(url)){
            List<BoardDTO> boardList = service.getBoards();
            req.setAttribute("bList", boardList); // bList라는 데이터 jsp한테 보낼거에염
            return new MyPageInfo(true, "/list"); // /WEB-INF/views/list.jsp
        }else if("/board/read.do".equals(url)){
            int no = Integer.parseInt(req.getParameter("no"));
            req.setAttribute("bbb", service.read(no)); // 모델한테 일시키기. bbb라는 데이터를 보내자!
            return new MyPageInfo(true, "/view"); // /WEB-INF/views/view.jsp
        }
        return null;
    }
}
