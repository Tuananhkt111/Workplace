$(function () {
    $('#form-login').validate({
        rules: {
            txtUserID: {
                required: true
            },
            password: {
                required: true
            },
        },
        messages: {
            txtUserID: {
                required: "Username cannot be epmty.",
                pattern: "Username has max length is 30 characters, includes alphanumeric only."
            },
            txtPassword: {
                required: "Password cannot be empty.",
                pattern: "Password must be 8-16 alphanumberic characters, including at least 1 uppercase letter, 1 lowercase letter."
            },
        }
    });
});