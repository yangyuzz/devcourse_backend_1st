package com.grepp.controller;

import com.grepp.model.dto.CommentDTO;
import com.grepp.model.service.BoardService;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.nio.charset.Charset;
import java.util.List;

//@Controller
@RestController // 모든 메소드가 view를 생성하지 않고 data 응답하는 @ResponseBody인게 됨.
@RequestMapping("/comment")
public class CommentController {
    @Autowired
    private BoardService boardService;

    @GetMapping("/write")
//    @ResponseBody // /WEB-INF/views/comment write success.jsp 이런 행동 하지 말아라~ ViewResolver 한테 안보낸다~ 화면 안만든다 ~~
    public String write(CommentDTO commentDTO){
        boardService.writeComment(commentDTO);
        return "comment write success";
    }

//    @GetMapping("/list") // front에서 요청 url에 /comment/list?bno=238 이렇게 보낼 때의 요청처리
//    public List<CommentDTO> list(@RequestParam("bno") int bno){
//
//    }
//    @GetMapping("/list/{bbb}") // 요청 url이 /comment/list/238 이렇게 옴
//    @ResponseBody // 화면 안만든다! 내가 리턴한 데이터 바로 front 한테 응답으로 줘라!
//    public List<CommentDTO> list(@PathVariable("bbb")int bno){
//        System.out.println(boardService.getComments(bno));
////        StringBuilder sb = new StringBuilder();
////        sb.append("[");
////        for(CommentDTO commentDTO: boardService.getComments(bno)){
////            sb.append("{");
////            sb.append("'cno':");
////            sb.append(commentDTO.getCno());
////            sb.append(",");
////            sb.append("'cwriter':");
////            sb.append(commentDTO.getCwriter());
////        }
//        return boardService.getComments(bno);
//    }

//    @GetMapping("/list/{bbb}") // 요청 url이 /comment/list/238 이렇게 옴
//    @ResponseBody // 화면 안만든다! 내가 리턴한 데이터 바로 front 한테 응답으로 줘라!
//    public List<CommentDTO> list(@PathVariable("bbb")int bno){
//        System.out.println(boardService.getComments(bno));
//        return boardService.getComments(bno);
//    }

    @GetMapping("/list/{bbb}") // 요청 url이 /comment/list/238 이렇게 옴
//    @ResponseBody // 화면 안만든다! 내가 리턴한 데이터 바로 front 한테 응답으로 줘라!
    public ResponseEntity<?> list(@PathVariable("bbb")int bno){
        System.out.println(boardService.getComments(bno));

        HttpHeaders header = new HttpHeaders();
        header.setContentType(new MediaType("application", "json", Charset.forName("UTF-8")));
        return ResponseEntity.ok().headers(header).body(boardService.getComments(bno));
    }
}
