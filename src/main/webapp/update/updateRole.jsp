<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: EDZ
  Date: 2019/8/20
  Time: 14:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>更新角色信息</title>
</head>
<body>
<div>
    <%--@elvariable id="updatingRole" type="com.ucar.training.entity.Role"--%>
    <%--@elvariable id="permissions" type="java.util.List<com.ucar.training.entity.Permission>"--%>
    <c:if test="${updatingRole != null}">
        <form action="${pageContext.request.contextPath}/updatingRole.action" method="post">
            <label>角色id（不可修改）
                <input type="text" name="rid" value="${updatingRole.rid}" readonly>
            </label>
            <br/>
            <label>角色名
                <input type="text" name="rname" value="${updatingRole.rname}">
            </label>
            <br/>
            <div>角色权限
                <c:forEach var="permission" items="${permissions}">
                    <input type="checkbox" name="permission" value="${permission.mid}"
                    <c:forEach items="${updatingRole.permissions}" var="rolePermission">
                           <c:if test="${rolePermission.mid == permission.mid}">checked</c:if>
                    </c:forEach>
                    >${permission.mname}
                </c:forEach>
            </div>
            <input type="submit" value="修改">
            <button><a href="${pageContext.request.contextPath}/roleManage.action">取消</a></button>
        </form>
    </c:if>

</div>
</body>

</html>
