// JavaScript Document
//支持Enter键登录
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

		$(function () {
			$('#register_btn').click(function () {
				show_msg('注册', '/register.html');
            })
        })

    	$(function(){
			//提交表单
			$('#submit_btn').click(function(){
				show_loading();
				//var myReg = /^\w+([-+.]\w+)*@\w+([-.]\w+)*\.\w+([-.]\w+)*$/; //邮件正则
				if($('#loginName').val() == ''){
					show_err_msg('账号还没填呢！');
					$('#loginName').focus();
				}else if($('#loginPwd').val() == ''){
					show_err_msg('密码还没填呢！');
					$('#loginPwd').focus();
				}else{
					//ajax提交表单，#login_form为表单的ID。 如：$('#login_form').ajaxSubmit(function(data) { ... });
					$.ajax({
						url: "/userServlet",
						data:"judge=login&loginName="+$("#loginName").val()+"&loginPwd="+$("#loginPwd").val(),
						success:function(message){
							console.info(message);
							if(message == "true"){
								show_msg('登录成功咯！  正在为您跳转...','/index.html');
							}else{
								show_err_msg('账号或密码错误！');
								$('#loginName').focus();
							}
						}
					})
				}
			});
		});