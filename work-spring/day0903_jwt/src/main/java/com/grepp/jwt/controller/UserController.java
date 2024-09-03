package com.grepp.jwt.controller;

import com.grepp.jwt.model.dto.UserDTO;
import com.grepp.jwt.model.entity.UserEntity;
import com.grepp.jwt.model.service.UserService;
import com.grepp.jwt.util.MyJwtTokenProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class UserController {
    @Autowired
    private UserService userService;
    @Autowired
    private MyJwtTokenProvider myJwtTokenProvider; // 토큰 생성 및 유효성 검증

    @PostMapping("/signup")
    public ResponseEntity<?> register(@RequestBody UserDTO userDTO){
        // 클라이언트 쪽에서 유효한 값을 '전송' 제대로 했는지 체크
        if(userDTO == null || userDTO.getPassword()==null) throw new RuntimeException("Invalid Password !!!!");

        UserEntity entity = userDTO.toEntity();
        UserEntity resultEntity = userService.join(entity);
        return ResponseEntity.ok().body(new UserDTO(resultEntity));
    }

    @PostMapping("/signin")
    public ResponseEntity<?> signin(@RequestBody UserDTO userDTO){
        UserEntity userEntity = userService.getByCredentials(userDTO.getUsername(), userDTO.getPassword());

        if(userEntity != null){ // login success
            String token = myJwtTokenProvider.createMyToken(userEntity, 1000*60);
            userDTO.setToken(token);
            return ResponseEntity.ok().body(userDTO); // token이 포함된 정보가 응답됨.
        }
        return ResponseEntity.badRequest().body("Login Failed");
    }
}
