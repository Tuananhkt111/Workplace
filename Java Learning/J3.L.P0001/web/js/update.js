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
            },
            txtRole: {
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
            },
            txtRole: {
                required: "Role cannot be empty",
                pattern: "Role must be 1-40 characters."
            }
        }
    });
});