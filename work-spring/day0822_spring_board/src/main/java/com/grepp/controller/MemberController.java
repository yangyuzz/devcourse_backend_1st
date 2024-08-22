package com.grepp.controller;

import com.grepp.model.dto.MemberDTO;
import com.grepp.model.service.MemberService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.sql.SQLException;

@Controller
@RequestMapping("/member")
public class MemberController {
    @Autowired
    private MemberService memberService;

    @Autowired
    ApplicationContext context;

    @GetMapping("/login")
    public String login() {
        System.out.println(context);
        System.out.println(context.getApplicationName());
        return "login_form";
    }

    @PostMapping("/login")
    public ModelAndView login(MemberDTO member, HttpSession session, HttpServletRequest request) throws SQLException { // public ModelAndView login(@RequestParam("userid")String userid)
        ModelAndView mav = new ModelAndView("alert");

        String loginId = memberService.login(member.getUserid(), member.getUserpw());
        if (loginId != null) {
            session.setAttribute("loginId", loginId);
            mav.addObject("msg", "login success");
            mav.addObject("path", request.getContextPath() + "/main");
        } else {
            mav.addObject("msg", "login fail");
            mav.addObject("path", request.getContextPath() + "/member/login");
        }
        return mav;
    }

    @GetMapping("/logout")
    public ModelAndView logout(HttpSession session, HttpServletRequest request) {
        ModelAndView mav = new ModelAndView("alert");

        session.invalidate();
        mav.addObject("msg", "logout");
        mav.addObject("path", request.getContextPath() + "/main");
        return mav;
    }
}
