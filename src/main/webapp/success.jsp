<%@ page import="java.util.*" %>
<%@ page import="main.java.com.ucar.training.User" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="C"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Success</title>
</head>
<body>

<%--定义list保存 Tomcat开启时注册的用户信息--%>
<%--更一般的保存为数据库文件，已写在另一个项目中--%>
<%!
    List<User> userList = new ArrayList<>();
%>

<%
    request.setCharacterEncoding("UTF-8");
    String username = request.getParameter("username");
    String password = request.getParameter("password1");
    String email    = request.getParameter("email");
    String realname = request.getParameter("realname");
    String phone    = request.getParameter("phone");
    String age      = request.getParameter("age");
    String sex      = request.getParameter("sex");
    User a = new User(username,password,email,realname,Integer.parseInt(age),sex,phone);
    userList.add(a);
    request.setAttribute("userList", userList);
%>
<style type="text/css">
    #user
    {
        font-family:"Trebuchet MS", Arial, Helvetica, sans-serif;
        width:100%;
        border-collapse:collapse;
    }

    #user td, #user th
    {
        font-size:1em;
        border:1px solid #98bf21;
        padding:3px 7px 2px 7px;
    }

    #user th
    {
        font-size:1.1em;
        text-align:left;
        padding-top:5px;
        padding-bottom:4px;
        background-color:#A7C942;
        color:#ffffff;
    }

    #user tr.alt td
    {
        color:#000000;
        background-color:#EAF2D3;
    }
</style>


<table id="user" width="50%" border="1" cellspacing="1" cellpadding="1" align="center">
    <tr>
        <td>用户名</td>
        <td>真实姓名</td>
        <td>密码</td>
        <td>电话号码</td>
        <td>年龄</td>
        <td>性别</td>
        <td>邮箱</td>
    </tr>
    <C:forEach items="${requestScope.userList}" var="h">
        <tr>
            <td>${h.username}</td>
            <td>${h.realname}</td>
            <td>${h.password}</td>
            <td>${h.phone}</td>
            <td>${h.age}</td>
            <td>${h.sex}</td>
            <td>${h.email}</td>
        </tr>
    </C:forEach>
</table>
</body>
</html>