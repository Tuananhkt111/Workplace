$(document).ready(function () {
    $('#form-insert').validate({
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
            txtAddress: {
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
            txtAddress: {
                required: "Address cannot be empty",
                pattern: "Address must be 1-100 characters."
            }
        }
    });
});