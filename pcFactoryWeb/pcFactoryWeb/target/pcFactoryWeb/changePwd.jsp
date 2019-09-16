<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
 <% 
	if(session.getAttribute("user")==null){
		response.sendRedirect("${contextPath}/login");
	}
 %>

<link rel="stylesheet" href="<%=basePath %>manger/layui2.4.5/css/layui.css">
<script src="<%=basePath %>manger/js/common/jquery-1.12.4.min.js"></script>
<script src="<%=basePath %>manger/layui2.4.5/layui.js"></script>

<form class="layui-form" style="margin:15px;" onsubmit="return false" method="post">
	<div style="margin-top: 10px;">
	 	<div class="layui-inline">
			<label class="layui-form-label" style="width: 60px;">当前账号</label>
			<div class="layui-input-inline" style="margin-top: 11px;">
				${user.userName}
			</div>
	    </div>
	</div>
	<div style="margin-top: 10px;">
	 	<div class="layui-inline">
			<label class="layui-form-label" style="width: 60px;">旧密码</label>
			<div class="layui-input-inline">
				<input type="password" style="width: 200px;" name="origPassword" lay-verify="origPassword" autocomplete="off" class="layui-input" maxlength="100">
			</div>
	    </div>
	</div>
	<div style="margin-top: 15px;">
	 	<div class="layui-inline">
			<label class="layui-form-label" style="width: 60px;">新密码</label>
			<div class="layui-input-inline">
				<input type="password" style="width: 200px;" name="newPassword" lay-verify="newPassword" autocomplete="off" class="layui-input" maxlength="100">
			</div>
	    </div>
	</div>
	<div style="margin-top: 15px;">
	 	<div class="layui-inline">
			<label class="layui-form-label" style="width: 60px;">重复密码</label>
			<div class="layui-input-inline">
				<input type="password" style="width: 200px;" name="repPassword" lay-verify="repPassword" autocomplete="off" class="layui-input" maxlength="100">
			</div>
	    </div>
	</div>
	<div style="display: none;">
    	<button class="layui-btn" lay-submit lay-filter="updatePassword" id="updatePassword">提交</button>
    </div>
</form>
<script type="text/javascript">

	var flag = false;
	function updatePassword(){
		$("#updatePassword").trigger("click");
	}
	
	layui.use(['form', 'layedit', 'laydate'], function(){
		var form = layui.form
		,layer = layui.layer
		,layedit = layui.layedit
		,laydate = layui.laydate;
		
		form.on('submit(updatePassword)', function(data){
			form.verify({
				origPassword : function(value, item){
					if(!new RegExp("^[A-Za-z0-9@#]{6,12}$").test(value)){
			    		return '旧密码必须6到12位！';
			    	}
				},		
				newPassword : function(value, item){
					if(!new RegExp("^[A-Za-z0-9@#]{6,12}$").test(value)){
			    		return '新密码必须6到12位！';
			    	}
				},		
				repPassword : function(value, item){
					if(!new RegExp("^[A-Za-z0-9@#]{6,12}$").test(value)){
			    		return '重复密码必须6到12位！';
			    	}
				},
			})
			
			
			
			if(flag == false){
				flag = true;
				return;
			}
			
			var newPassword = $("input[name='newPassword']").val();
			var repPassword = $("input[name='repPassword']").val();
			var origPassword = $("input[name='origPassword']").val();
			if(newPassword != repPassword){
				layer.msg('重复密码和新密码不一样，请重新输入！');
				return;
			}
			$.ajax({
				type : 'POST',
				url : '<%=basePath%>updatePassword',
				data : {"origPassword":origPassword,"newPassword":newPassword},
				dataType : 'json',
				success : function(data){
					if(data.success){
						layer.msg(data.msg);
						setTimeout(function(){
							var index = parent.layer.getFrameIndex(window.name);
							// 关闭当前窗口
							parent.layer.close(index);
							// 必须在父页面index.jsp跳转登录页，否则在当前提示框跳转
							parent.window.location.href="./index";
						},2000);
					}else{
						layer.msg(data.msg);
					}
				}
			});
		});		
	});
</script>

