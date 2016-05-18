<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title></title>
</head>
<body>


<div id="myTabContent" class="tab-content">

  <div role="tabpanel" class="tab-pane fade active in" id="homes" aria-labelledby="home-tab">
    <table class="table" style="color: black">
      <tr>
        <td>First Name:</td>
        <td>${userData.firstName}</td>
      </tr>
      <tr>
        <td>Second Name:</td>
        <td>${userData.secondName}</td>
      </tr>
      <tr>
        <td>Age:</td>
        <td>${userData.age}</td>
      </tr>
      <tr>
        <td>Email</td>
        <td>${email}</td>
      </tr>
    </table>
  </div>

  <div role="tabpanel" class="tab-pane fade" id="profile" aria-labelledby="profile-tab">
    <form:form method="post" action="/accountUpdate" >

      <table class="table">
        <tr>
          <td>First Name:</td>
          <td><input type="text" name="firstName" value="${userData.firstName}"/></td>
        </tr>
        <tr>
          <td>Second Name:</td>
          <td><input type="text" name="secondName" value="${userData.secondName}"/></td>
        </tr>
        <tr>
          <td>Age:</td>
          <td><input type="text" name="age" value="${userData.age}"/></td>
        </tr>
        <tr>
          <td colspan="2">
            <input type="submit" class="btn btn-success" value="Save">
          </td>
        </tr>
      </table>
    </form:form>
  </div>

</div>
</body>
</html>