package com.grepp.todo.model.entity

import jakarta.persistence.Entity
import jakarta.persistence.Id

@Entity(name="user")
data class UserEntity (
    @Id
    val username:String, // 사용자 아이디
    val password:String,)
{
    lateinit var role:String // 관리자? 일반사용자?
    lateinit var authProvider:String
}