<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: EDZ
  Date: 2019/8/20
  Time: 11:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="${pageContext.request.contextPath}/menuManage" method="post">
    <%--@elvariable id="updating" type="com.ucar.training.entity.Permission"--%>
    <input hidden type="hidden" name="toUpdate" value="toUpdate">
    <c:if test="${updating!=null}">
        <label>权限id（不可修改）
            <input type="text" name="mid" value="${updating.mid}" readonly>
        </label>
        <br/>
        <label>权限名
            <input type="text" name="mname" value="${updating.mname}">
        </label>
        <br/>
        <label>页面路径
            <input type="text" name="uri" value="${updating.uri}">
        </label>
        <br/>
        <input type="submit" value="确认修改">
    </c:if>

</form>
</body>
</html>
