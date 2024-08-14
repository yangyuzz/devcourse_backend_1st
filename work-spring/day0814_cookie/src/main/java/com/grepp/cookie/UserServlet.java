package com.grepp.cookie;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebServlet("/user")
public class UserServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");

        if("login".equals(action)){ // 로그인 하겠다고 ? 기존에 로그인한 상태 아닌지 체크한번 할게!
            HttpSession session = req.getSession();
            String loginId = (String)session.getAttribute("loginId");
            if(loginId==null) { // 로그인 안된 애네~ 로그인 html 화면 만들어 주지뭐~~
                req.getRequestDispatcher("/WEB-INF/views/login.jsp").forward(req, resp);
            } else { // 엥? 너 이미 로그인 되어있어!
                req.setAttribute("msg", "이미 로그인 내역 있습니다.");
                req.setAttribute("path", req.getContextPath()); // 맨 첫페이지로 보냄
                req.getRequestDispatcher("/WEB-INF/views/alert.jsp").forward(req,resp);
            }
        }else if("logout".equals(action)){
            HttpSession session = req.getSession();
            session.invalidate(); // removeAttribute("loginId") 해도 되지만 보통 지금 로그아웃하는 사용자의 정보 싹 날리느라 그냥 세션객체 자체를 없애버림.

            req.setAttribute("msg", "로그아웃 되었습니다.");
            req.setAttribute("path", req.getContextPath()); // 맨 첫페이지로 보냄
            req.getRequestDispatcher("/WEB-INF/views/alert.jsp").forward(req,resp);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String userid = req.getParameter("userid");
        String userpw = req.getParameter("userpw");

        if(userid.equals("grepp") && userpw.equals("1234")){
            // login success
            HttpSession session = req.getSession(); // 지금 요청보낸 사용자 전용 객체를 찾아낼 수 있음(이전에 나한테 JSESSIONID 쿠키 발급받아 갔을거임.)
            session.setAttribute("loginId", userid);

            req.setAttribute("msg", "로그인 완료되었습니다.");
            req.setAttribute("path", req.getContextPath()); // 맨 첫페이지로 보냄
            req.getRequestDispatcher("/WEB-INF/views/alert.jsp").forward(req,resp);
        }else{
            // login fail
            req.setAttribute("msg", "로그인 실패입니다. 아이디나 패스워드를 확인해 주세요.");
            req.setAttribute("path", req.getContextPath()+"/user?action=login"); // 로그인 페이지로 보냄.
            req.getRequestDispatcher("/WEB-INF/views/alert.jsp").forward(req,resp);
        }
    }
}
