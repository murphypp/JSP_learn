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
<script> alert("<%=msg%>");window.location="role_permissionManger.jsp"; </script>
<%
    }
%>




<div class="listTable">
    <table>
        <tr>
            <th>角色名</th>
            <th>权限</th>
            <th></th>
            <th></th>
            <th></th>
            <th></th>
            <th></th>
        </tr>
        <C:forEach items="${applicationScope.userList}" var="h">
            <tr>
                <td>${h.username}</td>
                <td><C:forEach var="item" items="${rolePermissionMap[h.username]}">
                    ${item.permissionName}<br>
                </C:forEach><br>
                </td>
                <td></td>
                <td>
                    <a href="${pageContext.request.contextPath}/ModifyRole_PermissionTemp?username=${h.username}" class="btn btn-inverse">Modify</a>
                </td>
            </tr>
        </C:forEach>
    </table>
    <a href="${pageContext.request.contextPath}/transit.jsp" class="btn btn-success" >返回</a>
</div>


</body>
</html>