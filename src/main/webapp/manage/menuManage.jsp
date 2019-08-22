<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: EDZ
  Date: 2019/8/20
  Time: 10:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>菜单管理</title>
</head>
<style type="text/css">

</style>
<body>
<div>
    <div>
        <a href="${pageContext.request.contextPath}/checkRole.action">回到主页</a>
    </div>
    <table>
        <form action="${pageContext.request.contextPath}/add/addMenu.jsp" method="post">
            <input type="submit" value="添加新权限">
        </form>
        <tr>
            <th>菜单id</th>
            <th>菜单名</th>
            <th>页面路径</th>
            <th>操作</th>
        </tr>
        <%--@elvariable id="permissions" type="java.util.List<com.ucar.training.entity.Permission>"--%>
        <c:forEach var="permission" items="${permissions}">
            <tr>
                <td>${permission.mid}</td>
                <td>${permission.mname}</td>
                <td>${permission.uri}</td>
                <td>
                    <form action="${pageContext.request.contextPath}/delMenu.action" method="post">
                        <input hidden type="hidden" name="mid" value="${permission.mid}">
                        <input type="submit" value="删除">
                    </form>
                    <form action="${pageContext.request.contextPath}/toUpdateMenu.action" method="post">
                        <input hidden type="hidden" name="mid" value="${permission.mid}">
                        <input type="submit" value="修改">
                    </form>
                </td>
            </tr>
        </c:forEach>
    </table>
</div>
</body>
</html>
