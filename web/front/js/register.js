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
        if($('#loginName').val() == ''){
            show_err_msg('用户名还没填呢！');
            $('#loginName').focus();
        } else if($('#loginPwd').val() == ''){
            show_err_msg('密码还没填呢！');
            $('#loginPwd').focus();
        } else if($('#phone').val() == ''){
            show_err_msg('手机号码还没填呢！');
            $('#phone').focus();
        }
        /*else if(!$("#phone").val().match(reg)){
            show_err_msg('手机号码不合法');
            $('#phone').focus();
        }*/
        else if($('#trueName').val() == ''){
            show_err_msg('请输入真实姓名');
            $('#trueName').focus();
        } else if($('#email').val() == ''){
            show_err_msg('请输入电子邮箱');
            $('#email').focus();
        } else if($('#address').val() == ''){
            show_err_msg('请输入送货地址');
            $('#address').focus();
        }else {
            //ajax提交表单，#login_form为表单的ID。 如：$('#login_form').ajaxSubmit(function(data) { ... });
            $.ajax({
                url: "/userServlet",
                data:"judge=register&loginName="+$("#loginName").val()+"&loginPwd="+$("#loginPwd").val()
                    +"&phone="+ $("#phone").val() + "&trueName=" + $("#trueName").val()+ "&email=" + $("#email").val()
                    + "&address="+ $("#address").val() ,
                success:function(message){
                    console.info(message);
                    if(message == "true"){
                        show_err_msg('该账号已存在，注册失败！');
                        $('#loginName').focus();
                    } else{
                        $('#phone').val('');
                        $('#trueName').val('');
                        $('#email').val('');
                        $('#address').val('');
                        show_msg('注册成功咯！  正在为您跳转...','/index.html');
                    }
                }
            })
        }
    });
});