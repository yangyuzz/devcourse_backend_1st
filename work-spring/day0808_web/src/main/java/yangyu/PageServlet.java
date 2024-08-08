package yangyu;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class PageServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("Page님 요즘 많이 바쁘십니다 ㅠㅠㅋㅋ");
        resp.getWriter().write("Hi hi ~~~ Welcome zzz");
    }
}
