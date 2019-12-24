<%--
  Created by IntelliJ IDEA.
  User: huiye
  Date: 2019-12-18
  Time: 22:16
  To change this template use File | Settings | File Templates.
--%>
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
    <title>Emp index</title>
</head>
<body>
<div class="w3-container w3-margin-top">
    <input type="text" class="w3-input" placeholder="KING"
           id="input-keywords">
    <a class="w3-btn w3-green" onclick="queryByKeywords()">Search</a>
    <a href="api/emp/create" class="w3-btn w3-blue w3-margin">Create</a>
    <a href="api/user/logout" class="w3-btn w3-red w3-margin">Logout</a>
    <h1>Emp List</h1>
    <table class="w3-table-all w3-hoverable" id="emp-list">
        <tr class="w3-green">
            <th>id</th>
            <th>ename</th>
            <th>mgr</th>
            <th>job</th>
            <th>hiredate</th>
            <th>deptno</th>
            <th>OPR</th>
        </tr>
        <tr class="w3-hover-black" w3-repeat="data" id="emp-data">
            <td>{{id}}</td>
            <td>{{ename}}</td>
            <td>{{mgr}}</td>
            <td>{{job}}</td>
            <td>{{hiredate}}</td>
            <td>{{deptno}}</td>
            <td>
                <a class="w3-button w3-red" onclick="remove('{{id}}')"
                   href="javascript:;">del
                </a>
                <a class="w3-button w3-blue"
                   href="api/emp/edit?id={{id}}">edit</a>
                <a class="w3-button w3-yellow"
                   href="api/emp/detail?id={{id}}">detail</a>
            </td>
        </tr>
    </table>
</div>
<%@include file="/WEB-INF/_inc/_inc_js.jsp" %>
<script>
    queryByKeywords();

    /**
     * 根据关键字搜索
     */
    function queryByKeywords() {
        w3.getHttpObject("api/emp/search?keywords=" +
            document.getElementById("input-keywords").value,
            function (apiResult) {
                var code = apiResult.code;
                var data = apiResult.data;
                if (code >= 0 && data && data.length > 0) {
                    w3.displayObject("emp-list", apiResult);
                    w3.removeClass("#emp-data", "w3-hide");
                } else {
                    w3.addClass("#emp-data", "w3-hide");
                }
            });
    }
</script>

<script src="<%=basePath%>/static/plugins/jq/1.3.2/jquery.min.js"></script>
<script>
    function remove(id) {
        $.ajax({
            type: "GET",
            url: "api/emp/delete",
            data: {
                id: id
            },
            dataType: "json",
            success: function (ret) {
                console.log(ret);
                if (ret.code === 0) {
                    queryByKeywords();
                } else {
                    alert(ret.msg);
                }
            }
        });
    }
</script>
</body>
</html>