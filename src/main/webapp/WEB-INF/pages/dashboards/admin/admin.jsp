<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!DOCTYPE html>
<html lang="en">
<head>
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
                <li class="active">
                    <a href="/adminDash">
                        <i class="pe-7s-user"></i>

                        <p>Admin Profile</p>
                    </a>
                </li>
                <li>
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
                    <a href="/listOfStreet">
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
                    <a class="navbar-brand" href="#">Profile</a>
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


        <div class="content">
            <div class="container-fluid">
                <div class="row">
                    <div class="col-md-8">
                        <div class="card">
                            <div class="header">
                                <h4 class="title">Edit Profile</h4>
                            </div>
                            <div class="content">
                                <form action="/adminEdit" method="post">

                                    <div class="row">
                                        <div class="col-md-6">
                                            <div class="form-group">
                                                <label>First Name</label>
                                                <input type="text" name="firstName" class="form-control"
                                                       placeholder="First Name"
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

                                                <select path="streetList" name="streetId" class="form-control">
                                                    <option value="">Select to Edit</option>
                                                    <c:forEach var="street" items="${streetList}">
                                                        <option

                                                                <c:if test="${street.id == myUserData.street.id}">
                                                                    <c:out value="selected"/>
                                                                </c:if>

                                                                value="${street.id}">
                                                                ${street.name}
                                                        </option>
                                                    </c:forEach>
                                                </select>

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
                                                <select path="cityList" name="cityId" class="form-control">
                                                    <option value="">Select to Edit</option>
                                                    <c:forEach var="city" items="${cityList}">
                                                        <option

                                                                <c:if test="${city.id == myUserData.city.id}">
                                                                    <c:out value="selected"/>
                                                                </c:if>

                                                                value="${city.id}">
                                                                ${city.name}
                                                        </option>
                                                    </c:forEach>
                                                </select>
                                            </div>
                                        </div>
                                        <div class="col-md-4">
                                            <div class="form-group">
                                                <label>Country</label>
                                                <select path="countryList" name="countryId" class="form-control">
                                                    <option value="">Select to Edit</option>
                                                    <c:forEach var="country" items="${countryList}">
                                                        <option

                                                                <c:if test="${country.id == myUserData.country.id}">
                                                                    <c:out value="selected"/>
                                                                </c:if>

                                                                value="${country.id}">
                                                                ${country.name}
                                                        </option>
                                                    </c:forEach>
                                                </select>
                                            </div>
                                        </div>
                                    </div>
                                    <button type="submit" class="btn btn-info btn-fill pull-right">Update Profile
                                    </button>
                                </form>

                                <div class="row">
                                </div>

                                <%--<form action="/sendPinCode" method="get">--%>
                                <div class="row">

                                    <div class="col-md-4">
                                        <div class="form-group">
                                            <%--<label for="exampleInputEmail">Email address</label>--%>
                                            <label>Email address</label>
                                            <input type="email" class="form-control" disabled
                                                   placeholder="${email}">
                                        </div>
                                    </div>

                                    <%--<div class="col-md-4">--%>
                                    <%--<div class="form-group">--%>
                                    <%--<label>Pin Code</label>--%>
                                    <%--<input type="number" class="form-control" name="pinCode"--%>
                                    <%--placeholder="your pin-code..." value="${user.hashCode()}">--%>
                                    <%--</div>--%>
                                    <%--</div>--%>
                                </div>
                                <%--<button type="submit" class="btn btn-info btn-fill pull-right">Send PIN--%>
                                <%--code--%>
                                <%--</button>--%>
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

                                    <a href="" class="smoothScroll" data-toggle="modal" data-target="#modal-3">
                                        <c:if test="${empty myUserData.avatar.id}">
                                            <img class="avatar border-gray"
                                                 src="/resources/dashboards/assets/img/default-avatar.png"/>
                                            <%--src="/resources/dashboards/assets/img/avatars/agios@agios.com2/AVBtq51sFG0.jpg"/>--%>
                                        </c:if>
                                        <c:if test="${not empty myUserData.avatar.id}">
                                            <img class="avatar border-gray"
                                                 src="${myUserData.avatar.path}"/>
                                        </c:if>
                                    </a>

                                    <%--<a href="#">--%>
                                    <%--<img class="avatar border-gray"--%>
                                    <%--src="/resources/dashboards/assets/img/faces/face-3.jpg" alt="..."/>--%>
                                    <%--</a>--%>

                                    <h4 class="title">${myUserData.firstName}<br/>
                                        <small>${myUserData.secondName}</small>
                                    </h4>

                                </div>
                                <%--<p class="description text-center"> "Lamborghini Mercy <br>--%>
                                <%--Your chick she so thirsty <br>--%>
                                <%--I'm in that two seat Lambo"--%>
                                <%--</p>--%>
                            </div>
                            <hr>
                            <div class="text-center">
                                <%--<button href="#" class="btn btn-simple"><i class="fa fa-facebook-square"></i></button>--%>
                                <%--<button href="#" class="btn btn-simple"><i class="fa fa-twitter"></i></button>--%>
                                <%--<button href="#" class="btn btn-simple"><i class="fa fa-google-plus-square"></i>--%>
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

<div id="modal-3" class="modal fade test-modal">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header"><button class="close" type="button" data-dismiss="modal">×</button>
                <h4 class="modal-title">Change Photo</h4>
            </div>
            <div class="modal-body">
                <form:form enctype="multipart/form-data" method="post" action="/uploadAvatar">

                    <div class="input-group">
                        <label class="input-group-btn">
                            <span class="btn btn-primary upload btn-color">
                                Browse&hellip;
                                <input id="upload-file-input"
                                       type="file"
                                       style="display: none;"
                                       accept="image/png,image/jpeg"
                                       name="avatarFile">
                            </span>
                        </label>

                        <input type="text" class="form-control" readonly>
                    </div>

                    <span class="help-block">
                        You can download an image in JPG or PNG format. Size image 120x120
                    </span>

                    <div class="btn-group">
                        <button type="submit" class="btn btn-primary btn-fill btn-color">Submit</button>
                        <button type="button" class="btn btn-default" data-dismiss="modal">Cancel</button>
                    </div>

                </form:form>
            </div>
        </div>
    </div>
</div>


</body>

<jsp:include page="/WEB-INF/pages/dashboards/template/footer.jsp"/>

</html>
