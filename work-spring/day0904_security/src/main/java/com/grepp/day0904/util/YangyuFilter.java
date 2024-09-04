package com.grepp.day0904.util;

import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.security.authentication.AbstractAuthenticationToken;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.awt.*;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@Component
public class YangyuFilter extends OncePerRequestFilter { // Filter는 디스패처서블릿 보다 먼저 작업을 처리함.
    @Autowired
    private MyJwtTokenProvider myJwtTokenProvider;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        try{
            String token = parseBearerToken(request);
            System.out.println("start yangyu filter : " + token); // 이런거 찍지 말라고 시큐리티 책에서 잔소리 좀아까 보고 왔는데....
            if(token != null){
                String username = myJwtTokenProvider.validateUserToken(token); // 유효하지 않은 토큰인 경우 throw exception
                // 토큰이 유효하다면 인증이 완료된거임.
                AbstractAuthenticationToken authToken = new UsernamePasswordAuthenticationToken(
                        username, // 지금처럼 문자열 말고 다른 것도 들어갈 수 있는데, 예제에서는 UserDetails라는 오브젝트를 넣는 경우가 많음. 우리는 안했음.
                        null,
                        AuthorityUtils.NO_AUTHORITIES // 로그인이 된 상태에서도 관리자, 일반사용자 등의 권한이 달라질 수 있음. 여기서 설정.
                );
                // 토큰에다가 기본적인 인증정보 외에 더 부가적으로 담아놓고 싶은 내용이 있으면 아래 Detail에서 더 담는 작업 수행 가능
                authToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
                SecurityContext securityContext = SecurityContextHolder.createEmptyContext(); // 비어있는 컨텍스트 생성
                securityContext.setAuthentication(authToken); // 컨텍스트에 토큰 담고
                SecurityContextHolder.setContext(securityContext); // 홀더에 컨텍스트 고정
            }
        }catch(Exception ex){
            // 토큰이 유효하지 않아서 인증 불가임! DispatcherServlet으로 안가야 하고 그러므로 ResponseEntity를 리턴하는 작업을 부탁할 수 없음.
            response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
            response.setContentType(MediaType.APPLICATION_JSON_VALUE); // response는 기본 설정이 html 응답으로 되어있을 거라..

            Map<String, Object> body = new HashMap<>(); // front한테 인증 불가에 대한 에러 메세지를 응답하고 싶어서
            body.put("status", HttpServletResponse.SC_UNAUTHORIZED);
            body.put("error", "Unauthorized~~~~~");
            body.put("message", ex.getMessage());
            body.put("path", request.getServletPath());

            ObjectMapper mapper = new ObjectMapper(); // 평소에 @RequestBody, @ResponseBody 처리하면서 자바 <-> json 작업할 때 쓰이던 lib
            mapper.writeValue(response.getOutputStream(), body); // 응답에 에러내용 json으로 만들어 보내기
        }
        filterChain.doFilter(request,response); // 때에 따라서는 아래 예외 발생시에도 나머지 필터를 더 진행해야 할 수 있음.
    }

    // JWT 토큰을 활용하는 과정에서 토큰 형식이 아래처럼 진행되는 경우가 많음
    // Authorization : Bearer eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJwcm9ncmFtbWVycyIsImlzcyI6Inlhbmd5dSBjb21wYW55IiwiaWF0IjoxNzI1MzQ1MDEzLCJleHAiOjE3MjUzNDUwNzN9.fANJqQgltjg4o07f1lU26Oe6bOPG7XxciW8n19IRBXPPE2kvMrOY1ei2vNHjYQ_iKS3kun4uTJaB6vp12KQxCg
    // 저 Bearer라는 글자가 기능적인 역할은 없는데 토큰 개발하는 프론트 쪽에서 관습적으로 항상 붙이는거 같은... 저도 잘 모름......
    private String parseBearerToken(HttpServletRequest request){
        String bearerToken = request.getHeader("Authorization");

        if(bearerToken!=null && bearerToken.startsWith("Bearer ")){
            return bearerToken.substring(7);
        }
        return null;
    }
}
