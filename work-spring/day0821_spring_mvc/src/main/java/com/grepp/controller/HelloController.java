package com.grepp.controller;


import com.grepp.model.ParamDTO;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.Map;

@Controller // DispatcherServlet의 관리 대상 객체가 됨.
public class HelloController {

    @RequestMapping(value = "/hello")
    public String hello() {
        // 여기서 컨트롤러가 하고자 하는 작업을 실행할 거임.
        System.out.println("is here??");
        return "hi"; // 기본 설정이 forward임.
    }

    // 원래는 이런식으로 request 객체의 파라미터를 하나하나 처리해줬어야 함.
//    @RequestMapping(value="/bye", method = RequestMethod.GET)
//    public ModelAndView bye(HttpServletRequest request){
//        System.out.println("param1 : "+request.getParameter("param1"));
//        System.out.println("param2 : "+request.getParameter("param2")+100);
//        System.out.println("param2 num : "+(Integer.parseInt(request.getParameter("param2"))+100));
//        return null;
//    }

    // 스프링이 @RequestParam 애노테이션을 통해 해당 파라미터 알아서 받아서 파싱해서 변수로 넣어줌.
    @GetMapping("/bye")
    public ModelAndView bye(@RequestParam("param1") String p1,
                            @RequestParam(value = "param2", required = false, defaultValue = "1") int p2) {
        System.out.println("param1:" + p1);
        System.out.println("param2:" + (p2 + 100));
        return null;
    }

    // 파라미터가 여러 개 인데 한꺼번에 받아서 처리하고 싶을 때 객체 하나에 다 담아주기도 함.
    // 이 때, 객체의 멤버변수 이름과 클라이언트 파라미터 이름을 일치는 시켜야 함.
//    @GetMapping("/bye")
//    public ModelAndView bye(ParamDTO param) {
//        System.out.println(param);
//        return null;
//    }

//    @GetMapping("/bye")
//    public ModelAndView bye(@RequestParam Map<String, Object> param){
//        System.out.println(param);
//        return null;
//    }

}
