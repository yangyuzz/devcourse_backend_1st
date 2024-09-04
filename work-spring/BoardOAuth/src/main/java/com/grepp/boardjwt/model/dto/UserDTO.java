package com.grepp.boardjwt.model.dto;

import com.grepp.boardjwt.model.entity.UserEntity;

public class UserDTO {
  private String token;
  private String username;
  private String password;
//  private int id;

  public UserDTO() {
  }

  public UserDTO(UserEntity entity){
//    this.id = entity.getId();
    this.username = entity.getUsername();
    this.password = entity.getPassword();
  }

  public UserDTO(String token, String username, String password) {
    this.token = token;
    this.username = username;
    this.password = password;
//    this.id = id;
  }

  public UserEntity toEntity(){
    UserEntity entity = new UserEntity();
//    entity.setId(this.id);
    entity.setUsername(this.username);
    entity.setPassword(this.password);
    return entity;
  }


  @Override
  public String toString() {
    return "UserDTO{" +
            "token='" + token + '\'' +
            ", username='" + username + '\'' +
            ", password='" + password + '\'' +
            //", id='" + id + '\'' +
            '}';
  }

  public String getToken() {
    return token;
  }

  public void setToken(String token) {
    this.token = token;
  }

  public String getUsername() {
    return username;
  }

  public void setUsername(String username) {
    this.username = username;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

//  public int getId() {
//    return id;
//  }
//
//  public void setId(int id) {
//    this.id = id;
//  }
}