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
            alert("注册成功");
        }
    });
});