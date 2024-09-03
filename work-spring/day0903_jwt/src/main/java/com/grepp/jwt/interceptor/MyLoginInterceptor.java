package com.grepp.jwt.interceptor;

import com.grepp.jwt.util.MyJwtTokenProvider;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

@Component
public class MyLoginInterceptor implements HandlerInterceptor {
    private final String HEADER_AUTH = "Authorization";

//    @Autowired
    private MyJwtTokenProvider myJwtTokenProvider;
    // 기본생성자 없이 반드시 의존하는 객체를 주입받도록 생성자 제한.
    public MyLoginInterceptor(MyJwtTokenProvider myJwtTokenProvider){
        this.myJwtTokenProvider = myJwtTokenProvider;
    }

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String token = request.getHeader(HEADER_AUTH); // Authorization 이름인 헤더에 토큰 담기로 프론트랑 사전에 약속함.
        if(token!=null && myJwtTokenProvider.validateUserToken(token)!=null){
            System.out.println("로그인 인터셉터 유효 토큰확인:"+token);
            return true;
        }
        System.out.println("로그인 인터셉터 유효하지 않은 토큰확인:"+token);
        throw new RuntimeException("유효하지 않은 토큰!!");
    }
}
