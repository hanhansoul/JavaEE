<%@ page import="java.util.Map" %>
<%@ page import="java.util.HashMap" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title></title>
</head>
<body>
<%--action="${pageContext.request.contextPath}" 采用绝对路径--%>
<form:form action="${pageContext.request.contextPath}/emp" method="post" modelAttribute="user">
    <c:if test="${user.id == null}">
        name:<form:input path="name"/>
    </c:if>
    <c:if test="${user.id != null}">
        <form:hidden path="id"/>
        <%--form标签用于表单回显--%>
        <%--此处_method不能用form标签，因为其不属于User属性--%>
        <input type="hidden" name="_method" value="PUT"/>
    </c:if>
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

    <!--
        1. 数据类型转换
        2. 数据类型格式化
        3. 数据验证

        数据绑定流程：
        1. 将ServletRequest对象及目标方法的入参实例传递给WebDataBinderFacotry实例，创建DataBinder实例对象。
        2. ConversionService实现数据转换和数据格式化。
        3. Validator组件对数据进行验证，生成BindingData对象。
        4. 抽取BindingResult中的入参对象和校验错误对象，赋给处理方法的响应入参。
    -->
</form:select>
    <br>
    <input type="submit" value="submit"/>
</form:form>
</body>
</html>
