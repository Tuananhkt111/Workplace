<%-- 
    Document   : error
    Created on : Jan 11, 2020, 10:52:36 AM
    Author     : NaNoPham
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
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
            ${requestScope.ERROR}
            </font>
        </h2>
        <a href="index.jsp">Back to Login page</a>
    </body>
</html>
