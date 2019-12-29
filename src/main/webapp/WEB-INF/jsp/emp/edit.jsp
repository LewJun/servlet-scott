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
    <title>Emp edit</title>
</head>
<body>
<div class="w3-container">
    <h1>Emp Edit</h1>
    <form id="frm-emp-detail">
        <input class="w3-input" type="hidden" value="{{id}}" name="id"/>
        <div>
            ename: <input class="w3-input" type="text" value="{{ename}}"
                          name="ename"/>
        </div>
        <div>
            mgr: <input class="w3-input" type="text" value="{{mgr}}"
                        name="mgr"/>
        </div>
        <div>
            job: <input class="w3-input" type="text" value="{{job}}"
                        name="job"/>
        </div>
        <div>
            hiredate: <input class="w3-input" type="text"
                             value="{{hiredate}}" name="hiredate"/>
        </div>
        <div>
            deptno: <input class="w3-input" type="text" value="{{deptno}}"
                           name="deptno"/>
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

    function edit() {
        $.ajax({
            type: "POST",
            url: "api/emp/edit",
            data: $("#frm-emp-detail").serialize(),
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