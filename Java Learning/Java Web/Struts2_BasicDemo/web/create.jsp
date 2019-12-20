<%-- 
    Document   : create
    Created on : Jun 27, 2019, 4:18:48 PM
    Author     : tuana
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Register Account</h1>
        <s:form action="registerAction" method="POST">
            <s:textfield name="username" label="Username"/>
            <s:password name="password" label="Password"/>
            <s:password name="confirm" label="Confirm"/>
            <s:textfield name="emailID" label="Email"/>
            <s:textfield name="phoneNo" label="Phone number: (090-1234567)"/>
            <s:submit value="Register"/>
        </s:form>
        <font color="red">
        <s:if test="%{exception.message.indexOf('duplicate') > -1}">
            <s:property value="username"/> is existed.
        </s:if>
        </font>
    </body>
</html>
