package hello.servlet.basic.response;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "responseHtmlServlet", urlPatterns = "/response-html")
public class ResponseHtmlServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //Content-Type: text/html;utf-8
        resp.setContentType("text/html");
        resp.setCharacterEncoding("utf-8");

        resp.getWriter()
                .print("<html>\n" +
                        "<body>\n" +
                        "<div>안녕?</div>\n" +
                        "</body>\n" +
                        "</html>");
    }
}
