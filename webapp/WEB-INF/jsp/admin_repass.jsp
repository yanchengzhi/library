<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>更改密码</title>
    <link rel="stylesheet" href="${APP_PATH}/static/css/bootstrap.min.css">
    <script src="${APP_PATH}/static/js/jquery-3.2.1.js"></script>
    <script src="${APP_PATH}/static/js/bootstrap.min.js"></script>
</head>
<body background="${APP_PATH}/static/img/book2.jpg" style=" background-repeat:no-repeat ;
background-size:100% 100%;
background-attachment: fixed;">
<div id="header" style="padding-bottom: 100px">
   <jsp:include page="admin_header.jsp"></jsp:include>
</div>
<div style="position: relative">
    <c:if test="${!empty succ}">
        <div class="alert alert-success alert-dismissable">
            <button type="button" class="close" data-dismiss="alert"
                    aria-hidden="true">
                &times;
            </button>
                ${succ}
        </div>
    </c:if>
    <c:if test="${!empty error}">
        <div class="alert alert-danger alert-dismissable">
            <button type="button" class="close" data-dismiss="alert"
                    aria-hidden="true">
                &times;
            </button>
                ${error}
        </div>
    </c:if>
</div>
<div class="col-xs-6 col-md-offset-3" style="position: relative;">
    <div class="panel panel-primary ">
        <div class="panel-heading">
            <h3 class="panel-title">密码修改</h3>
        </div>
        <div class="panel-body">
                <div>
                    <input type="password" id="oldPasswd" name="oldPasswd" placeholder="输入旧密码" class="form-control"/><br>
                    <input type="password" id="newPasswd" name="newPasswd" placeholder="输入新密码"  class="form-control"/><br>
                    <input type="password" id="reNewPasswd" name="reNewPasswd" placeholder="确认新密码" class="form-control"/>
                    <em id="tip" style="color: red;font-size:15px;font-weight:bold;"></em>
                    <br/>                 
                </div>
                <br>
                <div style="text-align:right">
                <button type="button" value="" id="save_btn" style="text-align:right" class="btn btn-primary">保存</button>
                </div>
        </div>
    </div>
</div>
<script src="${APP_PATH}/static/layer/layer.js"></script>
<script>
    //验证旧密码
    var pass = "${currentUser.password}";
    $('#oldPasswd').mouseout(
       function(){
    	 var oldPasswd = $('#oldPasswd').val();
    	   if(oldPasswd!=""){
    		   if(pass!=oldPasswd){
    	    	   $('#tip').text("原密码输入有误！");
    		   }else{
    			   $('#tip').text("");
    		   }
    	   }
       }		
    );
    
    $('#reNewPasswd').mouseout(
 	       function(){
 	    	 var newPass = $('#newPasswd').val();
 	    	 var reNewPass = $('#reNewPasswd').val();
 	    	   if(newPass!="" && reNewPass!=""){
 	    		   if(newPass!=reNewPass){
 	    	    	   $('#tip').text("两次设置新密码不一致！");
 	    		   }else{
 	    			   $('#tip').text("");
 	    		   }
 	    	   }
 	       }		
 	    );
    
    $('#save_btn').click(function(){
    	var oldPass = $('#oldPasswd').val();
    	var newPass = $('#newPasswd').val();
    	var reNewPass = $('#reNewPasswd').val();
    	if(oldPass==""){
    		layer.msg("请输入原密码！",{time:3000,icon:0,shift:5},function(){
    			
    		});
    		return;
    	}
    	if(newPass==""){
    		layer.msg("请设置新密码！",{time:3000,icon:0,shift:5},function(){
    			
    		});
    		return;
    	}
    	if(reNewPass==""){
    		layer.msg("请确认新密码！",{time:3000,icon:0,shift:5},function(){
    			
    		});
    		return;
    	}
    	
    	if(newPass!=reNewPass){
    		layer.msg("两次密码设置不一致！",{time:3000,icon:0,shift:5},function(){
    			
    		});
    		return;
    	}
    	
    	$.ajax({
    		url:"${APP_PATH}/login/repassDo",
    		type:"POST",
    		data:{
    			"id":"${currentUser.id}",
    			"password":newPass
    		},
    		success:function(result){
    			if(result){
    				layer.msg("新密码设置成功，请重新登录！",{time:10000,icon:6,shift:5},function(){
    					
    				});
    				window.location.href="${APP_PATH}/login/login";
    			}
    			else{
    				layer.msg("新密码设置失败！",{time:3000,icon:5,shift:5},function(){
    					
    				});
    			}
    		}
    	});
    });
</script>
</body>
</html>