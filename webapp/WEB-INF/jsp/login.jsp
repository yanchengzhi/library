<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<title>图书馆首页</title>
<link rel="stylesheet" href="${APP_PATH}/static/css/bootstrap.min.css">
<script src="${APP_PATH}/static/js/jquery-3.2.1.js"></script>
<script src="${APP_PATH}/static/js/bootstrap.min.js"></script>
<script src="${APP_PATH}/static/js/js.cookie.js"></script>
<script src="${APP_PATH}/static/layer/layer.js"></script>
<style>
#login {
	height: 50%;
	width: 28%;
	margin-left: auto;
	margin-right: auto;
	margin-top: 5%;
	display: block;
	position: center;
}

.form-group {
	margin-bottom: 0;
}

* {
	padding: 0;
	margin: 0;
}
</style>
</head>
<body background="${APP_PATH}/static/img/timg.jpg"
	style="background-repeat:no-repeat; background-size: 100% 100%; background-attachment: fixed;">
	<c:if test="${!empty error}">
		<script>
			alert("${error}");
			window.location.href = "login.jsp";
		</script>
	</c:if>
	<h2
		style="text-align: center; color: white; font-family: '华文行楷'; font-size: 500%">图
		书 馆</h2>

	<div class="panel panel-default" id="login">
		<div class="panel-heading" style="background-color: #fff">
			<h3 class="panel-title">请登录</h3>
		</div>
		<div class="panel-body">
			<div class="form-group">
				<label for="id">账号</label> 
				<input type="text" class="form-control"
					id="id" name="id" placeholder="请输入账号">
			</div>
			<div class="form-group">
				<label for="passwd">密码</label> 
				<input type="password"
					class="form-control" id="password" name="password" placeholder="请输入密码">
			</div>
			<div class="checkbox text-left">
				<label> <input type="checkbox" id="remember">记住密码
				</label>
			</div>

			<p style="text-align: right; color: red; position: absolute"
				id="info"></p>
			<br />
			<button id="loginButton" class="btn btn-primary  btn-block">登陆
			</button>
		</div>
	</div>
<script type="text/javascript">
    $(function(){
     //提示账号格式信息
	 $('#id').keyup(
	   function(){
		   if(isNaN($('#id').val())){//如果账号是非数字
			   $('#info').text("提示：账号必须为纯数字！");//下面显示提示信息
		   }else{
			   $('#info').text("");
		   }
	   }		 
	 );
	 
	 //记住登录信息
	 function rememberLogin(id,password,checked){
    	 Cookies.set('loginStatus',{
    		 id:id,
    		 password:password,
    		 remember:checked
    	 },{expires:30,path:''})//规定有效期为30s
     }
     
     //如果选择记住登录信息，则登录进去后进行相应设置
     function setLoginStatus(){
    	 var loginStatusText = Cookies.get('loginStatus');
    	 if(loginStatusText){
    		 var loginStatus = null;
    		 try{
    			loginStatus = JSON.parse(loginStatusText);
    			$('#id').val(loginStatus.id);
    			$('#password').val(loginStatus.password);
    			$('#remember').prop('checked',true);
    		 }catch(__){}
    	 }
     }
     
     //设置登录信息
     setLoginStatus();
     //登录验证
     $('#loginButton').click(function(){
    	 var id = $('#id').val();
    	 var password = $('#password').val();
    	 var remember = $('#remember').prop('checked');
    	 //先进行非空校验
    	 if(id==""){
    		 layer.msg("用户名不能为空！",{time:2000,icon:0,shift:5},function(){
    			 
    		 });
    		 return;
    	 }
    	 if(password==""){
    		 layer.msg("密码不能为空！",{time:2000,icon:0,shift:5},function(){
    			 
    		 });
    		 return;
    	 }
    	 if(isNaN(id)){
    		 layer.msg("账号必须为纯数字！",{time:2000,icon:0,shift:5},function(){
    			 
    		 });
    		 return; 
    	 }
    	 //然后进行账号验证
    	 var loadingIndex = null;
    	 $.ajax({
    		 url:"${APP_PATH}/login/loginCheck",
    		 type:"POST",
    		 data:{
    			 "id":id,
    			 "password":password
    		 },
    		 beforeSend:function(){
    			loadingIndex = layer.msg("处理中",{icon:16});
    		 },
    		 success:function(data){
    			 layer.close(loadingIndex);
    			 if(data.stateCode.trim()=="1"){
    				 window.location.href="${APP_PATH}/login/index";
    			 }else if(data.stateCode.trim()=="2"){
    				 window.location.href="${APP_PATH}/login/readermain";
    			 }else{
    	    		 layer.msg("用户名或密码错误！",{time:3000,icon:5,shift:3},function(){
    	    			 
    	    		 });

    			 }
    		 }
    	 });
    	 
     });
    });
</script>
</body>
</html>




