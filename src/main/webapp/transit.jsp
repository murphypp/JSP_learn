<%@ page import="java.util.*" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="C"%>
<html>
<head>
    <title>transit </title>
    <link href="style/table.css" rel="stylesheet" type="text/css" />
</head>
<body >
<body background="http://www.demo.amitjakhu.com/login-form/images/bg.png">

<C:forEach items="${sessionScope.currentPermission}" var="h">
    <a href="${pageContext.request.contextPath}${h.url}" class="btn btn-success" >${h.pname}</a>
</C:forEach>



<br>
<br>
<br>
<br>
<h2>用户信息</h2>
<div class="listTable">
    <table>
        <tr>
            <th>用户名</th>
            <th>真实姓名</th>
            <th>密码</th>
            <th>电话号码</th>
            <th>邮箱</th>
            <th></th>
            <th></th>
        </tr>
            <tr>
                    <td>${sessionScope.currentUser.username}</td>
                    <td>${sessionScope.currentUser.realname}</td>
                    <td>${sessionScope.currentUser.password}</td>
                    <td>${sessionScope.currentUser.phone}</td>
                    <td>${sessionScope.currentUser.email}</td>
                    <td>
                        <a href="${pageContext.request.contextPath}/modify.jsp?username=${sessionScope.currentUser.username}" class="btn btn-inverse">Modify</a>
                    </td>
            </tr>
    </table>
</div>

</body>
</html>
