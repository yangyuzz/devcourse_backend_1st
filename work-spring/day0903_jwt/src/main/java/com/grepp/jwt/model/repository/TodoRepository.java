package com.grepp.jwt.model.repository;

import com.grepp.jwt.model.entity.TodoEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TodoRepository extends JpaRepository<TodoEntity, Integer> {
    List<TodoEntity> findByUsername(String username);
    TodoEntity findById(int id);
}
