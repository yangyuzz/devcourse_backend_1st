package com.grepp.boardjwt.config;


import com.grepp.boardjwt.model.service.MyOAuth2Service;
import com.grepp.boardjwt.util.YangyuJwtFilter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.filter.CorsFilter;

@EnableWebSecurity
@Configuration
//@ConditionalOnDefaultWebSecurity // 이미 시큐리티에서 필터체인을 등록하는데 내거로 넣으면 둘중 하나 선택하라는 에러 남. 이걸 디폴트로 잡기
//@ConditionalOnWebApplication(type = ConditionalOnWebApplication.Type.SERVLET)
public class WebSecurityConfig {

//    @Autowired
    public YangyuJwtFilter yangyuJwtFilter;

    public WebSecurityConfig(final YangyuJwtFilter yangyuJwtFilter){//}, final MyJwtExceptionFilter myJwtExceptionFilter){
        this.yangyuJwtFilter = yangyuJwtFilter;
        System.out.println("config inject filter");
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http, MyOAuth2Service myOAuth2Service) throws Exception {//}, MyJwtExceptionFilter myJwtExceptionFilter) throws Exception {
        System.out.println("security config");
        return http.cors(AbstractHttpConfigurer::disable)
                .csrf(AbstractHttpConfigurer::disable)
                .httpBasic(AbstractHttpConfigurer::disable)// token을 사용하므로 basic 인증 disable
                .sessionManagement(AbstractHttpConfigurer::disable)  // session 기반이 아님을 선언
                .authorizeHttpRequests(request -> {
                    request.requestMatchers("/auth/**", "/", "/oauth2/**").permitAll(); // /auth/** 이랑 /는 로그인 해서 부여받는 권한 없어도 오케이
                    request.anyRequest().authenticated(); // 그밖의 다른 요청은 다 로그인할때의 권한 있나 체크
                })
                // oauth2 설정
                .oauth2Login(oauth -> // OAuth2 로그인 기능에 대한 여러 설정의 진입점
                        // OAuth2 로그인 성공 이후 사용자 정보를 가져올 때의 설정을 담당
                        oauth.userInfoEndpoint(c-> c.userService(myOAuth2Service))) // 로그인 성공 이후 사용자 정보 얻어와서 우리쪽 디비에 가입시키기
                .addFilterAfter(yangyuJwtFilter, CorsFilter.class)
//                .addFilterBefore(myJwtExceptionFilter, yangyuJwtFilter.getClass())
                .build();
    }
//  @Override
//  protected void configure(HttpSecurity http) throws Exception {
//    // http 시큐리티 빌더
//    http.cors() // WebMvcConfig에서 이미 설정했으므로 기본 cors 설정.
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
//
//    // filter 등록.
//    // 매 요청마다
//    // CorsFilter 실행한 후에
//    // jwtAuthenticationFilter 실행한다.
//    http.addFilterAfter(
//        jwtAuthenticationFilter,
//        CorsFilter.class
//    );

}

