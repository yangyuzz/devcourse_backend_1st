package com.grepp.todo.config

import com.grepp.todo.util.YangyuFilter
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.security.config.Customizer
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity
import org.springframework.security.config.annotation.web.configurers.AuthorizeHttpRequestsConfigurer.AuthorizationManagerRequestMatcherRegistry
import org.springframework.security.config.annotation.web.configurers.CorsConfigurer
import org.springframework.security.config.annotation.web.configurers.CsrfConfigurer
import org.springframework.security.config.annotation.web.configurers.HttpBasicConfigurer
import org.springframework.security.config.annotation.web.configurers.SessionManagementConfigurer
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.security.web.SecurityFilterChain
import org.springframework.web.filter.CorsFilter

@Configuration // 예전 xml로 설정하던 항목들의 자바버전
@EnableWebSecurity // DispatcherServlet보다 더 먼저 진행되어야 하는 설정이라 tomcat이 읽고 반영해줘야 함.
class MySecurityConfig {
    @Autowired
    lateinit var yangyuFilter: YangyuFilter

    @Bean
    @Throws(Exception::class)
    fun filterChain(http: HttpSecurity): SecurityFilterChain {
        return http.cors { it.disable() } // cors 일단 비활성화. 추후 프론트와 연결할 때 프론트 서버 CORS만 풀고 나머지는 불허해야 함.
            .csrf { it.disable() } // cookie등을 활용하지 않고 있어서 csrf 비활성화. 추후 csrf 공격을 막고싶으면 여기 활성화 하고 쿠키등의 설정 해줘야함.
            .httpBasic { it.disable() } // Basic 인증 환경 아니고 jwt 토큰이니까 Basic 모드 비활성화
            .sessionManagement { it.disable() } // session 기반 아님.
            .authorizeHttpRequests(Customizer {
                it.requestMatchers("/auth/**").permitAll() // 로그인 하러 오는 애한테 왜 토큰없냐고 멱살잡으면 안되니까 들어오게 해주고.
                it.anyRequest().authenticated() // 나머지는 다 인증되야(SecurityHolder에 인증 정보가 있는 요청만) 들어오게 할거임!
            })
            .addFilterAfter(yangyuFilter, CorsFilter::class.java)
            .build()
    }

    @Bean
    fun passwordEncoder(): PasswordEncoder {
        return BCryptPasswordEncoder()
    }
}