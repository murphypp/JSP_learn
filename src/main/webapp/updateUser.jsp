<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: EDZ
  Date: 2019/8/5
  Time: 19:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>编辑用户信息</title>
</head>
<style type="text/css">
    body{
        background: url("images/indexbg.jpg");
    }
    .updateUser{
        position:relative;
        left: 20%;
        top: 10%;
        width: 400px;
        z-index: 1;
    }
    span{
        cursor: pointer;
        display: inline-block;
        padding: 3px 6px;
        text-align: right;
        width: 100px;
        vertical-align: top;
    }
    .submit{
        height: 50px;
        font-size: 16px;
        font-weight: 700;
        background-image: none;
        position: relative;
        float: left;
        left: 25px;
        width: 350px;
        background-color: #3f89ec;
    }
    .input{
        width: 400px;
    }
    .false{
        color: red;
    }
    input{
        border-radius: 20px;
    }
</style>
<body>
<%--@elvariable id="users" type="java.util.Set<com.ucar.training.entity.User>"--%>
<%--@elvariable id="userid" type="java.lang.String"--%>
<div class="updateUser">
    <h2>修改用户${param.userid}的信息</h2>
    <%--@elvariable id="tip" type="java.lang.String"--%>
    <c:if test="${tip ne null}">
        <h3>${tip}</h3>
    </c:if>
    <c:forEach var="user" items="${users}">
    <c:if test="${user.username eq param.userid}">
    <form id="regisform" action="${pageContext.request.contextPath}/updateUser" method="post"  onsubmit="return check()&&confirm('确认修改？')">
        <input hidden value="register" type="hidden" name="source">
        <div class="input">
            <span>用户名：       </span>
            <input type="text" id="username" name="username"  value="${param.userid}" style="width: 200px">
            <span class="false" id="userFalse"></span>
        </div>
        <div>
            <span>性别：         </span>
            <c:if test="${user.sex eq 'male'}">
                <input type="radio" name="sex" value="male" checked>男
                <input type="radio" name="sex" value="female">女
            </c:if>
            <c:if test="${user.sex eq 'female'}">
                <input type="radio" name="sex" value="male" >男
                <input type="radio" name="sex" value="female" checked>女
            </c:if>
        </div>
        <div class="input">
            <span>年龄：         </span>
            <input type="text" id="age" name="age" value="${user.age}" style="width: 200px">
            <span class="false" id="ageFalse"></span>
        </div>
        <div >
            <span>爱好：          </span>
            <input type="checkbox" name="likes" value="sing">唱歌
            <input type="checkbox" name="likes" value="reading">看书
            <input type="checkbox" name="likes" value="playing">游戏
            <input type="checkbox" name="likes" value="sports">户外运动
            <span class="false" id="likesFalse"></span>
        </div>
        <div class="input">
            <span>个人签名：       </span>
            <textarea id="area" name="area" style="width: 200px;height: 100px;border-radius: 10px">${user.sign}</textarea>
            <span class="false" id="areaFalse"></span>
        </div>
        <div>
            <input type="submit" value="更新信息"  class="submit">
            <br/>
            <input type="button" value="取消" class="submit" onclick="window.history.back()">
        </div>
        </c:if>
        </c:forEach>
</div>

</body>
</html>
