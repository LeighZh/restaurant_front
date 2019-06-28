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

function getUserName(){
    $.ajax({
        url: "/userServlet",
        data:"judge=getSession",
        xhrFields: {withCredentials: true},
        success: function(data){
            console.log(data)
            $('#loginName').text(data);
        }
    });
}

$(function(){
    //提交表单
    $('#submit_btn').click(function(){
        show_loading();
        if($('#loginPwd').val() == ''){
            show_err_msg('密码还没填呢！');
            $('#loginPwd').focus();
        }else if($("#loginPwd").val() != $("#loginPwdTwo").val()){
            show_err_msg('二次密码不一致');
            $('#loginPwdTwo').focus();
        }else {
            //ajax提交表单，#login_form为表单的ID。 如：$('#login_form').ajaxSubmit(function(data) { ... });
            $.ajax({
                url: "/userServlet",
                data:"judge=update&loginName="+$("#loginName").val()+"&loginPwd="+$("#loginPwd").val(),
                success:function(message){
                    localStorage.setItem("loginName", loginName);
                    show_msg('修改成功，  正在为您跳转...','/index.html');
                }
            })
        }
    });
});