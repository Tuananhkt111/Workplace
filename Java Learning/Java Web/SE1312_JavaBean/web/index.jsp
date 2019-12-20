<%-- 
    Document   : index
    Created on : Jun 6, 2019, 3:05:01 PM
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
        <h1>Login Page</h1>
        <form action="LoginController.jsp" method="POST">
            Username: <input type="text" name="username" value="" />
            <br/>
            Password: <input type="password" name="password" value="" />
            <br/>
            <input type="submit" value="Login" />
        </form>
    </body>
</html>
