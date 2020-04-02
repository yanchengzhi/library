<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<!DOCTYPE html>
<html>
<head>
    <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
    <title>图书信息添加</title>
    <link rel="stylesheet" href="${APP_PATH}/static/css/bootstrap.min.css">
    <script src="${APP_PATH}/static/js/jquery-3.2.1.js"></script>
    <script src="${APP_PATH}/static/js/bootstrap.min.js"></script>
    <style>
        .form-group {
            margin-bottom: 0;
        }
    </style>
    <script>
    </script>
</head>
<body background="${APP_PATH}/static/img/sky.jpg" style=" background-repeat:no-repeat ;
background-size:100% 100%;
background-attachment: fixed;">
<div id="header">
  <jsp:include page="admin_header.jsp"></jsp:include>
</div>
<div style="position: relative;padding-top: 60px; width: 80%;margin-left: 10%">
        <div class="form-group">
            <label for="name">图书名</label>
            <input type="text" class="form-control" name="name" id="name" placeholder="请输入书名">
        </div>
        <div class="form-group">
            <label for="author">作者</label>
            <input type="text" class="form-control" name="author" id="author" placeholder="请输入作者名">
        </div>
        <div class="form-group">
            <label for="publish">出版社</label>
            <input type="text" class="form-control" name="publish" id="publish" placeholder="请输入出版社">
        </div>
        <div class="form-group">
            <label for="isbn">ISBN</label>
            <input type="text" class="form-control" name="isbn" id="isbn" placeholder="请输入ISBN">
        </div>
        <div class="form-group">
            <label for="introduction">简介</label>
            <textarea class="form-control" rows="3" name="introduction" id="introduction"
                      placeholder="请输入简介"></textarea>
        </div>
        <div class="form-group">
            <label for="language">语言</label>
            <input type="text" class="form-control" name="language" id="language" placeholder="请输入语言">
        </div>
        <div class="form-group">
            <label for="price">价格</label>
            <input type="text" class="form-control" name="price" id="price" placeholder="请输入价格">
        </div>
        <div class="form-group">
            <label for="pubstr">出版日期</label>
            <input type="date" class="form-control" name="pubDate" id="pubDate" placeholder="请输入出版日期">
        </div>
        <div class="form-group">
            <label for="classId">分类号</label>
            <input type="text" class="form-control" name="classId" id="classId" placeholder="请输入分类号">
        </div>
        <div class="form-group">
            <label for="number">数量</label>
            <input type="text" class="form-control" name="number" id="number" placeholder="请输入图书数量">
        </div>
        <br>
        <button type="button" id="add_btn" class="btn btn-success">提交</button>
        </div>
        <script src="${APP_PATH}/static/layer/layer.js"></script>
        <script>
          $(function(){
            $('#add_btn').click(function(){
            	var name = $('#name').val();
            	var author = $('#author').val();
            	var publish = $('#publish').val();
            	var ISBN = $('#isbn').val();
            	var introduction = $('#introduction').val();
            	var language = $('#language').val();
            	var pubDateStr = $('#pubDate').val();
            	var price = Number($('#price').val());
            	var classId = Number($('#classId').val());
            	var number = Number($('#number').val());
            	if(name==""){
            		layer.msg("书名不能为空！",{time:2000,icon:0,shift:5},function(){
            			
            		});
            		return;
            	}
            	if(author==""){
            		layer.msg("作者不能为空！",{time:2000,icon:0,shift:5},function(){
            			
            		});
            		return;
            	}
            	if(publish==""){
            		layer.msg("出版社不能为空！",{time:2000,icon:0,shift:5},function(){
            			
            		});
            		return;
            	}
            	if(ISBN==""){
            		layer.msg("ISBN不能为空！",{time:2000,icon:0,shift:5},function(){
            			
            		});
            		return;
            	}
            	if(introduction==""){
            		layer.msg("简介不能为空！",{time:2000,icon:0,shift:5},function(){
            			
            		});
            		return;
            	}
            	if(language==""){
            		layer.msg("书籍语言不能为空！",{time:2000,icon:0,shift:5},function(){
            			
            		});
            		return;
            	}
            	if(pubDateStr==""){
            		layer.msg("出版时间不能为空！",{time:2000,icon:0,shift:5},function(){
            			
            		});
            		return;
            	}
            	if(price==""){
            		layer.msg("书籍价格不能为空！",{time:2000,icon:0,shift:5},function(){
            			
            		});
            		return;
            	}
            	if(classId==""){
            		layer.msg("书籍分类号不能为空！",{time:2000,icon:0,shift:5},function(){
            			
            		});
            		return;
            	}
            	if(number==""){
            		layer.msg("书籍数量不能为空！",{time:2000,icon:0,shift:5},function(){
            			
            		});
            		return;
            	}
            	var loadingIndex = null;
            	$.ajax({
            		url:"${APP_PATH}/book/addBookInfo",
            		type:"POST",
            		data:{
                		"name":name,
                		"author":author,
                		"publish":publish,
                		"ISBN":ISBN,
                		"introduction":introduction,
                		"language":language,
                		"pubDateStr":pubDateStr,
                		"price":price,
                		"classId":classId,
                		"number":number
            		},
            		beforeSend:function(){
            			loadingIndex = layer.msg("处理中",{icon:16});
            		},
            		success:function(result){
            			layer.close(loadingIndex);
            			if(result.success){
                    		layer.msg("添加成功！",{time:3000,icon:6,shift:5},function(){
                    			
                    		});
                    		window.location.href="${APP_PATH}/book/adminBook";
            			}else{
                    		layer.msg("添加失败！",{time:3000,icon:5,shift:5},function(){
                    			
                    		});
            			}
            		}
            	});
            });
          });
        </script>
</body>
</html>
