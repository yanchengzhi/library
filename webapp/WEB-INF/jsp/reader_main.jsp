<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>${currentUser.username}的主页</title>
<link rel="stylesheet" href="${APP_PATH}/static/css/bootstrap.min.css">
<script src="${APP_PATH}/static/js/jquery-3.2.1.js"></script>
<script src="${APP_PATH}/static/js/bootstrap.min.js"></script>
</head>
<body background="${APP_PATH}/static/img/wolf.jpg"
	style="background-repeat: no-repeat; background-size: 100% 100%; background-attachment: fixed;">
	<div id="header">
	   <jsp:include page="reader_header.jsp"></jsp:include>
	</div>
</body>
</html>