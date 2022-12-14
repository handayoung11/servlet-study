package hello.servlet.basic.request;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 1. 파라미터 전송기능
 * /request-param?username=hello&age=20
 *
 * 2. 복수 파라미터 전송기능
 * /request-param?username=hello2&uesrname=kim&age=20
 */
@WebServlet(name = "requestParamServlet", urlPatterns = "/request-param")
public class RequestParamServlet extends HttpServlet {

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) {
        System.out.println("[전체 파라미터 조회] - start");
        req.getParameterNames().asIterator()
                        .forEachRemaining(name -> System.out.println(name + " = " + req.getParameter(name)));
        System.out.println("[전체 파라미터 조회] - end\n");

        System.out.println("[단일 파라미터 조회] - start");
        String username = req.getParameter("username");
        String age = req.getParameter("age");

        System.out.println("username = " + username);
        System.out.println("age = " + age);
        System.out.println("[단일 파라미터 조회] - end\n");

        System.out.println("[복수 파라미터 조회] - start");
        String[] usernames = req.getParameterValues("username");
        for (String name : usernames) {
            System.out.println("username = " + name);
        }
        System.out.println("[복수 파라미터 조회] - end\n");
    }
}
