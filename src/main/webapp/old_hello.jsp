<%@ page import="com.example.servlet.api.Hello" %><%--jsp가 서블릿 역할까지 모두하고 있는 mvc가 아닌 형태--%>
<%--jsp파일 경로를 webapp이하부터 .jsp까지 직접 호출해줘야한다.--%>

<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<%
//    String name = "kim";
//    int age = 10;


    Hello hello = new Hello();
    hello.setName("kim");
    hello.setAge(30);

%>
<html>
<head>
    <title>Getting Started: Serving Web Content</title>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
</head>
<body>
<%--<p><%=name%></p>--%>
<%--<p><%=age%></p>--%>
<p><%=hello.getName()%></p>
<p><%=hello.getAge()%></p>

</body>
</html>