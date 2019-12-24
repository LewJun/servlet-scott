<%@ page contentType="text/html;charset=UTF-8" %>
<!doctype html>
<html>
<head>
    <%@include file="/WEB-INF/_inc/_inc_base.jsp" %>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <%@include file="/WEB-INF/_inc/_inc_css.jsp" %>
    <title>login</title>
</head>
<body>
<div class="w3-container w3-center w3-margin-top">
    <form id="frm-user">
        <input class="w3-input" type="text" name="username" placeholder="用户名">
        <input class="w3-input" type="password" name="password"
               placeholder="密码">
        <a class="w3-btn w3-green w3-margin-top" href="javascript:void(0);"
           onclick="login()">登录</a>
    </form>
</div>
<%@include file="/WEB-INF/_inc/_inc_js.jsp" %>
<script src="<%=basePath%>/static/plugins/jq/1.3.2/jquery.min.js"></script>
<script>
    function login() {
        $.ajax({
            type: "POST",
            url: "api/user/login",
            dataType: "json",
            data: $("#frm-user").serialize(),
            success: function (ret) {
                console.log(ret);
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