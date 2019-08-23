<%--
  Created by IntelliJ IDEA.
  User: EDZ
  Date: 2019/8/22
  Time: 9:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="${pageContext.request.contextPath}/ModifyPermission" method="post" >
    <label >id:</label>  <input type="text" name="id" id="id"  value="${param.id}"  >   <br>
    <label >权限:</label>  <input type="text" name="permissionName" value="${param.permissionName}"  > <br>
    <label >地址:</label> <input type="text" name="permissionUrl"   value="${param.permissionUrl}"> <br>
    <input type="submit" value="修改" class="" > <input type="reset" name="重置" class="" >
</form>
</body>
</html>
