package com.grepp.boardjwt.interceptor;

import com.grepp.boardjwt.exception.UnAuthorizedException;
import com.grepp.boardjwt.util.MyTokenProvider;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

@Component
public class MyJWTInterceptor implements HandlerInterceptor {

	private final String HEADER_AUTH = "Authorization";
	
	private MyTokenProvider jwtUtil;

	public MyJWTInterceptor(MyTokenProvider jwtUtil) {
		super();
		this.jwtUtil = jwtUtil;
	}
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		final String token = request.getHeader(HEADER_AUTH);

		if (token != null && jwtUtil.validateAndGetUserId(token)!=null) {
//			log.info("토큰 사용 가능 : {}", token);
			System.out.println("유효 토큰 : "+token);
			return true;
		} else {
//			log.info("토큰 사용 불가능 : {}", token);
			System.out.println("유효하지 않은 토큰:"+token);
			throw new UnAuthorizedException();
		}

	}
}