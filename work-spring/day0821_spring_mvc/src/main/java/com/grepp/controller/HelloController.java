package com.grepp.controller;


import com.grepp.model.ParamDTO;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller // DispatcherServlet의 관리 대상 객체가 됨.
public class HelloController {

    @RequestMapping(value = "/hello")
    public String hello() {
        // 여기서 컨트롤러가 하고자 하는 작업을 실행할 거임.
        System.out.println("is here??");
        return "hi"; // 기본 설정이 forward임.
    }

//    @RequestMapping(value="/bye", method = RequestMethod.GET)
//    public ModelAndView bye(HttpServletRequest request){
//        System.out.println("param1 : "+request.getParameter("param1"));
//        System.out.println("param2 : "+request.getParameter("param2")+100);
//        System.out.println("param2 num : "+(Integer.parseInt(request.getParameter("param2"))+100));
//        return null;
//    }

//    @GetMapping("/bye")
//        public ModelAndView bye(@RequestParam("param1") String p1,
//                                @RequestParam("param2") int p2){
//        System.out.println("param1:"+p1);
//        System.out.println("param2:"+(p2+100));
//        return null;
//    }

    //    @GetMapping("/bye")
//    public ModelAndView bye(ParamDTO param){
//        System.out.println(param);
//        return null;
//    }
    @PostMapping(value="/bye")
    public ModelAndView bye(@RequestBody ParamDTO param) {
        System.out.println(param);
        return null;
    }
}
