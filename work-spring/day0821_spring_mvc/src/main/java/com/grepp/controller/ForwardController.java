package com.grepp.controller;

import com.grepp.model.ParamDTO;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.Date;

@Controller
@RequestMapping("/forward") // localhost:8080/mvc/forward/~~~~ 이렇게 생긴 애들 일단 다 이 클래스로
public class ForwardController {
    @RequestMapping("/mav")
    public ModelAndView mav(){
        ModelAndView mav = new ModelAndView();
        mav.setViewName("view1"); // viewResolver를 거쳐서 /WEB-INF/views/view1.jsp 라고 뷰 경로가 완성됨.
        mav.addObject("msg", "Forward컨트롤러가 뷰에게 전달하는 데이터");
        mav.addObject("now", new Date());
        return mav; // 데이터와 그 데이터를 전달받을 뷰의 이름이 모두 들어있음.
    }

    // return 되는 String을 뷰 이름으로 하고 전달받은 파라미터 DTO 객체와 추가로 데이터를 더 담은 model의 gugudan등도
    // 모두 뷰에게 전달할 수 있음.
    @RequestMapping("/str")
    public String str(@ModelAttribute("param") ParamDTO param, Model model){
        model.addAttribute("gugudan", 6);
        return "view2"; // view 이름이라고 생각함. /WEB-INF/views/view2.jsp
    }

    @PostMapping("/redirect")
    public String redirect(@RequestParam("age") int age, RedirectAttributes attr){
        attr.addAttribute("age", age); // hahaha한테 재요청 보낼때 이 데이터도 보낼 수 있음.
        return "redirect:hahaha"; // hahaha.jsp를 찾는게 아니라 /forward/hahaha라는 요청을 다시 보내게 됨.
    }

    @GetMapping("/hahaha")
    public String hahaha(@RequestParam(value="age",defaultValue = "1") int age){
        System.out.println("hahaha receive ?? "+age);
        return "view3";
    }
}
