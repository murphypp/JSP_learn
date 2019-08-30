<%--
  Created by IntelliJ IDEA.
  User: LinShaoxiong
  Date: 2019/7/30
  Time: 8:53
  To change this template use File | Settings | File Templates.
--%>



<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>register</title>
    <link href="style/register.css" rel="stylesheet" type="text/css" />
    <script>
        //定义全局不可提交变量
        var flag=1;
        var testpassword;
        var text="";
        function check() {
            var xmlHttp ;
            if(window.XMLHttpRequest) xmlHttp=new XMLHttpRequest();
            xmlHttp.onreadystatechange = function() {
                if(xmlHttp.readyState == 4 && xmlHttp.status == 200) {
                    if(xmlHttp.responseText === "1") {
                        document.getElementById("ERROR_name").innerHTML = "用户名已被注册！";
                        flag=1;
                    } else {
                        document.getElementById("ERROR_name").innerHTML = "";
                        flag=0;
                    }
                }
            };
            var username = document.getElementById("username").value;
            xmlHttp.open("GET", "${pageContext.request.contextPath}/RegisterCheck?username="+username, true);
            xmlHttp.send();
        }
        function showErrorName() {
            var name = document.getElementById("username").value;
            var reg= /[a-zA-Z0-9]/;
            if(name.length<6||name.length>16){
                document.getElementById("ERROR_name").innerText="长度为6-16个字符";
                flag=1;
            }else if(!reg.test(name)){
                document.getElementById("ERROR_name").innerText="用户名只能由字母和数字组成";
                flag=1;
            }
            else { //进入检验是否重复阶段
                check();
            }
        }
        function isEmpty(obj) {
            var obj= obj.replace(/(^\s*)|(\s*$)/g, '');
            if(typeof obj=="undefined"||obj==null||obj=="")
                return true;
            else
                return false
        }
        function showErrorAge() {
            var reg=/^\d+$/;
            var age=document.getElementById("age").value;
            if(isEmpty(age)) {
                document.getElementById("ERROR_age").innerText="*(为必填)";
                flag=1;
            }
            else if(reg.test(age)&&age>=1&&age<=150){
                document.getElementById("ERROR_age").innerText="";
                flag=0;
            }else {
                document.getElementById("ERROR_age").innerText="年龄必须为数字";
            }
        }
        function showErrorPassword1() {
            var reg= /[a-zA-Z0-9]{6,18}/;
            var password1=document.getElementById("password1").value;
            if(isEmpty(password1)) {
                document.getElementById("ERROR_password1").innerText="*(为必填)";
                flag=1;
            }else if(!reg.test(password1)){
                document.getElementById("ERROR_password1").innerText="密码6-18位，只能由字母数字组成!";
                flag=1;
            }
            else{
                testpassword=password1;
                document.getElementById("ERROR_password1").innerText="";
                flag=0;
            }
        }
        function showErrorPassword2() {
            var password2=document.getElementById("password2").value;
            if(isEmpty(password2)) {
                document.getElementById("ERROR_password2").innerText="*(为必填)";
                flag=1;
            }
            else if(testpassword==password2){
                document.getElementById("ERROR_password2").innerText="";
                flag=0;
            }else {
                document.getElementById("ERROR_password2").innerText="两次密码不一致";
                flag=1;
            }
        }
        function showErrorEmail() {
            var reg=/^\w+@[a-zA-Z0-9]{2,10}(?:\.[a-z]{2,4}){1,3}$/;
            var email=document.getElementById("email").value;
            if(isEmpty(email)) {
                document.getElementById("ERROR_email").innerText="*(为必填)";
                flag=1;
            }
            else if(reg.test(email)){
                document.getElementById("ERROR_email").innerText="";
                flag=0;
            }else{
                document.getElementById("ERROR_email").innerText="邮件名不符合格式";
            }
        }
        function showErrorCheck() {
            var checkbox = document.getElementsByName("hobby");
            var checksum=0;
            for(var i=0;i<checkbox.length;i++)
            {
                if(checkbox[i].checked)
                checksum++;
            }
            if(checksum>=1){
                    flag=0;
                    document.getElementById("ERROR_hobby").innerText="";
            }else {
                flag=1;
                document.getElementById("ERROR_hobby").innerText="请至少选择一个";
            }
        }
        function submitTest() {
            if(flag==1){
                alert("请检查必填项！");
                return false;
            }
            else {
                return true;
            }

        }

    </script>
</head>
<body background="http://www.demo.amitjakhu.com/login-form/images/bg.png">
<div class="div_form">
    <font color="red"> ${message}</font>
<form action="${pageContext.request.contextPath}/Register.action" method="post" onsubmit="return submitTest()" >
    <label >用户名:</label>  <input type="text" name="username" id="username" onblur="showErrorName()"> <span id="ERROR_name">长度6-16个字符</span><br>
    <label >真实姓名:</label> <input type="text" name="realname"><br>
    <label >性别:</label>男<input type="radio" name="sex" value="男" checked>
             女<input type="radio" name="sex" value="女"> <br>
    <label >年龄:</label> <input type="text" name="age" id="age" onchange="showErrorAge()"> <span id="ERROR_age">*(为必填)</span> <br>
    <label >密码:</label><input type="password" name="password1" id="password1" onchange="showErrorPassword1()"><span id="ERROR_password1">*(为必填)</span><br>
    <label >确认密码:</label><input type="password" name="password2" id="password2" onchange="showErrorPassword2()"><span id="ERROR_password2">*(为必填)</span><br>
    <label >电话号码:</label> <input type="text" name="phone"> <br>
    <label >邮箱地址:</label> <input type="text" name="email" id="email" onchange="showErrorEmail()"><span id="ERROR_email">*(为必填)</span><br>
    <label >爱好:</label>
            写代码<input type="checkbox" name="hobby" value="写代码"onclick="showErrorCheck()">
            篮球<input type="checkbox" name="hobby" value="篮球"onclick="showErrorCheck()">
            足球<input type="checkbox" name="hobby" value="足球"onclick="showErrorCheck()">
        <span id="ERROR_hobby">请至少选择一个 </span><br>
    <br>
    <label >个人签名:</label><textarea name="sign" id="" cols="30" rows="2" required></textarea><br>
    <br>

    <input type="submit" value="注册" class="button_left" > <input type="reset" name="重置" class="button_right" >
</form>

</div>
</body>
</html>
