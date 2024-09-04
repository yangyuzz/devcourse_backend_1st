package com.grepp.boardjwt.model.repository;


import com.grepp.boardjwt.model.entity.TodoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TodoRepository extends JpaRepository<TodoEntity, String> {
  List<TodoEntity> findByUsername(String username);

//  @Query("SELECT t FROM todo t WHERE t.username = ?1")
//  TodoEntity findByUserIdQuery(String userId);
  TodoEntity findById(int id);
}
