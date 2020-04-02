<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <title>编辑《 ${book.name}》</title>
    <link rel="stylesheet" href="${APP_PATH}/static/css/bootstrap.min.css">
    <script src="${APP_PATH}/static/js/jquery-3.2.1.js"></script>
    <script src="${APP_PATH}/static/js/bootstrap.min.js" ></script>
</head>
<body background="${APP_PATH}/static/img/book2.jpg" style=" background-repeat:no-repeat ;
background-size:100% 100%;
background-attachment: fixed;">

<div id="header" style="padding-bottom: 80px">
  <jsp:include page="admin_header.jsp"></jsp:include>
</div>
<div class="col-xs-6 col-md-offset-3" style="position: relative;">
    <div class="panel panel-primary">
        <div class="panel-heading">
            <h3 class="panel-title">编辑《 ${book.name}》</h3>
        </div>
        <div class="panel-body">
                <div class="input-group">
                    <span  class="input-group-addon">书名</span>
                    <input type="text" class="form-control" name="name" id="name" value="${book.name}">
                </div>
                <div class="input-group">
                    <span class="input-group-addon">作者</span>
                    <input type="text" class="form-control" name="author" id="author" value="${book.author}" >
                </div>
                <div class="input-group">
                    <span  class="input-group-addon">出版社</span>
                    <input type="text" class="form-control" name="publish" id="publish"  value="${book.publish}" >
                </div>
                <div class="input-group">
                    <span class="input-group-addon">ISBN</span>
                    <input type="text" class="form-control" name="isbn" id="isbn"  value="${book.ISBN}" >
                </div>
                <div class="input-group">
                    <span  class="input-group-addon">简介</span>
                    <textarea class="form-control" style="height:150px" name="introduction" id="introduction">
                    ${book.introduction}
                    </textarea>
                </div>
                <div class="input-group">
                    <span class="input-group-addon">语言</span>
                    <input type="text" class="form-control" name="language" id="language" value="${book.language}" >
                </div>
                <div class="input-group">
                    <span class="input-group-addon">出版日期</span>
                    <input type="date" class="form-control" name="pubDate" id="pubDate" value="<fmt:formatDate value='${book.pubDate}' pattern='yyyy-MM-dd'/>">
                </div>
                <div class="input-group">
                    <span  class="input-group-addon">价格</span>
                    <input type="text" class="form-control" name="price"  id="price" value="${book.price}">
                </div>
                <div class="input-group">
                    <span  class="input-group-addon">分类号</span>
                    <input type="text" class="form-control" name="classId" id="classId" value="${book.classId}">
                </div>
                <div class="input-group">
                    <span  class="input-group-addon">数量</span>
                    <input type="text" class="form-control" name="number"  id="number" value="${book.number}">
                </div>
                <br>
                <input type="submit" value="确定" id="edit_btn" class="btn btn-success btn-sm" class="text-left">
        </div>
    </div>
</div>
<script src="${APP_PATH}/static/layer/layer.js"></script>
    <script>
        $(function(){
            $('#edit_btn').click(function(){
            	var id = "${book.bookId}";
            	var bookId = Number(id);
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
            		url:"${APP_PATH}/book/editBookInfo",
            		type:"POST",
            		data:{
            			"bookId":bookId,
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
                    		layer.msg("修改成功！",{time:3000,icon:6,shift:5},function(){
                    			
                    		});
                    		window.location.href="${APP_PATH}/book/adminBook";
            			}else{
                    		layer.msg("修改失败！",{time:3000,icon:5,shift:5},function(){
                    			
                    		});
            			}
            		}
            	});
            });
          });
    </script>       
</body>
</html>