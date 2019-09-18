<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="contextPath" value="${pageContext.request.contextPath}"></c:set>
<link rel="stylesheet" href="manger/css/common/header.css">
<div id="header">
	<div class="header_in">
		<div class="f_left hi_left">
			<button class="header_mune" disabled="disabled"></button>
			
		</div>
		<div class="f_right hi_right">
			<ul>
				<li class="Welcoming">
					<span>欢迎您：${user.userName}<i></i></span>
				</li>
				<li>
					<a href="${contextPath}/index">主页</a>
				</li>
				<li class="revise_pwd">
					<a href="javascript:;">修改密码</a>
				</li>
				<li class="sign_out">
					<a href="javascript:;">退出</a>
				</li>
			</ul>
		</div>
	</div>
</div>

<script src="manger/js/common/navLeft.js"></script>
<script src="manger/js/common/header.js"></script>