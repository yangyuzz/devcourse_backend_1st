package com.grepp.controller;

import com.grepp.controller.util.MyControllerMapping;
import com.grepp.controller.util.MyPageInfo;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

// board.do, member.do, login.do, ... etc 모두 다 여기로 실행되게
// 그런고로 혹시 다른 서블릿이 있다면 걔들보다 이 서블릿이 더 먼저 생성되게 loadOnStartup=1
// Spring 백엔드 프레임워크 만든 사람들의 생각. 서블릿 단 하나로 다 처리되게 하자. DispatcherServlet!!!!!!!!!!!!!!!!!!!!1
@WebServlet(urlPatterns = "*.do", loadOnStartup = 1)
public class MainServlet extends HttpServlet {
    private MyControllerMapping controllerMapping = new MyControllerMapping();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        process(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        process(req, resp);
    }

    protected  void process(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String url = request.getServletPath();
        System.out.println("request here : "+url);

        try {
            MyController controller = controllerMapping.getController(url); // 얘한테 물어보면 컨트롤러 객체중에 하나 줄거임~ BoardController, MemberController, MainController, ... etc

            Object controllerResult = null;
            if (controller != null) { // 해당 요청을 처리할 컨트롤러 객체가 있음!
                controllerResult = controller.handleRequest(request, response); // 야 일해라~!
            } else { // 해당 요청을 처리할 컨트롤러 못찾았음!
                response.setStatus(HttpServletResponse.SC_NOT_FOUND);
            }

            if (controllerResult instanceof MyPageInfo) { // forward 또는 redirect 둘중 하나일 때 여기 (html 화면이 필요한 경우)
                MyPageInfo pageInfo = (MyPageInfo) controllerResult;
                System.out.println(pageInfo);
                if (pageInfo.isForward()) { // html 만들라고 jsp한테 전달해서 화면 만들기
                    request.getRequestDispatcher("/WEB-INF/views" + pageInfo.getPath()+".jsp").forward(request, response);
                } else { // jsp한테 화면 만들라고 안시키고 앗싸리 새로운 요청 유도하기. ~~~.do 라고 리다이렉트 시키겠쥬
                    response.sendRedirect(request.getContextPath() + pageInfo.getPath());
                }
            } else { // REST 요청에 대한 data 응답. (백엔드가 html 화면이 아니라 날것의 data만 응답하는 경우가 여기. 우리는 이런 백엔드는 아직 안배움^^^^^^^^)

            }
        } catch (Exception e) {
//            throw new RuntimeException(e); // 이러면 tomcat한테까지 예외 던져지는 거임. 걔가 에러페이지 만들거임. 안이쁨......
            e.printStackTrace();
            request.getRequestDispatcher("/WEB-INF/views/error.jsp").forward(request, response);
            return;
        }
    }
}
