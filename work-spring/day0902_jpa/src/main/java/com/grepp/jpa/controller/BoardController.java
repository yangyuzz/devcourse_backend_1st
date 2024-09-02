package com.grepp.jpa.controller;

import com.grepp.jpa.model.dto.BoardDTO;
import com.grepp.jpa.model.entity.BoardEntity;
import com.grepp.jpa.model.repository.BoardRepository;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import java.io.IOException;
import java.sql.SQLException;

@RestController
@RequestMapping("/board")
public class BoardController {
    // 원래는 BoardService 여야 하는데 지금은 jpa 간단 테스트 목적으로 repository를 가져옴.
    @Autowired
    private BoardRepository boardRepository;
    // 기존에 완전 REST 아니고 MVC로 작성하던 시절의 컨트롤러는 이렇게 생겼었음.
//    @PostMapping(value="/write")//, headers = ("content-type=multipart/*"))
//    public ModelAndView write(BoardDTO board, HttpSession session, @RequestParam(value="uploadFile", required = false) MultipartFile[] uploadFile) throws SQLException, IOException {
//
//    }

    @PostMapping
    public BoardDTO write(@RequestBody BoardDTO boardDTO){
        // 뭔가 null 체크 같은 작업을 한다거나 암튼 필요한 동작을 dto로 처리하다가 model 쪽에 데이터를 줄 때는 entity 형태로 넘겨줌.
        BoardEntity entity = new BoardEntity();
        entity.setTitle(boardDTO.getTitle());
        entity.setWriter(boardDTO.getWriter()); // 나중에는 로그인된 정보로 작성자 써야겠죠!
        entity.setContent(boardDTO.getContent());
        boardRepository.save(entity); // extends JpaRepository에 기본 insert, delete, select가 있었던 거임. save == insert
        System.out.println(boardDTO);
        System.out.println(entity);
        return boardDTO;
    }
}
