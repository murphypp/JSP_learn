<%--
  Created by IntelliJ IDEA.
  User: EDZ
  Date: 2019/8/5
  Time: 10:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>login</title>
    <link href="login.css" rel="stylesheet" type="text/css" />
    <%if("login_error".equals(request.getParameter("message"))){ %>
    <script>alert("请先注册！");</script>
    <%}else if ("password_error".equals(request.getParameter("message"))){%>
    <script>alert("密码错误！")</script>
    <% }%>
    <%
        String msg=(String)request.getAttribute("message");
        if(msg!=null){
    %>
    <script> alert("<%=msg%>");window.location="login.jsp";</script>
    <%
        }
    %>
</head>
<body>
<form name="login-form" class="login-form" action="${pageContext.request.contextPath}/LoginCheck" method="post">

    <div class="header">
        <h1>Welcome to Ucar</h1>
        <span>Please, login first</span>
    </div>

    <div class="content">
        <input name="username" type="text" class="input username" placeholder="Username" id="username" />
        <div class="user-icon"></div>
        <input name="password" type="password" class="input password" placeholder="Password" id="password" />
        <div class="pass-icon"></div>
    </div>

    <div class="footer">
        <a href="register.jsp" class="button2">Register</a>
        <input type="submit" class="button1" value="Login">
    </div>

</form>


</body>
</html>
