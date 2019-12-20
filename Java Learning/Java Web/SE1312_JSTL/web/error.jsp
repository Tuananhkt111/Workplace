<%-- 
    Document   : error
    Created on : Jun 6, 2019, 4:54:45 PM
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
        <h1>ERROR PAGE</h1>
        <font color="red">
        <h2>${requestScope.ERROR}</h2>
        </font>
        <a href="index.jsp">Back to Login page</a>
    </body>
</html>
