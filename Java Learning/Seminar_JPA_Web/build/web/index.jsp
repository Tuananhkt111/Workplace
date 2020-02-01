<%-- 
    Document   : index
    Created on : Jan 11, 2020, 9:55:41 AM
    Author     : NaNoPham
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
        <form action="LoginController" method="POST">
            Username: <input type="text" name="txtUsername"/>
            <br/>
            Password: <input type="password" name="txtPassword"/>
            <br/>
            <input type="submit" value="Login"/>
        </form>
    </body>
</html>
