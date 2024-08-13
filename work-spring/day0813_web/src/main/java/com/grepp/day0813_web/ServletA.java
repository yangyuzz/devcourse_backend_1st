package com.grepp.day0813_web;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/aa") // bb한테 보내기 전에 요청을 먼저 받아서 처리하는 서블릿
public class ServletA extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("---ServletA의 doGet 호출됨! 현재 들어온 요청에 담겨있는 다양한 정보---");
        System.out.println("client ip 주소 : "+req.getRemoteAddr());
        System.out.println("요청 url : "+req.getServletPath());
        System.out.println("phone 파라미터 값 : "+req.getParameter("phone"));

        req.getRequestDispatcher("/bb").forward(req, resp); // forward
    }
}
