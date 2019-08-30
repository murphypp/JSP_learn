<%--
  Created by IntelliJ IDEA.
  User: EDZ
  Date: 2019/8/22
  Time: 14:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="${pageContext.request.contextPath}/addRole.action" method="post" >
    <label >id:</label>  <input type="text" name="id" id="id"    >   <br>
    <label >角色名:</label>  <input type="text" name="roleName"  > <br>
    <input type="submit" value="新增" class="" > <input type="reset" name="重置" class="" >
</form>
</body>
</html>
