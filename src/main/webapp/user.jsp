<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%--
  Created by IntelliJ IDEA.
  User: EDZ
  Date: 2019/8/19
  Time: 14:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%--@elvariable id="permissions" type="java.util.List<com.ucar.training.entity.Permission>"--%>

<ul>
    <c:forEach var="permission" items="${permissions}">
        <li>
            <a href="${pageContext.request.contextPath}/action?action=${permission.mname}">${permission.mname}</a>
        </li>
    </c:forEach>
</ul>



</body>
</html>
