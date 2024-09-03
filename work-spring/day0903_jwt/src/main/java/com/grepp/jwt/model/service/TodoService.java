package com.grepp.jwt.model.service;

import com.grepp.jwt.model.entity.TodoEntity;
import com.grepp.jwt.model.repository.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service // @Component
public class TodoService {
    @Autowired
    private TodoRepository repository;

    public List<TodoEntity> create (TodoEntity entity){ // 할일 생성
        validate(entity);

        repository.save(entity);
        return repository.findByUsername(entity.getUsername()); // 방금 추가한거 포함해서 당신의 할일 목록입니다. 라고 해주려고....^^^^^^
    }

    public List<TodoEntity> todoList (String username){
        return repository.findByUsername(username);
    }

    public TodoEntity update(TodoEntity entity){
        validate(entity);

        TodoEntity original = repository.findById(entity.getId()); // 수정하기 요청이면 일단 원본부터 꺼내보자. 없을리가 없어.

        if(entity.getTitle()!=null) // 할일 제목을 새로 입력했네? 갱신!
            original.setTitle(entity.getTitle());
        if(original.isDone() != entity.isDone()) // 수행 여부가 달라졌네? 갱신!
            original.setDone(entity.isDone());
        System.out.println(original);
        repository.save(original);
        return repository.findById(original.getId());
    }


    // 전송 여부 보다는 지금 내가 사용해야 하는 '데이터(재료)가 멀쩡'한지 체크하기
    private void validate(TodoEntity entity){ // entity 유효한지 체크하기
        if(entity == null)
            throw new RuntimeException("엔티티 널이다!!");
        if(entity.getUsername() == null)
            throw new RuntimeException("정체 불명의 사용자가 엔티티를 만들래???");
    }
}
