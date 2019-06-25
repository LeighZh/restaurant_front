﻿<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>登录</title>




<link rel="stylesheet" href="../css/supersized.css">
<link rel="stylesheet" href="../css/login.css">
<link href="../css/bootstrap.min.css" rel="stylesheet">
<script src="../js/jquery-1.8.2.min.js"></script>
<script type="text/javascript" src="../js/jquery.form.js"></script>
<script type="text/javascript" src="../js/tooltips.js"></script>
<script type="text/javascript" src="../js/login.js"></script>
</head>

<body>

<div class="page-container">
	<div class="main_box">
		<div class="login_box">
			<div class="login_logo">
				<img src="../images/logo.png" >
			</div>
		
			<div class="login_form">
				<form action="####" id="login_form" method="post">
					<div class="form-group">
						<label for="j_username" class="t">账   号：</label> 
						<input id="email" value="" name="email" type="text" class="form-control x319 in" 
						autocomplete="off">
					</div>
					<div class="form-group">
						<label for="j_password" class="t">密　码：</label>
						<input id="password" value="" name="password" type="password" 
						class="password form-control x319 in">
					</div>
					<div class="form-group space">
						<label class="t"></label>
						<button type="button"  id="submit_btn" 
						class="btn btn-primary btn-lg">&nbsp;登&nbsp;录&nbsp </button>
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
</body>
</html>