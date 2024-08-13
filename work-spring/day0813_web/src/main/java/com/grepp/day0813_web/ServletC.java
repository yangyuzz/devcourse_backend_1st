package com.grepp.day0813_web;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/cc")
public class ServletC extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("---ServletC의 doGet 호출됨! 현재 들어온 요청에 담겨있는 다양한 정보---");
        System.out.println("client ip 주소 : "+req.getRemoteAddr());
        System.out.println("요청 url : "+req.getServletPath());
        System.out.println("phone 파라미터 값 : "+req.getParameter("phone"));

        resp.sendRedirect("dd"); // redirect !!!
    }
}
