<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
<title>画廊</title>
<link href="css/bootstrap.css" type="text/css" rel="stylesheet" media="all">
<link href="css/style.css" type="text/css" rel="stylesheet" media="all">
<!--Custom-Theme-files-->
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="keywords" content="Charm Responsive web template, Bootstrap Web Templates, Flat Web Templates, Android Compatible web template, 
	Smartphone Compatible web template, free webdesigns for Nokia, Samsung, LG, SonyEricsson, Motorola web design" />
<script type="application/x-javascript"> addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false); function hideURLbar(){ window.scrollTo(0,1); } </script>
<!--//Custom-Theme-files-->
<!--js-->
<script src="js/jquery-1.11.1.min.js"></script> 
<!--//js-->
<!--start-smoth-scrolling-->
<script type="text/javascript" src="js/move-top.js"></script>
<script type="text/javascript" src="js/easing.js"></script>
<script type="text/javascript">
			jQuery(document).ready(function($) {
				$(".scroll").click(function(event){		
					event.preventDefault();
					$('html,body').animate({scrollTop:$(this.hash).offset().top},1000);
				});
			});
		</script>
<!--start-smoth-scrolling-->
</head>
<body>
	<!--banner-starts-->
	<div class="banner" id="home">
		<!--header-->		
		<div class="header">
				<div class="logo">
					<h1><a href="${pageContext.request.contextPath}/indexui">主页<img src="images/d.png" alt="" /></a></h1>

				</div>
				<div class="navigation">
					<span class="menu"></span>
					<ul class="navig">
						<li class="active"><a href="${pageContext.request.contextPath}/indexui"  class="active">主页</a></li>
						<li><a href="${pageContext.request.contextPath}/imglist">画廊</a></li>
						<li><a href="${pageContext.request.contextPath}/blogList">博客</a></li>
						<li><a href="${pageContext.request.contextPath}/index.jsp">个人中心</a></li>
					</ul>
				</div>
				<div class="clearfix"></div>
		</div>
	</div>
	<!--banner-starts-->
	<!--script-for-menu-->
		<script>
			$("span.menu").click(function(){
				$(" ul.navig").slideToggle("slow" , function(){
				});
			});
		</script>
	<!--script-for-menu-->
	<!--gallery-starts-->
	<div class="gallery">
		<div class="container">
			<div class="gallery-top heading">
				<h2>画廊</h2>
			</div>
			<div class="gallery-bottom">
				<!--<div class="g-1">-->
					<!--<div class="col-md-6 g-left">-->
						<!--<a class="example-image-link mask" href="images/g-1.jpg" data-lightbox="example-set" data-title=""><img class="example-image zoom-img" src="images/g1.jpg" alt=""/></a>		-->
					<!--</div>-->
					<!--<div class="col-md-3 g-right">-->
						<!--<a class="example-image-link mask" href="images/g-2.jpg" data-lightbox="example-set" data-title=""><img class="example-image zoom-img" src="images/g2.jpg" alt=""/></a>	-->
					<!--</div>-->
					<!--<div class="col-md-3 g-right">						-->
						<!--<a class="example-image-link mask" href="images/g-4.jpg" data-lightbox="example-set" data-title=""><img class="example-image zoom-img" src="images/g4.jpg" alt=""/></a>								-->
					<!--</div>-->
					<!--<div class="clearfix"> </div>-->
				<!--</div>-->
				<!--<div class="g-2">-->
					<!--<div class="col-md-3 g-right">-->
						<!--<a class="example-image-link mask" href="images/g-5.jpg" data-lightbox="example-set" data-title=""><img class="example-image zoom-img" src="images/g5.jpg" alt=""/></a>-->
						<!--<div class="g1">-->
							<!--<a class="example-image-link mask" href="images/g-6.jpg" data-lightbox="example-set" data-title=""><img class="example-image zoom-img" src="images/g6.jpg" alt=""/></a>-->
						<!--</div>-->
					<!--</div>-->
					<!--<div class="col-md-3 g-right">						-->
						<!--<a class="example-image-link mask" href="images/g-7.jpg" data-lightbox="example-set" data-title=""><img class="example-image zoom-img" src="images/g7.jpg" alt=""/></a>	-->
						<!--<div class="g1">-->
							<!--<a class="example-image-link mask" href="images/g-8.jpg" data-lightbox="example-set" data-title=""><img class="example-image zoom-img" src="images/g8.jpg" alt=""/></a>-->
						<!--</div>						-->
					<!--</div>
					<!--<div class="col-md-6 g-left">-->
						<!--<a class="example-image-link mask" href="images/g-3.jpg" data-lightbox="example-set" data-title=""><img class="example-image zoom-img" src="images/g3.jpg" alt=""/></a>	-->
					<!--</div>-->
					<!--<div class="clearfix"> </div>-->
				<!--</div>-->
			<!--</div>-->

				<c:forEach  var="img" items="${requestScope.imglist}"  varStatus="varSta">
					<div class="col-md-6 g-left">
					<a class="example-image-link mask" href="${pageContext.request.contextPath}/${img.url}" data-lightbox="example-set" data-title=""><img class="example-image zoom-img" src="${pageContext.request.contextPath}/${img.url}" alt=""/></a>

					</div>
				</c:forEach>
		</div>
	</div>
	<!--gallery-end-->
	<script src="js/jquery.chocolat.js"></script>
		<link rel="stylesheet" href="css/chocolat.css" type="text/css" media="screen">
		<!--light-box-files -->
		<script type="text/javascript">
		$(function() {
			$('.gallery-bottom a').Chocolat();
		});
	</script>
</body>
</html>