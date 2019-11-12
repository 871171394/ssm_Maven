<%--
  Created by IntelliJ IDEA.
  User: 87117
  Date: 2019/11/8
  Time: 15:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<script src="js/jquery-1.8.3.min.js"></script>
<script>
    $(function () {
        $("#btn").click(function () {
            $.ajax({
                url:"${pageContext.request.contextPath}/productJson",
                contentType:"application/json;charset=utf-8",
                data:{name:"ipone11",price:52211.2},
                success:function (date) {
                    alert(date)

                }
            })
        });

    });

</script>
<html>
<head>
    <title>Title</title>
</head>
<body>
<button id="btn">ajax发送json请求</button>
<h1>${name}</h1>
</body>
</html>
