$(document).ready(function () {
    $('#form-updt').validate({
        rules: {
            txtUsername: {
                required: true
            },
            txtEmail: {
                required: true
            },
            txtPhone: {
                required: true
            }
        },
        messages: {
            txtUsername: {
                required: "Username cannot be empty.",
                pattern: "Username must be 1-40 characters."
            },
            txtEmail: {
                required: "Email cannot be empty"
            },
            txtPhone: {
                required: "Phone cannot be empty",
                pattern: "Phone must be 10-16 numberic characters."
            },
            txtPhoto: {
                accept: "Please input valid image extension .pjp, .jpg, .pjpeg, .jpeg, .jfif or .png"
            }
        }
    });
    $('#form-change-pwd').validate({
        rules: {
            txtPassOld: {
                required: true
            },
            txtPassNew: {
                required: true
            },
            txtRepPass: {
                required: true,
                equalTo: "#txtPassNew"
            },
        },
        messages: {
            txtPassOld: {
                required: "Password cannot be empty.",
                pattern: "Password must be 8-16 alphanumberic characters, including at least 1 uppercase letter, 1 lowercase letter."
            },
            txtPassNew: {
                required: "Password cannot be empty.",
                pattern: "Password must be 8-16 alphanumberic characters, including at least 1 uppercase letter, 1 lowercase letter."
            },
            txtRepPass: {
                required: "Password cannot be empty.",
                pattern: "Password must be 8-16 alphanumberic characters, including at least 1 uppercase letter, 1 lowercase letter.",
                equalTo: "Repeat password doesn't match."
            }
        }
    });
});