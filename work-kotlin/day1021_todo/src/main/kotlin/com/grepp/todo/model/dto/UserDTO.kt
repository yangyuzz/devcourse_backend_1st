package com.grepp.todo.model.dto

import com.grepp.todo.model.entity.UserEntity

data class UserDTO (val username:String,val password:String,){
    lateinit var token:String
    fun toEntity():UserEntity = UserEntity(username, password)
}