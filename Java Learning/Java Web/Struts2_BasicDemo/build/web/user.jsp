<%-- 
    Document   : admin
    Created on : Jun 27, 2019, 2:54:42 PM
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
        <h1>USER PAGE</h1>
        <h1>Welcome <s:property value="%{#session.USER}"/></h1>
    </body>
</html>