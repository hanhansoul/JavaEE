<%@ page import="java.util.Date" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
</head>
<body>
<%
    out.println("Your IP address is "+request.getRemoteAddr());
%>
<%! int i = 0;%>
<%! int a,b,c;%>
<%! Date cur = new Date();%>
<br />
date:<%=cur %>
</body>
</html>
