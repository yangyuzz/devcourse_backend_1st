package com.grepp.boardjwt.model.service;


import com.grepp.boardjwt.model.entity.TodoEntity;
import com.grepp.boardjwt.model.repository.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class TodoService {
    @Autowired
    private TodoRepository repository;

//    public String testService() {
//        // TodoEntity 생성
//        TodoDTO entity = new TodoDTO();
//        entity.setTitle("My first todo item");
//        // TodoEntity 저장
//        repository.save(entity);
//        // TodoEntity 검색
//        TodoDTO savedEntity = repository.findById(entity.getId()).get();
//        return savedEntity.getTitle();
//    }

    public List<TodoEntity> create(final TodoEntity entity) {
        // Validations
        validate(entity);

        repository.save(entity);
        return repository.findByUsername(entity.getUsername());

    }

    // 리팩토링 한 메서드
    private void validate(final TodoEntity entity) {
        if (entity == null) {
            throw new RuntimeException("Entity cannot be null.");
        }

        if (entity.getUsername() == null) {
            throw new RuntimeException("Unknown user.");
        }
    }

    public List<TodoEntity> retrieve(String username) {
        return repository.findByUsername(username);
    }

    public List<TodoEntity> update(final TodoEntity entity) {
        // (1) 저장 할 엔티티가 유효한지 확인한다. 이 메서드는 2.3.1 Create Todo에서 구현했다.
        validate(entity);

        // (2) 넘겨받은 엔티티 id를 이용해 TodoEntity를 가져온다. 존재하지 않는 엔티티는 업데이트 할 수 없기 때문이다.
        TodoEntity original = repository.findById(entity.getId());

        if (entity.getTitle() != null)
            original.setTitle(entity.getTitle());
        if (entity.isDone() != entity.isDone())
            original.setDone(entity.isDone());
        repository.save(original);

        // 2.3.2 Retrieve Todo에서 만든 메서드를 이용해 유저의 모든 Todo 리스트를 리턴한다.
        return retrieve(entity.getUsername());
    }

    public List<TodoEntity> delete(final TodoEntity entity) {
        // (1) 저장 할 엔티티가 유효한지 확인한다. 이 메서드는 2.3.1 Create Todo에서 구현했다.
        validate(entity);

        try {
            // (2) 엔티티를 삭제한다.
            repository.delete(entity);
        } catch (Exception e) {
            // (3) exception 발생시 id와 exception을 로깅한다.
//            log.error("error deleting entity ", entity.getId(), e);

            // (4) 컨트롤러로 exception을 날린다. 데이터베이스 내부 로직을 캡슐화 하기 위해 e를 리턴하지 않고 새 exception 오브젝트를 리턴한다.
            throw new RuntimeException("error deleting entity " + entity.getId());
        }
        // (5) 새 Todo리스트를 가져와 리턴한다.
        return retrieve(entity.getUsername());
    }
}
