package com.grepp.day0813_web;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/dd")
public class ServletD extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("---ServletD의 doGet 호출됨! 아마도 redirect...---");
        System.out.println("client ip 주소 : "+req.getRemoteAddr());
        System.out.println("요청 url : "+req.getServletPath());
        System.out.println("phone 파라미터 값 : "+req.getParameter("phone"));

        resp.setContentType("text/html");

        PrintWriter out = resp.getWriter();
        out.println("<html><body>");
        out.println("<h1>이 곳은 ServletD가 작성한 html 화면입니다!!!!</h1>");
        out.println("</body></html>");
    }
}
