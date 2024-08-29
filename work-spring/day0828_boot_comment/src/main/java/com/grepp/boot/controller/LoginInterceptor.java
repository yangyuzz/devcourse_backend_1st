package com.grepp.boot.controller;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

@Component("iii")
public class LoginInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String loginId = (String) request.getSession().getAttribute("loginId");
        if(loginId == null){
            response.sendRedirect(request.getContextPath()+"/member/login");
            return false;
        }
        return true;
    }
}
