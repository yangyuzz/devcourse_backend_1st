package com.grepp.day0904.config;

import com.grepp.day0904.util.YangyuFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.filter.CorsFilter;

@Configuration // 예전 xml로 설정하던 항목들의 자바버전
@EnableWebSecurity // DispatcherServlet보다 더 먼저 진행되어야 하는 설정이라 tomcat이 읽고 반영해줘야 함.
public class MySecurityConfig {
    @Autowired
    public YangyuFilter yangyuFilter;

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        return
                http.cors(AbstractHttpConfigurer::disable) // cors 일단 비활성화. 추후 프론트와 연결할 때 프론트 서버 CORS만 풀고 나머지는 불허해야 함.
                        .csrf(AbstractHttpConfigurer::disable) // cookie등을 활용하지 않고 있어서 csrf 비활성화. 추후 csrf 공격을 막고싶으면 여기 활성화 하고 쿠키등의 설정 해줘야함.
                        .httpBasic(AbstractHttpConfigurer::disable) // Basic 인증 환경 아니고 jwt 토큰이니까 Basic 모드 비활성화
                        .sessionManagement(AbstractHttpConfigurer::disable) // session 기반 아님.
                        .authorizeHttpRequests(req -> {
                            req.requestMatchers("/auth/**").permitAll(); // 로그인 하러 오는 애한테 왜 토큰없냐고 멱살잡으면 안되니까 들어오게 해주고.
                            req.anyRequest().authenticated(); // 나머지는 다 인증되야(SecurityHolder에 인증 정보가 있는 요청만) 들어오게 할거임!
                        })
                        .addFilterAfter(yangyuFilter, CorsFilter.class)
                        .build();
    }

    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

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