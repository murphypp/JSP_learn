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

<%
    String msg=(String)request.getAttribute("message");
    if(msg!=null){
%>
<script> alert("<%=msg%>");window.location="permissionManager.jsp"; </script>
<%
    }
%>


<div class="listTable">
    <table>
        <tr>
            <th>id</th>
            <th>权限</th>
            <th>地址</th>
            <th></th>
            <th></th>
            <th></th>
            <th></th>
        </tr>
        <C:forEach items="${applicationScope.permissionListAll}" var="h">
                <tr>
                    <td>${h.id}</td>
                    <td>${h.permissionName}</td>
                    <td>${h.permissionUrl}</td>
                    <td>
                        <a href="${pageContext.request.contextPath}/modifyPermission.jsp?id=${h.id}&permissionName=${h.permissionName}&permissionUrl=${h.permissionUrl}" class="btn btn-inverse">Modify</a>
                        <a href="${pageContext.request.contextPath}/DeletePermission?id=${h.id}" class="btn btn-danger">Delete</a>
                    </td>
                </tr>
        </C:forEach>
    </table>
    <a href="${pageContext.request.contextPath}/addPermission.jsp" class="btn btn-success" >新增</a>
    <a href="${pageContext.request.contextPath}/transit.jsp" class="btn btn-success" >返回</a>
</div>


</body>
</html>