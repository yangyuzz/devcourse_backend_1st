package com.grepp.todo.controller

import com.grepp.todo.model.dto.TodoDTO
import com.grepp.todo.model.entity.TodoEntity
import com.grepp.todo.model.service.TodoService
import io.swagger.v3.oas.annotations.Operation
import io.swagger.v3.oas.annotations.tags.Tag
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import org.springframework.security.core.annotation.AuthenticationPrincipal

@Tag(name="Todo API", description = "Todo 추가 및 목록을 볼 수 있는 서비스 API")
@RestController
@RequestMapping("/todo")
class TodoController (val service:TodoService){
//    val username = "programmers" // temp 사용자. 시큐리티 붙이면 그 쪽에서 로그인 정보 제공할 예정.

    @Operation(summary = "Todo 목록보기", description = "로그인 토큰을 첨부해야 하며 현재 로그인된 사용자의 Todo목록을 응답합니다.")
    @GetMapping
    // /auth/~~ 회원가입,로그인 요청을 제외한 다른 요청들은 다 필터에서 토큰검사 하고 유효한 애들만 securityContext에 담아서
    // securityHolder에 기록해 놓음. 아래 AuthenticationPrincipal이 홀더에 있는 정보 가져다주는 애노테이션임.
    fun todoList(@AuthenticationPrincipal username:String) = ResponseEntity.ok().body(service.getList(username))

    @PostMapping
    fun todoCreate(@AuthenticationPrincipal username:String, @RequestBody todoDTO:TodoDTO): ResponseEntity<TodoEntity> {
        val todo = todoDTO.toEntity()
        todo.username = username // 시큐리티 붙이고 나면 로그인된 사용자 정보로 셋팅될 예정
        val result = service.create(todo)
        println("create result ${result}")
        return ResponseEntity.ok().body(result)
    }
}