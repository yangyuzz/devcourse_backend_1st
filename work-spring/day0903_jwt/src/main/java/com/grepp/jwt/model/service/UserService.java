package com.grepp.jwt.model.service;

import com.grepp.jwt.model.entity.UserEntity;
import com.grepp.jwt.model.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private UserRepository repository;

    public UserEntity join(UserEntity entity){
        return repository.save(entity);
    }

    public UserEntity getByCredentials(String username, String password){
        return repository.findByUsernameAndPassword(username,password);
    }
}
