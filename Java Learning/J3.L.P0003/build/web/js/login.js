$(function () {
    $('#form-login').validate({
        rules: {
            txtEmail: {
                required: true
            },
            txtPassword: {
                required: true
            }
        },
        messages: {
            txtEmail: {
                required: "Email cannot be empty"
            },
            txtPassword: {
                required: "Password cannot be empty.",
                pattern: "Password must be 8-16 alphanumberic characters, including at least 1 uppercase letter, 1 lowercase letter."
            }
        }
    });
});