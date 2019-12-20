function checkUsernameExisted() {
    $.ajax({
        type: "POST",
        url: "/Principal/CheckUsername",
        dataType: 'json',
        contentType: 'application/json; charset=utf-8',
        data: JSON.stringify($('#Username').val()),
        success: function (isExisted) {
            if (isExisted === true) {
                $('#Username-exist').html("Username existed.");
            } else {
                $('#Username-exist').html("");
            }
        },
        error: function () {
            alert("Principal/CheckUsername error.");
        }
    });
}
function checkLogin() {
    var s = {
        Username: $('#txtUsernameLg').val(), Password: $('#txtPasswordLg').val()
    }
    $.ajax({
        type: "POST",
        url: "/Principal/LogIn",
        dataType: 'json',
        contentType: 'application/json; charset=utf-8',
        data: JSON.stringify(s),
        success: function (role) {
            if (role === "failed") {
                $('#login-result').html("Username or password incorrect.");
            } else if (role === "admin" || role === "user") {
                $('#login-result').html("");
                location.href = "/Home";
            } else {
                $('#login-result').html("Your role is not supported.");
            }
        },
        error: function () {
            alert("Principal/Login error.");
        }
    });
}
$(function () {
    $('#form-login').validate({
        rules: {
            txtUsernameLg: {
                required: true
            },
            txtPasswordLg: {
                required: true
            }
        },
        messages: {
            txtUsernameLg: {
                required: "Username cannot be epmty.",
                pattern: "Username has max length is 30 characters, includes alphanumeric only."
            },
            txtPasswordLg: {
                required: "Password cannot be empty.",
                pattern: "Password must be 8 - 16 alphanumberic characters, including at least 1 uppercase letter, 1 lowercase letter."
            }
        },
        submitHandler: function () {
            checkLogin();
        }
    });

    $('#form-register').validate({
        rules: {
            Username: {
                required: true
            },
            Password: {
                required: true
            },
            txtRepPasswordRg: {
                required: true,
                equalTo: "#Password"
            },
            Fullname: {
                required: true
            },
            Phone: {
                required: true
            },
            Address: {
                required: true
            }
        },
        messages: {
            Username: {
                required: "Username cannot be epmty.",
                pattern: "Username has max length is 30 characters, includes alphanumeric only."
            },
            Password: {
                required: "Password cannot be empty.",
                pattern: "Password must be 8-16 alphanumberic characters, including at least 1 uppercase letter, 1 lowercase letter."
            },
            txtRepPasswordRg: {
                required: "Password cannot be empty.",
                pattern: "Password must be 8-16 alphanumberic characters, including at least 1 uppercase letter, 1 lowercase letter.",
                equalTo: "Repeat password doesn't match."
            },
            Fullname: {
                required: "Fullname cannot be empty.",
                pattern: "Fullname must be 1-40 characters."
            },
            Phone: {
                required: "Phone cannot be empty.",
                pattern: "Phone must be 10-16 numberic characters."
            },
            Address: {
                required: "Address cannot be empty.",
                pattern: "Address must be 1-70 characters."
            }
        }
    });
});




