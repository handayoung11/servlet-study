<%@ page import="hello.servlet.domain.MemberRepository" %>
<%@ page import="java.util.List" %>
<%@ page import="hello.servlet.domain.Member" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<%
    MemberRepository memberRepository = MemberRepository.getInstance();
    List<Member> members = memberRepository.findAll();
%>
<html>
<head>
    <title>Title</title>
</head>
<body>
<table>
    <thead>
    <th>id</th>
    <th>username</th>
    <th>age</th>
    </thead>
    <tbody>
    <%
        StringBuilder builder = new StringBuilder();
        for (Member member : members) {
            builder.append("<tr>" +
                    "<td>" + member.getId() + "</td>" +
                    "<td>" + member.getName() + "</td>" +
                    "<td>" + member.getAge() + "</td>" +
                    "</tr>");
        }
        out.write(builder.toString());
        System.out.println(out);
    %>
    </tbody>
</table>
</body>
</html>
