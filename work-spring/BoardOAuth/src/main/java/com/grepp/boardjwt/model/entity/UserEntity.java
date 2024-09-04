package com.grepp.boardjwt.model.entity;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity(name="user")
public class UserEntity { // token은 디비저장 안함.

//  @GeneratedValue(strategy = GenerationType.IDENTITY)
//  private int id;// 유저에게 고유하게 부여되는 id.
@Id
  private String username;// 아이디로 사용할 유저네임. 이메일일 수도 그냥 문자열일 수도 있다.
  private String password;// 패스워드.
  private String role; // 유저의 롤.
  private String authProvider; // example : facebook

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
