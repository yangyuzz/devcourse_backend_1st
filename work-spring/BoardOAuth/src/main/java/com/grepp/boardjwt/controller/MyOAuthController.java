package com.grepp.boardjwt.controller;

import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/oauth2")
public class MyOAuthController {
    @RequestMapping("/mycallback")
    public void here(){
        System.out.println("is here");
    }

}
