<%-- 
    Document   : insert
    Created on : Jun 13, 2019, 3:29:39 PM
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
        <h1>Register account</h1>
        <form method="POST" action="MainController">
            Username: <input type="text" name="txtUsername" value="${param.txtUsername}">
            <font color="red">
            ${requestScope.INVALID.usernameError}
            </font>
            <br>
            Password: <input type="password" name="txtPassword">
            <font color="red">
            ${requestScope.INVALID.passwordError}
            </font>
            <br>
            Confirm Password: <input type="password" name="txtConfirm">
            <font color="red">
            ${requestScope.INVALID.confirmError}
            </font>
            <br> 
            Fullname: <input type="text" name="txtFullname" value="${param.txtFullname}">
            <font color="red">
            ${requestScope.INVALID.fullnameError}
            </font>
            <br>
            Role: <select name="cbRole">
                <option>admin</option>
                <option>user</option>
            </select>
            <br>
            <input type="submit" name="action" value="Insert">
        </form>
    </body>
</html>
