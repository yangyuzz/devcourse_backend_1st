package com.grepp.cookie;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/checkCookie")
public class CheckServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("-----------" +req.getRemoteAddr());
        Cookie[] cookies = req.getCookies();
        if(cookies!=null) {
            for (Cookie c : cookies) {
                System.out.println(c.getName() + "//" + c.getValue());
            }
        }
        System.out.println("--------------------------------------");

        req.getRequestDispatcher("/WEB-INF/views/checkCookie.jsp").forward(req,resp);
    }

}
