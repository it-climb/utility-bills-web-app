<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login</title>
</head>
<body>
<form:form method="post" action="/userLogin">
    <div align="right"><strong>${email}</strong></div>
    <table>
        <tr>
            <td>Email:</td>
            <td><input type="text" name="email" value="${user.email}"/></td>
        </tr>
        <tr>
            <td>Password:</td>
            <td><input type="password" name="password" value="${user.password}"/></td>
        </tr>
        <tr>
            <td colspan="2">
                <input type="hidden" name="id" value="${user.id}">
                <input type="submit" value="Ok">
            </td>
        </tr>
    </table>
    <a href="/regSave">Registration</a>
</form:form>
</body>
</html>
