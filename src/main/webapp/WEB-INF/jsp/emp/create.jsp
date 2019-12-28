<%@ page contentType="text/html;charset=UTF-8" %>
<!doctype html>
<html lang="en">
<head>
    <%@include file="/WEB-INF/_inc/_inc_base.jsp" %>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <%@include file="/WEB-INF/_inc/_inc_css.jsp" %>
    <title>Emp create</title>
</head>
<body>
<div class="w3-container">
    <h1>Emp Create</h1>
    <form id="frm-emp-detail">
        <div>
            id: <input class="w3-input" type="text" name="id"/>
        </div>
        <div>
            ename: <input class="w3-input" type="text" name="ename"/>
        </div>
        <div>
            mgr: <input class="w3-input" type="text" name="mgr"/>
        </div>
        <div>
            job: <input class="w3-input" type="text" name="job"/>
        </div>
        <div>
            hiredate: <input class="w3-input" type="text" name="hiredate"/>
        </div>
        <div>
            deptno: <input class="w3-input" type="text" name="deptno"/>
        </div>
        <a onclick="create()" href="javascript:void(0);"
           class="w3-button w3-blue w3-center w3-margin">Submit</a>
    </form>
</div>
<%@include file="/WEB-INF/_inc/_inc_js.jsp" %>
<script>
    function create() {
        $.ajax({
            type: "POST",
            url: "api/emp/create",
            data: $("#frm-emp-detail").serialize(),
            dataType: "json",
            success: function (ret) {
                if (ret.code === 0) {
                    window.location.href = "api/emp/index";
                } else {
                    alert(ret.msg)
                }
            }
        });
    }
</script>
</body>
</html>