<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<c:set var="contextPath" value="${pageContext.request.contextPath}"></c:set>
<% 
	/* 如果用户没登录去到登录页面 */
	if(session.getAttribute("user")==null){
		response.sendRedirect(basePath + "login.jsp");
	}
%>  

<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="UTF-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<title>昆仑定位-后台系统</title>
	<link rel="stylesheet" href="<%=basePath %>manger/layui2.4.5/css/layui.css">
	<link rel="stylesheet" href="manger/css/common/common.css">
	<link rel="stylesheet" href="manger/css/index.css" />
	<link rel="stylesheet" href="manger/css/common/navLeft.css">
	<script src="<%=basePath %>manger/js/common/jquery-1.12.4.min.js"></script>
	<script src="<%=basePath %>manger/layui2.4.5/layui.js"></script>
	<script src="<%=basePath %>manger/js/common/lay/modules/table.js"></script>
	
 <style>
 	.main_mune dl>dd.cur {
	    color: #f08200;
	    background-color: #30453b;
 	}
</style>
</head>
<body>
  
	<!-- 头部 -->	
	<header class="header"></header>
	<!-- 头部 end -->

	<main class="main_wrap">	
		<!-- 左边导航 -->
		<nav class="left_nav">
		<div class="nav_wrap">
	<!-- 一级菜单 -->
	<div class="main_mune">
		<dl>
			<dt>主菜单</dt>
			<dd id="detil">昆仑定位列表</dd>			
		</dl>
	</div>
	
</div>
		
		</nav>
		<!-- 左边导航 -->
		
		<!-- 主体内容 -->
		<div class="main_in">
			
		</div>
		<!-- 主体内容  end -->
	</main>
	
	<script>
		$(function(){	
			$(".header").load("common/header.jsp");
		})
	</script>
</body>
<script src="manger/js/common/navLeft.js"></script> 
</html>