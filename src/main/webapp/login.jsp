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
        width: 250px;
    }
    .click{
        background: lightblue;
        border-radius: 10px;
        width: 80px;
        height: 40px;
    }
    .login{
        font-size: 20px;
        text-align: right;
    }
</style>
<body>
<div class="form">
    <h2>用户登录</h2>
    <h4><a href="register.jsp">没有账号？点击前往注册</a></h4>
    <div class="login">
        <form action="${pageContext.request.contextPath}/login" method="post" >
            <label>用户名
                <input type="text" name="username">
            </label>
            <br/>
            <label>密码
                <input type="password" name="password">
            </label>
            <br/>
            <input class="click" type="submit" value="登录">
        </form>
        <a href="index.jsp"><button class="click">返回</button></a>
    </div>
</div>
</body>
</html>
