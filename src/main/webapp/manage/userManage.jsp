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
    <title>管理信息</title>
</head>
<style type="text/css">
    body{
        background: goldenrod;
    }
    .users{
        position: relative;
        left: 10%;
        top: 20px;
        right: 10%;
    }
    .click{
        background: paleturquoise;
        border-radius: 10px;
        width: 120px;
        height: 30px;
    }
    table,th,td{
        border:solid 1px black;
    }
    th,td{
        width: 180px;
        text-align: center;
    }
    tr{
        height: 65px;
    }
</style>
<script type="text/javascript">

</script>
<body>
<h1>登录成功！</h1>
<div>
    <div>
        <a href="${pageContext.request.contextPath}/checkRole.action">回到主页</a>
    </div>
    <div class="users">
        <div>
            <%--@elvariable id="current" type="com.ucar.training.entity.User"--%>
            <h2>您是管理员：${current.username}</h2>
            <a href="${pageContext.request.contextPath}/viewMessages.action?select=" target="_blank">
                <button class="click">查看留言板</button>
            </a>
            <a href="${pageContext.request.contextPath}/add/addUser.jsp" target="_blank"><button  class="click">添加普通用户</button></a>
            <a href="${pageContext.request.contextPath}/login.jsp"><button  class="click">退出登录</button></a>
        </div>
        <%--@elvariable id="tip" type="java.lang.String"--%>
        <c:if test="${tip ne null}">
            <h3>${tip}</h3>
        </c:if>
        <h3>已注册的用户</h3>
        <table style="border-collapse: collapse">
            <tr>
                <th>用户名</th>
                <th>年龄</th>
                <th>性别</th>
                <th>爱好</th>
                <th>个性签名</th>
                <th>操作</th>
            </tr>
            <%--@elvariable id="users" type="java.util.Set<com.ucar.training.entity.User>"--%>
            <c:forEach var="user" items="${users}">
                <c:if test="${current ne user.username}">
                    <tr>
                        <td>${user.username}</td>
                        <td>${user.age}</td>
                        <td>${user.sex}</td>
                        <td>${user.hobby}</td>
                        <td>${user.sign}</td>
                        <td>
                            <form action="${pageContext.request.contextPath}/delUser.action" method="post"
                                  onsubmit="return confirm('确定删除？删除后无法恢复')" >
                                <input type="hidden" name="deleted" value="${user.username}">
                                <input type="submit" value="删除">
                            </form>
                            <a href="${pageContext.request.contextPath}/toUpdateUser.action?username=${user.username}"><button value="修改信息">修改信息</button></a>
                        </td>
                    </tr>
                </c:if>
            </c:forEach>
        </table>
    </div>
</div>
</body>
</html>
