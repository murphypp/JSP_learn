<%@ page import="java.util.*" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="C"%>
<html>
<head>
    <title>Success</title>
    <link href="style/table.css" rel="stylesheet" type="text/css" />
</head>
<body background="http://www.demo.amitjakhu.com/login-form/images/bg.png">

<%
    String msg=(String)request.getAttribute("message");
    if(msg!=null){
%>
<script> alert("<%=msg%>");window.location="userinfo.jsp";</script>
<%
    }
%>



<div class="listTable">
    <table>
        <tr>
            <th>文件名</th>
            <th>真实姓名</th>
            <th>密码</th>
            <th>邮箱</th>
            <th></th>
            <th></th>
        </tr>
        <C:forEach items="${applicationScope.userList}" var="h">
            <C:if test="${(sessionScope.privileges )}" var="flag" scope="session">
            <tr>
                <td>${h.username}</td>
                <td>${h.realname}</td>
                <td>${h.password}</td>
                <td>${h.email}</td>
                <td>
                    <a href="${pageContext.request.contextPath}/modify.jsp?username=${h.username}" class="btn btn-inverse">Modify</a>
                    <a href="${pageContext.request.contextPath}/DeleteUser?username=${h.username}" class="btn btn-danger">Delete</a>
                </td>
            </tr>
            </C:if>

            <C:if test="${!(sessionScope.privileges )}" var="flag" scope="session">
                <C:if test="${sessionScope.user eq h.username}">
                <tr>
                    <td>${h.username}</td>
                    <td>${h.realname}</td>
                    <td>${h.password}</td>
                    <td>${h.email}</td>
                    <td>
                        <a href="${pageContext.request.contextPath}/modify.jsp?username=${h.username}" class="btn btn-inverse">Modify</a>
                    </td>
                </tr>
               </C:if>
            </C:if>

        </C:forEach>
    </table>
    <a href="${pageContext.request.contextPath}/transit.jsp" class="btn btn-success" >返回</a>
</div>


</body>
</html>