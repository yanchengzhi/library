<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
<title>管理主页</title>
<link rel="stylesheet" href="${APP_PATH}/static/css/bootstrap.min.css">
<script src="${APP_PATH}/static/js/jquery-3.2.1.js"></script>
<script src="${APP_PATH}/static/js/bootstrap.min.js"></script>
</head>
<body background="${APP_PATH}/static/img/book2.jpg"
	style="background-repeat: no-repeat; background-size: 100% 100%; background-attachment: fixed;">

	<div id="header">
	   <!-- 包含主页面进来 -->
	   <jsp:include page="admin_header.jsp"></jsp:include>
	</div>

	<!-- 模态框（Modal） -->
	<div class="modal fade" id="myModal" tabindex="-1" role="dialog"
		aria-labelledby="myModalLabel" aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"
						aria-hidden="true">&times;</button>
					<h4 class="modal-title" id="myModalLabel">温馨提示</h4>
				</div>
				<div class="modal-body">使用结束后请安全退出。</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-primary" data-dismiss="modal">知道了
					</button>
				</div>
			</div>
		</div>
	</div>
	<c:if test="${!empty login}">
		<script>
			$(function() {
				$("#myModal").modal({
					show : true
				})
			})
		</script>
	</c:if>

</body>
</html>