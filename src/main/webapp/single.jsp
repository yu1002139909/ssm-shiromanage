<%@ page import="entity.LyUser" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
<title>Single</title>
<link href="${pageContext.request.contextPath}/css/bootstrap.css" type="text/css" rel="stylesheet" media="all">
<link href="${pageContext.request.contextPath}/css/style.css" type="text/css" rel="stylesheet" media="all">
<!--Custom-Theme-files-->
	<link href="${pageContext.request.contextPath}/layui-v2.2.5/layui/css/layui.css" type="text/css" rel="stylesheet" media="all">
<link href="${pageContext.request.contextPath}/css/style.css" type="text/css" rel="stylesheet" media="all">
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/static/h-ui/css/H-ui.min.css" />
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
<script type="text/javascript" src="${pageContext.request.contextPath}/js/move-top.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/easing.js"></script>
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
		<!--header-->

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
		<!--left-->
		<div style="margin-left: 200px;width: 100px;text-align: center;float:left;margin-right: 50px">
			<ul class="layui-timeline">
				<c:forEach  var="acticle" items="${requestScope.acticleList}"  varStatus="varSta">
					<li class="layui-timeline-item">
						<i class="layui-icon layui-timeline-axis">&#xe63f;</i>
						<div class="layui-timeline-content layui-text">
							<h5 class="layui-timeline-title">${acticle.date}</h5>
							<ul>
								<li>${acticle.address}</li>
							</ul>
						</div>
					</li>
				</c:forEach>
				<li class="layui-timeline-item">
					<i class="layui-icon layui-timeline-axis">&#xe63f;</i>
					<div class="layui-timeline-content layui-text">
						<div class="layui-timeline-title">过去</div>
					</div>
				</li>
			</ul>
		</div>

		<div class="container" style="">
			<div class="single-bottom">
				<h2>${requestScope.acticle.title}</h2>
				<ul>
					<li><i class="layui-icon">&#xe715;</i> <p><a href="#">${requestScope.acticle.address}</a></p></li>
					<li><i class="layui-icon">&#xe637;</i> </span><p>${requestScope.acticle.date}</p></li>
					<li><i class="layui-icon">&#xe612;</i> <p><a href="#">${acticle.lyUser.name}</a></p>

					</li>
					<li><i class="layui-icon">&#xe641;</i> </span><p><a href="#" onclick="member_del(this,${requestScope.acticle.id})">转发</a></p></li>
					<li>
						<i class="layui-icon">&#xe6c6;</i>   <p><a href="#" onclick="addstar(this,${requestScope.acticle.id})">点赞</a></p></li>
					<li><i class="layui-icon">&#xe600;</i></span><p>点赞数量${requestScope.acticle.star}</p></li>
				</ul>
				${requestScope.acticle.conten}

				<div class="single-top">
					<c:forEach  var="img" items="${requestScope.acticle.imgList}"  varStatus="varSta">
						<img class="img-responsive" src="${pageContext.request.contextPath}/${img.url}" alt="" />
					</c:forEach>
				</div>
			</div>
			<div class="comments">
					<div class="comments-top heading">
						<h3>评论</h3>
					</div>
					<div class="comments-bottom">
						<div class="media">
						<div class="media">
							<c:forEach  var="comment" items="${requestScope.acticle.commentList}"  varStatus="varSta">
								<div class="media">
									<div class="media">
								<div class="media-body">
									<h4 class="media-heading"><a href="#">${comment.lyUser.name}</a></h4>
									<p>${comment.date}</p>
									<p>${comment.content}</p>
									<a href=""></a>
								</div>
							</c:forEach>

			        	</div>

					</div>
					</div>
			</div>
						<div style="width:100%;height:100%;border:1px solid gray" id="container"></div>
						<div id="r-result"></div>
			<div class="reply heading">
				<h3>添加你的回复</h3>
				<div class="reply-btm">
				<form  id="form-member-add" >
					<textarea placeholder="Message" required  name="content">

					</textarea>
					<input type="hidden" value="${requestScope.acticle.id}" name="acticleId">
					<div class="submit-btn">
						<input type="submit" value="提交">
					</div>
				</form>	
				</div>
			</div>
		</div>
	</div>			
	<!--single-ends-->
	<!--footer-starts-->
	<!--footer-end-->
		</div>
	</div>
</body>
<!--_footer 作为公共模版分离出去-->
<script type="text/javascript" src="${pageContext.request.contextPath}/lib/jquery/1.9.1/jquery.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/lib/layer/2.4/layer.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/lib/jquery.validation/1.14.0/jquery.validate.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/static/h-ui/js/H-ui.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/static/h-ui.admin/js/H-ui.admin.js"></script>
<!--/_footer 作为公共模版分离出去-->

<!--请在下方写此页面业务相关的脚本-->
<script type="text/javascript" src="${pageContext.request.contextPath}/lib/My97DatePicker/4.8/WdatePicker.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/lib/datatables/1.10.0/jquery.dataTables.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/lib/laypage/1.2/laypage.js"></script>
<script type="text/javascript" src="http://api.map.baidu.com/api?v=2.0&ak=HyletaniKAZlSzMhT0bOCZFP1m1K7ZfZ"></script>
<script type="text/javascript" src="http://api.map.baidu.com/library/CurveLine/1.5/src/CurveLine.min.js"></script>
<script>
    /*用户-删除*/
    function member_del(obj,id){
        layer.open({
            title: '分享'
            ,content: '确定分享吗',
            offset: 't',
            yes: function(index, layero){
                $.ajax({
                    type: 'get',
                    url: '${pageContext.request.contextPath}/forward?id=${requestScope.acticle.id}',
                    dataType: 'text',
                    success: function(data){
                        <%
                        Object userInfo = session.getAttribute("userInfo");
                        if(userInfo==null){
                            %>
                        window.location.href = "${pageContext.request.contextPath}/index.jsp";
                        return;
                        <%
                      }
                      %>
                        layer.open({
                            content: '转发成功！',
                            offset: '100px'
                        });
                    },
                    error:function(data) {
                        layer.open({
                            content: '您已经点过啦！',
                            offset: '100px'
                        });
                    },
                });
            }
        });
    }

    function addstar(obj,id){
        layer.open({
            title: '点赞',content: '确定点赞吗',
            offset: '100px',
            yes: function(index, layero){
                $.ajax({
                    type: 'get',
                    url: '${pageContext.request.contextPath}/addStar?id=${requestScope.acticle.id}',
                    dataType: 'text',
                    success: function(data){
                         <%
                         LyUser user = (LyUser) session.getAttribute("userInfo");
                         if(user==null){
                             %>
                        window.location.href = "${pageContext.request.contextPath}/index.jsp";
                        return;
                        <%
                      }
                      %>
                        layer.open({
                            content: '点赞成功！',
                            offset: '100px'
                        });
                    },
                    error:function(data) {
                        layer.open({
                            offset: '100px',
                            content: '您已经点过啦！'

                        });
                    },
                });
            }
        });
    }

    $("#form-member-add").validate({
        rules:{
            name:{
                required:false,
                minlength:2,
                maxlength:16
            },
            gender:{
                required:true,
            },
            mobile:{
                required:true,
                isMobile:true,
            },
            email:{
                required:true,
                email:true,
            },
            uploadfile:{
                required:true,
            },

        },
        onkeyup:false,
        focusCleanup:true,
        success:"valid",
        submitHandler:function(form){
            $(form).ajaxSubmit({
                type: 'post',
                url: "${pageContext.request.contextPath}/addComment" ,
                success: function(data){
                    <%
                  LyUser user2 = (LyUser) session.getAttribute("userInfo");
                if(user2==null){
                    %>
                    window.location.href = "${pageContext.request.contextPath}/login.jsp";
                    return;
                    <%
                  }
                  %>
                    layer.open({
                        offset: '100px',
                        content: '评论成功！'
                    });
                    location.reload();
                },
                error: function(XmlHttpRequest, textStatus, errorThrown){
                    layer.open({
                        offset: '100px',
                        content: '评论失败！'

                    });
                }
            });

        }
    });

</script>
<script type="text/javascript">
    // 百度地图API功能
    var map = new BMap.Map("container");
    var points = [];
    var point = new BMap.Point(116.404, 39.915);
    map.centerAndZoom(point, 15);
    // 编写自定义函数,创建标注
    var sContent ="天安门坐落在中国北京市中心,故宫的南侧,与天安门广场隔长安街相望,是清朝皇城的大门...";
    function addMarker(point){
        var marker = new BMap.Marker(point);
        map.addOverlay(marker);
    }

    // var sContent =
    //     "<h4 style='margin:0 0 5px 0;padding:0.2em 0'>天安门</h4>" +
    //     "<img style='float:right;margin:4px' id='imgDemo' src='../img/tianAnMen.jpg' width='139' height='104' title='天安门'/>" +
    //     "<p style='margin:0;line-height:1.5;font-size:13px;text-indent:2em'>天安门坐落在中国北京市中心,故宫的南侧,与天安门广场隔长安街相望,是清朝皇城的大门...</p>" +
    //     "</div>";
    var img = new BMap.Marker(point);
    // 随机向地图添加25个标注
    var bounds = map.getBounds();
    var sw = bounds.getSouthWest();
    var ne = bounds.getNorthEast();
    var opts = {
        width : 500,     // 信息窗口宽度
        height: 300,     // 信息窗口高度
        title : "信息窗口" , // 信息窗口标题
        enableMessage:true//设置允许信息窗发送短息
    };
    var lngSpan = Math.abs(sw.lng - ne.lng);
    var latSpan = Math.abs(ne.lat - sw.lat);
    <c:forEach  var="acticle" items="${requestScope.acticleList}"  varStatus="varSta">
       var beijingPosition=new BMap.Point(${acticle.jd},${acticle.wd})
	   points.push(beijingPosition);

       var content =
           "<img style='float:right;margin:4px' id='imgDemo' src='${pageContext.request.contextPath}/${acticle.imgList[0].url}' width='500' height='300' title=''/>"
           "</div>";
       var marker = new BMap.Marker(beijingPosition);
       map.addOverlay(marker);
       addClickHandler(content,marker);
	</c:forEach>
    var infoWindow = new BMap.InfoWindow(sContent);
    map.centerAndZoom(new BMap.Point(118.454, 32.955), 6);
    map.enableScrollWheelZoom();
    var curve = new BMapLib.CurveLine(points, {strokeColor:"blue", strokeWeight:3, strokeOpacity:0.5}); //创建弧线对象
    map.addOverlay(curve); //添加到地图中

    function addClickHandler(content,marker){
        marker.addEventListener("click",function(e){
            openInfo(content,e)}
        );
    }
    function openInfo(content,e){
        var p = e.target;
        var point = new BMap.Point(p.getPosition().lng, p.getPosition().lat);
        var infoWindow = new BMap.InfoWindow(content,opts);  // 创建信息窗口对象
        map.openInfoWindow(infoWindow,point); //开启信息窗口
    }
</script>
</html>