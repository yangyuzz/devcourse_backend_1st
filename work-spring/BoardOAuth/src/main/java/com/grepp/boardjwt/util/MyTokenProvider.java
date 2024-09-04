package com.grepp.boardjwt.util;


import com.grepp.boardjwt.model.entity.UserEntity;
import io.jsonwebtoken.*;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.springframework.stereotype.Component;

import javax.crypto.SecretKey;
import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.Date;

@Component
public class MyTokenProvider {
//  @Value("${jwt.salt}")
  //private String SECRET_KEY = "FlRpX30pMqDbiAkmlfArbrmVkDD4RqISskGZmBFax5oGVxzXXWUzTR5JyskiHMIV9M1Oicegkpi46AdvrcX1E6CmTUBc6IFbTPiD";
  private String SECRET_KEY = "12345678901234561234567890123456123456789012345612345678901234561234567890123456";
  public String create(UserEntity userEntity, long expireTime) {
    // 기한 지금으로부터 1일로 설정
//    Date expiryDate = Date.from(
//        Instant.now()
//            .plus(1, ChronoUnit.DAYS));
//    System.out.println("create jwt token with key : "+getSigningKey());
  /*
  { // header
    "alg":"HS512"
  }.
  { // payload
    "sub":"40288093784915d201784916a40c0001",
    "iss": "demo app",
    "iat":1595733657,
    "exp":1596597657
  }.
  // SECRET_KEY를 이용해 서명한 부분
  Nn4d1MOVLZg79sfFACTIpCPKqWmpZMZQsbNrXdJJNWkRv50_l7bPLQPwhMobT4vBOG6Q3JYjhDrKFlBSaUxZOg
   */
    // JWT Token 생성
    return Jwts.builder()
            // header에 들어갈 내용 및 서명을 하기 위한 SECRET_KEY
            .signWith(getSigningKey())
            // payload에 들어갈 내용
            .subject(userEntity.getUsername()) // sub
            .issuer("demo app") // iss
            .issuedAt(new Date()) // iat
            .expiration(new Date(System.currentTimeMillis()+expireTime)) // exp
            .compact();
  }


  public String validateAndGetUserId(String token) {
    // parseClaimsJws메서드가 Base 64로 디코딩 및 파싱.
    // 즉, 헤더와 페이로드를 setSigningKey로 넘어온 시크릿을 이용 해 서명 후, token의 서명 과 비교.
    // 위조되지 않았다면 페이로드(Claims) 리턴, 위조라면 예외를 날림
    // 그 중 우리는 userId가 필요하므로 getBody를 부른다.
    System.out.println("token provider token:"+token);
    try {
    Claims claims = Jwts.parser()
            .verifyWith(getSigningKey())
            .build()
            .parseSignedClaims(token)
            .getPayload();
//        .setSigningKey(SECRET_KEY)
//        .parseClaimsJws(token)
//        .getBody();

    return claims.getSubject();
    } catch (SecurityException e) {
      //logger.info("Invalid JWT signature.");
      throw new JwtException("잘못된 JWT 시그니처");
    } catch (MalformedJwtException e) {
      //log.info("Invalid JWT token.");
      throw new JwtException("유효하지 않은 JWT 토큰");
    } catch (ExpiredJwtException e) {
      //log.info("Expired JWT token.");
      throw new JwtException("토큰 기한 만료");
    } catch (UnsupportedJwtException e) {
      //log.info("Unsupported JWT token.");
    } catch (IllegalArgumentException e) {
      //log.info("JWT token compact of handler are invalid.");
      throw new JwtException("JWT token compact of handler are invalid.");
    }
    return null;
  }

  private SecretKey getSigningKey() {
    byte[] keyBytes = Decoders.BASE64.decode(this.SECRET_KEY);
    return Keys.hmacShaKeyFor(keyBytes);
  }
}

