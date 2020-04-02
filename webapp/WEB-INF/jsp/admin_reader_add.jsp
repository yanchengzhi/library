<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
    <title>添加读者</title>
    <link rel="stylesheet" href="${APP_PATH}/static/css/bootstrap.min.css">
    <script src="${APP_PATH}/static/js/jquery-3.2.1.js"></script>
    <script src="${APP_PATH}/static/js/bootstrap.min.js" ></script>
</head>
<body background="${APP_PATH}/static/img/school.jpg" style=" background-repeat:no-repeat ;
background-size:100% 100%;
background-attachment: fixed;">

<div id="header">
    <jsp:include page="admin_header.jsp"></jsp:include>
</div>
<div class="col-xs-6 col-md-offset-3" style="padding-top: 100px;position: relative">
    <div class="panel panel-primary">
        <div class="panel-heading">
            <h3 class="panel-title">添加读者</h3>
        </div>
        <div class="panel-body">
                <div class="input-group" style="padding-top: 20px;">
                    <span  class="input-group-addon">密码</span>
                    <input  type="password" class="form-control" name="password" id="password" ">
                </div>
                <div class="input-group" style="padding-top: 20px;">
                    <span class="input-group-addon">姓名</span>
                    <input type="text" class="form-control" name="name" id="name"  >
                </div>
                <div class="input-group" style="padding-top: 20px;">
                    <span  class="input-group-addon">性别</span>
                    <input type="text" class="form-control" name="sex" id="sex" >
                </div>
                <div class="input-group" style="padding-top: 20px;">
                    <span class="input-group-addon">生日</span>
                    <input type="date" class="form-control" name="birthStr" id="birthStr"  >
                </div>
                <div class="input-group" style="padding-top: 20px;">
                    <span  class="input-group-addon">地址</span>
                    <input type="text" class="form-control" name="address" id="address"  >
                </div>
                <div class="input-group" style="padding-top: 20px;">
                    <span class="input-group-addon">电话</span>
                    <input type="text" class="form-control" name="phone" id="phone"  >
                </div>
                <br>
                <input style="align-items: center" type="submit" id="add_btn" value="添加" class="btn btn-success btn-sm"
                       class="text-left">
        <script src="${APP_PATH}/static/layer/layer.js"></script>
        <script>
          $(function(){
            $('#add_btn').click(function(){
            	var password = $('#password').val();
            	var name = $('#name').val();
            	var sex = $('#sex').val();
            	var birthStr = $('#birthStr').val();
            	var address = $('#address').val();
            	var phone = $('#phone').val();
            	if(password==""){
            		layer.msg("密码不能为空！",{time:2000,icon:0,shift:5},function(){
            			
            		});
            		return;
            	}
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
            		url:"${APP_PATH}/reader/addReaderInfo",
            		type:"POST",
            		data:{
            			"password":password,
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
                    		layer.msg("添加成功！",{time:3000,icon:6,shift:5},function(){
                    			
                    		});
                    		window.location.href="${APP_PATH}/reader/adminReader";
            			}else{
                    		layer.msg("添加失败！",{time:3000,icon:5,shift:5},function(){
                    			
                    		});
            			}
            		}
            	});
            });
          });
        </script>
        </div>
    </div>

</div>

</body>
</html>