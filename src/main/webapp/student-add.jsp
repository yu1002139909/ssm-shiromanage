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

	<title>新增学生</title>
</head>
<form id="form-member-add" class="form form-horizontal"    enctype="multipart/form-data" onsubmit="return validate_form(this)">
	<div class="row cl">
		<label class="form-label col-xs-4 col-sm-3"><span class="c-red">*</span>学生姓名：</label>
		<div class="formControls col-xs-8 col-sm-9">
			<input type="text" class="input-text" value="" placeholder="" id="name" name="name">
		</div>
	</div>
	<div class="row cl">
		<label class="form-label col-xs-4 col-sm-3"><span class="c-red">*</span>学生电话：</label>
		<div class="formControls col-xs-8 col-sm-9">
			<input type="text" class="input-text" value="" placeholder="" id="tel" name="tel">
		</div>
	</div>
	<div class="row cl">
		<label class="form-label col-xs-4 col-sm-3"><span class="c-red">*</span>QQ：</label>
		<div class="formControls col-xs-8 col-sm-9">
			<input type="text" class="input-text" value="" placeholder="" id="qq" name="qq">
		</div>
	</div>
	<div class="row cl">
		<label class="form-label col-xs-4 col-sm-3"><span class="c-red">*</span>就职单位：</label>
		<div class="formControls col-xs-8 col-sm-9">
			<input type="text" class="input-text" value="" placeholder="" id="company" name="company">
		</div>
	</div>
	<div class="row cl">
		<label class="form-label col-xs-4 col-sm-3">照片：</label>
		<div class="formControls col-xs-8 col-sm-9"> <span class="btn-upload form-group">
				<input class="input-text upload-url" type="text" name="file" id="uploadfile" readonly nullmsg="请添加附件！" style="width:200px">
				<a href="" class="btn btn-primary radius upload-btn"><i class="Hui-iconfont">&#xe642;</i> 浏览文件</a>
				<input type="file" multiple name="file" class="input-file">
				</span> </div>
	</div>
	<div class="row cl">
		<label class="form-label col-xs-4 col-sm-3">所属学院：</label>
		<div class="formControls col-xs-8 col-sm-9"> <span class="select-box">
				 <select class="select" size="1"  name="scourse_id" id="orgId" onchange="test();">
					 <option value="">请选择</option>
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
				 <select class="select" size="1"  name="gmajor_id" id="major" onchange="test2()">
					  <option value="" name="gmajor_id">

					  </option>
				</select>
				</span>
		</div>
	</div>
	<div class="row cl">
		<label class="form-label col-xs-4 col-sm-3">班级：</label>
		<div class="formControls col-xs-8 col-sm-9"> <span class="select-box">
				 <select class="select" size="1"  name="sgrade_id" id="grade" >
					  <option value="" name="grade_id">

					  </option>
				</select>
				</span>
		</div>
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
                name:{
                    required:true,
                    minlength:1,
                    maxlength:16
                },
                tel:{
                    required:true,
                },
                qq:{
                    required:true,
                },
                company:{
                    required:true,
                },
                file:{
                    required:true,
                },
                orgId:{
                    required:true,

                },

            },
            onkeyup:false,
            focusCleanup:true,
            success:"valid",
            submitHandler:function(form){
                $(form).ajaxSubmit({
                    type: 'post',
                    url: '${pageContext.request.contextPath}/student/add',
                    success: function(data){
                        layer.msg('添加成功!',{icon:1,time:1000});
                        parent.layer.close(index);
                    },
                    error: function(XmlHttpRequest, textStatus, errorThrown){
                        layer.msg('添加失败!',{icon:2,time:1000});
                    }
                });

            }
        });
    });
    function test () {
        var wen =  $("#orgId").val();
        $.ajax({
            url: '${pageContext.request.contextPath}/student/getMajor?major_id='+wen,
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
    function test2 () {
        var wen1 =  $("#major").val();
        $.ajax({
            url: '${pageContext.request.contextPath}/student/getGrade?grade_id='+wen1,
            type: "post",
            async: false,//非异步
            success:function (msg) {
                $("#grade").empty();
                $("#grade").append("<option value=''>---选择班级----</option>");
                $.each(msg.gradeList,function(index,item){
                    $("#grade").append( "<option value='"+item.grade_id+"'>"+item.grade_name+"</option>");
                });
            }
        });
    }
    function validate_form(thisform){
        var couse=document.getElementById("orgId");
        var major=document.getElementById("major");
        var grade=document.getElementById("grade");

        if(couse.value == ""){
            alert("学院不能为空！");
            couse.focus();
            return false;
        }else if(major.value == ""){
            alert("专业不能为空！");
            major.focus();
            return false;
        }else if(grade.value == ""){
            alert("班级不能为空！");
            grade.focus();
            return false;
        }
        else{
            return true;
        }
    }
</script>
</body>
</html>