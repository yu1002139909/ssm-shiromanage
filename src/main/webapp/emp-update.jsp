<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
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

	<title>新增职工</title>
</head>
<form action="${pageContext.request.contextPath}/emp/update?empId=${employee.empId}" method="post" class="form form-horizontal" id="form-member-add" enctype="multipart/form-data">
	<div class="row cl">
		<label class="form-label col-xs-4 col-sm-3"><span class="c-red">*</span>职工姓名：</label>
		<div class="formControls col-xs-8 col-sm-9">
			<input type="text" class="input-text" value="${employee.empName}" placeholder="" id="name" name="empName">
		</div>
	</div>

	<div class="row cl">
		<label class="form-label col-xs-4 col-sm-3"><span class="c-red">*</span>性别：</label>
		<div class="formControls col-xs-8 col-sm-9 skin-minimal">
			<div class="radio-box">
				<input name="empGrade" type="radio" id="sex-1"  value="男" ${employee.empGrade=='男'?'checked':'' }>
				<label>男</label>
			</div>
			<div class="radio-box">
				<input name="empGrade" type="radio" value="女" ${employee.empGrade=='女'?'checked':'' }>
				<label>女</label>
			</div>
		</div>
	</div>
	<div class="row cl">
		<label class="form-label col-xs-4 col-sm-3"><span class="c-red">*</span>照片：</label>
		<div class="formControls col-xs-8 col-sm-9">
			<img src="${pageContext.request.contextPath}/${employee.photo}">
		</div>
	</div>
	<div class="row cl">
		<label class="form-label col-xs-4 col-sm-3">照片：</label>
		<div class="formControls col-xs-8 col-sm-9"> <span class="btn-upload form-group">
				<input class="input-text upload-url" type="text" name="file" id="uploadfile" readonly nullmsg="请添加附件！" style="width:200px">
				<a href="${employee.photo}" class="btn btn-primary radius upload-btn"><i class="Hui-iconfont">&#xe642;</i> 浏览文件</a>
				<input type="file" multiple name="file" class="input-file">
				</span> </div>
	</div>
	<div class="row cl">
		<label class="form-label col-xs-4 col-sm-3"><span class="c-red">*</span>入职时间：</label>
		<div class="formControls col-xs-8 col-sm-9">

			<input type="text" class="input-text" value="<fmt:formatDate value="${employee.enterDate}" pattern="yyyy-MM-dd"/>" placeholder=""name="enterDate" onfocus="WdatePicker({'dateFmt':'yyyy-MM-dd'})">
		</div>
	</div>
	<div class="row cl">
		<label class="form-label col-xs-4 col-sm-3">入职部门：</label>
		<div class="formControls col-xs-8 col-sm-9"> <span class="select-box">
				 <select class="select" size="1"  name="enterDeptId" id="orgId">
					 <option value="${employee.enterDept.deptId}">${employee.enterDept.deptName}</option>
					<c:forEach var="dept" items="${requestScope.deptList}">
					  <option value="${dept.deptId}" name="">
							  ${dept.deptName}
					  </option>
					</c:forEach>
				</select>
				</span> </div>
	</div>
	<div class="row cl">
		<label class="form-label col-xs-4 col-sm-3"><span class="c-red">*</span>退休时间：</label>
		<div class="formControls col-xs-8 col-sm-9">

			<input type="text" class="input-text" value="<fmt:formatDate value="${employee.overDate}" pattern="yyyy-MM-dd"/>" placeholder=""name="overDate" onfocus="WdatePicker({'dateFmt':'yyyy-MM-dd'})">
		</div>
	</div>
	<div class="row cl">
		<label class="form-label col-xs-4 col-sm-3">退休/在职部门：</label>
		<div class="formControls col-xs-8 col-sm-9"> <span class="select-box">
				 <select class="select" size="1"  name="overDeptId" >
					 <option value="${employee.overDept.deptId}">${employee.overDept.deptName}</option>
					<c:forEach var="dept" items="${requestScope.deptList}">
					  <option value="${dept.deptId}" name="">
							  ${dept.deptName}
					  </option>
					</c:forEach>
				</select>
				</span> </div>
	</div>
	<div class="row cl">
		<label class="form-label col-xs-4 col-sm-3"><span class="c-red">*</span>在职状态：</label>
		<div class="formControls col-xs-8 col-sm-9 skin-minimal">
			<div class="radio-box">
				<input name="state" type="radio"   value="在职" ${employee.state=='在职'?'checked':''}>
				<label for="sex-1">在职</label>
			</div>
			<div class="radio-box">
				<input type="radio" id="" name="state" value="退休" ${employee.state=='退休'?'checked':''} >
				<label >退休</label>
			</div>
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
</body>
</html>