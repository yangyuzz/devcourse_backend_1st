package com.grepp.todo.model.service

import com.grepp.todo.model.entity.TodoEntity
import com.grepp.todo.model.repository.TodoRepository
import org.springframework.stereotype.Service

@Service
class TodoService(val repo:TodoRepository) { // 의존하는 객체 생성자 주입 권장.
    // 원래 service는 더 복잡한 비즈니스 로직 처리를 해야하는데 ;; 예제가 너무 단순해서 할일이 없네 ;;;
    fun create(todo: TodoEntity) = repo.save(todo)
    fun getList(username:String) = repo.findByUsername(username)
}