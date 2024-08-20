package com.grepp.controller;

import com.grepp.controller.util.MyPageInfo;
import com.grepp.model.service.MemberService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.sql.SQLException;

// /member/~~~.do 형태의 요청들은 다 여기로 와라
public class MemberController implements MyController{
    private MemberService service = MemberService.getInstance();

    @Override
    public Object handleRequest(HttpServletRequest req, HttpServletResponse resp) throws SQLException {
        String url = req.getServletPath();

        Object result = null;
        if("/member/loginForm.do".equals(url)){
            result = new MyPageInfo(true, "/login_form"); // /WEB-INF/views/login_form.jsp
        }else if("/member/login.do".equals(url)){
            String userid = req.getParameter("userid");
            String userpw = req.getParameter("userpw");
            String loginId = service.login(userid,userpw);
            if(loginId != null){ // 로그인 성공
                HttpSession session = req.getSession();
                session.setAttribute("loginId", loginId);
                req.setAttribute("msg", "login success!");
                req.setAttribute("path", req.getContextPath()+"/main.do");
                result = new MyPageInfo(true, "/alert");
            } else{ // 로그인 실패
                req.setAttribute("msg", "login fail!");
                req.setAttribute("path", "loginForm.do"); // 다시 로그인 하러 가게 만들기
                result = new MyPageInfo(true, "/alert");
            }
        } else if("/member/logout.do".equals(url)){
            req.getSession().invalidate(); // 현재 요청보낸 클라이언트의 세션객체 날려버리기
            req.setAttribute("msg", "logout!");
            req.setAttribute("path", req.getContextPath()+"/main.do");
            result = new MyPageInfo(true, "/alert");
        }
        return result;
    }
}
