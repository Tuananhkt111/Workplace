<%@taglib prefix="s" uri="/struts-tags" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

    <head>
        <meta charset="utf-8" />
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
        <title>Book Store</title>
        <!-- Custom fonts for this template-->
        <link href="css/bootstrap.min.css" rel="stylesheet" type="text/css"/>
        <!-- Custom styles for this template-->
        <style>
            .card-login {
                max-width: 40rem;
            }

            .error {
                color: red;
            }
        </style>
    </head>

    <body class="bg-dark">

        <div class="container">
            <div class="card card-login mx-auto mt-5">
                <div class="card-header">Login Page</div>
                <div class="card-body">
                    <form id="form-login" action="LoginAction" method="POST">
                        <div class="form-group">
                            <p class="error" id="login-result"><s:property value="%{msg}"/></p>
                            <div class="form-label-group">
                                <label for="txtEmail">Email</label>
                                <input type="email" id="txtEmail" name="txtEmail" class="form-control" placeholder="Email" autofocus="autofocus">
                            </div>
                        </div>
                        <div class="form-group">
                            <div class="form-label-group">
                                <label for="txtPassword">Password</label>
                                <input type="password" id="txtPassword" name="txtPassword" class="form-control" placeholder="Password" pattern="(?=.*[A-Z])(?=.*[a-z])[A-Za-z0-9]{8,16}">
                            </div>
                        </div>
                        <button class="btn btn-primary btn-block" type="submit">LogIn</button>
                    </form>
                    <div class="text-center mt-3"><a href="InsertUserPageAction">Not sign up? Sign up now</a></div>
                </div>
            </div>
        </div>

        <!-- Bootstrap core JavaScript-->
        <script src="js/jquery.min.js" type="text/javascript"></script>
        <script src="js/bootstrap.bundle.min.js" type="text/javascript"></script>
        <script src="js/jquery.easing.min.js" type="text/javascript"></script>
        <script src="js/jquery.validate.min.js" type="text/javascript"></script>
        <script src="js/additional-methods.js" type="text/javascript"></script>
        <script src="js/login.js" type="text/javascript"></script>
    </body>
</html>
