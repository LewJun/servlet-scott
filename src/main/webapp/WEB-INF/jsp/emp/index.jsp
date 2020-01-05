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
    <title>Emp index</title>
</head>
<body>
<div class="w3-container w3-margin-top">
    <span>hello, ${loginUser}
        <a href="api/user/logout"
           class="w3-btn w3-red w3-margin">Logout</a>
    </span>

    <h1>Emp List</h1>

    <div class="w3-margin-bottom">
        <input type="text" class="w3-input w3-margin-bottom"
               placeholder="KING" id="input-keywords">
        <button class="w3-btn w3-green" onclick="queryByKeywords()">Search
        </button>
        <button onclick="showCreateEmpModal()"
                class="w3-btn w3-blue">Create
        </button>
    </div>
    <table class="w3-table-all w3-hoverable" id="emp-list">
        <tr class="w3-brown">
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
                <a class="w3-button w3-red"
                   onclick="remove('{{id}}', '{{ename}}')"
                   href="javascript:">del
                </a>

                <a class="w3-button w3-blue"
                   onclick="showEditEmpModal('{{id}}')"
                   href="javascript:">edit</a>

                <a class="w3-button w3-yellow"
                   onclick="showDetailEmpModal('{{id}}')"
                   href="javascript:">detail</a>
            </td>
        </tr>
    </table>
</div>
<div id="empModal" class="w3-modal">
    <div class="w3-modal-content">
        <div class="w3-container">
            <span onclick="closeEmpModal()"
                  class="w3-button w3-display-topright">&times;</span>
            <form id="frm-emp" class="w3-container">
                <div class="w3-section">
                    <input type="hidden" id="opr">
                    <label for="id">id</label>
                    <input class="w3-input" type="text" name="id" id="id"
                           value="{{id}}"/>
                    <label for="ename">ename</label>
                    <input class="w3-input" type="text" name="ename"
                           id="ename" value="{{ename}}"/>
                    <label for="mgr">mgr</label>
                    <input class="w3-input" type="text" name="mgr" id="mgr"
                           value="{{mgr}}"/>
                    <label for="job">job</label>
                    <input class="w3-input" type="text" name="job" id="job"
                           value="{{job}}"/>
                    <label for="hiredate">hiredate</label>
                    <input class="w3-input" type="text" name="hiredate"
                           id="hiredate" value="{{hiredate}}"/>
                    <label for="deptno">deptno</label>
                    <input class="w3-input" type="text" name="deptno"
                           id="deptno" value="{{deptno}}"/>
                    <button onclick="createOrUpdate()" id="btnSubmit"
                            class="w3-button w3-block w3-green w3-hover-blue w3-section w3-padding"
                            type="submit">Submit
                    </button>
                    <button onclick="closeEmpModal()"
                            class="w3-button w3-block w3-light-gray w3-section w3-padding"
                            type="button">Cancel
                    </button>
                </div>
            </form>
        </div>
    </div>
</div>

<script src="static/plugins/w3/w3.js"></script>
<script src="static/plugins/jq/1.10.2/jquery.min.js"></script>
<script src="static/base.js"></script>
<script>
    function createOrUpdate() {
        let opr = $("#opr").val();
        parseInt(opr) === 1 ? create() : edit();
    }

    function create() {
        $.ajax({
            type: "POST",
            url: "api/emp/create",
            data: $("#frm-emp").serialize(),
            success: function (ret) {
                if (ret.code === 0) {
                    queryByKeywords();
                } else {
                    alert(ret.msg);
                }
            }
        });
    }

    function edit() {
        $.ajax({
            type: "POST",
            url: "api/emp/edit",
            data: $("#frm-emp").serialize(),
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

    function closeEmpModal() {
        $("#frm-emp")[0].reset();
        $("#empModal").hide();
    }

    function showCreateEmpModal() {
        w3.displayObject("frm-emp",
            {
                id: '',
                ename: '',
                mgr: '',
                job: '',
                hiredate: '',
                deptno: ''
            }
        );
        showEmpModal(true);
        $("#opr").val(1);
    }

    function showDetailEmpModal(id) {
        queryByEmpId(id, function (apiResult) {
            w3.displayObject("frm-emp", apiResult.data);
            showEmpModal(false);
        });
    }

    function showEditEmpModal(id) {
        queryByEmpId(id, function (apiResult) {
            w3.displayObject("frm-emp", apiResult.data);
            showEmpModal(true);
            $("#opr").val(0);
        });
    }

    function showEmpModal(isShowBtnSubmit) {
        $("#empModal").show();
        showOrHideBtnSubmit(isShowBtnSubmit);
    }

    function showOrHideBtnSubmit(isShow) {
        let btnSubmit = $("#btnSubmit");
        isShow ? btnSubmit.show() : btnSubmit.hide();
    }

    function queryByEmpId(id, callback) {
        $.getJSON("api/emp/search/id?id=" + id, callback)
    }

    queryByKeywords();

    /**
     * 根据关键字搜索
     */
    function queryByKeywords() {
        $.getJSON("api/emp/search?keywords=" + $("#input-keywords").val(),
            function (apiResult) {
                const code = apiResult.code;
                const data = apiResult.data;
                if (code >= 0 && data && data.length > 0) {
                    w3.displayObject("emp-list", apiResult);
                    w3.removeClass("#emp-data", "w3-hide");
                } else {
                    w3.addClass("#emp-data", "w3-hide");
                }
            });
    }

    function remove(id, ename) {
        if (!confirm("你确定要删除`" + ename + "`吗？")) return;
        $.ajax({
            type: "GET",
            url: "api/emp/delete",
            data: {
                id: id
            },
            success: function (ret) {
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