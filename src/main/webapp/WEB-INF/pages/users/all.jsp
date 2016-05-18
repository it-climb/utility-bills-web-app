<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<head>
  <title>All Departments</title>
</head>
<body class="no-js">
<div align="right"><strong>${email}</strong></div>
<table width="600px">
  <tr>
    <td><b>ID</b></td>
    <td><b>Email</b></td>
    <td><b>Name</b></td>
    <td><b>Age</b></td>
    <td><b>Version</b></td>
  </tr>
  <c:forEach var="usersData" items="${usersData}">
    <tr>
      <td>${usersData.user.id}</td>
      <td>${usersData.user.email}</td>
      <td>${usersData.firstName} ${usersData.secondName}</td>
      <td>${usersData.age}</td>
      <td>v.${usersData.user.version}</td>
      <td>
        <form method="post" action="/depDelete">
          <input type="hidden" name="id" value=${usersData.user.id}>
          <input type="submit" value="Delete">
        </form>
      </td>
      <td><form method="post" action="/depEdit">
            <input type="hidden" name="id" value=${usersData.user.id}>
            <input type="submit" value="Update">
          </form>
      </td>
    </tr>
  </c:forEach>
  <tr>
    <td colspan="5">
      <form method="post" action="/depEdit">
        <input type="submit" value="Add new one">
      </form>
    </td>
  </tr>
</table>
</body>
</html>