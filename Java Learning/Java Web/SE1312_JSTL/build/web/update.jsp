<%-- 
    Document   : update
    Created on : Jun 13, 2019, 2:45:58 PM
    Author     : tuana
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Hello World!</h1>
        <form method="POST" action="MainController">
            Username: <input type="text" name="txtUsername" value="${requestScope.DTO.username}" readonly="true">
            <br>
            Fullname: <input type="text" name="txtFullname" value="${requestScope.DTO.fullname}">
            <font color="red">
            ${requestScope.INVALID.fullnameError}
            </font>
            <br>
            Role: <select name="cbRole">
                <option <c:if test="${requestScope.DTO.role eq 'admin'}">selected="true"</c:if>>Admin</option>
                <option <c:if test="${requestScope.DTO.role eq 'user'}">selected="true"</c:if>>User</option>
            </select>
                    <input type="hidden" name="txtSearch" value="${param.txtSearch}">
                    <input type="submit" name="action" value="Update">
        </form>
    </body>
</html>
