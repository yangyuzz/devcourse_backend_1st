package com.grepp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/board")
public class BoardController {
    @GetMapping("/list")
    public ModelAndView list(){
        ModelAndView mav = new ModelAndView("list");

        return mav;
    }
}
