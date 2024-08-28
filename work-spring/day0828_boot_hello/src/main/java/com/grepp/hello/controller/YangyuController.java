package com.grepp.hello.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class YangyuController {
    @RequestMapping("/yangyu")
    public String yangyu(){
        return "hello.html";
    }

    @RequestMapping("/programmers")
    public String programmers(){
        return "programmers.html";
    }
}
