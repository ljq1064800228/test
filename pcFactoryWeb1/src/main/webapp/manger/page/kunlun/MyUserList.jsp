<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<%
	String pathUrl = request.getContextPath();
	String basePathUrl = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/user/";
%>
<html>
<head>
<link rel="stylesheet" href="<%=basePath %>manger/layui2.4.5/css/layui.css">
<script src="<%=basePath %>manger/js/common/jquery-1.12.4.min.js"></script>
<script src="<%=basePath %>manger/layui2.4.5/layui.js"></script>

<style type="text/css">
	.layui-nav{
		background-color: #f3f3f2;
	}
	.layui-table-page .layui-laypage button{
		background-color: #009688;
	}
	.my-skin .layui-layer-btn .layui-layer-btn1 {
	background-color: #84c101;
	border: 1px solid #84c101;
	color: #FFF;
	}
	.layui-unselect dl { max-height:180px; }
</style>
</head>
<body>
	<div style="margin-top: 20px;">
		<form action="" class="layui-form" id="form">
			<div class="layui-form-item">
				<div class="layui-inline">
					<label class="layui-form-label">用户ID</label>
					<div class="layui-input-block" style="width: 200px;">
						<input type="text" name="name" autocomplete="off" class="layui-input">
					</div>						
				</div>
				<div class="layui-inline" style="margin-left: 35px;">	
					<button class="layui-btn btn_search" lay-submit lay-filter="quarry" id="the_Approved_search">搜索</button>
					<button class="layui-btn layui-btn-primary" lay-submit lay-filter="export" >导出数据</button>	
				</div>
			</div>
		</form>
		<div>		
			<div>
				<table id="table_group" lay-filter="table_group"></table>
			</div>
		</div>
	</div>
</body>
<script type="text/javascript">
var group = [ [ 
	{
		type:'user_id',
		title : 'ID',
		align : 'center',
		width : '12%',	
	},
	{
		type:'user_id',
		title : '用户昵称',
		align : 'center',
		width : '18%',	
	},
	{
		type:'course_id',
		title : '用户类型',
		align : 'center',
		width : '18%',	
	},
	{
		type:'payment',
		title : '状态',
		align : 'center',
		width : '12%',	
	},
	{
		field : 'created',
		title : '注册时间',
		align : 'center',
		width : '26%'
	},
] ];
$(function(){
	layui.use(['table',"layer","form"], function(){
		var table = layui.table;
		var layer = layui.layer;
		var form = layui.form;
		var tableOv =  null;
		
	
		//表格渲染
		tableOv = table.render({
			elem : "#table_group",
			height : 500,
			url : "<%=basePathUrl%>getKlUsers", // 数据接口
			method : "POST",
			id : "table_group",
			page : true ,// 开启分页
			limits : [ 10, 20, 50, 100 ],
			cols : group,
			done:function(res, curr){
		    	  var brforeCurr = curr; // 获得当前页码
		    	  var dataLength = 0	    	  
		    }
		});		
		form.on('submit(quarry)',function(data) {
			var allData = $("#form").serializeObject();
			table.reload("table_group", {
				url : "<%=basePathUrl%>getKlUsers",
		        dataType : 'json',
				where : allData,
				page : {
					curr : 1
					//重新从第 1 页开始
					}
				});
			return false; //阻止表单跳转。如果需要表单跳转，去掉这段即可。
	  	});
		form.render();
		form.on('submit(export)',function(data) {
			var allData = $("#form").serializeObject();
			$("#form").attr("action","<%=basePathUrl%>exportKlUserInfo?doctor="+allData);
			$("#form").submit();
	  	}); 
	});	
});
$.fn.serializeObject = function() {  
	  o = {};  
	     var a = this.serializeArray();  
	     $.each(a, function() {  
	         if (o[this.name]) {  
	             if (!o[this.name].push) {  
	                 o[this.name] = [ o[this.name] ];  
	             }  
	             o[this.name].push(this.value || '');  
	         } else {  
	             o[this.name] = this.value || '';  
	         }  
	     });  
	   return o;  
};
</script>
</html>