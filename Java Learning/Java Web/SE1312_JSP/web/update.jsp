<%-- 
    Document   : update
    Created on : May 30, 2019, 2:38:35 PM
    Author     : Hoang Dung
--%>

<%@page import="dungth.dtos.RegistrationDTO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Update Profile</h1>
        <%
            RegistrationDTO dto = (RegistrationDTO) request.getAttribute("DTO");
        %>
        <form action="MainController" method="POST">
            Username: <input type="text" name="txtUsername" value="<%= dto.getUsername()%>" readonly/>
            <br/>
            Fullname: <input type="text" name="txtFullname" value="<%= dto.getFullname()%>" />
            <br/>
            Role: <br/>
            <input type="radio" name="rdRole" value="admin" <% if (dto.getRole().equals("admin")) {%>checked<%} %>/> Admin <br/>
            <input type="radio" name="rdRole" value="user" <% if (dto.getRole().equals("user")) {%>checked<%}%>/> User <br/>
            <input type="hidden" name="txtSearch" value="<%= request.getParameter("txtSearch")%>"/>;
            <input type="submit" name="action" value="Update"/>
        </form>
    </body>
</html>
