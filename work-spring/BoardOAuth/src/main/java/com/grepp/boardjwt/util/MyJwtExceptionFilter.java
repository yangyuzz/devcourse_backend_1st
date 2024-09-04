package com.grepp.boardjwt.util;//package com.grepp.boardjwt.util;
//
//import com.fasterxml.jackson.databind.ObjectMapper;
//import io.jsonwebtoken.JwtException;
//import jakarta.servlet.FilterChain;
//import jakarta.servlet.ServletException;
//import jakarta.servlet.http.HttpServletRequest;
//import jakarta.servlet.http.HttpServletResponse;
//import org.springframework.http.MediaType;
//import org.springframework.stereotype.Component;
//import org.springframework.web.filter.OncePerRequestFilter;
//
//import javax.lang.model.type.ErrorType;
//import java.io.IOException;
//import java.util.HashMap;
//import java.util.Map;
//
//@Component
//public class MyJwtExceptionFilter extends OncePerRequestFilter {
//
//    /*
//    인증 오류가 아닌, JWT 관련 오류는 이 필터에서 따로 잡아낸다.
//    이를 통해 JWT 만료 에러와 인증 에러를 따로 잡아낼 수 있다.
//     */
//    @Override
//    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain) throws ServletException, IOException {
//        try {
//            System.out.println("에러 컨트롤 필터 진입");
//            chain.doFilter(request, response); // YangyuJwtFilter로 이동
//            System.out.println("에러 컨트롤 필터 탈출");
//        } catch (JwtException ex) {
//            // JwtAuthenticationFilter에서 예외 발생하면 바로 setErrorResponse 호출
//            System.out.println("양유 필터에서 토큰 에러났나봐!");
//            setErrorResponse(request, response, ex);
//        }
//    }
//
//    public void setErrorResponse(HttpServletRequest req, HttpServletResponse res, Throwable ex) throws IOException {
//
//        res.setContentType(MediaType.APPLICATION_JSON_VALUE);
//        final Map<String, Object> body = new HashMap<>();
//        body.put("status", HttpServletResponse.SC_UNAUTHORIZED);
//        body.put("error", "Unauthorized");
//        // ex.getMessage() 에는 jwtException을 발생시키면서 입력한 메세지가 들어있다.
//        body.put("message", ex.getMessage());
//        body.put("path", req.getServletPath());
//        final ObjectMapper mapper = new ObjectMapper();
//        mapper.writeValue(res.getOutputStream(), body);
//        res.setStatus(HttpServletResponse.SC_OK);
//    }
//}