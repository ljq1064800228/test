<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}"></c:set>
<link rel="stylesheet" href="manger/css/common/navLeft.css">
<div class="nav_wrap">
	<!-- 一级菜单 -->
	<div class="main_mune">
		<dl>
			<dt>主菜单</dt>
			<c:forEach items="${SysMenuList}" var="menu" varStatus="status">
				<c:if test="${menu.parentID==0}">
					<%-- <shiro:hasPermission name="${menu.menuID }"> --%>
					<dd menuId="${menu.menuID }">${menu.menuName}</dd>
					<%-- </shiro:hasPermission> --%>
				</c:if>
			</c:forEach>
			
			<!--<dd>商品管理</dd>
			<dd>订单管理</dd>
			<dd>系统配置</dd>
			<dd>会员管理</dd>
			<dd>客服支持</dd>
			<dd>处方笺管理</dd>
			<dd>营销策略</dd>   --> 
		</dl>
	</div>
	<!-- 一级菜单  -->
	
	<!-- 子菜单 -->
	<div class="all_sub_mune">
		 <div class="sub_mune_item">
			<dl class="sub_mune">
				<!-- 子菜单 -->			
			</dl>
			<button class="layui-btn layui-btn-back round"><i class="icons icon_back"></i>返回</button>
		</div>
		<!-- 子菜单 end -->
	
	<!-- 遮罩 -->
	<div class="covers"></div>
	<!-- 遮罩 end -->
</div>
</div>
<script src="manger/js/common/navLeft.js"></script>







