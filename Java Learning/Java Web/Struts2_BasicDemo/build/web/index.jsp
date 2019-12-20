<%-- 
    Document   : index
    Created on : Jun 27, 2019, 2:27:01 PM
    Author     : tuana
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <s:head/>
    </head>
    <body>
        <h1>Login Page</h1>
        <s:form action="loginAction" method="POST">
            <s:textfield name="username" label="Username"/>
            <s:password name="password" label="Password"/>
            <s:submit value="Login"/>
        </s:form>
        <a href="create.jsp">Register Account</a>
    </body>
</html>
