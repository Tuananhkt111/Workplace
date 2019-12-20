$(document).ready(function () {
    $('#form-register').validate({
        rules: {
            txtUserID: {
                required: true
            },
            txtUsername: {
                required: true
            },
            txtPassword: {
                required: true
            },
            txtRepPass: {
                required: true,
                equalTo: "#txtPassword"
            },
            txtEmail: {
                required: true
            },
            txtPhone: {
                required: true
            },
            txtRole: {
                required: true
            }
        },
        messages: {
            txtUserID: {
                required: "Username cannot be epmty.",
                pattern: "Username has max length is 30 characters, includes alphanumeric only."
            },
            txtUsername: {
                required: "Username cannot be empty.",
                pattern: "Username must be 1-40 characters."
            },
            txtPassword: {
                required: "Password cannot be empty.",
                pattern: "Password must be 8-16 alphanumberic characters, including at least 1 uppercase letter, 1 lowercase letter."
            },
            txtRepPass: {
                required: "Password cannot be empty.",
                pattern: "Password must be 8-16 alphanumberic characters, including at least 1 uppercase letter, 1 lowercase letter.",
                equalTo: "Repeat password doesn't match."
            },
            txtEmail: {
                required: "Email cannot be empty"
            },
            txtPhone: {
                required: "Phone cannot be empty",
                pattern: "Phone must be 10-16 numberic characters."
            },
            txtPhoto: {
                required: "Photo cannot be empty",
                accept: "Please input valid image extension .pjp, .jpg, .pjpeg, .jpeg, .jfif or .png"
            },
            txtRole: {
                required: "Role cannot be empty",
                pattern: "Role must be 1-40 characters."
            }
        }
    });
});