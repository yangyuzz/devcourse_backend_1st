package com.grepp.jwt.util;

import com.grepp.jwt.model.entity.UserEntity;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.springframework.stereotype.Component;

import javax.crypto.SecretKey;
import java.util.Base64;
import java.util.Date;

@Component
public class MyJwtTokenProvider {
    private String TOKEN_KEY="123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890";

    // 로그인 성공시 해당 유저에게 발급할 토큰 생성
    public String createMyToken(UserEntity entity, long expireTime){
        return Jwts.builder()
                .signWith(getTokenKey()) // 내 시크릿 키로 서명하기
                .subject(entity.getUsername()) // payload에 노출되는 데이터 담기
                .issuer("yangyu company") // 토큰 발급처
                .issuedAt(new Date()) // 토큰 생성 시간
                .expiration(new Date(System.currentTimeMillis()+expireTime)) // 발급 시간기준 얼만큼 오래 유효한지.
                .compact();
    }

    // 나중에 사용자가 토큰을 들고왔네? 이 토큰이 유효한 토큰이 맞는지 검사하기
    public String validateUserToken(String token){
        Claims claims = Jwts.parser()
                .verifyWith(getTokenKey()) // 내 키 집어넣어서 입력토큰과 동일하게 생성되는지 체크할거임
                .build()
                .parseSignedClaims(token) // 여기서 만약 내가 지금 생성한 토큰과 입력 토큰이 다르거나 유효시간 만료되거나 하면 예외날림
                .getPayload(); // 위에서 예외 안날렸으면 괜찮네?! 저장된 데이터(username) 꺼내기
        return claims.getSubject();
    }

    // 토큰 발급과 토큰 유효성 검사에 사용되는 키 생성
    private SecretKey getTokenKey(){
        byte[] keyBytes = Decoders.BASE64.decode(this.TOKEN_KEY);
        return Keys.hmacShaKeyFor(keyBytes);
    }
}
