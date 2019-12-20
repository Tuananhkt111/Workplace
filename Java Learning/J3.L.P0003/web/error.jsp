<%-- 
    Document   : error
    Created on : Nov 13, 2019, 8:30:28 AM
    Author     : tuana
--%>
<%@taglib prefix="s" uri="/struts-tags" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>ERROR PAGE</title>
    </head>
    <body>
        <h1>ERROR PAGE</h1>
        <font color="red">
        <h2>Some error occurs</h2>
        <h2><s:property value="%{msg}"/></h2>
        </font>
    </body>
</html>
