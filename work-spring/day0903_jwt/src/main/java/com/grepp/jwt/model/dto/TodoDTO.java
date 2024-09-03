package com.grepp.jwt.model.dto;

import com.grepp.jwt.model.entity.TodoEntity;

// 사용자들은 어차피 자기 자신의 todo만 보는거라 username 굳이 같이 저장해서 줄 필요 음슴
// 데이터베이스랑 상관없이 Data Transfer Object : 들고다닐 데이터 주머니.(클라이언트 <-> 서버)
public class TodoDTO {
    private int id;
    private String title;
    private boolean done;

    public TodoDTO(){}

    public TodoDTO(TodoEntity entity){ // service 쪽에서 가공된 데이터가 entity로 제공되었는데, dto로 만들어서 클라이언트한테 주고 싶으면
        this.id = entity.getId();
        this.title = entity.getTitle();
        this.done = entity.isDone();
    }

    public TodoEntity toEntity(){ // 클라이언트한테 받은 정보를 dto에 가지고 있는데 service 쪽으로 넘길 때 entity객체로 만들어서 줘야 할 때
        TodoEntity entity = new TodoEntity();
        entity.setId(id);
        entity.setTitle(title);
        entity.setDone(done);
        return entity;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public boolean isDone() {
        return done;
    }

    public void setDone(boolean done) {
        this.done = done;
    }

    @Override
    public String toString() {
        return "TodoDTO{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", done=" + done +
                '}';
    }
}
