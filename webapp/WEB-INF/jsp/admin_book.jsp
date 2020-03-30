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
			<div class="input-group">
				<input type="text" placeholder="输入关键字" class="form-control"
					id="queryText" name="queryText" class="form-control"> <span
					class="input-group-btn"> 
					<input type="submit" value="搜索" id="search" class="btn btn-default">
				</span>
			</div>

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
						<th style="text-align: center;">书名</th>
						<th style="text-align: center;">作者</th>
						<th style="text-align: center;">出版社</th>
						<th style="text-align: center;">ISBN</th>
						<th style="text-align: center;">价格</th>
						<th style="text-align: center;">剩余数量</th>
						<th style="text-align: center;">详情</th>
						<th style="text-align: center;">编辑</th>
						<th style="text-align: center;">删除</th>
					</tr>
				</thead>
				<tbody style="text-align: center;" id="bookData">
			
				</tbody>
				<!-- 翻页 -->
				<tfoot>
					<tr>
						<td colspan="6" align="right">
							<ul class="pagination">
							</ul>
						</td>
					</tr>
				</tfoot>
			</table>
		</div>
	</div>
	<script type="text/javascript" src="${APP_PATH}/static/layer/layer.js"></script>
	<script type="text/javascript">
	queryPaged(1);//显示第一页
	//模糊查询
	var likeFlag = false;
	$('#search').click(function(){
		var queryText = $('#queryText').val();//获取文本框内容
		if(queryText==""){//为空时关闭模糊查询
			likeFlag = false;
		}else{//有内容时开启模糊查询
			likeFlag = true;
		}
		queryPaged(1);
	});
	//异步分页查询
	function queryPaged(pageNum){
		var loadingIndex = null;
		var jsonData = {
			"page":pageNum,
			"pageSize":5
		};
		if(likeFlag==true){
			jsonData.queryText = $('#queryText').val();
		}
		$.ajax({
			url:"${APP_PATH}/book/queryBooksPaged",
		    type:"POST",
		    data:jsonData,
		    beforeSend:function(){
		    	loadingIndex = layer.msg("处理中",{icon:16});
		    },
		    success:function(result){
		    	layer.close(loadingIndex);//关闭组件
		    	if(result.success){
		    		//局部刷新页面
		    		var tableContext="";
		    		var pageContent="";
		    		//获取后台数据
		    		var bookPage = result.data;
		    	    var books = bookPage.datas;
		    	    //遍历并拼接字符串
		    	    $.each(books,function(i,book){
		    	    	tableContext+='<tr>';
		    	    	tableContext+='<td>'+book.name+'</td>';
		    	    	tableContext+='<td>'+book.author+'</td>';
		    	    	tableContext+='<td>'+book.publish+'</td>';
		    	    	tableContext+='<td>'+book.isbn+'</td>';
		    	    	tableContext+='<td>'+book.price+'</td>';
		    	    	tableContext+='<td>'+book.number+'</td>';
		    	    	tableContext+='<td><a href="${APP_PATH}/book/adminBookDetail?bookId='+book.bookId+'"><button type="button" class="btn btn-success btn-xs">详情</button></a></td>';
						tableContext+='<td><a href="${APP_PATH}/book/adminEditBook?bookId='+book.bookId+'"><button type="button" class="btn btn-primary btn-xs">编辑</button></a></td>';
						tableContext+='<td><a href="#"><button type="button" onclick="deleteBook('+book.bookId+',\''+book.name+'\')" class="btn btn-danger btn-xs">删除</button></a></td>';
						tableContext+='</tr>';
		    	    });
		    	    $('#bookData').html(tableContext);//添加到表主体中
		    	    if(pageNum==1){
		    	    	pageContent += '<li class="disabled"><a href="#">上一页</a></li>';
		    	    }else{
		    	    	pageContent += '<li><a href="#" onclick="queryPaged('+(pageNum-1)+')">上一页</a></li>';
		    	    }
					//显示页码数
					for (var i = 1; i <= bookPage.maxPage; i++) {
						//添加当前页样式  		    
						if (i == pageNum) {
							pageContent += '<li class="active"><a href="#">'+i+'</a></li>';
						} else {
							pageContent += '<li><a href="#" onclick="queryPaged('+i+')">' + i + '</a></li>';
						}
					}
		    	    if(pageNum==bookPage.maxPage){
		    	    	pageContent += '<li class="disabled"><a href="#">下一页</a></li>';
		    	    }else{
		    	    	pageContent += '<li><a href="#" onclick="queryPaged('+(pageNum+1)+')">下一页</a></li>';
		    	    }
		    	    $('.pagination').html(pageContent);
		    	}else{
		    	   layer.msg("查询失败！",{time:3000,icon:5,shift:5},function(){
		    		   
		    	   });
		    	}
		    }
		});
	 }
	//删除书籍
	function deleteBook(bookId,name){
		layer.confirm("删除书籍《"+name+"》，是否继续？",{icon:3,title:"提示"},function(cindex){
			$.ajax({
				url:"${APP_PATH}/book/deleteBook",
				type:"POST",
				data:{
					"bookId":bookId
				},
				success:function(result){
					if(result.success){
						layer.msg("书籍删除成功！",{time:3000,icon:6,shift:5},function(){
							
						});
						window.location.href="${APP_PATH}/book/adminBook";
					}else{
						layer.msg("书籍删除失败！",{time:3000,icon:5,shift:5},function(){
							
						});
					}
				}
			});
			layer.close(cindex);
		},function(cindex){
			layer.close(cindex);
		});
		
	}
	</script>
</body>
</html>
