<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
为了引入jquery文件，需要在spring mvc中处理静态资源
DispatcherServlet请求映射配置为/，则spring mvc捕获了web容器的所有请求，包括静态资源请求。
对于静态资源请求，spring mvc将其当做一个普通请求进行处理。
在springmvc中配置<mvc:default-servlet-handler/>解决静态资源问题
--%>
<script type="text/javascript" src="scripts/jquery-3.2.1.min.js"></script>
<script type="text/javascript">
    $(function () {
        $(".delete").click(function () {
            var href = $(this).attr("href");
            $("form").attr("action", href).submit();
            return false;
        });
    })
</script>
<html>
<head>
    <title></title>
</head>
<body>
<form action="" method="post">
    <input type="hidden" name="_method" value="DELETE"/>
</form>

<c:if test="${empty requestScope.users}">
    无任何员工信息
</c:if>
<c:if test="${!empty requestScope.users}">
    <table border="1" cellpadding="10" cellspacing="0">
        <tr>
            <th>ID</th>
            <th>name</th>
            <th>age</th>
            <th>email</th>
            <th>department</th>
            <th>edit</th>
            <th>delete</th>
        </tr>
        <c:forEach items="${requestScope.users}" var="emp">
            <tr>
                <td>${emp.id}</td>
                <td>${emp.name}</td>
                <td>${emp.age}</td>
                <td>${emp.email}</td>
                <td>${emp.department.departmentName}</td>
                <td><a class="update" href="emp/${emp.id}">edit</a></td>
                <%--为了为delete请求传递一个post请求，需要利用javascript--%>
                <td><a class="delete" href="emp/${emp.id}">delete</a></td>
            </tr>
        </c:forEach>
    </table>
</c:if>
<br/><br/>
<a href="emp">添加用户</a>
</body>
</html>