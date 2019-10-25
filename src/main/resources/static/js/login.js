function isEmpty(obj) {
    return typeof obj == "undefined" || obj == null || obj.trim() === "";
}

$(document).ready(function () {

    $('#login').click(function () {
        const user_email = $('#login_email').val();
        const user_password = $('#login_password').val();
        if (isEmpty(user_email) || isEmpty(user_password)) {
            alert("用户名和密码不能为空");
        } else {
            $.ajax({
                url: "/do_login",
                type: "post",
                contentType: "application/json",
                dataType: "json",
                data: JSON.stringify({
                    'userEmail': user_email,
                    'userPassword': user_password
                }),
                success:
                    function (data) {
                        console.log(data);
                        if (data.status === "failure") {
                            alert("用户名或密码错误");
                        } else {
                            window.location.href = data.type;
                        }
                    }
            });
        }
    });

    $('#register').click(function () {
        const email = $('#reg_email').val();
        const password = $('#reg_password').val();
        const password_a = $('#reg_password_again').val();
        if (isEmpty(email) || isEmpty(password) || isEmpty(password_a)) {
            alert("邮箱和密码不能为空!");
        } else if (password_a !== password) {
            alert("两次输入的密码不一致!");
        } else {
            $.ajax({
                url: "/do_register",
                type: "post",
                contentType: "application/json",
                dataType: "json",
                data: JSON.stringify({
                    'userEmail': email,
                    'userPassword': password
                }),
                success:
                    function (data) {
                        console.log(data);
                        if(data){
                            alert("注册成功,即将前往登录页面");
                            window.location.href = "/login";
                        }else {
                            alert("注册失败");
                        }
                    }
            });
        }
    });
});