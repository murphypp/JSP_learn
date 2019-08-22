<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: EDZ
  Date: 2019/8/20
  Time: 14:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>添加角色</title>
</head>
<body>
<div>
    <form action="${pageContext.request.contextPath}/addRole.action" method="post">
        <input hidden type="hidden" name="toAdd" value="toAdd">
        <label>角色id
            <input type="text" name="rid">
        </label>
        <br/>
        <label>角色名
            <input type="text" name="rname" >
        </label>
        <br/>
        <div>角色权限
            <%--@elvariable id="permissions" type="java.util.List<com.ucar.training.entity.Permission>"--%>
            <c:forEach var="permission" items="${permissions}">
                <input type="checkbox" name="permission" value="${permission.mid}">
                ${permission.mname}
            </c:forEach>
        </div>
        <input type="submit" value="修改">
    </form>
</div>
</body>
</html>
