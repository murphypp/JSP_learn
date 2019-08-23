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

<C:forEach items="${sessionScope.permissionList}" var="h">
    <a href="${pageContext.request.contextPath}${h.permissionUrl}" class="btn btn-success" >${h.permissionName}</a>
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
        <C:forEach items="${applicationScope.userList}" var="h">
            <C:if test="${sessionScope.user eq h.username}">
            <tr>
                    <td>${h.username}</td>
                    <td>${h.realname}</td>
                    <td>${h.password}</td>
                    <td>${h.phone}</td>
                    <td>${h.email}</td>
                    <td>
                        <a href="${pageContext.request.contextPath}/modify.jsp?username=${h.username}" class="btn btn-inverse">Modify</a>
                    </td>
                </tr>
           </C:if>
        </C:forEach>
    </table>
</div>

</body>
</html>
