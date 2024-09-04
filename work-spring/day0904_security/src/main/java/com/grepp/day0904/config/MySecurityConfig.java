package com.grepp.day0904.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;

@Configuration // 예전 xml로 설정하던 항목들의 자바버전
@EnableWebSecurity // DispatcherServlet보다 더 먼저 진행되어야 하는 설정이라 tomcat이 읽고 반영해줘야 함.
public class MySecurityConfig {


}

// 시큐리티 6 이전 버전에서는 아래처럼
//public class MySecurityConfig extends WebSecurityConfigurerAdapter{
//    @Override
//    protected void configure(HttpSecurity http){
//        http~~~~ 설정
//        http.cors() // WebMvcConfig에서 이미 설정했으므로 기본 cors 설정.
//        .and()
//        .csrf()// csrf는 현재 사용하지 않으므로 disable
//        .disable()
//        .httpBasic()// token을 사용하므로 basic 인증 disable
//        .disable()
//        .sessionManagement()  // session 기반이 아님을 선언
//        .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
//        .and()
//        .authorizeRequests() // /와 /auth/** 경로는 인증 안해도 됨.
//        .antMatchers("/", "/auth/**").permitAll()
//        .anyRequest() // /와 /auth/**이외의 모든 경로는 인증 해야됨.
//        .authenticated();
//    }
//}