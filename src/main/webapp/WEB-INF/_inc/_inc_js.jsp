<%@ page contentType="text/html;charset=UTF-8" %>
<script src="static/plugins/w3/w3.js"></script>
<script src="static/plugins/jq/1.10.2/jquery.min.js"></script>
<script>
    $.ajaxSetup({
        timeout: 1200,
        contentType: "application/x-www-form-urlencoded;charset=utf-8",
        headers: {
            "author": "huiye"
        },
        type: "POST",
        dataType: "json",
        success: function (jqXHR, textStatus) {

        },
        error: function (jqXHR, textStatus, errMsg) {
            // jqXHR 是经过jQuery封装的XMLHttpRequest对象
            // textStatus 可能为： null、"timeout"、"error"、"abort"或"parsererror"
            // errorMsg 可能为： "Not Found"、"Internal Server Error"等

            // 提示形如：发送AJAX请求到`/index.html`时出错[404]：Not Found
            // alert("请求`" + this.url + "`时出错，[" + jqXHR.status + "]：" + errMsg);
        },
        complete: function (jqXHR, textStatus) {
            // 通过XMLHttpRequest取得响应结果
            const res = jqXHR.responseText;
            try {
                const jsonData = JSON.parse(res);
                const msg = jsonData.msg;
                const code = jsonData.code;
                if (code === 2001) {
                    alert(msg);
                    window.location.href = "api/user/login";
                } else {
                    //正常情况就不统一处理了
                }
            } catch (e) {
                console.error(e)
            }
        }
    });
</script>