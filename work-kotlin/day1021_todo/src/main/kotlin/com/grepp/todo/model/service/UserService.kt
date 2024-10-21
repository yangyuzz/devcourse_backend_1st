package com.grepp.todo.model.service

import com.grepp.todo.model.entity.UserEntity
import com.grepp.todo.model.repository.UserRepository
import org.springframework.stereotype.Service

@Service
class UserService(val repo:UserRepository) {
    // 회원가입
    fun join(entity:UserEntity) = repo.save(entity)
    // 로그인
    fun login(username:String, password:String) = repo.findByUsernameAndPassword(username, password)
}