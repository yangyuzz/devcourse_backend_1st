package com.grepp.cookie;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/makeCookie")
public class MakeServlet extends HttpServlet {
    static int cooNum=0;
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("쿠키 발급 요청이 들어와서 쿠키를 발급합니다."+cooNum);

        Cookie cookie = new Cookie("yangyuCookie"+cooNum, "hi"+cooNum); // 쿠키이름, 쿠키값
//        cookie.setMaxAge(60*5); // 쿠키 유효시간 설정
//        cookie.setDomain("promrammers.co.kr"); // 이 쿠키를 들고갈 도메인
//        cookie.setPath("/checkCookir"); // 도메인 뒤의 세부 path
        resp.addCookie(cookie);
        cooNum++;

        req.getRequestDispatcher("/WEB-INF/views/makeCookie.jsp").forward(req,resp); // html 화면 하나 만들어라~
    }
}
