<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
    <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
<title>《 ${book.name}》</title>
<link rel="stylesheet" href="${APP_PATH}/static/css/bootstrap.min.css">
<script src="${APP_PATH}/static/js/jquery-3.2.1.js"></script>
<script src="${APP_PATH}/static/js/bootstrap.min.js"></script>
</head>
<body background="${APP_PATH}/static/img/book2.jpg"
	style="background-repeat: no-repeat; background-size: 100% 100%; background-attachment: fixed;">
	<div id="header" style="padding-bottom: 80px">
	   <jsp:include page="admin_header.jsp"></jsp:include>
	</div>

	<div class="col-xs-6 col-md-offset-3">
		<div class="panel panel-primary">
			<div class="panel-heading">
				<h3 class="panel-title">《 ${book.name}》</h3>
			</div>
			<div class="panel-body">
				<table class="table table-hover">
					<tbody>
						<tr>
							<th width="15%">书名</th>
							<td>${book.name}</td>
						</tr>
						<tr>
							<th>作者</th>
							<td>${book.author}</td>
						</tr>
						<tr>
							<th>出版社</th>
							<td>${book.publish}</td>
						</tr>
						<tr>
							<th>ISBN</th>
							<td>${book.ISBN}</td>
						</tr>
						<tr>
							<th>简介</th>
							<td>${book.introduction}</td>
						</tr>
						<tr>
							<th>语言</th>
							<td>${book.language}</td>
						</tr>
						<tr>
							<th>价格</th>
							<td>${book.price}</td>
						</tr>
						<tr>
							<th>出版日期</th>
							<td>${book.pubDateStr}</td>
						</tr>
						<tr>
							<th>分类号</th>
							<td>${book.classId}</td>
						</tr>
						<tr>
							<th>数量</th>
							<td>${book.number}</td>
						</tr>
					</tbody>
				</table>
			</div>
		</div>

	</div>

</body>
</html>
