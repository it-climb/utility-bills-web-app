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

                <li>
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
                <li class="active">
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

                <li>
                    <a href="/showMap">
                        <i class="pe-7s-map-marker"></i>

                        <p>Maps</p>
                    </a>
                </li>

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

                    </ul>

                    <ul class="nav navbar-nav navbar-right">

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
                                <h4 class="title">List of city</h4>

                                <p class="category">Here is a subtitle for this table</p>
                            </div>
                            <div class="content table-responsive table-full-width">
                                <table class="table table-hover table-striped">
                                    <thead>
                                    <th>ID</th>
                                    <th>Name</th>
                                    </thead>
                                    <tbody>
                                    <tr>
                                        <c:forEach var="city" items="${cityList}">
                                    <tr>
                                        <td>${city.id}</td>
                                        <td>${city.name}</td>

                                        <td>
                                            <form method="post" action="/cityEdit">
                                                <input type="hidden" name="cityId" value=${city.id}>
                                                <input type="submit" class="btn btn-success btn-sm custom-width"
                                                       value="Edit">
                                            </form>
                                        </td>
                                        <td>

                                            <form method="post" action="/deleteCity">
                                                <input type="hidden" name="cityId" value=${city.id}>
                                                <input type="submit" class="btn btn-danger btn-sm custom-width"
                                                       value="Delete">
                                            </form>

                                        </td>
                                    </tr>
                                    </c:forEach>
                                    </tbody>
                                    <tr>
                                        <td>
                                            <form method="post" action="/cityEdit">
                                                <input type="submit" class="btn btn-danger btn-sm custom-width"
                                                       value="New city">
                                            </form>
                                        </td>
                                    </tr>
                                </table>

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
