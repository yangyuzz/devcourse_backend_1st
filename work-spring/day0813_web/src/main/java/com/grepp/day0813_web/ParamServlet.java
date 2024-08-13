package com.grepp.day0813_web;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/paramServlet")
public class ParamServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("param servlet doGet execute");
        System.out.println("receive param uname : "+ req.getParameter("uname"));
        System.out.println("receive param uage : "+ req.getParameter("uage"));
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("param servlet doPost execute");
        System.out.println("receive param uname : "+ req.getParameter("uname"));
        System.out.println("receive param uage : "+ req.getParameter("uage"));
    }
}
