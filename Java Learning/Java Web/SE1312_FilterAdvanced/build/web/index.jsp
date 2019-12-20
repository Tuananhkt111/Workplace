<%-- 
    Document   : index
    Created on : Jun 20, 2019, 2:27:57 PM
    Author     : tuana
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Login Page</h1>
        <form action="MainController" method="POST">
            Username: <input type="text" name="txtUsername"/><br>
            Password: <input type="password" name="txtPassword"/><br>
            <input type="submit" name="action" value="Login"/><br>
        </form>
    </body>
</html>
