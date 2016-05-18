<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--This code is a body of error page--%>
<%@ page isErrorPage="true"%>
<html>
<font color="WHITE"/>
<head>
    <title>404 Error</title>
</head>
<!--
Failed URL: ${url}
Exception: ${exception.message}
<c:forEach items="${exception.stackTrace}" var="stackTrace">
    ${stackTrace}
</c:forEach>
-->
<body>
<%--<img src="http://www.haba.nl/images/404.png">--%>
<p class=""> Sorry but this web-page not found..</p>
<p>Why?</p>
<ol>
    <li>Bad url.
    <li>Page was deleted or moved to another url.
</ol>
<p>You can go to:</p>
<ul>
    <li><a href="/">Home page.</a>
    <li><a href="/dep">Departments</a>
</ul>
</body>
</html>
