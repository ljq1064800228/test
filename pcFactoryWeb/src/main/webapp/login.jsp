<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="UTF-8" />
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<title>后台登录系统</title>
	<link rel="stylesheet" href="<%=basePath %>manger/css/common/cssreset.css">
	<link rel="stylesheet" href="<%=basePath %>manger/css/login.css">
	<link rel="stylesheet" href="<%=basePath %>manger/layui2.4.5/css/layui.css">

	<script src="<%=basePath %>manger/js/common/jquery-1.12.4.min.js"></script>
	<script src="<%=basePath %>manger/layui2.4.5/layui.js"></script>

	
</head>
<body>
		<div class="main_in">
			<div class="con">
				<div class="login_wrap">
					<div class="login_in">
						<h2>
							<span>USER LOIN</span>
							<p>用户登录</p>
						</h2>
						<form id="loginForm"  method="post" onsubmit="return false">
							<input type="text" name="userName" id="userName" autocomplete="off" />
							<input type="password" name="password" id="password" autocomplete="off" />
							<span class="wran"></span>
							<button class="btn_submit" type="submit" >登录</button>
						</form>
					</div>
				</div>
			</div>
		</div>
</body>
<script>
$(function(){
	
	layui.use(['table',"layer","form",], function(){
		
		var table = layui.table;
		var layer = layui.layer;
		var form = layui.form;
		
		$(".btn_submit").click(function(){
			var userName = $("#userName").val();
			var password = $("#password").val();
			$.ajax({
				type : 'POST',
				url : '<%=basePath%>login',
				data : {"userName":userName,"password":password},
				dataType : 'json',
				success : function(data){
					if(data.success){
						layer.msg(data.msg);
						setTimeout(function(){
							window.location.href="./index";
						},2000);
					}else{
						layer.msg(data.msg);
					}
				}
			});
		});

		
	});
});

</script>
</html>