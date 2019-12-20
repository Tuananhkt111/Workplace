<%-- 
    Document   : error
    Created on : Jun 18, 2019, 8:12:37 AM
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
        <h1>Error Page</h1>
        <s:property value="%{#request.ERROR}"/>
    </body>
</html>
