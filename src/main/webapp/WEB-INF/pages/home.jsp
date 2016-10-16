<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!DOCTYPE html>
<html lang="en">

<head>
  <meta charset="UTF-8" />

  <title>Utility Bills</title>

  <meta http-equiv="X-UA-Compatible" content="IE=Edge">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <meta name="keywords" content="">
  <meta name="description" content="">
  <!--

  Template 2077 Modern Town

  http://www.tooplate.com/view/2077-modern-town

  -->
  <link rel="stylesheet" href="resources/assets/css/bootstrap.min.css">
  <link rel="stylesheet" href="resources/assets/css/animate.min.css">
  <link rel="stylesheet" href="resources/assets/css/font-awesome.min.css">
  <link rel="stylesheet" href="resources/assets/css/owl.theme.css">
  <link rel="stylesheet" href="resources/assets/css/owl.carousel.css">
  <link rel="stylesheet" href="resources/assets/css/style.css">
  <link href='https://fonts.googleapis.com/css?family=Open+Sans:400,700' rel='stylesheet' type='text/css'>

  <script src="resources/assets/js/jquery.js"></script>
  <script src="resources/assets/js/jquery.validate.min.js"></script>

</head>
<body data-spy="scroll" data-target=".navbar-collapse" data-offset="50">


<!-- Home section
================================================== -->
<section id="home" class="parallax-section">
  <div class="container">
    <div class="row">

      <div class="col-md-12 col-sm-12">
        <h2 class="wow fadeInDown" data-wow-delay="0.2s"><spring:message code="home.section.h2"/></h2>
        <h1 class="wow fadeInDown"><spring:message code="home.section.h1"/></h1>
        <a href="#" class="btn btn-danger wow fadeInUp" data-wow-delay="0.4s"><spring:message code="home.section.button1"/></a>
        <a href="#about" class="btn btn-default smoothScroll wow fadeInUp" data-wow-delay="0.6s"><spring:message code="home.section.button2"/></a>
      </div>

    </div>
  </div>
</section>


<!-- Navigation section
================================================== -->
<section class="navbar navbar-default navbar-fixed-top sticky-navigation" role="navigation">
  <div class="container">

    <div class="navbar-header">
      <button class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
        <span class="icon icon-bar"></span>
        <span class="icon icon-bar"></span>
        <span class="icon icon-bar"></span>
      </button>
      <a href="#" class="navbar-brand"><spring:message code="nav.section.brand"/></a>
    </div>
    <div class="collapse navbar-collapse">
      <ul class="nav navbar-nav navbar-right main-navigation">
        <li><a href="#home" class="smoothScroll"><spring:message code="nav.section.link1"/></a></li>
        <li><a href="#about" class="smoothScroll"><spring:message code="nav.section.link2"/></a></li>
        <li><a href="#testimonial" class="smoothScroll"><spring:message code="nav.section.link3"/></a></li>
        <%--<li><a href="#blog" class="smoothScroll"><spring:message code="nav.section.link4"/></a></li>--%>
        <li><a href="#contact" class="smoothScroll"><spring:message code="nav.section.link5"/></a></li>
        <c:if test="${email == null}">
        <li><a href="" class="smoothScroll" data-toggle="modal" data-target="#modal-1"><spring:message code="nav.section.link6"/></a></li>
        <li><a href="" class="smoothScroll" data-toggle="modal" data-target="#modal-2"><spring:message code="nav.section.link9"/></a></li>
        </c:if>
        <c:if test="${email != null}">
          <li><a href="/dashboards" class="smoothScroll">${email}</a></li>
          <li><a href="/accountLogout" class="smoothScroll"><spring:message code="nav.section.link10"></spring:message></a> </li>
        </c:if>
        <a href="home?mylocale=en"><spring:message code="nav.section.link7"/></a> | <a href="home?mylocale=ru"><spring:message code="nav.section.link8"/></a>
      </ul>
    </div>

  </div>
</section>


<!-- about section
================================================== -->
<section id="about" class="paralla-section">
  <div class="container">
    <div class="row">
      <!---->
      <div class="col-md-6 col-sm-12">
        <img src="resources/assets/images/about-img-1.jpg" class="img-responsive" alt="about img 1">
      </div>

      <div class="col-md-6 col-sm-12">
        <div class="about-des">
          <h4><spring:message code="about.section1.h4"/></h4>
          <h3><spring:message code="about.section1.h3"/></h3>
          <p><spring:message code="about.section1.p.path1"/> <a rel="nofollow" href="http://www.tooplate.com" target="_parent"><spring:message code="about.section1.p.link1"/></a> <spring:message code="about.section1.p.path2"/> <a rel="nofollow" href="http://unsplash.com" target="_parent"><spring:message code="about.section1.p.link2"/></a> <spring:message code="about.section1.p.path3"/> <a rel="nofollow" href="http://pixabay.com" target="_parent"><spring:message code="about.section1.p.link3"/></a> <spring:message code="about.section1.p.path4"/></p>
        </div>
      </div>

    </div>

    <div class="row">

      <div class="col-md-6 col-sm-12">
        <div class="about-des">
          <h4><spring:message code="about.section2.h4"/></h4>
          <h3><spring:message code="about.section2.h3"/></h3>
          <p><spring:message code="about.section2.p.path1"/></p>
        </div>
      </div>

      <div class="col-md-6 col-sm-12">
        <img src="resources/assets/images/about-img-2.jpg" class="img-responsive" alt="about img 2">
      </div>

    </div>
  </div>
</section>

<!-- Testimonial section
================================================== -->
<section id="testimonial" class="parallax-section">
  <div class="container">
    <div class="row">

      <!-- Service Owl Carousel section
      ================================================== -->
      <div id="owl-testimonial" class="owl-carousel">

        <div class="item">
          <div class="row">
            <div class="col-md-offset-2 col-md-8">
              <img src="resources/assets/images/testimonial-img-1.jpg" class="img-responsive img-circle" alt="testimonial img">
              <h2><spring:message code="service.section1.h2"/></h2>
              <p><spring:message code="service.section1.p"/></p>
            </div>
          </div>
        </div>
        <div class="item">
          <div class="row">
            <div class="col-md-offset-2 col-md-8">
              <img src="resources/assets/images/testimonial-img-2.jpg" class="img-responsive img-circle" alt="testimonial img">
              <h2><spring:message code="service.section2.h2"/></h2>
              <p><spring:message code="service.section2.p"/></p>
            </div>
          </div>
        </div>
        <div class="item">
          <div class="row">
            <div class="col-md-offset-2 col-md-8">
              <img src="resources/assets/images/testimonial-img-3.jpg" class="img-responsive img-circle" alt="testimonial img">
              <h2><spring:message code="service.section3.h2"/></h2>
              <p><spring:message code="service.section3.p"/></p>
            </div>
          </div>
        </div>

      </div>


    </div>
  </div>
</section>





<!-- Counter section
================================================== -->
<section id="counter" class="paralla-section">
  <div class="container">
    <div class="row">

      <div class="col-md-3 col-sm-3 counter-item">
        <h3 class="counter-number" data-from="1" data-to="256" data-speed="1000"></h3>
        <span class="counter-text"><spring:message code="count.section1.h3"/></span>
      </div>
      <div class="col-md-3 col-sm-3 counter-item">
        <h3 class="counter-number" data-from="1" data-to="512" data-speed="2000"></h3>
        <span class="counter-text"><spring:message code="count.section2.h3"/></span>
      </div>
      <div class="col-md-3 col-sm-3 counter-item">
        <h3 class="counter-number" data-from="1" data-to="1024" data-speed="3000"></h3>
        <span class="counter-text"><spring:message code="count.section3.h3"/></span>
      </div>
      <div class="col-md-3 col-sm-3 counter-item">
        <h3 class="counter-number" data-from="1" data-to="2048" data-speed="4000"></h3>
        <span class="counter-text"><spring:message code="count.section4.h3"/></span>
      </div>

    </div>
  </div>
</section>


<!-- blog section
================================================== -->
  <div id="whiteline"></div>
<!-- Contact section
================================================== -->
<section id="contact" class="parallax-section">
  <div class="container">
    <div class="row">

      <!-- Contact form section
      ================================================== -->
      <div class="col-md-6 col-sm-6 wow fadeInDown" data-wow-delay="0.6s">
        <form action="#" method="post">
          <div class="col-md-12 col-sm-12">
            <input type="text" class="form-control" placeholder="<spring:message code="contact.section.name"/>" name="name" id="name">
            <input type="email" class="form-control" placeholder="<spring:message code="contact.section.email"/>" name="email" id="email1"> //edit id, was id="email"
            <input type="text" class="form-control" placeholder="<spring:message code="contact.section.subject"/>" name="subject">
            <textarea name="message" rows="8" class="form-control" id="message" placeholder="<spring:message code="contact.section.message"/>" message="message"></textarea>
          </div>
          <div class="col-md-6 col-sm-6">
            <input name="submit" type="submit" class="form-control" id="submit" value="<spring:message code="contact.section.button"/>">
          </div>
        </form>
      </div>

      <!-- Contact detail section
      ================================================== -->
      <div class="col-md-6 col-sm-6 wow fadeInUp" data-wow-delay="0.9s">
        <div class="contact-detail">
          <h2><spring:message code="contact.details.section.h2"/></h2>
          <div>
            <h4><spring:message code="contact.details.section.h4"/></h4>
            <p><spring:message code="contact.details.section.p"/></p>
          </div>
          <div>
            <h4><spring:message code="contact.details.section1.h4"/></h4>
            <p><spring:message code="contact.details.section1.p"/></p>
            <p><spring:message code="contact.details.section1.p1"/></p>
          </div>
        </div>
      </div>

    </div>
  </div>
</section>

<!-- modal login
================================================== -->
<div class="modal" id="modal-1">
  <div class="modal-dialog modal-sm">
    <div class="modal-content">
      <div class="modal-body">
        <div class="btn-group btn-group-justified" role="group" aria-label="...">
          <div class="btn-group" role="group">
            <button type="button" class="btn btn-default active"><spring:message code="nav.section.link6"/></button>
          </div>
          <div class="btn-group" role="group">
            <button type="button" class="btn btn-default" data-toggle="modal" data-target="#modal-2" data-dismiss="modal"><spring:message code="nav.section.link9"/></button>
          </div>
        </div>
      </div>
      <div class="modal-footer">
        <div align="center">
          <ul class="sign-social-icon">
            <li><a href="/facebookLogin" class="fa fa-facebook wow fadeIn sign-facebook" data-wow-delay="0.3s"></a></li>
            <li><a href="/twitterLogin" class="fa fa-twitter wow fadeIn sign-twitter" data-wow-delay="0.6s"></a></li>
            <li><a href="/linkedinLogin" class="fa fa-linkedin wow fadeIn sign-linkedin" data-wow-delay="0.9s"></a></li>
            <li><a href="/googleLogin" class="fa fa-google-plus wow fadeIn sign-google" data-wow-delay="1.2s"></a></li>
          </ul>
        </div>

        <div class="or">
          <p><spring:message code="modal.section.h3"/></p>
        </div >

        <form:form method="post" action="/userLogin" id="contact-formL" class="form-horizontal">

          <div class="control-group controls">
            <input type="email" class="reg"  placeholder="<spring:message code="modal.section.h6"/>" name="email" id="emailL" value="${dto.email}">
          </div>
          <div class="control-group controls ">
            <input type="password" class="reg"  id="passwordL" placeholder="<spring:message code="modal.section.h7"/>" name="password"  value="${dto.password}" >
          </div>

          <div class="sign form-actions">
            <input role="button" type="submit" class="btn btn-primary  btn-block" value="<spring:message code="nav.section.link6"/>">
          </div>

        </form:form>

        <%--<div class="fmp">--%>
          <%--<a><spring:message code="modal.section.h4"/></a>--%>
        <%--</div>--%>
      </div>
    </div>
  </div>
</div>

<!-- modal registration
================================================== -->

<div class="modal" id="modal-2">
  <div class="modal-dialog modal-sm">
    <div class="modal-content">
      <div class="modal-body">
        <div class="btn-group btn-group-justified" role="group" aria-label="...">
          <div class="btn-group" role="group">
            <button type="button" class="btn btn-default" data-toggle="modal" data-target="#modal-1" data-dismiss="modal" ><spring:message code="nav.section.link6"/></button>
          </div>
          <div class="btn-group" role="group">
            <button type="button" class="btn btn-default active"><spring:message code="nav.section.link9"/></button>
          </div>
        </div>
      </div>
      <div class="modal-footer">

        <div align="center">
          <ul class="sign-social-icon">
            <li><a href="/facebookLogin" class="fa fa-facebook wow fadeIn sign-facebook" data-wow-delay="0.3s"></a></li>
            <li><a href="/twitterLogin" class="fa fa-twitter wow fadeIn sign-twitter" data-wow-delay="0.6s"></a></li>
            <li><a href="/linkedinLogin" class="fa fa-linkedin wow fadeIn sign-linkedin" data-wow-delay="0.9s"></a></li>
            <li><a href="/googleLogin" class="fa fa-google-plus wow fadeIn sign-google" data-wow-delay="1.2s"></a></li>
          </ul>
        </div>

        <div class="or">
          <p><spring:message code="modal.section.h3"/></p>
        </div>

        <form:form action="/saveUser" modelAttribute="dto" name="myForm" id="contact-form" class="form-horizontal">
          <div class="control-group controls">
                <input type="email" class="reg"  placeholder="<spring:message code="modal.section.h6"/>" name="email" id="email" value="${dto.email}">
            </div>
          <div class="control-group controls ">
            <input type="password" class="reg"  id="password" placeholder="<spring:message code="modal.section.h7"/>" name="password"  value="${dto.password}" >
          </div>
          <div class="control-group controls">
            <input type="password" class="reg" id="conf"  placeholder="<spring:message code="modal.section.h8"/>" name="conf">
          </div>
          <div class="sign form-actions">
            <input role="button" type="submit" class="btn btn-primary  btn-block" value="<spring:message code="nav.section.link9"/>">
          </div>
        </form:form>

        <div class="policy">
          <spring:message code="modal.section.h5"/>        </div>
      </div>
    </div>
  </div>
</div>

<!-- modal add
================================================== -->
<c:if test="${add == 'add'}">
<div class="modal fade" id="my-modal" tabindex="-1" role="dialog"  aria-hidden="true">
  <div class="modal-dialog">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
        <h4 class="modal-title modal-center-text" id="myModalLabel"><spring:message code="modal.section.h11"/> </h4>
      </div>
      <div class="modal-body">
        <div class="modal-center-text"><spring:message code="modal.section.h12"/></div>
      </div>
    </div>
    </div>
  </div>
</c:if>

<!-- modal errorLogin
================================================== -->
<c:if test="${add == 'errorLogin'}">
<div class="modal fade" id="my-modal" tabindex="-1" role="dialog"  aria-hidden="true">
  <div class="modal-dialog">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
        <h4 class="modal-title modal-center-text" id="myModalLabel2"><p><spring:message code="modal.section.h9"/></p> </h4>
      </div>
      <div class="modal-body">
        <div class="modal-center-text"><spring:message code="modal.section.h10"/></div>
      </div>
    </div>
    </div>
  </div>
</c:if>

<!-- Footer section
================================================== -->
<footer>
  <div class="container">
    <div class="row">

      <div class="col-md-6 col-sm-6 wow fadeInUp" data-wow-delay="0.3s">
        <h2><spring:message code="footer.section.h2"/></h2>
        <p><spring:message code="footer.section.p"/></p>
        <p><spring:message code="footer.section.p1"/> <a rel="nofollow" href="http://www.tooplate.com" target="_parent"><spring:message code="footer.section.p1.link"/></a></p>
      </div>
      <div class="link-list col-md-2 col-sm-2 wow fadeInUp" data-wow-delay="0.6s">
        <h2><spring:message code="footer.section1.h2"/></h2>
        <a href="#"><spring:message code="footer.section1.link1"/></a>
        <%--<a href="#"><spring:message code="footer.section1.link2"/></a>--%>
        <a href="#"><spring:message code="footer.section1.link3"/></a>
        <a href="#"><spring:message code="footer.section1.link4"/></a>
      </div>
      <div class="link-list col-md-2 col-sm-2 wow fadeInUp" data-wow-delay="0.6s">
        <h2><spring:message code="footer.section2.h2"/></h2>
        <a href="#"><spring:message code="footer.section2.link1"/></a>
        <a href="#"><spring:message code="footer.section2.link2"/></a>
        <a href="#"><spring:message code="footer.section2.link3"/></a>
        <a href="#"><spring:message code="footer.section2.link4"/></a>
      </div>
      <div class="col-md-2 col-sm-2 wow fadeInUp" data-wow-delay="0.9s">
        <h2><spring:message code="footer.section3.h2"/></h2>
        <ul class="social-icon">
          <li><a href="/facebookLogin" class="fa fa-facebook wow fadeIn" data-wow-delay="0.3s"></a></li>
          <li><a href="/twitterLogin" class="fa fa-twitter wow fadeIn" data-wow-delay="0.6s"></a></li>
          <li><a href="/linkedinLogin" class="fa fa-linkedin wow fadeIn" data-wow-delay="0.9s"></a></li>
          <li><a href="/googleLogin" class="fa fa-google-plus wow fadeIn" data-wow-delay="1.2s"></a></li>
        </ul>
      </div>
      <!--/vkLogin-->
      <div class="col-md-12 col-sm-12">
        <div class="copyright-text wow bounceIn">

        </div>
      </div>

    </div>
  </div>
</footer>

<!-- Javascript
================================================== -->

<script src="resources/assets/js/smoothscroll.js"></script><!---->
<script src="resources/assets/js/jquery.nav.js"></script>
<script src="resources/assets/js/jquery.parallax.js"></script>
<script src="resources/assets/js/owl.carousel.min.js"></script>
<script src="resources/assets/js/isotope.min.js"></script>
<script src="resources/assets/js/wow.min.js"></script>
<script src="resources/assets/js/counter.js"></script>
<script src="resources/assets/js/custom.js"></script>

<script src="resources/assets/js/bootstrap.min.js"></script>
<script src="resources/assets/js/additional-methods.js"></script>
<script src="resources/assets/js/home.js"></script>


<script>
      $(document).ready(function(){
        $("#my-modal").modal();
      });
</script>

<script>
  function getParameter(paramName) {

    var searchString = window.location.search.substring(1),
            i, val, params = searchString.split("&");

    for (i=0; i<params.length; i++) {
      val = params[i].split("=");
      if (val[0] == paramName) {
        return val[1];
      }
    }
    return null;
  }


  if (getParameter("mylocale") == "ru")
    $.getScript("resources/assets/js/messages_ru.min.js");

</script>

</body>


</html>
