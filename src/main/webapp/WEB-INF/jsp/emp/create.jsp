<%@ page contentType="text/html;charset=UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
        <a onclick="edit()" href="javascript:void(0);"
           class="w3-button w3-blue w3-center w3-margin">Submit</a>
    </form>
</div>
<%@include file="/WEB-INF/_inc/_inc_js.jsp" %>
<script>
    search();

    function search() {
        w3.getHttpObject("api/emp/search/id?id=${id}",
            function (apiResult) {
                w3.displayObject("frm-emp-detail", apiResult.data);
            });
    }
</script>

<script src="<%=basePath%>/static/plugins/ajax.js"></script>
<script src="<%=basePath%>/static/plugins/formser.js"></script>
<script>
    function edit() {
        var ajax = new Ajax();
        ajax.send({
            method: "POST",
            url: "api/emp/create",
            resType: "json",
            data: formser(document.getElementById("frm-emp-detail")),
            success: function (ret) {
                console.log(ret);
                if (ret.code === 0) {
                    window.location.href = "api/emp/index";
                }
            }
        });
    }
</script>
</body>
</html>