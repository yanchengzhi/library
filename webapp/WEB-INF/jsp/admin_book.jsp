<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<title>全部图书信息</title>
<link rel="stylesheet" href="${APP_PATH}/static/css/bootstrap.min.css">
<script src="${APP_PATH}/static/js/jquery-3.2.1.js"></script>
<script src="${APP_PATH}/static/js/bootstrap.min.js"></script>
</head>
<body background="${APP_PATH}/static/img/book1.jpg"
	style="background-repeat: no-repeat; background-size: 100% 100%; background-attachment: fixed;">

	<div id="header">
	   <jsp:include page="admin_header.jsp"></jsp:include>
	</div>
	<div style="padding: 70px 550px 10px">
		<form method="post" action="querybook.html" class="form-inline"
			id="searchform">
			<div class="input-group">
				<input type="text" placeholder="输入图书名" class="form-control"
					id="search" name="searchWord" class="form-control"> <span
					class="input-group-btn"> <input type="submit" value="搜索"
					class="btn btn-default">
				</span>
			</div>
		</form>

	</div>
	<div style="position: relative; top: 10%">
		<c:if test="${!empty succ}">
			<div class="alert alert-success alert-dismissable">
				<button type="button" class="close" data-dismiss="alert"
					aria-hidden="true">&times;</button>
				${succ}
			</div>
		</c:if>
		<c:if test="${!empty error}">
			<div class="alert alert-danger alert-dismissable">
				<button type="button" class="close" data-dismiss="alert"
					aria-hidden="true">&times;</button>
				${error}
			</div>
		</c:if>
	</div>
	<div class="panel panel-default" style="width: 90%; margin-left: 5%">
		<div class="panel-heading" style="background-color: #fff">
			<h3 class="panel-title">全部图书</h3>
		</div>
		<div class="panel-body">
			<table class="table table-hover">
				<thead>
					<tr>
						<th style="text-align:center;">书名</th>
						<th style="text-align:center;">作者</th>
						<th style="text-align:center;">出版社</th>
						<th style="text-align:center;">ISBN</th>
						<th style="text-align:center;">价格</th>
						<th style="text-align:center;">剩余数量</th>
						<th style="text-align:center;">详情</th>
						<th style="text-align:center;">编辑</th>
						<th style="text-align:center;">删除</th>
					</tr>
				</thead>
				<tbody style="text-align:center;">
				   <c:forEach items="${books}" var="book">
				      <tr>
				         <td>${book.name}</td>
				         <td>${book.author}</td>
				         <td>${book.publish}</td>
				         <td>${book.ISBN}</td>
				         <td>${book.price}</td>
				         <td>${book.number}</td>
				         <td>
				         
				         </td>
				         <td>
				           <a href="#">
				           <button type="button" class="btn btn-primary btn-xs">编辑</button>
				           </a>
				         </td>
				         <td>
				           <a href="#">
				           <button type="button" class="btn btn-danger btn-xs">删除</button>
				           </a>
				         </td>
				      </tr>
				   </c:forEach>
				</tbody>
			</table>
		</div>
	</div>
</body>
</html>
