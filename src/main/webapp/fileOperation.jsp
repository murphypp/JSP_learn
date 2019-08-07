<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: EDZ
  Date: 2019/8/6
  Time: 16:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<style type="text/css">
    body{
        background: cadetblue;
    }
    .upload{
        background: aquamarine;
        height:200px ;
    }
    .lists{
        background: cornflowerblue;
        height: 400px;
    }
    table{
    }
    th,td{
        width: 250px;
        text-align: left;
    }
</style>
<body>
<div class="upload">
    <h3>文件上传</h3>
    <div>
        <form action="${pageContext.request.contextPath}/upload" method="post" enctype="multipart/form-data">
            <input type="file" name="upload">
            <br/><br/><br/><br/>
            <input type="submit" value="确认上传">
        </form>
    </div>
</div>
<div class="lists">
    <h3>文件列表</h3>
    <%--@elvariable id="files" type="java.util.Set<java.lang.String>"--%>
    <c:if test="${files ne null}">
        <table>
            <tr>
                <th>文件名</th>
                <th></th>
            </tr>
            <c:forEach items="${files}" var="file">
                <tr>
                    <td>${file}</td>
                    <td>
                        <a href="${pageContext.request.contextPath}/download?download=${file}">下载</a>
                    </td>
                </tr>
            </c:forEach>
        </table>
    </c:if>
</div>
</body>
</html>
