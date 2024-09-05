package com.grepp.day0904.model.service;

import com.grepp.day0904.model.entity.UserEntity;
import com.grepp.day0904.model.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private UserRepository repository;
    @Autowired
    private PasswordEncoder passwordEncoder;

    public UserEntity join(UserEntity entity){
        entity.setPassword(passwordEncoder.encode(entity.getPassword())); // 회원가입시 패스워드 인코딩해서 저장시키자!
        return repository.save(entity);
    }

    public UserEntity getByCredentials(String username, String password){
        UserEntity originalUser = repository.findByUsername(username);
        
        // 현재 로그인 시도에 사용된 패스워드 1234와 회원가입시 저장된 패스워드 $2a$10$Ga3l0a1PFlBy/3ZWUKYj.utGlfqz0M/j4UI0xdKsF1l8FzG43PKPa 가 매칭되는지 체크해줌.
        // 아이디가 유효하고 입력한 패스워드가 매치 되는지 체크해서
        if(originalUser != null && passwordEncoder.matches(password, originalUser.getPassword())){
            return originalUser;
        }
        
        return null;
    }
}
