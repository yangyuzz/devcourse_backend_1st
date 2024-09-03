package com.grepp.jwt.config;

import com.grepp.jwt.interceptor.MyLoginInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration // 옛날 스프링 xml 설정파일에서 설정하던거 이제 자바로 하고 싶어서 작성하는 파일
public class MyWebConfig implements WebMvcConfigurer {
    @Autowired
    private MyLoginInterceptor myLoginInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(myLoginInterceptor)
                .order(1) // 인터셉터가 여러 개인 경우 지들끼리 처리순서 결정해줌.
                .addPathPatterns("/todo", "/board"); // 로그인 처리할 요청이 다양한 경우 여러 개 등록 가능.
    }
}
