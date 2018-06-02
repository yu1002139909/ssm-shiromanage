<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
<title>Blog</title>
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
					<h1><a href="${pageContext.request.contextPath}/index.jsp">主页<img src="images/d.png" alt="" /></a></h1>

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
				<div class="social">
					<ul>
					</ul>
				</div>
		</div>
		<!--//header-->
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
	<!--blog-starts-->
	<div class="blog">
		<div class="container">
			<div class="blog-top heading">
				<h2>文章</h2>
				<p>精选文章</p>
			</div>


			<div class="blog-bottom">

				<c:forEach  var="acticle" items="${requestScope.acticleList}"  varStatus="varSta">
					<div class="blog1">
						<div class="col-md-6 blog-left">
							<a href="${pageContext.request.contextPath}/activle/activlebyid?id=${acticle.id}" class="mask"><img class="zoom-img" src="${pageContext.request.contextPath}/${acticle.imgList[0].url}" alt=""/></a>
						</div>
						<div class="col-md-6 blog-right">
							<h3><a href="${pageContext.request.contextPath}/activle/activlebyid?id=${acticle.id}">${acticle.title}</a></h3>
							<ul>
								<li><span class="glyphicon glyphicon-bookmark" aria-hidden="true"></span><p><a href="#">${acticle.address}</a></p></li>
								<li><span class="glyphicon glyphicon-calendar" aria-hidden="true"></span><p>${acticle.date}</p></li>
								<li><span class="glyphicon glyphicon-user" aria-hidden="true"></span><p><a href="">${acticle.lyUser.userName}</a></p></li>
							</ul>
							<p>${acticle.conten}</p>
							<div class="b-btn">
								<a href="${pageContext.request.contextPath}/activle/activlebyid?id=${acticle.id}">更多</a>
							</div>
						</div>
						<div class="clearfix"></div>
					</div>

				</c:forEach>
			<!--<div class="page">-->
				<!--<nav>-->
				  <!--<ul class="pagination">-->
					<!--<li class="disabled"><a href="#" aria-label="Previous"><span aria-hidden="true">«</span></a></li>-->
					<!--<li class="active"><a href="#">1 <span class="sr-only">(current)</span></a></li>-->
					<!--<li><a href="#">2 <span class="sr-only"></span></a></li>-->
					<!--<li><a href="#">3 <span class="sr-only"></span></a></li>-->
					<!--<li><a href="#">4 <span class="sr-only"></span></a></li>-->
					<!--<li><a href="#">5 <span class="sr-only"></span></a></li>-->
					 <!--<li> <a href="#" aria-label="Next"><span aria-hidden="true">»</span> </a> </li>-->
				  <!--</ul>-->
				<!--</nav>-->
			<!--</div>-->
		</div>
	</div>			
	<!--blog-ends-->
	<!--footer-starts-->
</body>
</html>