<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <title>Utility bills</title>
    <meta charset="utf-8"/>
    <link rel="icon" type="image/png" href="/resources/dashboards/assets/img/favicon.ico">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1"/>

    <meta content='width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0' name='viewport'/>
    <meta name="viewport" content="width=device-width"/>

    <!-- Bootstrap core CSS     -->
    <link href="/resources/dashboards/assets/css/bootstrap.min.css" rel="stylesheet"/>

    <!-- Animation library for notifications   -->
    <link href="/resources/dashboards/assets/css/animate.min.css" rel="stylesheet"/>

    <!--  Light Bootstrap Table core CSS    -->
    <link href="/resources/dashboards/assets/css/light-bootstrap-dashboard.css" rel="stylesheet"/>

    <!--  CSS for Demo Purpose, don't include it in your project     -->
    <link href="/resources/dashboards/assets/css/demo.css" rel="stylesheet"/>

    <!--     Fonts and icons     -->
    <link href="http://maxcdn.bootstrapcdn.com/font-awesome/4.2.0/css/font-awesome.min.css" rel="stylesheet">
    <link href='http://fonts.googleapis.com/css?family=Roboto:400,700,300' rel='stylesheet' type='text/css'>
    <link href="/resources/dashboards/assets/css/pe-icon-7-stroke.css" rel="stylesheet"/>

</head>
<body>

<div class="wrapper">
    <div class="sidebar" data-color="purple" data-image="/resources/dashboards/assets/img/sidebar-5.jpg">

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
                <li class="active">
                    <a href="/userDash">
                        <i class="pe-7s-user"></i>

                        <p>User Profile</p>
                    </a>
                </li>
                <li>
                    <a href="/showTable">
                        <i class="pe-7s-note2"></i>

                        <p>List Bills</p>
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
                    <a class="navbar-brand" href="#">Profile</a>
                </div>
                <div class="collapse navbar-collapse">
                    <ul class="nav navbar-nav navbar-left">
                        <li>
                            <a href="#" class="dropdown-toggle" data-toggle="dropdown">
                                <i class="fa fa-dashboard"></i>
                            </a>
                        </li>
                        <li class="dropdown">
                            <a href="#" class="dropdown-toggle" data-toggle="dropdown">
                                <i class="fa fa-globe"></i>
                                <b class="caret"></b>
                                <span class="notification">5</span>
                            </a>
                            <ul class="dropdown-menu">
                                <li><a href="#">Notification 1</a></li>
                                <li><a href="#">Notification 2</a></li>
                                <li><a href="#">Notification 3</a></li>
                                <li><a href="#">Notification 4</a></li>
                                <li><a href="#">Another notification</a></li>
                            </ul>
                        </li>
                        <li>
                            <a href="">
                                <i class="fa fa-search"></i>
                            </a>
                        </li>
                    </ul>

                    <ul class="nav navbar-nav navbar-right">
                        <li>
                            <a href="/userDash">
                                Account
                            </a>
                        </li>
                        <li class="dropdown">
                            <a href="#" class="dropdown-toggle" data-toggle="dropdown">
                                Dropdown
                                <b class="caret"></b>
                            </a>
                            <ul class="dropdown-menu">
                                <li><a href="#">Action</a></li>
                                <li><a href="#">Another action</a></li>
                                <li><a href="#">Something</a></li>
                                <li><a href="#">Another action</a></li>
                                <li><a href="#">Something</a></li>
                                <li class="divider"></li>
                                <li><a href="#">Separated link</a></li>
                            </ul>
                        </li>
                        <li>
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
                    <div class="col-md-8">
                        <div class="card">
                            <div class="header">
                                <h4 class="title">Edit Profile</h4>
                            </div>
                            <div class="content">
                                <form action="/userEdit" method="post">

                                    <div class="row">
                                        <div class="col-md-6">
                                            <div class="form-group">
                                                <label>First Name</label>
                                                <input type="text" name="firstName" class="form-control"
                                                       value="${myUserData.firstName}">
                                            </div>
                                        </div>
                                        <div class="col-md-6">
                                            <div class="form-group">
                                                <label>Last Name</label>
                                                <input type="text" name="secondName" class="form-control"
                                                       placeholder="Last Name"
                                                       value="${myUserData.secondName}">
                                            </div>
                                        </div>
                                    </div>

                                    <div class="row">
                                        <div class="col-md-4">
                                            <div class="form-group">
                                                <label>Street</label>
                                                <input type="text" class="form-control" name="street"
                                                       placeholder="Enter your street"
                                                       value="${myUserData.street}">
                                            </div>
                                        </div>

                                        <div class="col-md-4">
                                            <div class="form-group">
                                                <label>House</label>
                                                <input type="text" class="form-control" name="house"
                                                       placeholder="Enter your house"
                                                       value="${myUserData.house}">
                                            </div>
                                        </div>

                                        <div class="col-md-4">
                                            <div class="form-group">
                                                <label>Apartment</label>
                                                <input type="text" class="form-control"
                                                       placeholder="Enter your apartment"
                                                       name="apartment"
                                                       value="${myUserData.apartment}">
                                            </div>
                                        </div>

                                    </div>

                                    <div class="row">
                                        <div class="col-md-4">
                                            <div class="form-group">
                                                <label>City</label>
                                                <input type="text" class="form-control" placeholder="City" name="city"
                                                       value="${myUserData.city}">
                                            </div>
                                        </div>
                                        <div class="col-md-4">
                                            <div class="form-group">
                                                <label>Country</label>
                                                <input type="text" class="form-control" placeholder="Country"
                                                       name="country"
                                                       value="${myUserData.country}">
                                            </div>
                                        </div>
                                    </div>
                                    <button type="submit" class="btn btn-info btn-fill pull-right">Update Profile
                                    </button>
                                </form>

                                <div class="row">
                                </div>

                                <form action="/sendPinCode" method="post">
                                    <div class="row">

                                        <div class="col-md-4">
                                            <div class="form-group">
                                                <%--<label for="exampleInputEmail">Email address</label>--%>
                                                <label>Email address</label>
                                                <input type="email" class="form-control" disabled
                                                       placeholder="${user.email}">
                                            </div>
                                        </div>

                                        <div class="col-md-4">
                                            <div class="form-group">
                                                <label>Pin Code</label>
                                                <input type="number" class="form-control" name="pinCode"
                                                       placeholder="your pin-code..."
                                                       value="${myUserData.hashCode()}">
                                            </div>
                                        </div>
                                    </div>
                                    <button type="submit" class="btn btn-info btn-fill pull-right">Send PIN
                                        code
                                    </button>
                                </form>

                                <div class="clearfix"></div>
                            </div>
                        </div>
                    </div>
                    <div class="col-md-4">
                        <div class="card card-user">
                            <div class="image">
                                <img src="https://ununsplash.imgix.net/photo-1431578500526-4d9613015464?fit=crop&fm=jpg&h=300&q=75&w=400"
                                     alt="..."/>
                            </div>
                            <div class="content">
                                <div class="author">
                                    <a href="#">
                                        <img class="avatar border-gray"
                                             src="/resources/dashboards/assets/img/faces/face-3.jpg" alt="..."/>

                                        <h4 class="title">${myUserData.firstName}<br/>
                                            <small>${myUserData.secondName}</small>
                                        </h4>
                                    </a>
                                </div>
                                <%--<p class="description text-center"> "Lamborghini Mercy <br>--%>
                                    <%--Your chick she so thirsty <br>--%>
                                    <%--I'm in that two seat Lambo"--%>
                                <%--</p>--%>
                            </div>
                            <hr>
                            <div class="text-center">
                                <button href="#" class="btn btn-simple"><i class="fa fa-facebook-square"></i></button>
                                <button href="#" class="btn btn-simple"><i class="fa fa-twitter"></i></button>
                                <button href="#" class="btn btn-simple"><i class="fa fa-google-plus-square"></i>
                                </button>

                            </div>
                        </div>
                    </div>

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
                        <li>
                            <a href="#">
                                Company
                            </a>
                        </li>
                        <li>
                            <a href="#">
                                Portfolio
                            </a>
                        </li>
                        <li>
                            <a href="#">
                                Blog
                            </a>
                        </li>
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

<!--   Core JS Files   -->
<script src="../../../resources/dashboards/assets/js/jquery-1.10.2.js" type="text/javascript"></script>
<script src="../../../resources/dashboards/assets/js/bootstrap.min.js" type="text/javascript"></script>

<!--  Checkbox, Radio & Switch Plugins -->
<script src="../../../resources/dashboards/assets/js/bootstrap-checkbox-radio-switch.js"></script>

<!--  Charts Plugin -->
<script src="../../../resources/dashboards/assets/js/chartist.min.js"></script>

<!--  Notifications Plugin    -->
<script src="../../../resources/dashboards/assets/js/bootstrap-notify.js"></script>

<!--  Google Maps Plugin    -->
<script type="text/javascript" src="https://maps.googleapis.com/maps/api/js?sensor=false"></script>

<!-- Light Bootstrap Table Core javascript and methods for Demo purpose -->
<script src="../../../resources/dashboards/assets/js/light-bootstrap-dashboard.js"></script>

<!-- Light Bootstrap Table DEMO methods, don't include it in your project! -->
<script src="../../../resources/dashboards/assets/js/demo2.js"></script>

</html>
