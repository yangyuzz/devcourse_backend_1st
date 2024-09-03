package com.grepp.jwt.model.repository;

import com.grepp.jwt.model.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserEntity, String> {
    // save
    UserEntity findByUsernameAndPassword(String username, String password);
}
