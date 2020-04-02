<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
    <title>借还日志</title>
    <link rel="stylesheet" href="${APP_PATH}/static/css/bootstrap.min.css">
    <script src="${APP_PATH}/static/js/jquery-3.2.1.js"></script>
    <script src="${APP_PATH}/static/js/bootstrap.min.js"></script>
    <script src="${APP_PATH}/static/layer/layer.js"></script>
</head>
<body background="${APP_PATH}/static/img/u5.jpeg" style=" background-repeat:no-repeat ;
background-size:100% 100%;
background-attachment: fixed;">
<div id="header">
   <jsp:include page="admin_header.jsp"></jsp:include>
</div>
<br>
<div style="padding: 70px 550px 10px">
			<div class="input-group">
				<input type="text" placeholder="输入关键字" class="form-control"
					id="queryText" name="queryText" class="form-control"> <span
					class="input-group-btn"> 
					<input type="submit" value="搜索" id="search" class="btn btn-default">
				</span>
			</div>
</div><br><br>
<div class="panel panel-default" style="width: 90%;margin-left: 5%">
    <div class="panel-heading">
        <h3 class="panel-title">
            借还日志
        </h3>
    </div>
    <div class="panel-body">
        <table class="table table-hover">
            <thead>
            <tr>
                <th style="text-align:center;">流水号</th>
                <th style="text-align:center;">图书号</th>
                <th style="text-align:center;">读者证号</th>
                <th style="text-align:center;">借出日期</th>
                <th style="text-align:center;">归还日期</th>
                <th style="text-align:center;">删除</th>
            </tr>
            </thead>
            
            <tbody style="text-align:center;" id="lendData">
            
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
			"pageSize":10
		};
		if(likeFlag==true){
			jsonData.queryText = $('#queryText').val();
		}
		$.ajax({
			url:"${APP_PATH}/lend/queryLendPaged",
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
		    		var lendPage = result.data;
		    	    var lends = lendPage.datas;
		    	    //遍历并拼接字符串
		    	    $.each(lends,function(i,lend){
		    	    	tableContext+='<tr>';
		    	    	tableContext+='<td>'+lend.serNum+'</td>';
		    	    	tableContext+='<td>'+lend.bookId+'</td>';
		    	    	tableContext+='<td>'+lend.readerId+'</td>';
		    	    	tableContext+='<td>'+lend.lendDateStr+'</td>';
		    	    	tableContext+='<td>'+lend.backDateStr+'</td>';
		    	    	if(lend.backDateStr=="未归还"){
		    	    	   tableContext+='<td><a href="#"><button type="button" class="btn btn-danger btn-xs" disabled="disabled">删除</button></a></td>';
		    	    	}else{
		    	    	   tableContext+='<td><a href="#"><button type="button" onclick="deleteLend('+lend.serNum+')" class="btn btn-danger btn-xs">删除</button></a></td>';
		    	    	}
						tableContext+='</tr>';
		    	    });
		    	    $('#lendData').html(tableContext);//添加到表主体中
		    	    if(pageNum==1){
		    	    	pageContent += '<li class="disabled"><a href="#">上一页</a></li>';
		    	    }else{
		    	    	pageContent += '<li><a href="#" onclick="queryPaged('+(pageNum-1)+')">上一页</a></li>';
		    	    }
					//显示页码数
					for (var i = 1; i <= lendPage.maxPage; i++) {
						//添加当前页样式  		    
						if (i == pageNum) {
							pageContent += '<li class="active"><a href="#">'+i+'</a></li>';
						} else {
							pageContent += '<li><a href="#" onclick="queryPaged('+i+')">' + i + '</a></li>';
						}
					}
		    	    if(pageNum==lendPage.maxPage){
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
	
	//删除借还日志
	function deleteLend(serNum){
		layer.confirm("确认删除此条记录？",{icon:3,title:"提示"},function(cindex){
			$.ajax({
				url:"${APP_PATH}/lend/deleteLend",
				type:"POST",
				data:{
					"serNum":serNum
				},
				success:function(result){
					if(result.success){
						layer.msg("删除成功！",{time:3000,icon:6,shift:5},function(){
							
						});
						window.location.href="${APP_PATH}/lend/lendList";
					}else{
						layer.msg("删除失败！",{time:3000,icon:5,shift:5},function(){
							
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