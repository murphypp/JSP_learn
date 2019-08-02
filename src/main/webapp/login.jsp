<%--
  Created by IntelliJ IDEA.
  User: EDZ
  Date: 2019/8/2
  Time: 9:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>login</title>
    <%if("login_error".equals(request.getParameter("message"))){ %>
    <script>alert("请先注册！");</script>
    <%}else if ("password_error".equals(request.getParameter("message"))){%>
    <script>alert("密码错误！")</script>
    <% }%>

    <form action="${pageContext.request.contextPath}/LoginCheck" method="post">
        账号：<input type="text" name="username" id="username"><br>
        密码：<input type="password" name="password" id="password"><br>
        <a href="register.jsp">注册</a> <input type="submit" value="登录">
    </form>


</head>
<body>

</body>
</html>
