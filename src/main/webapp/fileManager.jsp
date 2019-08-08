<%--
  Created by IntelliJ IDEA.
  User: EDZ
  Date: 2019/8/6
  Time: 11:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.*" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="C"%>

<html>
<head>
    <title>Title</title>
    <link href="style/table.css" rel="stylesheet" type="text/css" />
</head>

<%
    String msg=(String)request.getAttribute("message");
    if(msg!=null){
%>
    <script> alert("<%=msg%>");window.location="fileManager.jsp";</script>
<%
    }
%>

<body>
<body background="http://www.demo.amitjakhu.com/login-form/images/bg.png">

<div class="form-horizontal" ng-controller="castRoles.controller">
    <h2></h2>

    <form name="uploadForm" method="POST" enctype="multipart/form-data" action="${pageContext.request.contextPath}/UploadFile">
        <h3>文件上传</h3>

        <div class="addTable">
            <table>
                文件: <input type="file" name="upfile"><br/><br/>
                <input type="submit" value="上传">
            </table>
        </div>

        <div class="clearfix"></div>

        <h3>文件管理  <a href="${pageContext.request.contextPath}/ListUploadedFiles" style="color: #2e8aea">刷新</a></h3>
        <div class="listTable">
            <table>
                <tr>
                    <th>文件名</th>
                    <th></th>
                    <th></th>
                    <th></th>
                </tr>
                <C:forEach items="${requestScope.fileList}" var="h">
                        <tr>
                            <td>${h.name}</td>
                            <td></td>
                            <td></td>
                            <td>
                                <a href="${pageContext.request.contextPath}/DownloadFile?filename=${h.name}" class="btn btn-inverse">Download</a>
                                <a href="${pageContext.request.contextPath}/DeleteUploadedFile?filename=${h.name}" class="btn btn-danger">Delete</a>
                            </td>
                        </tr>
                </C:forEach>
            </table>
        </div>

    </form>
    <a href="${pageContext.request.contextPath}/transit.jsp" class="btn btn-success">返回</a>
</div>


</body>
</html>
