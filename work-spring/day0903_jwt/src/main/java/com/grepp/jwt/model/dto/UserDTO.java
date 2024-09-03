package com.grepp.jwt.model.dto;

import com.grepp.jwt.model.entity.UserEntity;

public class UserDTO {
    private String username;
    private String password;
    private String token; // db에 저장안하지만 클라이언트와 상호작용 하다보면 받게되는 데이터

    public UserDTO(){}

    public UserDTO(UserEntity entity){
        this.username = entity.getUsername();
        this.password = entity.getPassword();
    }

    public UserEntity toEntity(){
        UserEntity entity = new UserEntity();
        entity.setUsername(username);
        entity.setPassword(password);
        return entity;
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

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    @Override
    public String toString() {
        return "UserDTO{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", token='" + token + '\'' +
                '}';
    }
}
