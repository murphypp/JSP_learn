<%@ page import="java.util.*" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="C"%>
<html>
<head>
    <title>userinfo</title>
    <link href="${pageContext.request.contextPath}/style/table.css" rel="stylesheet" type="text/css" />
</head>
<body background="http://www.demo.amitjakhu.com/login-form/images/bg.png">

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
        <C:forEach items="${requestScope.userList}" var="h">
                <tr>
                    <td>${h.username}</td>
                    <td>${h.realname}</td>
                    <td>${h.password}</td>
                    <td>${h.phone}</td>
                    <td>${h.email}</td>
                    <td>
                        <a href="${pageContext.request.contextPath}/toUpdateUser.action?username=${h.username}" class="btn btn-inverse" >Modify</a>
                        <a href="${pageContext.request.contextPath}/deleteUser.action?username=${h.username}" class="btn btn-danger" >Delete</a>
                    </td>
                </tr>
        </C:forEach>
    </table>
    <a href="${pageContext.request.contextPath}/transit.jsp" class="btn btn-success" >返回</a>
</div>


</body>
</html>