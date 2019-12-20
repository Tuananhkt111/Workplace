<%-- 
    Document   : error
    Created on : Jun 27, 2019, 2:53:11 PM
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
        <h1>ERROR PAGE</h1>
        <h2>
            <font color="red">
            <s:property value="%{#request.ERROR}"/>
            </font>
        </h2>
            <a href="./index.jsp">Back to Index Page</a>
    </body>
</html>
