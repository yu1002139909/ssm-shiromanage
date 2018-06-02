<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://shiro.apache.org/tags" prefix="shiro" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
<title>Home</title>
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
<script src="${pageContext.request.contextPath}/js/jquery-1.11.1.min.js"></script>
<!--//js-->
<!--start-smoth-scrolling-->
<script type="text/javascript" src="${pageContext.request.contextPath}/js/move-top.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}js/easing.js"></script>
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
					<h1><a href="${pageContext.request.contextPath}/index.jsp">个人中心<img src="images/d.png" alt="" /></a></h1>
				</div>
				<div class="navigation">
					<span class="menu"></span> 
					<ul class="navig">
						<li class="active"><a href="${pageContext.request.contextPath}/indexui"  class="active">主页</a></li>
						<li><a href="${pageContext.request.contextPath}/imglist">画廊</a></li>
						<li><a href="${pageContext.request.contextPath}/blogList">博客</a></li>
					</ul>
				</div>
				<div class="clearfix"></div>
				<div class="social">
					<ul>
						<!--<li><a href="#"><span class="fb"></span></a></li>-->
						<!--<li><a href="#"><span class="twit"></span></a></li>-->
						<!--<li><a href="#"><span class="google"></span></a></li>-->
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
	<!--bnr-starts-->

	<div class="bnr grid">
		<c:forEach  var="acticle" items="${requestScope.acticleList}"  varStatus="varSta">
		   	<div class="col-md-3 bnr-left">
				<figure class="effect-oscar">
					<img src="${pageContext.request.contextPath}/${acticle.imgList[0].url}" alt=""/>
					<figcaption>
						<h3>${acticle.lyUser.name}</h3>
						<p>	${acticle.title}</p>
					</figcaption>
				</figure>
			</div>
		</c:forEach>
	</div>

	<!--bnr-end-->
	<!--welcome-starts-->
	<div class="welcome">
		<div class="container">
		</div>
	</div>
	<!--welcome-starts-->
	<!--fashion-starts-->
	<div class="fashion">
		<div class="container">
			<div class="welcomr-top heading" style="margin-top: 20px">
				<h3>最佳文章</h3>
				<br>
			</div>
			<div class="fashion-top">
				<div class="col-md-6 fashion-left">
					<img src="${pageContext.request.contextPath}/${requestScope.acticle.imgList[0].url}" alt="" width="500" height="300"/>
				</div>
				<div class="col-md-6 fashion-right heading">
					<h3>${requestScope.acticle.title}</h3>
					<p>${requestScope.acticle.conten}</p>
					<div class="f-btn">
						<a href="${pageContext.request.contextPath}/activle/activlebyid?id=${acticle.id}">更多</a>
					</div>
				</div>
				<div class="clearfix"></div>
			</div>
		</div>
	</div>

	<!--fashion-starts-->
	<!--profile-starts-->
	<div class="profile">

		<div class="welcomr-top heading" style="margin-top: 20px">
			<h3>最佳图片</h3>
			<br>

		</div>
			<div class="container">
			<div class="profile-top grid">

					<%--<div class="col-md-6 profile-left">--%>
						<%--<a href="images/p2.jpg" rel="title" class="b-link-stripe b-animate-go  thickbox">--%>
							<%--<figure class="effect-apollo">--%>
								<%--<img src="images/p2.jpg" alt="" />--%>
							<%--<figcaption>--%>
							<%--</figcaption>--%>
							<%--</figure>--%>
						<%--</a>--%>
					<%--</div>--%>
				<c:forEach  var="img" items="${requestScope.imgs}"  varStatus="varSta">
					<div class="col-md-6 profile-left">
							<figure class="effect-apollo">
								<img src="${pageContext.request.contextPath}/${img.url}" alt="" />
								<figcaption>
								</figcaption>
							</figure>
					</div>
				</c:forEach>

			</div>
		</div>
	</div>
	<!--profile-starts-->
	<!--gallery-end-->
	<script src="js/jquery.chocolat.js"></script>
		<link rel="stylesheet" href="css/chocolat.css" type="text/css" media="screen">
		<!--light-box-files -->
		<script type="text/javascript">
		$(function() {
			$('.profile-left a').Chocolat();
		});
		</script>
	<!--top-starts-->
	<!--add-starts-->
	<div class="add">
		<div class="container">
			<div class="add-top heading">
				<h3>优秀文章</h3>
			</div>
			<div class="add-bottom">
				<%--<div class="add-one">--%>
					<%--<div class="col-md-6 add-left">--%>
						<%--<div class="ad-left">--%>
							<%--<a href="single.jsp"><img src="images/add1.png" alt="" /></a>--%>
						<%--</div>--%>
						<%--<div class="ad-right">--%>
							<%--<a href="single.jsp"><h4>稻城，一个有你的地方</h4></a>--%>
							<%--<p>街道，穿越浮华的都市，串联我们的脚步，一步一步延伸到尽头。可路的尽头在哪儿？风乍起，搅乱本该散落在地的尘埃，飞扬着，向着远方的静谧，悄无声息的离去。然而我们都是旅行者，无法像尘埃那样，身临其境的感受神秘的远方。属于街道的故事，因为岁月的流逝，慢慢的埋藏。记忆的影子，似乎和离去的风一样，飞跃远方，再尘埃落定。--%>

								<%--我们喜欢旅行，于是去了很多个城市。</p>--%>
							<%--<div class="ad-btn">--%>
								<%--<a href="single.jsp">Readmore</a>--%>
							<%--</div>--%>
							<%--<span></span>--%>
						<%--</div>--%>
						<%--<div class="clearfix"></div>--%>
					<%--</div>--%>
					<%--<div class="col-md-6 add-left">--%>
						<%--<div class="ad-left">--%>
							<%--<a href="single.jsp"><img src="images/add2.png" alt="" /></a>--%>
						<%--</div>--%>
						<%--<div class="ad-right">--%>
							<%--<a href="single.jsp"><h4>重回罗布泊</h4></a>--%>
							<%--<p>在沿途，可以看看风景。那些曼妙的风景，有些稍纵即逝，很快从记忆里抽离；有些亘古绵长，在很久以后依然可以带着微笑回忆。--%>

								<%--我们用心记下每一个瞬间， 很久很久之后，这些是可以用生命去回忆的。每一个精彩的定格，都丰富了我们的人生。在下一个城市，你是不速之客。突兀的迈进一座城市，陌生而孤独的情绪是旅行路上常有的姿态。但不久的将来，你会慢慢熟悉城市的气息，城市也会熟悉你的气息。</p>--%>
							<%--<div class="ad-btn">--%>
								<%--<a href="single.jsp">Readmore</a>--%>
							<%--</div>--%>
							<%--<span></span>--%>
						<%--</div>--%>
						<%--<div class="clearfix"></div>--%>
					<%--</div>--%>
					<%--<div class="clearfix"></div>--%>
				<%--</div>--%>
				<%--<div class="add-two">--%>
					<%--<div class="col-md-6 add-left">--%>
						<%--<div class="ad-left">--%>
							<%--<a href="single.jsp"><img src="images/add3.png" alt="" /></a>--%>
						<%--</div>--%>
						<%--<div class="ad-right">--%>
							<%--<a href="single.jsp"><h4>再见，冰城哈尔滨</h4></a>--%>
							<%--<p>旅途中的孤单，因为旅行之人的浪漫，可以变得很亲切。每一程山水，都是一种领悟。行走在繁华的红尘，和岁月低吟浅笑，和时间陌路相逢，和命运谈笑风生。一个人的旅行，一个人的天堂。</p>--%>
							<%--<div class="ad-btn">--%>
								<%--<a href="single.jsp">Readmore</a>--%>
							<%--</div>--%>
							<%--<span></span>--%>
						<%--</div>--%>
						<%--<div class="clearfix"></div>--%>
					<%--</div>--%>

					<%--<div class="clearfix"></div>--%>
					<c:forEach  var="acticle" items="${requestScope.acticleList}"  varStatus="varSta">
						<div class="col-md-6 add-left">
							<div class="ad-left">
								<a href="${pageContext.request.contextPath}/activle/activlebyid?id=${acticle.id}"><img src="${pageContext.request.contextPath}/${acticle.imgList[0].url}" alt="" /></a>
							</div>
							<div class="ad-right">
								<a href="${pageContext.request.contextPath}/activle/activlebyid?id=${acticle.id}"><h4>${acticle.title}</h4></a>
								<div>
										${acticle.conten}
								</div>
								<span></span>
								<div class="ad-btn">
									<a href="${pageContext.request.contextPath}/activle/activlebyid?id=${acticle.id}">更多</a>
								</div>
							</div>
						</div>
					</c:forEach>

				</div>
			</div>
		</div>
	</div>
	<!--add-end-->
	<!--footer-starts-->
		<script type="text/javascript">
									$(document).ready(function() {
										/*
										var defaults = {
								  			containerID: 'toTop', // fading element id
											containerHoverID: 'toTopHover', // fading element hover id
											scrollSpeed: 1200,
											easingType: 'linear' 
								 		};
										*/
										
										$().UItoTop({ easingType: 'easeOutQuart' });
										
									});
								</script>
		<a href="#home" id="toTop" class="scroll" style="display: block;"> <span id="toTopHover" style="opacity: 1;"> </span></a>
	</div>
	<!--footer-end-->
</body>
</html>