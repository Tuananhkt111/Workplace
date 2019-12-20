<%-- 
    Document   : insert
    Created on : May 28, 2019, 4:47:46 PM
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
        <h1>Register Account</h1>
        <form action="MainController" method="POST">
            Username: <input type="text" name="txtUsername"/>
            <br/>
            Password: <input type="password" name="txtPassword"/>
            <br/>
            Fullname: <input type="text" name="txtFullname"/>
            <br/>
            Role: <select name="cboRole">
                <option>manager</option>
                <option>user</option>
            </select>
            <br/>
            <input type="submit" value="Register" name="action" />
        </form>
    </body>
</html>
