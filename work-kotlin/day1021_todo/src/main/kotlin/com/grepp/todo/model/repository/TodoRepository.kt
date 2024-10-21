package com.grepp.todo.model.repository

import com.grepp.todo.model.entity.TodoEntity
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
interface TodoRepository :CrudRepository<TodoEntity, Long> {
    // todo 추가 : insert 기본
    // todo 조회
    fun findByUsername(username:String) : List<TodoEntity>

}