package com.grepp.boardjwt.model.dto;


import com.grepp.boardjwt.model.entity.TodoEntity;

public class TodoDTO {
  private int id;
  private String title;
  private boolean done;

  public TodoDTO(){}

  public TodoDTO(final TodoEntity entity) {
    this.id = entity.getId();
    this.title = entity.getTitle();
    this.done = entity.isDone();
  }

  public TodoEntity toEntity() {
    TodoEntity entity = new TodoEntity();
    entity.setId(this.id);
    entity.setDone(this.done);
    entity.setTitle(this.title);
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
