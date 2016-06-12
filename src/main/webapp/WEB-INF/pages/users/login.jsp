<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login</title>
</head>
<body><!-- ng-app="app" ng-controller="home as home"-->
<form:form method="post" action="/userLogin">
    <div align="right"><strong>${email}</strong></div>
    <div align="right"> <a href="/logout">logout</a></div>

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
    <!--


    class="container"
    <div                             ng-show="!home.authenticated">
        <a href="/facebookLogin">Log in with Facebook</a>
    </div>
    -->

</form:form>
<!--div>
    Login with Facebook: <a href="/loginFacebook">click here</a>
</div-->

<!--<form action="/facebookLogin" method="post">
    <input type="hidden" name="scope" value="user_posts" >
    <p><button type="submit">Login with Facebook</button></p>
</form>-->
<!---->

<!--<script type="text/javascript" src="resources/assets/js/owl.carousel.min.js"></script>
<script type="text/javascript">
    angular.module("app", []).controller("home", function($http) {
        var self = this;
        $http.get("/user").success(function(data) {
            self.user = data.userAuthentication.details.name;
            self.authenticated = true;
        }).error(function() {
            self.user = "N/A";
            self.authenticated = false;
        });
    });
</script>-->
</body>
</html>
