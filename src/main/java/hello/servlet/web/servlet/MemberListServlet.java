package hello.servlet.web.servlet;

import hello.servlet.domain.Member;
import hello.servlet.domain.MemberRepository;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet(name = "memberListServlet", urlPatterns = "/servlet/members")
public class MemberListServlet extends HttpServlet {

    MemberRepository memberRepository = MemberRepository.getInstance();

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        List<Member> members = memberRepository.findAll();

        resp.setContentType("text/html");
        resp.setCharacterEncoding("utf-8");

        StringBuilder html = new StringBuilder();
        PrintWriter w = resp.getWriter();

        html.append("<html>\n" +
                "<head>\n" +
                "    <meta charset=\"UTF-8\">\n" +
                "    <title>Title</title>\n" +
                "</head>\n" +
                "<body>\n" +
                "<a href=\"/index.html\">메인</a>\n" +
                "<table>\n" +
                "    <thead>\n" +
                "    <th>id</th>\n" +
                "    <th>username</th>\n" +
                "    <th>age</th>\n" +
                "    </thead>\n" +
                "    <tbody>\n" +
                "    <tr>\n");
        for (Member member : members) {
            html.append("    <tr>\n" +
                    "        <td>" + member.getId() + "</td>\n" +
                    "        <td>" + member.getName() + "</td>\n" +
                    "        <td>" + member.getAge() + "</td>\n" +
                    "    </tr>\n");
        }
        html.append("    </tbody>\n" +
                "</table>\n" +
                "</body>\n" +
                "</html>");
        System.out.println(html.capacity());
        w.write(html.toString());
    }
}
