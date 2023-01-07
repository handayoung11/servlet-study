package hello.servlet.basic.response;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static javax.servlet.http.HttpServletResponse.*;

@WebServlet(name = "responseHeaderServlet", urlPatterns = "/response-header")
public class ResponseHeaderServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //[status-line]
        resp.setStatus(SC_OK);

        //[response-headers]
        resp.setHeader("Content-Type", "text/plain;charset=utf-8");
        resp.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
        resp.setHeader("Pragma", "no-cache");
        resp.setHeader("my-header", "hello");

        //[Header 편의 메서드]
        content(resp);
        cookie(resp);
        redirect(resp);

        resp.getWriter().println("안녕");
    }

    private void redirect(HttpServletResponse resp) throws IOException {
        //Status Code: 302
        //Location: /basic/hello-form.html

        //resp.setStatus(SC_FOUND);
        //resp.setHeader("Location", "/hello-form.html");
        resp.sendRedirect("/hello-form.html");
    }

    private void cookie(HttpServletResponse resp) {
        //Set-Cookie: myCookie=good; Max-Age=600;
        Cookie cookie = new Cookie("myCookie", "good");
        cookie.setMaxAge(600);
        resp.addCookie(cookie);
    }

    private void content(HttpServletResponse resp) {
        //Content-Type: text/plain;charset=utf-8
        resp.setContentType("text/plain");
        resp.setCharacterEncoding("utf-8");
    }


}
