<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>注册</title>


<link rel="stylesheet" href="../css/supersized.css">
<link rel="stylesheet" href="../css/login.css">
<link href="../css/bootstrap.min.css" rel="stylesheet">
<script src="../js/jquery-1.8.2.min.js"></script>
<script type="text/javascript" src="../js/jquery.form.js"></script>
<script type="text/javascript" src="../js/tooltips.js"></script>
</head>

<body>

<div class="page-container">
	<div class="main_box">
		<div class="login_box">
			<div class="login_logo">
				<!-- <img src="../images/logo.png" > -->
				<h1>注册</h1>
			</div>
		
			<div class="login_form">
				<form action="####" id="login_form" method="post">
					<div class="form-group">
						<label for="j_username" class="t">账号：</label> 
						<input id="email" value="" name="email" type="text" class="form-control x319 in" 
						autocomplete="off">
					</div>
					<div class="form-group">
						<label for="j_password" class="t">密码：</label>
						<input id="password" value="" name="password" type="password" 
						class="password form-control x319 in">
					</div>
					<div class="form-group">
						<label for="j_password" class="t">确认密码：</label>
						<input id="passwordTwo" value=""  type="password" 
						class="password form-control x319 in">
					</div>
					<div class="form-group">
						<label for="" class="t">预留号码：</label>
						<input id="number" value="" type="text" class="form-control x319 in">
					</div>
					<div class="form-group space">
						<label class="t"></label>
						<button type="button"  id="submit_btn" 
						class="btn btn-primary btn-lg">&nbsp;注&nbsp;册&nbsp </button>
						<input type="reset" value="&nbsp;重&nbsp;置&nbsp;" class="btn btn-default btn-lg">
					</div>
				</form>
			</div>
		</div>
		<div class="bottom">Copyright &copy; 2018 <a href="#">系统登陆</a></div>
	</div>
</div>

<!-- Javascript -->
<script src="../js/supersized.3.2.7.min.js"></script>
<script src="../js/supersized-init.js"></script>
<script src="../js/scripts.js"></script>

<script type="text/javascript">
	document.onkeydown = function(e){
		if($(".bac").length==0)
		{
			if(!e) e = window.event;
			if((e.keyCode || e.which) == 13){
				var obtnLogin=document.getElementById("submit_btn")
				obtnLogin.focus();
			}
		}
	}
	
	$(function(){
		//提交表单
		$('#submit_btn').click(function(){
			show_loading();
			var reg =/^(13|14|15|18|17)[0-9]{9}$/;
			//var myReg = /^\w+([-+.]\w+)*@\w+([-.]\w+)*\.\w+([-.]\w+)*$/; //邮件正则
			if($('#email').val() == ''){
				show_err_msg('账号还没填呢！');
				$('#email').focus();
			}else if($('#password').val() == ''){
				show_err_msg('密码还没填呢！');
				$('#password').focus();
			}else if($('#number').val() == ''){
				show_err_msg('预留号码还没填呢！');
				$('#number').focus();
			}else if(!$("#number").val().match(reg)){
				show_err_msg('预留号码不合法');
				$('#number').focus();
			}else if($("#password").val() != $("#passwordTwo").val()){
				show_err_msg('二次密码不一致');
				$('#passwordTwo').focus();
			}else {
				//ajax提交表单，#login_form为表单的ID。 如：$('#login_form').ajaxSubmit(function(data) { ... });
				$.ajax({
					url: "/restaurant/userServlet",
					data:"judge=register&name="+$("#email").val()+"&password="+$("#password").val()+"&number="+$("#number").val(),
					success:function(message){
						console.info(message);
						if(message == "true"){
							show_err_msg('该账号已存在，注册失败！');
							$('#email').focus();
						} else{
							$('#number').val('');
							show_msg('注册成功咯！  正在为您跳转...','/restaurant/index.jsp');								
						}
					}
				})
			}
		});
	});
</script>

</body>
</html>