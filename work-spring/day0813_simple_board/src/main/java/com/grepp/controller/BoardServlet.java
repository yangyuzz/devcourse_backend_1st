package com.grepp.controller;

import com.grepp.model.BoardDTO;
import com.grepp.model.BoardRepository;
import com.grepp.model.BoardRepositoryMysql;
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
    private BoardRepository repo = BoardRepositoryMysql.getInstance();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");

        // 클라이언트가 어떤 링크를 클릭했는지에 따라 다른 행동을 해줘야 함.
        try {
            if ("list".equals(action)) {
                List<BoardDTO> boardList = repo.selectAll();
//                System.out.println(boardList);
                req.setAttribute("bList", boardList);
                req.getRequestDispatcher("/WEB-INF/views/list.jsp").forward(req,resp);
            } else if ("writeForm".equals(action)) {

            }
        } catch (SQLException e) {
            e.printStackTrace();
            req.getRequestDispatcher("/WEB-INF/views/common/error.jsp").forward(req,resp);
        }
    }
}


















