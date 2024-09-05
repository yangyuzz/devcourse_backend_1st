package com.grepp.day0904.model.repository;

import com.grepp.day0904.model.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserEntity, String> {
    // save
    UserEntity findByUsername(String username);
}
