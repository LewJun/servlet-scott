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
    <title>Emp detail</title>
</head>
<body>
<div class="w3-container">
    <h1>Emp Detail</h1>
    <div id="emp-detail">
        <div>
            id: {{id}}
        </div>
        <div>
            ename: {{ename}}
        </div>
        <div>
            mgr: {{mgr}}
        </div>
        <div>
            job: {{job}}
        </div>
        <div>
            hiredate: {{hiredate}}
        </div>
        <div>
            deptno: {{deptno}}
        </div>
    </div>
</div>
<%@include file="/WEB-INF/_inc/_inc_js.jsp" %>
<script>
    search();

    function search() {
        w3.getHttpObject("api/emp/search/id?id=${id}",
            function (apiResult) {
                w3.displayObject("emp-detail", apiResult.data);
            });
    }
</script>
</body>
</html>