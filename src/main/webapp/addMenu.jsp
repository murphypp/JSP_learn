<%--
  Created by IntelliJ IDEA.
  User: EDZ
  Date: 2019/8/20
  Time: 13:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>添加权限</title>
</head>
<body>
<div>
    <form action="${pageContext.request.contextPath}/menuManage" method="post">
        <input type="hidden" hidden name="toAdd" value="toAdd">
        <label>菜单id
            <input type="text" name="mid" >
        </label>
        <br/>
        <label>菜单名
            <input type="text" name="mname">
        </label>
        <br/>
        <label>页面路径
            <input type="text" name="uri">
        </label>
        <br/>
        <input type="submit" value="确认添加">
    </form>
</div>
</body>
</html>
