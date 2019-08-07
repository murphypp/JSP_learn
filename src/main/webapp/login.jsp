<%--
  Created by IntelliJ IDEA.
  User: EDZ
  Date: 2019/8/5
  Time: 13:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>登录</title>
</head>
<style type="text/css">
    body{
        background: url("images/indexbg.jpg");
    }
    .form{
        position: relative;
        left: 10%;
        top: 50px;
        height: 100px;
        text-align: right;
        width: 300px;
    }
    .login{
        background: lightblue;
        border-radius: 10px;
        width: 80px;
        height: 40px;
    }
</style>
<body>
<div class="form">
    <form action="${pageContext.request.contextPath}/login" method="post" >
        <label>用户名
            <input type="text" name="username">
        </label>
        <br/>
        <label>密码
            <input type="password" name="password">
        </label>
        <br/>
        <input class="login" type="submit" value="登录">
    </form>
</div>
</body>
</html>
