<%@ page import="java.util.*" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="C"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<html>
<head>
    <title>userinfo</title>
    <link href="style/table.css" rel="stylesheet" type="text/css" />
</head>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="${pageContext.request.contextPath}/ModifyRole_Permission" method="post" >
    <label >角色名:</label>  <input type="text" name="username" value="${param.username}"  readonly="readonly"  > <br>
    <label >权限:</label><br>

    <C:forEach var="item" items="${applicationScope.permissionListAll}" >
        ${item.permissionName}
        <input type="checkbox" name="permissionList" value="${item.permissionName}"
        <C:forEach var="h" items="${sessionScope.tmpPermissionList}">
            <C:if test="${item.permissionName == h.permissionName }"> checked</C:if>
        </C:forEach>
        >
    </C:forEach>



    <%--
    用户管理 <input type="checkbox" name="permissionList" value="用户管理">
    留言板管理  <input type="checkbox" name="permissionList" value="留言板管理">
    文件管理 <input type="checkbox" name="permissionList" value="文件管理">
    角色管理 <input type="checkbox" name="permissionList" value="角色管理">
    用户留言<input type="checkbox" name="permissionList" value="用户留言">
    权限管理  <input type="checkbox" name="permissionList" value="权限管理">
    角色-权限管理<input type="checkbox" name="permissionList" value="角色-权限管理">
    <br>--%>

    <input type="submit" value="修改" class="" > <input type="reset" name="重置" class="" >
</form>
</body>
</html>
