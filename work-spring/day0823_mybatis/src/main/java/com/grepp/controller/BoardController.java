package com.grepp.controller;

import com.grepp.model.dto.BoardDTO;
import com.grepp.model.service.BoardService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import java.sql.SQLException;

@Controller
@RequestMapping("/board")
public class BoardController {
    @Autowired
    private BoardService boardService;

    @GetMapping("/list")
    public ModelAndView list(@RequestParam(name = "page", defaultValue = "1")int page) throws SQLException {
        ModelAndView mav = new ModelAndView("list"); // /WEB-INF/views/list.jsp
        System.out.println(boardService.getBoards(page));
        mav.addObject("pageData", boardService.getBoards(page)); // 현재 페이지를 기준으로 하단의 페이지 링크 정보와 보여질 게시글 목록 데이터까지 다 담아뒀음.
        return mav;
    }

    @GetMapping("/write")
    public String write(){ // 로그인 안된 사용자는 글쓰기 못하게 하고 싶음.
        return "write_form";
    }

    @PostMapping(value="/write")//, headers = ("content-type=multipart/*"))
    public ModelAndView write(BoardDTO board, HttpSession session, @RequestParam(value="uploadFile", required = false) MultipartFile[] uploadFile) throws SQLException {// 로그인 안된 사용자는 글쓰기 못하게 하고 싶음.
        System.out.println(uploadFile[0].getOriginalFilename());
        System.out.println(uploadFile[1].getOriginalFilename());

        board.setWriter((String)session.getAttribute("loginId"));
        boardService.write(board);
        ModelAndView mav = new ModelAndView("alert"); // /WEB-INF/views/list.jsp
        mav.addObject("msg", "write success");
        mav.addObject("path", "list");
        return mav;
    }

    @GetMapping("/read")
    public ModelAndView read(@RequestParam("no") int no) throws SQLException {// 로그인 안된 사용자는 글읽기 못하게 하고 싶음.
        ModelAndView mav = new ModelAndView("view");
        mav.addObject("bbb",boardService.read(no));
        return mav;
    }
}
