<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!doctype html>
<html lang="en">
<head>
    <meta charset="utf-8"/>
    <link rel="icon" type="image/png" href="assets/img/favicon.ico">
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
                <li>
                    <a href="/listOfUsers">
                        <i class="pe-7s-note2"></i>

                        <p>List users</p>
                    </a>
                </li>
                <li>
                    <a href="/listOfStreets">
                        <i class="pe-7s-note2"></i>

                        <p>List of streets</p>
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
                <li class="active">
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
                    <a class="navbar-brand" href="#">Maps</a>
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
                        <li>
                            <a href="/accountLogout">
                                Log out
                            </a>
                        </li>
                    </ul>
                </div>
            </div>
        </nav>

        <div id="map"></div>

    </div>
</div>


</body>

<jsp:include page="/WEB-INF/pages/dashboards/template/footer.jsp"/>


<script>
    $().ready(function () {
        demo.initGoogleMaps();
    });
</script>

</html>
