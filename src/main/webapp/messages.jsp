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
    }
    table,th,td{
        border:solid 1px black;
    }
    th,td{
        width: 100px;
    }
    td{
        text-align: center;
    }
</style>
<body>

<div class="messages">
    <div>
        <h2>
            <form method="post" action="${pageContext.request.contextPath}/viewMessages">
                <input hidden type="hidden" name="select" value="all">
                <input type="submit" value="全部留言">
            </form>
        </h2>
    </div>
    <%--@elvariable id="allMessages" type="java.util.List<com.ucar.training.entity.Message>"--%>
    <c:if test="${allMessages ne null}">
        <table style="border-collapse: collapse">
            <tr>
                <th>留言者</th>
                <th>留言信息</th>
                <th>留言时间</th>
                <th>操作</th>
            </tr>
            <c:forEach items="${allMessages}" var="message">
                <tr>
                <td>
                    <form method="post" action="${pageContext.request.contextPath}/viewMessages">
                        <input hidden type="hidden" name="select" value="${message.author}">
                        <input type="submit" value="${message.author}">
                    </form>
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
