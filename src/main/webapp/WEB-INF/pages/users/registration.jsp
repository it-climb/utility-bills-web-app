<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE HTML>
<html>
<head>
    <style>
        body { background-color: #eee; }
        #container { width: 500px; background-color: #fff; margin: 30px auto; padding: 30px; border-radius: 5px; }
        label {width: 150px; display:inline-block;}
        input { display:inline-block; margin-right: 10px; }
        form {line-height: 160%; }
        .hide { display: none; }
        .error { color: red; font-size: 0.9em; font-weight: bold; }
    </style>
</head>
<body>

<div id="container">

    <form:form action="regSave" modelAttribute="user">
        <label for="emailInp">Email: </label>
        <form:input path="email" id="emailInp" />
        <form:errors cssClass="error" />
        <br/>

        <label for="passImp">Password: </label>
        <form:password path="password" id="passImp"/>
        <form:errors cssClass="error" />
        <br/>
        
        <label for="confPass">Confirm password:</label>
        <form:password path="confirmPassword" id="confPass"/>
        <form:errors cssClass="error"/>
        <br/>

        <br/>
        <input type="submit" value="OK" />
    </form:form>
</div>
</body>
</html>