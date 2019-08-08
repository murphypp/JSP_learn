<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: EDZ
  Date: 2019/8/6
  Time: 15:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>留言板</title>
</head>
<style type="text/css">
    body{
        background: url("images/timg.jpg");
    }
    .messages{
        position: relative;
        left: 10%;
        top: 20px;
        width: 550px;
    }
    .action{
        width: 550px;
    }
    table,th,td{
        border:solid 1px black;
    }
    td{
        height: 65px;
        text-align: center;
    }
</style>
<body>

<div class="messages">
    <div class="action">
        <div>
            <form method="post" action="${pageContext.request.contextPath}/viewMessages">
                <input hidden type="hidden" name="select" >
                <input type="submit" value="全部留言">
            </form>
        </div>
        <div style="text-align: left">
            <button onclick="window.close()">退出</button>
        </div>
    </div>
    <%--@elvariable id="allMessages" type="java.util.List<com.ucar.training.entity.Message>"--%>
    <c:if test="${allMessages ne null}">
        <table style="border-collapse: collapse">
            <tr>
                <th>留言者</th>
                <th style="width: 250px;">留言信息</th>
                <th style="width: 200px;">留言时间</th>
                <th>操作</th>
            </tr>
            <c:forEach items="${allMessages}" var="message">
                <tr>
                <td>
                    <a href="${pageContext.request.contextPath}/viewMessages?select=${message.author}" style="color: black">${message.author}</a>
                </td>
                <td>${message.content}</td>
                <td>${message.time}</td>
                <td>
                    <form method="post" onsubmit="return confirm('确认删除？')" action="${pageContext.request.contextPath}/deleteMessage">
                        <input type="hidden" name="ID" hidden value="${message.ID}">
                        <input type="submit" value="删除留言">
                    </form>
                </td>
                </tr>
            </c:forEach>
        </table>
    </c:if>
</div>
</body>
</html>
