<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<nav class="navbar navbar-default" role="navigation"
	style="background-color: #fff">
	<div class="container-fluid">
		<div class="navbar-header" style="margin-left: 8%; margin-right: 1%">
			<a class="navbar-brand" href="${APP_PATH}/login/readermain">
			<p class="text-primary" style="font-family: 华文行楷; font-size: 200%;">我的图书馆</p></a>
		</div>
		<div class="collapse navbar-collapse" id="example-navbar-collapse">
			<ul class="nav navbar-nav navbar-left">
				<li class="active"><a href="${APP_PATH}/reader/readerBooks"> 图书查询 </a></li>
				<li><a href="reader_info.html"> 个人信息 </a></li>
				<li><a href="mylend.html"> 我的借还 </a></li>
				<li><a href="reader_repasswd.html"> 密码修改 </a></li>
			</ul>
			<ul class="nav navbar-nav navbar-right">
			<c:if test="${empty currentUser.username}">
			   <li><a href="#" style="font-weight:bold;">未登录</a></li>
			</c:if>
			<c:if test="${!empty currentUser.username}">
			  	<li><a href="#" style="font-weight:bold;">【${currentUser.username}】已登录</a></li>
			</c:if>
				<li><a href="${APP_PATH}/login/login">退出</a></li>
			</ul>
		</div>
	</div>
</nav>