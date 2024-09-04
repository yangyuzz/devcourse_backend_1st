package com.grepp.boardjwt.model.service;


import com.grepp.boardjwt.model.entity.UserEntity;
import com.grepp.boardjwt.model.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class UserService {

  @Autowired
  private UserRepository userRepository;

  public UserEntity create(final UserEntity userEntity) {
    if(userEntity == null || userEntity.getUsername() == null ) {
      throw new RuntimeException("Invalid arguments");
    }
    final String username = userEntity.getUsername();
    if(userRepository.existsByUsername(username)) {
     // log.warn("Username already exists {}", username);
      throw new RuntimeException("Username already exists");
    }

    return userRepository.save(userEntity);
  }

  public UserEntity getByCredentials(final String username, final String password) {
    return userRepository.findByUsernameAndPassword(username, password);
  }
}

