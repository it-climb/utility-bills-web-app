<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--<%@ taglib prefix="c" uri="/struts-tags" %>--%>

<!doctype html>
<html lang="en">
<head>
    <meta charset="utf-8"/>
    <link rel="icon" type="image/png" href="../../../../../resources/dashboards/assets/img/favicon.ico">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1"/>

    <title>Utility bills</title>

    <jsp:include page="/WEB-INF/pages/dashboards/template/header.jsp"/>

</head>
<body>

<div class="wrapper">
    <div class="sidebar" data-color="purple" data-image="/resources/dashboards/assets/img/sidebar-4.jpg">

        <!--   you can change the color of the sidebar using: data-color="blue | azure | green | orange | red | purple" -->


        <div class="sidebar-wrapper">
            <div class="logo">
                <a href="/home" class="simple-text">
                    Modern Town
                </a>
            </div>

            <ul class="nav">
                <%--<li>--%>
                <%--<a href="/dashboards">--%>
                <%--<i class="pe-7s-graph"></i>--%>

                <%--<p>Dashboard</p>--%>
                <%--</a>--%>
                <%--</li>--%>
                <li>
                    <a href="/adminDash">
                        <i class="pe-7s-user"></i>

                        <p>Admin Profile</p>
                    </a>
                </li>
                <li class="active">
                    <a href="/listOfUsers">
                        <i class="pe-7s-note2"></i>

                        <p>List of users</p>
                    </a>
                </li>
                <li>
                    <a href="/listOfCountry">
                        <i class="pe-7s-note2"></i>

                        <p>List of country</p>
                    </a>
                </li>
                <li>
                    <a href="/listOfCity">
                        <i class="pe-7s-note2"></i>

                        <p>List of city</p>
                    </a>
                </li>
                <li>
                    <a href="/listOfStreets">
                        <i class="pe-7s-note2"></i>

                        <p>List of streets</p>
                    </a>
                </li>
                <%--<li>--%>
                <%--<a href="typography.html">--%>
                <%--<i class="pe-7s-news-paper"></i>--%>

                <%--<p>Typography</p>--%>
                <%--</a>--%>
                <%--</li>--%>
                <%--<li>--%>
                <%--<a href="icons.html">--%>
                <%--<i class="pe-7s-science"></i>--%>

                <%--<p>Icons</p>--%>
                <%--</a>--%>
                <%--</li>--%>
                <li>
                    <a href="/showMap">
                        <i class="pe-7s-map-marker"></i>

                        <p>Maps</p>
                    </a>
                </li>
                <%--<li>--%>
                <%--<a href="notifications.html">--%>
                <%--<i class="pe-7s-bell"></i>--%>

                <%--<p>Notifications</p>--%>
                <%--</a>--%>
                <%--</li>--%>
                <%--<li class="active-pro">--%>
                <%--<a href="upgrade.jsp">--%>
                <%--<i class="pe-7s-rocket"></i>--%>

                <%--<p>Upgrade to PRO</p>--%>
                <%--</a>--%>
                <%--</li>--%>
            </ul>
        </div>
    </div>

    <div class="main-panel">
        <nav class="navbar navbar-default navbar-fixed">
            <div class="container-fluid">
                <div class="navbar-header">
                    <button type="button" class="navbar-toggle" data-toggle="collapse"
                            data-target="#navigation-example-2">
                        <span class="sr-only">Toggle navigation</span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                    </button>
                    <a class="navbar-brand" href="#">Utility bills</a>
                </div>
                <div class="collapse navbar-collapse">
                    <ul class="nav navbar-nav navbar-left">
                        <%--<li>--%>
                        <%--<a href="#" class="dropdown-toggle" data-toggle="dropdown">--%>
                        <%--<i class="fa fa-dashboard"></i>--%>
                        <%--</a>--%>
                        <%--</li>--%>
                        <%--<li class="dropdown">--%>
                        <%--<a href="#" class="dropdown-toggle" data-toggle="dropdown">--%>
                        <%--<i class="fa fa-globe"></i>--%>
                        <%--<b class="caret"></b>--%>
                        <%--<span class="notification">5</span>--%>
                        <%--</a>--%>
                        <%--<ul class="dropdown-menu">--%>
                        <%--<li><a href="#">Notification 1</a></li>--%>
                        <%--<li><a href="#">Notification 2</a></li>--%>
                        <%--<li><a href="#">Notification 3</a></li>--%>
                        <%--<li><a href="#">Notification 4</a></li>--%>
                        <%--<li><a href="#">Another notification</a></li>--%>
                        <%--</ul>--%>
                        <%--</li>--%>
                        <%--<li>--%>
                        <%--<a href="">--%>
                        <%--<i class="fa fa-search"></i>--%>
                        <%--</a>--%>
                        <%--</li>--%>
                    </ul>

                    <ul class="nav navbar-nav navbar-right">
                        <%--<li>--%>
                        <%--<a href="/userDash">--%>
                        <%--Account--%>
                        <%--</a>--%>
                        <%--</li>--%>
                        <%--<li class="dropdown">--%>
                        <%--<a href="#" class="dropdown-toggle" data-toggle="dropdown">--%>
                        <%--Dropdown--%>
                        <%--<b class="caret"></b>--%>
                        <%--</a>--%>
                        <%--<ul class="dropdown-menu">--%>
                        <%--<li><a href="#">Action</a></li>--%>
                        <%--<li><a href="#">Another action</a></li>--%>
                        <%--<li><a href="#">Something</a></li>--%>
                        <%--<li><a href="#">Another action</a></li>--%>
                        <%--<li><a href="#">Something</a></li>--%>
                        <%--<li class="divider"></li>--%>
                        <%--<li><a href="#">Separated link</a></li>--%>
                        <%--</ul>--%>
                        <%--</li>--%>
                        <%--<li>--%>
                        <a href="/accountLogout">
                            Log out
                        </a>
                        </li>
                    </ul>
                </div>
            </div>
        </nav>


        <div class="content">
            <div class="container-fluid">
                <div class="row">
                    <div class="col-md-12">
                        <div class="card">
                            <div class="header">
                                <h4 class="title">List of users</h4>

                                <p class="category">Here is a subtitle for this table</p>
                            </div>
                            <div class="content table-responsive table-full-width">
                                <table class="table table-hover table-striped">
                                    <thead>
                                    <th>ID</th>
                                    <th>First Name</th>
                                    <th>Second Name</th>
                                    <th>Country</th>
                                    <th>City</th>
                                    <th>Street</th>
                                    </thead>
                                    <tbody>
                                    <tr>
                                        <c:forEach var="users" items="${userList}">
                                    <tr>
                                        <td>${users.id}</td>
                                        <td>${users.firstName}</td>
                                        <td>${users.secondName}</td>
                                        <td>${users.country.name}</td>
                                        <td>${users.city.name}</td>
                                        <td>${users.street.name}</td>
                                        <td><a href="#" class="btn btn-success btn-sm custom-width">Edit</a></td>
                                        <td><a href="#" class="btn btn-danger btn-sm custom-width">Delete</a></td>
                                    </tr>
                                    </c:forEach>
                                    </tbody>
                                    <tr>
                                        <td>
                                            <a href="/addNewUser"
                                               class="btn btn-primary btn-sm custom-width pull-right">New
                                                User</a></td>
                                    </tr>
                                </table>

                            </div>
                        </div>
                    </div>


                    <%--<div class="col-md-12">--%>
                    <%--<div class="card card-plain">--%>
                    <%--<div class="header">--%>
                    <%--<h4 class="title">Bills for water</h4>--%>

                    <%--<p class="category">Here is a subtitle for this table</p>--%>
                    <%--</div>--%>
                    <%--<div class="content table-responsive table-full-width">--%>
                    <%--<table class="table table-hover">--%>
                    <%--<thead>--%>
                    <%--<th>ID</th>--%>
                    <%--<th>Name</th>--%>
                    <%--<th>Debts</th>--%>
                    <%--<th>Country</th>--%>
                    <%--<th>City</th>--%>
                    <%--</thead>--%>
                    <%--<tbody>--%>
                    <%--<tr>--%>
                    <%--<td>1</td>--%>
                    <%--<td>Dakota Rice</td>--%>
                    <%--<td>$36,738</td>--%>
                    <%--<td>Niger</td>--%>
                    <%--<td>Oud-Turnhout</td>--%>
                    <%--</tr>--%>
                    <%--<tr>--%>
                    <%--<td>2</td>--%>
                    <%--<td>Minerva Hooper</td>--%>
                    <%--<td>$23,789</td>--%>
                    <%--<td>Curaçao</td>--%>
                    <%--<td>Sinaai-Waas</td>--%>
                    <%--</tr>--%>
                    <%--<tr>--%>
                    <%--<td>3</td>--%>
                    <%--<td>Sage Rodriguez</td>--%>
                    <%--<td>$56,142</td>--%>
                    <%--<td>Netherlands</td>--%>
                    <%--<td>Baileux</td>--%>
                    <%--</tr>--%>
                    <%--<tr>--%>
                    <%--<td>4</td>--%>
                    <%--<td>Philip Chaney</td>--%>
                    <%--<td>$38,735</td>--%>
                    <%--<td>Korea, South</td>--%>
                    <%--<td>Overland Park</td>--%>
                    <%--</tr>--%>
                    <%--<tr>--%>
                    <%--<td>5</td>--%>
                    <%--<td>Doris Greene</td>--%>
                    <%--<td>$63,542</td>--%>
                    <%--<td>Malawi</td>--%>
                    <%--<td>Feldkirchen in Kärnten</td>--%>
                    <%--</tr>--%>
                    <%--<tr>--%>
                    <%--<td>6</td>--%>
                    <%--<td>Mason Porter</td>--%>
                    <%--<td>$78,615</td>--%>
                    <%--<td>Chile</td>--%>
                    <%--<td>Gloucester</td>--%>
                    <%--</tr>--%>
                    <%--</tbody>--%>
                    <%--</table>--%>

                    <%--</div>--%>
                    <%--</div>--%>
                    <%--</div>--%>


                </div>
            </div>
        </div>

        <footer class="footer">
            <div class="container-fluid">
                <nav class="pull-left">
                    <ul>
                        <li>
                            <a href="/home">
                                Home
                            </a>
                        </li>
                        <%--<li>--%>
                        <%--<a href="#">--%>
                        <%--Company--%>
                        <%--</a>--%>
                        <%--</li>--%>
                        <%--<li>--%>
                        <%--<a href="#">--%>
                        <%--Portfolio--%>
                        <%--</a>--%>
                        <%--</li>--%>
                        <%--<li>--%>
                        <%--<a href="#">--%>
                        <%--Blog--%>
                        <%--</a>--%>
                        <%--</li>--%>
                    </ul>
                </nav>
                <p class="copyright pull-right">
                    &copy; 2016 <a href="/home">Agios</a>, & Co
                </p>
            </div>
        </footer>


    </div>
</div>


</body>

<jsp:include page="/WEB-INF/pages/dashboards/template/footer.jsp"/>

</html>
