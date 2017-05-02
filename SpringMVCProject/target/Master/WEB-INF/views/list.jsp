<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title></title>
</head>
<body>
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
                <td><a href="">edit</a></td>
                <td><a href="">delete</a></td>
            </tr>
        </c:forEach>
    </table>
</c:if>
<br/><br/>
<a href="emp" >添加用户</a>
</body>
</html>