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
    <title>管理员添加新用户</title>
</head>
<style type="text/css">
    body{
        background: url("images/indexbg.jpg");
    }
    .addUser{
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
<script type="text/javascript">
    var text ="";
    function ajaxCheck(username) {
        var xmlhttp;
        if (window.XMLHttpRequest) {
            xmlhttp=new XMLHttpRequest();
        } else {
            xmlhttp=new ActiveXObject("Microsoft.XMLHTTP");
        }
        xmlhttp.onreadystatechange=function() {
            if (xmlhttp.readyState===4 && xmlhttp.status===200)
            {
                text = xmlhttp.responseText;
            }
        };
        xmlhttp.open("GET","${pageContext.request.contextPath}/checkUser?username="+username,true);
        xmlhttp.send();
        if (text === "1"){
            return true;
        }else if (text === "0"){
            return false;
        }
    }
    function checkUsername() {
        var username = document.getElementById("username").value;
        var warn = document.getElementById("userFalse");
        warn.innerHTML = "";
        var uPattern = /^[a-zA-Z0-9_-]{6,16}$/;
        var check = true;
        if (!uPattern.test(username)){
            warn.innerHTML = "用户名格式错误！";
            check = false;
            return check;
        }
        if(ajaxCheck(username)){
            warn.innerHTML = "用户名已存在！";
            check =false;
        }else {
            warn.innerHTML = "用户名可以使用";
        }
        return check;
    }
    function checkPasswd() {
        var password = document.getElementById("password").value;
        var e_password = document.getElementById("e_password").value;
        var warn = document.getElementById("PassFalse");
        warn.innerHTML = "";
        var uPattern = /^[a-zA-Z0-9_-]{6,18}$/;
        var check = true;
        if (password === ""){
            warn.innerHTML = "密码不能为空";
            check = false;
        }
        if (!uPattern.test(password)){
            warn.innerHTML = "密码格式错误";
            check = false;
        }
        return check;
    }
    /**
     * @return {boolean}
     */
    function EnsurePasswd() {
        var password = document.getElementById("password").value;
        var e_password = document.getElementById("e_password").value;
        var warn = document.getElementById("ePassFalse");
        warn.innerHTML = "";
        if (password !== e_password){
            warn.innerHTML = "两次输入密码不一致！";
            return  false;
        }
        return true;
    }
    function checkAge() {
        var age = document.getElementById("age").value;
        var warn = document.getElementById("ageFalse");
        var check = true;
        warn.innerHTML = "";
        if (age.match(/\D/)){
            warn.innerHTML = "请输入数字！";
            check = false;
        }
        if (age < 1 || age > 150){
            warn.innerHTML = "请输入1-150的数字";
            check = false;
        }
        return check;
    }
    function checkBox() {
        var likes = document.getElementsByName("likes");
        var flag = true;
        var warn = document.getElementById("likesFalse");
        warn.innerHTML = "";
        for(var i = 0; i<likes.length; i++){
            if(likes[i].checked){
                flag = false;
                break;
            }
        }
        if (flag){
            warn.innerHTML = "请至少选择一项";
        }
        return !flag;
    }
    function checkTextarea() {
        var sign = document.getElementById("area").value;
        var warn = document.getElementById("areaFalse");
        warn.innerHTML = "";
        if (sign.length<1){
            warn.innerHTML ="个性签名不能为空";
            return false;
        }
        return true;
    }
    function check() {
        var result = false;
        var c1 = checkUsername();
        var c2 = checkAge();
        var c3 = checkPasswd();
        var c4 = EnsurePasswd();
        var c5 = checkBox();
        var c6 = checkTextarea();
        if( c1 && c2 && c3 && c4 && c5 && c6){
            return true;
        }
        return false;
    }
</script>

<body style="background: aliceblue url('images/timg.jpg') " >
<div class="addUser">
    <h1>添加新用户</h1>
    <%--@elvariable id="tip" type="java.lang.String"--%>
    <c:if test="${tip ne null}">
        <h3>${tip}</h3>
    </c:if>
    <form id="addForm" action="${pageContext.request.contextPath}/userRegist" method="post"  onsubmit="return check()">
        <input hidden value="add" type="hidden" name="source">
        <div class="input">
            <span>用户名：       </span>
            <input type="text" id="username" name="username"  onchange="checkUsername()" onblur="checkUsername()" style="width: 200px">
            <span class="false" id="userFalse"></span>
        </div>
        <div>
            <span>性别：         </span>
            <input type="radio" name="sex" value="male" checked>男
            <input type="radio" name="sex" value="female">女
        </div>
        <div class="input">
            <span>年龄：         </span>
            <input type="text" id="age" name="age" onchange="checkAge()" style="width: 200px">
            <span class="false" id="ageFalse"></span>
        </div>
        <div class="input">
            <span>密码：         </span>
            <input type="password" id="password" name="password" onchange="checkPasswd()" style="width: 200px">
            <span class="false" id="PassFalse"></span>
        </div>
        <div class="input">
            <span>确认密码：      </span>
            <input type="password" id="e_password" name="e_password" onchange="EnsurePasswd()" style="width: 200px">
            <span class="false" id="ePassFalse"></span>
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
            <textarea id="area" name="area" style="width: 200px;height: 100px;border-radius: 10px">没心情。。</textarea>
            <span class="false" id="areaFalse"></span>
        </div>
        <div>
            <input type="submit" value="添加"  class="submit">
            <br/>
            <input type="button" value="取消" class="submit" onclick="window.close()">
        </div>
    </form>
</div>
</body>
</html>
