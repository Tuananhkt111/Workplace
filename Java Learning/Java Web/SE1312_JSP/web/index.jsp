<%-- 
    Document   : index
    Created on : May 23, 2019, 3:19:41 PM
    Author     : Hoang Dung
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Login Page!</h1>
        <form action="MainController" method="POST">
            Username: <input type="text" name="txtUsername" value="" /> <br/>
            Password: <input type="password" name="txtPassword" value="" /> <br/>
            <input type="submit" value="Login" name="action" />
        </form>
        <a href="insert.jsp">Register Account</a>
    </body>
</html>
