package com.grepp.todo.controller

import com.grepp.todo.model.dto.UserDTO
import com.grepp.todo.model.entity.UserEntity
import com.grepp.todo.model.service.UserService
import com.grepp.todo.util.MyJwtTokenProvider
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/auth")
class UserController (val service:UserService){
    // autowired는 객체 생성 이후 주입이기 때문에 반드시 lateinit var 해줘야 함.
    @Autowired
    lateinit var myTokenProvider : MyJwtTokenProvider
    
    // 회원가입
    @PostMapping("/signup")
    fun register(@RequestBody userDTO : UserDTO): ResponseEntity<UserEntity> {
        val result = service.join(userDTO.toEntity())
        println("join result : ${result}")
        result.role="ADMIN" // 지금 권한이나
        result.authProvider="grepp" // 소셜 정보 하나도 구현 안해서 ;;; 임의로 ;;; json 만들어서 응답 못한다 해서 ;;
        return ResponseEntity.ok().body(result)
    }
    
    // 로그인
    @PostMapping("/login")
    fun login(@RequestBody userDTO: UserDTO):ResponseEntity<Any>{
        val userEntity = service.login(userDTO.username, userDTO.password)

        println("login result : ${userEntity}")
        if(userEntity!=null){ // 로그인 성공했어? 그럼 토큰 발급해줘야지~~
            val token = myTokenProvider.createMyToken(userEntity,1000*60*2)
            userDTO.token = token
            return ResponseEntity.ok().body(userDTO)
        }

        return ResponseEntity.badRequest().body("login failed!!")
    }
}