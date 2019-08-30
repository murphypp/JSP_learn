<%@ page import="java.util.*" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="C"%>
<html>
<head>
    <title>userinfo</title>
    <link href="style/table.css" rel="stylesheet" type="text/css" />
</head>
<body background="http://www.demo.amitjakhu.com/login-form/images/bg.png">




<div class="listTable">
    <table>
        <tr>
            <th>id</th>
            <th>权限</th>
            <th></th>
            <th></th>
            <th></th>
            <th></th>
            <th></th>
        </tr>
        <C:forEach items="${requestScope.roleList}" var="h">
            <tr>
                <td>${h.rid}</td>
                <td>${h.rname}</td>
                <td>
                    <a href="${pageContext.request.contextPath}/toUpdateRole.action?rid=${rid}" class="btn btn-inverse" >Modify</a>
                    <a href="${pageContext.request.contextPath}/deleteRole.action?rid=${rid}" class="btn btn-danger" >Delete</a>
                </td>
            </tr>
        </C:forEach>
    </table>
    <a href="${pageContext.request.contextPath}/add/addRole.jsp" class="btn btn-success" >新增</a>
    <a href="${pageContext.request.contextPath}/transit.jsp" class="btn btn-success" >返回</a>
</div>


</body>
</html>