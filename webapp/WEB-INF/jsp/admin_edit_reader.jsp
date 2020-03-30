<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <title>编辑读者信息【${reader.readerId}】</title>
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
            <h3 class="panel-title">编辑读者信息【${reader.readerId}】</h3>
        </div>
        <div class="panel-body">
                <div class="input-group">
                    <span class="input-group-addon">姓名</span>
                    <input type="text" class="form-control" name="name" id="name" value="${reader.name}" >
                </div>
                <div class="input-group">
                    <span  class="input-group-addon">性别</span>
                    <input type="text" class="form-control" name="sex" id="sex"  value="${reader.sex}" >
                </div>
                <div class="input-group">
                    <span class="input-group-addon">生日</span>
                    <input type="date" class="form-control" name="birthStr" id="birthStr" value="<fmt:formatDate value='${reader.birth}' pattern='yyyy-MM-dd'/>" >
                </div>
                <div class="input-group">
                    <span  class="input-group-addon">地址</span>
                    <input type="text" class="form-control" name="address" id="address"  value="${reader.address}" >
                </div>
                <div class="input-group">
                    <span class="input-group-addon">电话</span>
                    <input type="text" class="form-control" name="phone" id="phone" value="${reader.phone}" >
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
        	var id = ${reader.readerId};
        	var readerId = Number(id);
        	var name = $('#name').val();
        	var sex = $('#sex').val();
        	var birthStr = $('#birthStr').val();
        	var address = $('#address').val();
        	var phone = $('#phone').val();
        	if(name==""){
        		layer.msg("姓名不能为空！",{time:2000,icon:0,shift:5},function(){
        			
        		});
        		return;
        	}
        	if(sex==""){
        		layer.msg("性别不能为空！",{time:2000,icon:0,shift:5},function(){
        			
        		});
        		return;
        	}
        	if(birthStr==""){
        		layer.msg("出生日期不能为空！",{time:2000,icon:0,shift:5},function(){
        			
        		});
        		return;
        	}
        	if(address==""){
        		layer.msg("地址不能为空！",{time:2000,icon:0,shift:5},function(){
        			
        		});
        		return;
        	}
        	if(phone==""){
        		layer.msg("联系方式不能为空！",{time:2000,icon:0,shift:5},function(){
        			
        		});
        		return;
        	}
        	var loadingIndex = null;
        	$.ajax({
        		url:"${APP_PATH}/reader/editReaderInfo",
        		type:"POST",
        		data:{
        			"readerId":readerId,
            		"name":name,
            		"sex":sex,
            		"birthStr":birthStr,
            		"address":address,
            		"phone":phone
        		},
        		beforeSend:function(){
        			loadingIndex = layer.msg("处理中",{icon:16});
        		},
        		success:function(result){
        			layer.close(loadingIndex);
        			if(result.success){
                		layer.msg("修改成功！",{time:3000,icon:6,shift:5},function(){
                			
                		});
                		window.location.href="${APP_PATH}/reader/adminReader";
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