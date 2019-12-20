<%-- 
    Document   : admin
    Created on : Jun 6, 2019, 3:35:19 PM
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
        <jsp:useBean id="ProcessBean" class="dungth.models.TestBean" scope="session"/>

        <h1>Hello <%= ProcessBean.getUsername()%></h1>
        <h1>Hello ${pageScope.ProcessBean.username}</h1>
        <h1>Hello ${ProcessBean.username}</h1> 
        <h1>Hello ${sessionScope.ProcessBean.username}</h1>

    </body>
</html>
