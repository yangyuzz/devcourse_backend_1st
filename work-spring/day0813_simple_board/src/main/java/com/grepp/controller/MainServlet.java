package com.grepp.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/main.do")
public class MainServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // main.jsp를 webapp에 안만들고 /WEB-INF/아래로 넣어버리는 이유는
        // 어떤 클라이언트가 url에 127.0.0.1:8080/simple/main.jsp 라는 요청을 보내면
        // webapp 폴더에 있는 jsp는 요청을 받을 수 있어짐.
        // 나는 MVC 구조를 준수할 예정이므로 jsp가 요청을 먼저 받아서 처리하는 경우는 아예 막아버릴거임.
        req.getRequestDispatcher("/WEB-INF/views/main.jsp").forward(req,resp);
    }
}
