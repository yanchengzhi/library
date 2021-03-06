<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<nav
	style="position: fixed; z-index: 999; width: 100%; background-color: #25c6fc"
	class="navbar navbar-default" role="navigation">
	<div class="container-fluid">
		<div class="navbar-header" style="margin-left: 8%; margin-right: 1%">
			<a class="navbar-brand" href="${APP_PATH}/login/index"
				style="font-family: 华文行楷; font-size: 250%; color: white">图书管理系统</a>
		</div>
		<div class="collapse navbar-collapse">
			<ul class="nav navbar-nav navbar-left">
				<li class="dropdown"><a href="#" class="dropdown-toggle"
					data-toggle="dropdown" style="color: white"> 图书管理 <b
						class="caret"></b>
				</a>
					<ul class="dropdown-menu">
						<li><a href="${APP_PATH}/book/adminBook">全部图书</a></li>
						<li class="divider"></li>
						<li><a href="${APP_PATH}/book/addBook">增加图书</a></li>
					</ul></li>
				<li class="dropdown"><a href="#" class="dropdown-toggle"
					data-toggle="dropdown" style="color: white"> 读者管理 <b
						class="caret"></b>
				</a>
					<ul class="dropdown-menu">
						<li><a href="${APP_PATH}/reader/adminReader">全部读者</a></li>
						<li class="divider"></li>
						<li><a href="${APP_PATH}/reader/adminReaderAdd">增加读者</a></li>
					</ul></li>
				<li class="dropdown"><a href="#" class="dropdown-toggle"
					data-toggle="dropdown" style="color: white"> 借还管理 <b
						class="caret"></b>
				</a>
					<ul class="dropdown-menu">
						<li><a href="${APP_PATH}/lend/lendList">借还日志</a></li>
					</ul></li>
				<li><a href="${APP_PATH}/login/repass?id=${currentUser.id}" style="color: white">
						密码修改</a></li>
			</ul>
			<ul class="nav navbar-nav navbar-right">
				<li><a href="#" style="color: white">【${currentUser.username}】
						已登录</a></li>
				<li><a href="${APP_PATH}/login/logout" style="color: white">退出</a></li>
			</ul>
		</div>
	</div>
</nav>