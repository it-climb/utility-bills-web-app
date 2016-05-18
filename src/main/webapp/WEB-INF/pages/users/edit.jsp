<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Edit Department</title>
</head>
<body>
        <form:form method="post" action="/depSaveOrUpdate">
            <table>
                <tr>
                    <td height="50" width="200">New Department Name:</td>
                    <td height="30"><input type="text" name="name" value="${department.name}"/></td>
                </tr>
                </table>
            <table width="200">
                <tr>
                    <td width="50" align="center" height="20">
                        <input type="hidden" name="id" value=${department.id}>
                        <input type="hidden" name="version" value=${department.version}>
                        <input type="submit" value="Add">
                    </td>
                    <td width="50" height="20">
                        <form method="post" action="/dep">
                            <input type="submit" value="Cancel">
                        </form>
                    </td>
                </tr>
            </table>
        </form:form>
</body>
</html>
