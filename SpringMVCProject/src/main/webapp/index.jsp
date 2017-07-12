<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
</head>
<body>
<a href="/springmvc/testRequestMapping">test RequestMapping</a>
<br/><br/>

<a href="/springmvc/testRequestMappingMethod">test RequestMappingMethod</a>
<br/><br/>

<form action="/springmvc/testRequestMappingMethod" method="post">
    <input type="submit" value="submit"/>
</form>
<br><br>

<a href="/springmvc/testParamsAndHeaders?username=test&age=11">test ParamsAndHeaders</a>
<br><br>

<a href="/springmvc/testPathVariable/1">test PathVariable</a>
<br><br>

<a href="/springmvc/testREST/1">test REST GET</a>
<br><br>

<form action="/springmvc/testREST" method="post">
    <input type="submit" value="test REST POST"/>
</form>
<br><br>

<form action="/springmvc/testREST/1" method="post">
    <input type="hidden" name="_method" value="PUT">
    <input type="submit" value="test REST PUT"/>
</form>
<br><br>

<form action="/springmvc/testREST/1" method="post">
    <input type="hidden" name="_method" value="DELETE">
    <input type="submit" value="test REST DELETE"/>
</form>
<br><br>

<a href="/springmvc/testRequestParam?username=test&age=11">test requestParam</a>
<br><br>

<a href="/springmvc/testCookieValue">test cookieValue</a>
<br ><br>

<form action="/springmvc/testPOJO" method="post">
    username: <input type="text" name="username"/>
    <br>
    password: <input type="password" name="password" />
    <br>
    email: <input type="text" name="email" />
    <br>
    age: <input type="text" name="age" />
    <br>
    departmentId: <input type="text" name="department.id" />
    <br/>
    departmentName: <input type="text" name="department.departmentName" />
    <input type="submit" value="submit"/>
</form>
<br><br>

<a href="/springmvc/testServletAPI">Test ServletAPI</a>
<br><br>

<!--ModelAndViewExample-->
<a href="/springmvc/testModelAndView">test ModelAndView</a>
<br><br>

<a href="/springmvc/testMap">test Map</a>
<br><br>

<a href="/springmvc/testSessionAttributes">test SessionAttributes</a>
</body>

<!--@ModelAttribute-->
<form action="springmvc/testModelAttribute" method="post">
    <input type="hidden" name="id" value="1">
    username: <input type="text" name="name" value="Tom"/>
    <br>
    email: <input type="text" name="email" value="Tom@163.com"/>
    <br>
    age: <input type="text" name="age" value="12"/>
    <br>
    <input type="submit" value="submit">
</form>
<br><br>

<!---->
<a href="/springmvc/testViewAndViewResolver">Test viewAndViewResolver</a>
<br><br>

<a href="/springmvc/testCustomedView">Test customedView</a>
<br><br>

<a href="/springmvc/testRedirect">Test Redirect</a>
<br><br>

<a href="emps">List All Users</a>
<br/><br/>
</html>
