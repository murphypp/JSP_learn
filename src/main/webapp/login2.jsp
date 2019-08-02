<%--
  Created by IntelliJ IDEA.
  User: EDZ
  Date: 2019/8/2
  Time: 17:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<link href="style2.css" rel="stylesheet" type="text/css" />

<script type="text/javascript">
    function submit(){
        document.getElementById("form").submit();//表单提交
    }
</script>


<body>
<form name="login-form" class="login-form" action="" method="post">

    <div class="header">
        <h1>Welcome to Ucar</h1>
    </div>

    <div class="content">
        <input name="username" type="text" class="input username" placeholder="Username" />
        <div class="user-icon"></div>
        <input name="password" type="password" class="input password" placeholder="Password" />
        <div class="pass-icon"></div>
    </div>

    <div class="footer">
        <a href="#" class="button1">Login</a>
        <a href="register.jsp" class="button2">Register</a>
    </div>

</form>
</body>
</html>
