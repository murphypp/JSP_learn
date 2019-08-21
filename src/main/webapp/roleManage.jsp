<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: EDZ
  Date: 2019/8/19
  Time: 16:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<div>
    <table>
        <form action="${pageContext.request.contextPath}/roleManage" method="post">
            <input hidden type="hidden" name="add" value="add">
            <input type="submit" value="添加角色">
        </form>
        <tr>
            <th>角色id</th>
            <th>角色名</th>
            <th>角色权限</th>
            <th>操作</th>
        </tr>
        <%--@elvariable id="roles" type="java.util.List<com.ucar.training.entity.Role>"--%>
        <c:forEach items="${roles}" var="role">
            <tr>
                <td>${role.rid}</td>
                <td>${role.rname}</td>
                <td></td>
                <td>
                    <form method="post" action="${pageContext.request.contextPath}/roleManage">
                        <input hidden type="hidden" name="delete" value="delete">
                        <input hidden type="hidden" name="rid" value="${role.rid}">
                        <input hidden type="hidden" name="rname" value="${role.rname}">
                        <input type="submit" value="删除">
                    </form>
                    <form action="${pageContext.request.contextPath}/roleManage" method="post">
                        <input hidden type="hidden" name="update" value="update">
                        <input hidden type="hidden" name="rid" value="${role.rid}">
                        <input type="submit" value="修改角色信息">
                    </form>
                </td>
            </tr>
        </c:forEach>
    </table>
</div>
</body>
</html>
