<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2017/4/29
  Time: 22:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>success</title>
</head>
<body>
<h2>SUCCESS</h2>

time:${requestScope.time}
<br/><br/>

names:${requestScope.names}
<br><br>

request user:${requestScope.user}
<br><br>

session user:${sessionScope.user}
<br><br>

request school:${requestScope.school}
<br><br>

session school:${sessionScope.school}
<br><br>

<fmt:message key="i18n.username"></fmt:message>
<br><br>

<fmt:message key="i18n.password"></fmt:message>
<br><br>

</body>
</html>
