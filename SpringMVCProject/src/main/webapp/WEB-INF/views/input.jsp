<%@ page import="java.util.Map" %>
<%@ page import="java.util.HashMap" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title></title>
</head>
<body>
<form:form action="emp" method="post" modelAttribute="user">
    name:<form:input path="name"/>
    <br>
    age:<form:input path="age"/>
    <br>
    <%
        Map<String, String> genders = new HashMap();
        genders.put("1", "Male");
        genders.put("0", "Female");
        request.setAttribute("genders", genders);
    %>
    gender:<form:radiobuttons path="gender" items="${genders}"/>
    <br>
    email:<form:input path="email"/>
    <br>
    department:<form:select path="department.id" items="${departments}"
                            itemLabel="departmentName" itemValue="id">
    </form:select>
    <br>
    <input type="submit" value="submit"/>
</form:form>
</body>
</html>
