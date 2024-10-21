package com.grepp.todo.model.entity

import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id

@Entity(name="todo")
data class TodoEntity(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id:Int,
    var title:String,
    var done:Boolean
) {
    lateinit var username:String // 로그인 정보가 시큐리티 쪽에서 오니까 나중에 사용자이름 기록해야 되는 상황 생기더라고요.
}