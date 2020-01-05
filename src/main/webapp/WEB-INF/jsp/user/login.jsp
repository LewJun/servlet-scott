<%@ page contentType="text/html;charset=UTF-8" %>
<!doctype html>
<html>
<head>
    <base href="http://localhost:8080/scott-servlet/">
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <link rel="stylesheet" href="static/plugins/w3/w3.css">
    <title>login</title>
</head>
<body>
<div class="w3-container w3-center w3-margin-top">
    <form id="frm-user">
        <label for="username">用户名：</label>
        <input class="w3-input" type="text" name="username" id="username"
               placeholder="请输入用户名" value="admin">
        <label for="pwd">密码：</label>
        <input class="w3-input" type="password" name="password" id="pwd"
               placeholder="请输入密码" value="123456">
        <a class="w3-btn w3-green w3-margin-top" href="javascript:void(0);"
           onclick="login()">登录</a>
    </form>
</div>
<script src="static/plugins/w3/w3.js"></script>
<script src="static/plugins/jq/1.10.2/jquery.min.js"></script>
<script src="static/base.js"></script>
<script>
    function login() {
        $.ajax({
            type: "POST",
            url: "api/user/login",
            dataType: "json",
            data: $("#frm-user").serialize(),
            success: function (ret) {
                if (ret.code === 0) {
                    window.location.href = "api/emp/index";
                } else {
                    alert(ret.msg);
                }
            }
        });
    }
</script>
</body>
</html>