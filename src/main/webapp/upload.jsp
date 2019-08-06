
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>文件上传测试</title>
</head>
<body>
<form method="POST" enctype="multipart/form-data" action="${pageContext.request.contextPath}/UploadFile">
    文件: <input type="file" name="upfile"><br/>
    <br/>
    <input type="submit" value="上传">
</form>
<c:if test="${not empty errorMessage}">
    <input type="text" id="errorMessage" value="${errorMessage}" style="color:red;" disabled="disabled">
</c:if>
</body>
</html>
