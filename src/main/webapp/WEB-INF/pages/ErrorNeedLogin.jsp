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
<%--<img src="https://lh3.googleusercontent.com/-Y8mfYyAWW4w/U2cuhZS_gKI/AAAAAAAAADo/l83TyYyF0Uo/w426-h409/500-error.png">--%>
<strong><p class=""> Sorry but you must <a href="/login"> log in</a></p></strong>
</body>
</html>
