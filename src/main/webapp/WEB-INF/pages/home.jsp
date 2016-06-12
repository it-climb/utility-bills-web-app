<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!DOCTYPE html>
<html>

<head lang="en">
  <meta charset="UTF-8" />

  <title>Utility Bills</title>

  <meta http-equiv="X-UA-Compatible" content="IE=Edge">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <meta name="keywords" content="">
  <meta name="description" content="">
  <!--

  Template 2077 Modern Town

  http://www.tooplate.com/view/2077-modern-town
<form method="get" action="/except">
  <input type="submit" value="Check log">
</form>

  -->
  <link rel="stylesheet" href="resources/assets/css/bootstrap.min.css" rel="stylesheet">
  <link rel="stylesheet" href="resources/assets/css/animate.min.css">
  <link rel="stylesheet" href="resources/assets/css/font-awesome.min.css">
  <link rel="stylesheet" href="resources/assets/css/owl.theme.css">
  <link rel="stylesheet" href="resources/assets/css/owl.carousel.css">
  <link rel="stylesheet" href="resources/assets/css/style.css">
  <link href='https://fonts.googleapis.com/css?family=Open+Sans:400,700' rel='stylesheet' type='text/css'>

  <script src="http://code.jquery.com/jquery-latest.js"></script>
  <script src="js/bootstrap.min.js"></script>

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
        <li><a href="#blog" class="smoothScroll"><spring:message code="nav.section.link4"/></a></li>
        <li><a href="#contact" class="smoothScroll"><spring:message code="nav.section.link5"/></a></li>
        <li><a class="btn btn-link btn-lg reg" data-toggle="modal" data-target="#modal-1" ><spring:message code="nav.section.link6"/></a></li>
        <li><a class="btn btn-link btn-lg reg" data-toggle="modal" data-target="#modal-2" ><spring:message code="nav.section.link9"/></a></li>
        <%--<li><a href=/login ><spring:message code="nav.section.link6"/></a></li>--%>
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
<section id="blog" class="paralla-section">
  <div class="container">
    <div class="row">

      <h2><spring:message code="blog.section.h2"/></h2>
      <h4><spring:message code="blog.section.h4"/></h4>

      <div class="blog-masonry masonry-true">

        <div class="post-masonry col-md-4 col-sm-6 wow fadeInUp">
          <div class="blog-wrapper">
            <img src="resources/assets/images/blog-img-1.jpg" class="img-responsive" alt="blog img">
            <h3><a href="#"><spring:message code="blog.section1.h3.link"/></a></h3>
            <small><spring:message code="blog.section1.small"/></small>
            <p><spring:message code="blog.section1.p"/></p>
          </div>
        </div>
        <div class="post-masonry col-md-4 col-sm-6 wow fadeInUp" data-wow-delay="0.2s">
          <div class="blog-wrapper">
            <img src="resources/assets/images/blog-img-2.jpg" class="img-responsive" alt="blog img">
            <h3><a href="#"><spring:message code="blog.section2.h3.link"/></a></h3>
            <small><spring:message code="blog.section2.small"/></small>
            <p><spring:message code="blog.section2.p"/></p>
          </div>
        </div>
        <div class="post-masonry col-md-4 col-sm-6 wow fadeInUp" data-wow-delay="0.4s">
          <div class="blog-wrapper">
            <img src="resources/assets/images/blog-img-3.jpg" class="img-responsive" alt="blog img">
            <h3><a href="#"><spring:message code="blog.section3.h3.link"/></a></h3>
            <small><spring:message code="blog.section3.small"/></small>
            <p><spring:message code="blog.section3.p"/></p>
          </div>
        </div>
        <div class="post-masonry col-md-4 col-sm-6 wow fadeInUp" data-wow-delay="0.6s">
          <div class="blog-wrapper">
            <img src="resources/assets/images/blog-img-4.jpg" class="img-responsive" alt="blog img">
            <h3><a href="#"><spring:message code="blog.section4.h3.link"/></a></h3>
            <small><spring:message code="blog.section4.small"/></small>
            <p><spring:message code="blog.section4.p"/></p>
          </div>
        </div>
        <div class="post-masonry col-md-4 col-sm-6 wow fadeInUp" data-wow-delay="0.8s">
          <div class="blog-wrapper">
            <img src="resources/assets/images/blog-img-5.jpg" class="img-responsive" alt="blog img">
            <h3><a href="#"><spring:message code="blog.section5.h3.link"/></a></h3>
            <small><spring:message code="blog.section5.small"/></small>
            <p><spring:message code="blog.section5.p"/></p>
          </div>
        </div>
        <div class="post-masonry col-md-4 col-sm-6 wow fadeInUp" data-wow-delay="1.0s">
          <div class="blog-wrapper">
            <img src="resources/assets/images/blog-img-6.jpg" class="img-responsive" alt="blog img">
            <h3><a href="#"><spring:message code="blog.section6.h3.link"/></a></h3>
            <small><spring:message code="blog.section6.small"/></small>
            <p><spring:message code="blog.section6.p"/></p>
          </div>
        </div>

      </div>

    </div>
  </div>
</section>


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
            <input type="email" class="form-control" placeholder="<spring:message code="contact.section.email"/>" name="email" id="email">
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
            <button type="button" class="btn btn-default active">Log In</button>
          </div>
          <div class="btn-group" role="group">
            <button type="button" class="btn btn-default" data-toggle="modal" data-target="#modal-2" data-dismiss="modal">Sing Up</button>
          </div>
        </div>
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-primary  btn-block btns btn-social btn-facebook"><span class="fa fa-facebook"></span> Sign in with Facebook</button>
        <div class="or">
          <p><strong>or</strong></p>
        </div >

        <form:form method="post" action="/userLogin">
          <div class="input-group email-password">
            <div class="input-group-addon"><span class="glyphicon glyphicon-envelope"></span></div>
            <input type="email" class="form-control"  placeholder="Email" name="email" value="${user.email}">
          </div>

          <div class="input-group email-password">
            <div class="input-group-addon"><span class="glyphicon glyphicon-asterisk"></span></div>
            <input type="password" class="form-control" placeholder="Password" name="password" value="${user.password}">
          </div>
          <div class="sign">
            <%--<input type="hidden" name="id" value="${user.id}">--%>
            <input role="button" type="submit" name="id" class="btn btn-primary  btn-block" value="Sign In"/>
          </div>
        </form:form>

        <div class="fmp">
          <a>Forgot my password</a>
        </div>
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
            <button type="button" class="btn btn-default" data-toggle="modal" data-target="#modal-1" data-dismiss="modal" >Log In</button>
          </div>
          <div class="btn-group" role="group">
            <button type="button" class="btn btn-default active">Sing Up</button>
          </div>
        </div>
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-primary  btn-block btns btn-social btn-facebook"><span class="fa fa-facebook"></span> Sign up with Facebook</button>
        <div class="or">
          <p><strong>or</strong></p>
        </div>

        <form:form action="saveUser" modelAttribute="dto" name="myForm">
          <div class="input-group email-password">
            <div class="input-group-addon"><span class="glyphicon glyphicon-user"></span></div>
            <input type="text" class="form-control"  placeholder="First Name" value="${dto.firstName}" name="firstName" ng-model="firstName" ng-length="1" required>
          </div>
          <div class="input-group email-password">
            <div class="input-group-addon"><span class="glyphicon glyphicon-user"></span></div>
            <input type="text" class="form-control"  placeholder="Second Name" value="${dto.secondName}" name="secondName" ng-model="secondName" ng-length="1" required>
          </div>
          <div class="input-group email-password">
            <div class="input-group-addon"><span class="glyphicon glyphicon-envelope"></span> </div>
            <input type="email" class="form-control"  placeholder="Email" name="email" ng-model="email" value="${dto.email}" required>
          </div>
          <div class="input-group email-password">
            <div class="input-group-addon"><span class="glyphicon glyphicon-asterisk"></span></div>
            <input type="password" class="form-control"  placeholder="Password" name="password" ng-model="password" ng-minlength="3" value="${dto.password}" required>
          </div>
          <div class="sign">
            <input role="button" type="submit" class="btn btn-primary  btn-block" value="Sign Up" ng-disabled="!myForm.firstName.$valid || !myForm.secondName.$valid || !myForm.email.$valid || !myForm.password.$valid"/>
          </div>
        </form:form>

        <div class="policy">
          By signing up to create an account I accept Utility Bills Terms of Use and Privacy Policy
        </div>
      </div>
    </div>
  </div>
</div>


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
        <a href="#"><spring:message code="footer.section1.link2"/></a>
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
          <li><a href="#" class="fa fa-facebook wow fadeIn" data-wow-delay="0.3s"></a></li>
          <li><a href="#" class="fa fa-twitter wow fadeIn" data-wow-delay="0.6s"></a></li>
          <li><a href="#" class="fa fa-dribbble wow fadeIn" data-wow-delay="0.9s"></a></li>
          <li><a href="#" class="fa fa-behance wow fadeIn" data-wow-delay="1s"></a></li>
        </ul>
        <div>

        </div>
      </div>

      <div class="col-md-12 col-sm-12">
        <div class="copyright-text wow bounceIn">

        </div>
      </div>

    </div>
  </div>
</footer>

<!-- Javascript
================================================== -->
<script src="resources/assets/js/jquery.js"></script>
<script src="resources/assets/js/bootstrap.min.js"></script>
<script src="resources/assets/js/smoothscroll.js"></script>
<script src="resources/assets/js/jquery.nav.js"></script>
<script src="resources/assets/js/jquery.parallax.js"></script>
<script src="resources/assets/js/owl.carousel.min.js"></script>
<script src="resources/assets/js/isotope.min.js"></script>
<script src="resources/assets/js/wow.min.js"></script>
<script src="resources/assets/js/counter.js"></script>
<script src="resources/assets/js/custom.js"></script>

</body>
</html>
