package com.grepp.todo.model.repository

import com.grepp.todo.model.entity.UserEntity
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
interface UserRepository : CrudRepository<UserEntity, Long> {
    // 회원가입 함수는 자동으로 create 만들어지니까.
    // 로그인 함수만 만들어놓을까요 : 로그인 실패시 결과 null 허용되게 ? 붙여놨습니당
    fun findByUsernameAndPassword(username:String, password:String): UserEntity?// login할 때 함수
}