package com.grepp.boardjwt.controller;


import com.grepp.boardjwt.model.dto.UserDTO;
import com.grepp.boardjwt.model.entity.UserEntity;
import com.grepp.boardjwt.model.service.UserService;
import com.grepp.boardjwt.util.MyTokenProvider;
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
    private MyTokenProvider myTokenProvider;

    @PostMapping("/signup")
    public ResponseEntity<?> registerUser(@RequestBody UserDTO userDTO) {
        System.out.println("try to signup : " + userDTO);
        try {
            if (userDTO == null || userDTO.getPassword() == null) {
                throw new RuntimeException("Invalid Password value.");
            }
            UserEntity entity = userDTO.toEntity();
            // 서비스를 이용해 리포지터리 에 유저 저장
            UserEntity registeredUser = userService.create(entity);
            System.out.println("after signup " + registeredUser);
            return ResponseEntity.ok().body(registeredUser);
        } catch (Exception e) {
            // 유저 정보는 항상 하나이므로 리스트로 만들어야 하는 ResponseDTO를 사용하지 않고 그냥 UserDTO 리턴.
            e.printStackTrace();
//            ResponseDTO responseDTO = new ResponseDTO();
            return ResponseEntity
                    .badRequest()
                    .body(userDTO);
        }
    }


    @PostMapping("/signin")
    public ResponseEntity<?> authenticate(@RequestBody UserDTO userDTO) {
        UserEntity user = userService.getByCredentials(
                userDTO.getUsername(),
                userDTO.getPassword());

        if (user != null) {
//            final UserDTO responseUserDTO = new UserDTO();
//            responseUserDTO.setUsername(user.getUsername());
//            responseUserDTO.setId(user.getId());
            final String token = myTokenProvider.create(user, 1000*60);
            userDTO.setToken(token);

            return ResponseEntity.ok().body(userDTO);
        } else {
//            ResponseDTO responseDTO = new ResponseDTO();
//            responseDTO.setError("Login failed.");
            return ResponseEntity
                    .badRequest()
                    .body("Login Failed");
        }
    }
}

