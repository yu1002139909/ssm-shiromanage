<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
	<meta charset="utf-8">
	<meta name="renderer" content="webkit|ie-comp|ie-stand">
	<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
	<meta name="viewport" content="width=device-width,initial-scale=1,minimum-scale=1.0,maximum-scale=1.0,user-scalable=no" />
	<meta http-equiv="Cache-Control" content="no-siteapp" />
	<link rel="Bookmark" href="/favicon.ico" >
	<link rel="Shortcut Icon" href="/favicon.ico" />
	<!--[if lt IE 9]>
	<script type="text/javascript" src="${pageContext.request.contextPath}/lib/html5shiv.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/lib/respond.min.js"></script>
	<![endif]-->
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/static/h-ui/css/H-ui.min.css" />
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/static/h-ui.admin/css/H-ui.admin.css" />
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/lib/Hui-iconfont/1.0.8/iconfont.css" />
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/static/h-ui.admin/skin/default/skin.css" id="skin" />
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/static/h-ui.admin/css/style.css" />
	<!--[if IE 6]>
	<script type="text/javascript" src="${pageContext.request.contextPath}/lib/DD_belatedPNG_0.0.8a-min.js" ></script>
	<script>DD_belatedPNG.fix('*');</script>
	<![endif]-->
	<!--/meta 作为公共模版分离出去-->

	<title>添加班级 - H-ui.admin 3.0</title>
	<meta name="keywords" content="H-ui.admin 3.0,H-ui网站后台模版,后台模版下载,后台管理系统模版,HTML后台模版下载">
	<meta name="description" content="H-ui.admin 3.0，是一款由国人开发的轻量级扁平化网站后台模板，完全免费开源的网站后台管理系统模版，适合中小型CMS后台系统。">
</head>
<form action="${pageContext.request.contextPath}/grade/add.action" method="post" class="form form-horizontal" id="form-member-add"  enctype="multipart/form-data">
	<div class="row cl">
		<label class="form-label col-xs-4 col-sm-3"><span class="c-red">*</span>班级编号：</label>
		<div class="formControls col-xs-8 col-sm-9">
			<input type="text" class="input-text" value="" placeholder="" id="grade_name" name="grade_name">
		</div>
	</div>
	<div class="row cl">
		<label class="form-label col-xs-4 col-sm-3"><span class="c-red">*</span>入学年份：</label>
		<div class="formControls col-xs-8 col-sm-9">
			<input type="text" class="input-text" value="" placeholder="" id="grade_year" name="year" onfocus="WdatePicker({'dateFmt':'yyyy'})">
		</div>
	</div>
	<div class="row cl">
		<label class="form-label col-xs-4 col-sm-3">照片：</label>
		<input type="file" name="file"/>
	</div>
	<div class="row cl">
		<label class="form-label col-xs-4 col-sm-3">所属学院：</label>
		<div class="formControls col-xs-8 col-sm-9"> <span class="select-box">
				 <select class="select" size="1"  name="mcourse_id" id="orgId" onchange="test();">
					<option value="">--请选择学院--</option>
					 <c:forEach var="course" items="${requestScope.courseList}">
						<option value="${course.course_id}" name="">
						  ${course.course_name}
						</option>
					</c:forEach>
				</select>
				</span> </div>
	</div>
	<div class="row cl">
		<label class="form-label col-xs-4 col-sm-3">所属专业：</label>
		<div class="formControls col-xs-8 col-sm-9"> <span class="select-box">
				 <select class="select" size="1"  name="gmajor_id" id="major" >
					  <option value="" name="gmajor_id">

					  </option>
				</select>
				</span> </div>
	</div>
	<div class="row cl">
		<div class="col-xs-8 col-sm-9 col-xs-offset-4 col-sm-offset-3">
			<input class="btn btn-primary radius" type="submit" value="&nbsp;&nbsp;提交&nbsp;&nbsp;">
		</div>
	</div>
</form>

<!--_footer 作为公共模版分离出去-->
<script type="text/javascript" src="${pageContext.request.contextPath}/lib/jquery/1.9.1/jquery.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/lib/layer/2.4/layer.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/static/h-ui/js/H-ui.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/static/h-ui.admin/js/H-ui.admin.js"></script>
<!--/_footer 作为公共模版分离出去-->

<!--请在下方写此页面业务相关的脚本-->
<script type="text/javascript" src="${pageContext.request.contextPath}/datepicker/WdatePicker.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/lib/My97DatePicker/4.8/WdatePicker.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/lib/jquery.validation/1.14.0/jquery.validate.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/lib/jquery.validation/1.14.0/validate-methods.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/lib/jquery.validation/1.14.0/messages_zh.js"></script>
<script type="text/javascript">
    $(function(){
        $('.skin-minimal input').iCheck({
            checkboxClass: 'icheckbox-blue',
            radioClass: 'iradio-blue',
            increaseArea: '20%'
        });

        $("#form-member-add").validate({
            rules:{
                course_name:{
                    required:true,
                    minlength:1,
                    maxlength:16
                },
                sex:{
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
            s:function(form){
                var index = parent.layer.getFrameIndex(window.name);
                //parent.$('.btn-refresh').click();
                parent.layer.close(index);
                //$(form).ajaxSubmit();

            }
        });
    });
    function test () {
        var wen =  $("#orgId").val();
        $.ajax({
            url: '${pageContext.request.contextPath}/grade/getMajor?course_id='+wen,
            type: "post",
            async: false,//非异步
            success:function (msg) {
                $("#major").empty();
                $("#major").append("<option value=''>----选择专业----</option>");
                $.each(msg.tasks,function(index,item){
                    $("#major").append( "<option value='"+item.major_id+"'>"+item.major_name+"</option>");
                });
            }
        });
    }
</script>
</body>
</html>