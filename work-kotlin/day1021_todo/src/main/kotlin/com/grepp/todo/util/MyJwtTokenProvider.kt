package com.grepp.todo.util

import com.grepp.todo.model.entity.UserEntity
import io.jsonwebtoken.*
import io.jsonwebtoken.io.Decoders
import io.jsonwebtoken.security.Keys
import io.jsonwebtoken.security.SecurityException
import org.springframework.stereotype.Component
import java.util.*
import javax.crypto.SecretKey

@Component
class MyJwtTokenProvider {
    private val TOKEN_KEY = "123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890"

    // 로그인 성공시 해당 유저에게 발급할 토큰 생성
    fun createMyToken(entity: UserEntity, expireTime: Long): String {
        return Jwts.builder()
            .signWith(tokenKey) // 내 시크릿 키로 서명하기
            .subject(entity.username) // payload에 노출되는 데이터 담기
            .issuer("yangyu company") // 토큰 발급처
            .issuedAt(Date()) // 토큰 생성 시간
            .expiration(Date(System.currentTimeMillis() + expireTime)) // 발급 시간기준 얼만큼 오래 유효한지.
            .compact()
    }

    // 나중에 사용자가 토큰을 들고왔네? 이 토큰이 유효한 토큰이 맞는지 검사하기
    fun validateUserToken(token: String?): String {
//        try {
            val claims = Jwts.parser()
                .verifyWith(tokenKey) // 내 키 집어넣어서 입력토큰과 동일하게 생성되는지 체크할거임
                .build()
                .parseSignedClaims(token) // 여기서 만약 내가 지금 생성한 토큰과 입력 토큰이 다르거나 유효시간 만료되거나 하면 예외날림
                .payload // 위에서 예외 안날렸으면 괜찮네?! 저장된 데이터(username) 꺼내기
            return claims.subject
//        } catch (ex: SecurityException) {
//            throw JwtException("잘못된 jwt 시그니처 입니다!!")
//        } catch (ex: MalformedJwtException) {
//            throw JwtException(("유효하지 않은 토큰입니다! MalformedJwtException"))
//        } catch (ex: ExpiredJwtException) {
//            throw JwtException("유효기간이 만료된 토큰입니다!")
//        } catch (ex: RuntimeException) {
//            ex.printStackTrace()
//            throw ex
//        }
    }

    private val tokenKey: SecretKey
        // 토큰 발급과 토큰 유효성 검사에 사용되는 키 생성
        get() {
            val keyBytes = Decoders.BASE64.decode(this.TOKEN_KEY)
            return Keys.hmacShaKeyFor(keyBytes)
        }
}
