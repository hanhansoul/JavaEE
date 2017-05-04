<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2017/5/1
  Time: 11:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
    <script type="text/javascript">
        $(function () {
            $("#testJson").click(function () {
                var url = this.href;
                var args = {};
                $.post(url, args, function (data) {
                    for (var i = 0; i < data.length; i++) {
                        var id = data[i].id;
                        var name = data[i].name;
                        alert(id + ": " + name);
                    }
                });
                return false;
            })
        })
    </script>
</head>
<body>

<a href="emps">List All Users</a>
<br/><br/>

<a href="testJson">Test Json</a>
<br><br>

<form action="testFileUpload" method="post" enctype="multipart/form-data">
    File:<input type="file" name="file"/>
    Desc:<input type="text" name="desc"/>
    <input type="submit" value="submit"/>
</form>
<br/><br/>
</body>
</html>
