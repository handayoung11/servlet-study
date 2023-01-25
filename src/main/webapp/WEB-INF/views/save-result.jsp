<%@ page import="hello.servlet.domain.Member" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
성공
<ul>
    <li>
        id=${member.id}
        <%--id=<%=((Member)request.getAttribute("member")).getId()%>--%>
    </li>
    <li>
        name=${member.name}
    </li>
    <li>
        age=${member.age}
    </li>
</ul>
<a href="/index.html">메인</a>
</body>
</html>
