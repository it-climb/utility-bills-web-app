

 /* template navigation
  -----------------------------------------------*/
 $('.main-navigation').onePageNav({
        scrollThreshold: 0.2, // Adjust if Navigation highlights too early or too late
        scrollOffset: 75, //Height of Navigation Bar
        filter: ':not(.external)',
        changeHash: true
    }); 

    /* Navigation visible on Scroll */
    mainNav();
    $(window).scroll(function () {
        mainNav();
    });

    function mainNav() {
        var top = (document.documentElement && document.documentElement.scrollTop) || document.body.scrollTop;
        if (top > 40) $('.sticky-navigation').stop().animate({
            "opacity": '1',
            "top": '0'
        });
        else $('.sticky-navigation').stop().animate({
            "opacity": '0',
            "top": '-75'
        });
    }

$(document).ready(function() {

  /* Hide mobile menu after clicking on a link
    -----------------------------------------------*/
    $('.navbar-collapse a').click(function(){
        $(".navbar-collapse").collapse('hide');
    });


  /* jQuery to collapse the navbar on scroll
    -----------------------------------------------*/
  $(window).scroll(function() {
      if ($(".navbar").offset().top > 50) {
          $(".navbar-fixed-top").addClass("top-nav-collapse");
      } else {
          $(".navbar-fixed-top").removeClass("top-nav-collapse");
      }
  });


   /*  smoothscroll
    -----------------------------------------------*/
   $(function() {
        $('.navbar-default a').bind('click', function(event) {
            var $anchor = $(this);
            $('html, body').stop().animate({
                scrollTop: $($anchor.attr('href')).offset().top - 49
            }, 1000);
            event.preventDefault();
        });
    });


  /* blog masonry
  -----------------------------------------------*/
  $(window).load(function () {
    blogisotope = function () {
        var e, t = $(".blog-masonry").width(),
            n = Math.floor(t);
        if ($(".blog-masonry").hasClass("masonry-true") === true) {
            n = Math.floor(t * .3033);
            e = Math.floor(t * .04);
            if ($(window).width() < 1023) {
                if ($(window).width() < 768) {
                    n = Math.floor(t * 1)
                } else {
                    n = Math.floor(t * .48)
                }
            } else {
                n = Math.floor(t * .3033)
            }
        }
        return e
    };
    var r = $(".blog-masonry");
    bloggingisotope = function () {
        r.isotope({
            itemSelector: ".post-masonry",
            animationEngine: "jquery",
            masonry: {
                gutterWidth: blogisotope()
            }
        })
    };
    bloggingisotope();
    $(window).smartresize(bloggingisotope)
  })


  /* Owl Carousel
    -----------------------------------------------*/
  $(document).ready(function() {
    $("#owl-testimonial").owlCarousel({
      autoPlay: 8000,
      singleItem: true,
    });
  });


  /* Parallax section
    -----------------------------------------------*/
  function initParallax() {
    $('#home').parallax("100%", 0.1);
    $('#testimonial').parallax("100%", 0.3);
    $('#about').parallax("100%", 0.1);
    $('#counter').parallax("100%", 0.2);
    $('#blog').parallax("100%", 0.1);
    $('#contact').parallax("100%", 0.3);

  }
  initParallax();


   /* Divider Counter
    -----------------------------------------------*/
  jQuery('.counter-item').appear(function() {
    jQuery('.counter-number').countTo();
    jQuery(this).addClass('funcionando');
    console.log('funcionando');
  });

  /* wow
  -------------------------------*/
  new WOW({ mobile: false }).init();

  });

