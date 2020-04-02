<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>我的借还</title>
    <link rel="stylesheet" href="${APP_PATH}/static/css/bootstrap.min.css">
    <script src="${APP_PATH}/static/js/jquery-3.2.1.js"></script>
    <script src="${APP_PATH}/static/js/bootstrap.min.js" ></script>
    <script type="text/javascript" src="${APP_PATH}/static/layer/layer.js"></script>
</head>
<body background="${APP_PATH}/static/img/lizhi.jpg" style=" background-repeat:no-repeat ;
background-size:100% 100%;
background-attachment: fixed;">
<div id="header">
   <jsp:include page="reader_header.jsp"></jsp:include>
</div>
<div class="panel panel-default" style="width: 90%;margin-left: 5%;margin-top: 5%">
    <div class="panel-heading">
        <h3 class="panel-title">
            我的借还日志
        </h3>
    </div>
    <div class="panel-body">
        <table class="table table-hover">
            <thead>
            <tr>
                <th style="text-align:center">图书号</th>
                <th style="text-align:center">书名</th>
                <th style="text-align:center">借出日期</th>
                <th style="text-align:center">归还日期</th>
                <th style="text-align:center">状态</th>
            </tr>
            </thead>
            <tbody style="text-align:center" id="bookData">

            </tbody>
        </table>
    </div>
</div>
<script type="text/javascript">
//加载数据
querymyLend();
//异步查询
function querymyLend(){
	var loadingIndex = null;
	$.ajax({
		url:"${APP_PATH}/reader/queryLend",
	    type:"POST",
	    data:{
	    	"readerId":"${readerId}"
	    },
	    beforeSend:function(){
	    	loadingIndex = layer.msg("处理中",{icon:16});
	    },
	    success:function(result){
	    	layer.close(loadingIndex);//关闭组件
	    	if(result.success){
	    		//局部刷新页面
	    		var tableContext="";
	    		//获取后台数据
	    	    var datas = result.data;
	    		var size = "${len}";
	    	    //遍历并拼接字符串
	    	    if(size!=0){
	    	    $.each(datas,function(i,data){
	    	    	tableContext+='<tr>';
	    	    	tableContext+='<td>'+data.bookId+'</td>';
	    	    	tableContext+='<td>'+'《'+data.name+'》'+'</td>';
	    	    	tableContext+='<td>'+data.lendDateStr+'</td>';
	    	    	tableContext+='<td>'+data.backDateStr+'</td>';
	    	    	if(data.backDateStr=="未归还"){
	    	    		tableContext+='<td style="color:red">未还</td>';
	    	    	}else{
	    	    		tableContext+='<td>已还</td>';
	    	    	}
					tableContext+='</tr>';
	    	    });
	    	    }else{
	    	    	tableContext+='<tr><td colspan="5" style="font-size:20px;font-weight:bold;">没有任何记录！</td></tr>';
	    	    }
	    	    $('#bookData').html(tableContext);//添加到表主体中
	    	}else{
	    	   layer.msg("查询失败！",{time:3000,icon:5,shift:5},function(){
	    		   
	    	   });
	    	}
	    }
	});
 }
</script>
</body>
</html>