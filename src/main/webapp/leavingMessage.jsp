<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: EDZ
  Date: 2019/8/5
  Time: 17:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>登录成功</title>
</head>
<style type="text/css">
    body{
        background: darkgoldenrod;
    }
    .leaveMessage{
        position: relative;
        left: 10%;
        top: 20px;
    }
    .message{
        width:400px;
        height: 100px;
        scroll-behavior: smooth;
    }
    .click{
        background: paleturquoise;
        border-radius: 10px;
        width: 120px;
        height: 30px;
    }
    .submit{
        background: #3f89ec;
        border-radius: 10px;
        width: 80px;
        height: 40px;
        font-size: 20px;
    }
</style>
<body>
<div>
    <%--@elvariable id="current" type="com.ucar.training.entity.User"--%>
    <h1>欢迎登录：${current.username}</h1>
    <div>
        <a href="${pageContext.request.contextPath}/checkRole.action">回到主页</a>
    </div>
    <div class="leaveMessage">
        <h3>这里是留言板，您可以在这里留言</h3>
        <%--@elvariable id="count" type="java.util.List<com.ucar.training.entity.Permission>"--%>
        <c:if test="${count ne null}">
            <h6>您之前已经发布了${count.size()}条留言</h6>
        </c:if>
        <c:if test="${count eq null}">
            <h6>您还没有发布过留言</h6>
        </c:if>
        <form method="post" action="${pageContext.request.contextPath}/addMessage.action">
            <label>留言
                <br/>
                <textarea name="message"  class="message">没什么好说的。。</textarea>
            </label>
            <br/>
            <input type="submit" class="submit" value="发布">
            <%--@elvariable id="warning" type="java.lang.String"--%>
            <span>${warning}</span>
        </form>
    </div>
</div>

</body>
</html>
