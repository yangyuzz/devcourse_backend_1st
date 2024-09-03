package com.grepp.jwt.controller;

import com.grepp.jwt.model.dto.TodoDTO;
import com.grepp.jwt.model.entity.TodoEntity;
import com.grepp.jwt.model.entity.UserEntity;
import com.grepp.jwt.model.service.TodoService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/todo")
public class TodoController {
    final String tempUser = "programmers"; // 현재 로그인 구현 전이라 임시 유저네임
    @Autowired
    private TodoService todoService;

    @GetMapping
    public ResponseEntity<?> todoList(){
        List<TodoEntity> entities = todoService.todoList(tempUser); // 추후 로그인 정보를 바탕으로 조회되게 수정해야 함.
        List<TodoDTO> dtos = entities.stream().map(TodoDTO::new).collect(Collectors.toList());
        return ResponseEntity.ok().body(dtos);
    }

    @PostMapping
    public ResponseEntity<?> createTodo(@RequestBody TodoDTO dto){
        TodoEntity entity = dto.toEntity();
        entity.setUsername(tempUser); // 로그인 구현하고 나면 수정해야 함.
        
        List<TodoEntity> entities = todoService.create(entity); // 추가된 todo까지 포함해서 갱신된 todo 목록
        List<TodoDTO> dtos = entities.stream().map(TodoDTO::new).collect(Collectors.toList());
        return ResponseEntity.ok().body(dtos);
    }

    @PutMapping
    public ResponseEntity<?> updateTodo(@RequestBody TodoDTO dto){
        System.out.println(dto);
        TodoEntity entity = dto.toEntity();
        entity.setUsername(tempUser); // 로그인 구현하고 수정해야 함.
        return ResponseEntity.ok().body(todoService.update(entity));
    }
}













