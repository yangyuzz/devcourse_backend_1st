package com.grepp.controller;

import com.grepp.model.dto.BoardDTO;
import com.grepp.model.service.BoardService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.sql.SQLException;

@Controller
@RequestMapping("/board")
public class BoardController {
    @Autowired
    private BoardService boardService;

    @GetMapping("/list")
    public ModelAndView list() throws SQLException {
        ModelAndView mav = new ModelAndView("list"); // /WEB-INF/views/list.jsp
        mav.addObject("bList", boardService.getBoards());
        return mav;
    }

    @GetMapping("/write")
    public String write(){ // 로그인 안된 사용자는 글쓰기 못하게 하고 싶음.
        return "write_form";
    }

    @PostMapping("/write")
    public ModelAndView write(BoardDTO board) throws SQLException {// 로그인 안된 사용자는 글쓰기 못하게 하고 싶음.
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
