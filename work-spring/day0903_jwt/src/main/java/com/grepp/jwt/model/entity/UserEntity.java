package com.grepp.jwt.model.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity(name="user")
public class UserEntity {
    @Id
    private String username; // 아이디로 사용할 유저네임. 이메일일 수도 있고 그냥 문자열일 수도 있음.
    private String password;
    private String role; // 사용자 권한(관리자, 일반사용자, 등등)
    private String authProvider; // oauth로 소셜 로그인 제공할거면 example : facebook, naver, google

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

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getAuthProvider() {
        return authProvider;
    }

    public void setAuthProvider(String authProvider) {
        this.authProvider = authProvider;
    }

    @Override
    public String toString() {
        return "UserEntity{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", role='" + role + '\'' +
                ", authProvider='" + authProvider + '\'' +
                '}';
    }
}
