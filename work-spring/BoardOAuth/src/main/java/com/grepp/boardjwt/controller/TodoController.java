package com.grepp.boardjwt.controller;



import com.grepp.boardjwt.model.dto.TodoDTO;
import com.grepp.boardjwt.model.entity.TodoEntity;
import com.grepp.boardjwt.model.service.TodoService;
import com.grepp.boardjwt.util.MyTokenProvider;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/todo")
public class TodoController {

  @Autowired
  private TodoService service;

  @Autowired
  private MyTokenProvider myTokenProvider;

//  @GetMapping("/test")
//  public ResponseEntity<?> testTodo(String token) {
//    System.out.println(myTokenProvider.validateAndGetUserId(token));
//
//    String str = service.testService(); // 테스트 서비스 사용
//    List<String> list = new ArrayList<>();
//    list.add(str);
//    ResponseDTO<String> response = new ResponseDTO<String>();
//    response.setData(list);
//    return ResponseEntity.ok().body(response);
//  }

  @GetMapping
  public ResponseEntity<?> retrieveTodoList(@AuthenticationPrincipal String username) {
    //String temporaryUserId = "temporary-user"; // temporary user id.
//    int temporaryUserId=1;
    // (1) 서비스 메서드의 retrieve메서드를 사용해 Todo리스트를 가져온다
    List<TodoEntity> entities = service.retrieve(username);

    // (2) 자바 스트림을 이용해 리턴된 엔티티 리스트를 TodoDTO리스트로 변환한다.
    List<TodoDTO> dtos = entities.stream().map(TodoDTO::new).collect(Collectors.toList());

    // (6) 변환된 TodoDTO리스트를 이용해ResponseDTO를 초기화한다.
//    ResponseDTO<TodoDTO> response = new ResponseDTO<TodoDTO>();
//    response.setData(dtos);

    // (7) ResponseDTO를 리턴한다.
    return ResponseEntity.ok().body(dtos);
  }


  @PostMapping
  public ResponseEntity<?> createTodo(@AuthenticationPrincipal String username, @RequestBody TodoDTO dto) {
    try {
      //String temporaryUserId = "temporary-user"; // temporary user id.
//      int temporaryUserId=1;
      // (1) TodoEntity로 변환한다.
      TodoEntity entity = dto.toEntity();

      // (3) 임시 유저 아이디를 설정 해 준다. 이 부분은 4장 인증과 인가에서 수정 할 예정이다. 지금은 인증과 인가 기능이 없으므로 한 유저(temporary-user)만 로그인 없이 사용 가능한 애플리케이션인 셈이다
      entity.setUsername(username);

      // (4) 서비스를 이용해 Todo엔티티를 생성한다.
      List<TodoEntity> entities = service.create(entity);

      // (5) 자바 스트림을 이용해 리턴된 엔티티 리스트를 TodoDTO리스트로 변환한다.
      List<TodoDTO> dtos = entities.stream().map(TodoDTO::new).collect(Collectors.toList());

      // (7) ResponseDTO를 리턴한다.
      return ResponseEntity.ok().body(dtos);
    } catch (Exception e) {
      // (8) 혹시 예외가 나는 경우 dto대신 error에 메시지를 넣어 리턴한다.

//      String error = e.getMessage();
//      ResponseDTO<TodoDTO> response =new ResponseDTO<TodoDTO>();
      return ResponseEntity.badRequest().body(e.getMessage());
    }
  }

//  @PutMapping
//  public ResponseEntity<?> updateTodo(@RequestBody TodoDTO dto) {
//    String temporaryUserId = "temporary-user"; // temporary user id.
//
//    // (1) dto를 entity로 변환한다.
//    //TodoEntity entity = TodoDTO.toEntity(dto);
//
//    // (2) id를 temporaryUserId로 초기화 한다. 여기는 4장 인증과 인가에서 수정 할 예정이다.
//    dto.setUserId(temporaryUserId);
//
//    // (3) 서비스를 이용해 entity를 업데이트 한다.
//    List<TodoDTO> entities = service.update(dto);
//
//    // (4) 자바 스트림을 이용해 리턴된 엔티티 리스트를 TodoDTO리스트로 변환한다.
//    //List<TodoDTO> dtos = entities.stream().map(TodoDTO::new).collect(Collectors.toList());
//
//    // (5) 변환된 TodoDTO리스트를 이용해ResponseDTO를 초기화한다.
//    ResponseDTO<TodoDTO> response =new ResponseDTO<TodoDTO>();
//    response.setData(entities);
//
//    // (6) ResponseDTO를 리턴한다.
//    return ResponseEntity.ok().body(response);
//  }

//  @DeleteMapping
//  public ResponseEntity<?> deleteTodo(@RequestBody TodoDTO dto) {
//    try {
//      String temporaryUserId = "temporary-user"; // temporary user id.
//
//      // (1) TodoEntity로 변환한다.
//      TodoEntity entity = TodoDTO.toEntity(dto);
//
//      // (2) 임시 유저 아이디를 설정 해 준다. 이 부분은 4장 인증과 인가에서 수정 할 예정이다. 지금은 인증과 인가 기능이 없으므로 한 유저(temporary-user)만 로그인 없이 사용 가능한 애플리케이션인 셈이다
//      entity.setUserId(temporaryUserId);
//
//      // (3) 서비스를 이용해 entity를 삭제 한다.
//      List<TodoEntity> entities = service.delete(entity);
//
//      // (4) 자바 스트림을 이용해 리턴된 엔티티 리스트를 TodoDTO리스트로 변환한다.
//      List<TodoDTO> dtos = entities.stream().map(TodoDTO::new).collect(Collectors.toList());
//
//      // (5) 변환된 TodoDTO리스트를 이용해ResponseDTO를 초기화한다.
//      ResponseDTO<TodoDTO> response = ResponseDTO.<TodoDTO>builder().data(dtos).build();
//
//      // (6) ResponseDTO를 리턴한다.
//      return ResponseEntity.ok().body(response);
//    } catch (Exception e) {
//      // (8) 혹시 예외가 나는 경우 dto대신 error에 메시지를 넣어 리턴한다.
//      String error = e.getMessage();
//      ResponseDTO<TodoDTO> response = ResponseDTO.<TodoDTO>builder().error(error).build();
//      return ResponseEntity.badRequest().body(response);
//    }
//  }


}
