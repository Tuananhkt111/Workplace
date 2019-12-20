<%-- 
    Document   : edit
    Created on : Jun 13, 2019, 12:38:27 AM
    Author     : tuana
--%>

<%@page import="anhht.dto.FoodDTO"%>
<%@page import="anhht.dto.InsertErrorObject"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Edit Food Info</h1>
        <form method="POST" action="MainController">
            <% 
                FoodDTO dto = (FoodDTO) request.getAttribute("DTO");
            %>
            Name: 
            <br><input type="text" name="txtName" value="<%= dto.getName() %>">
            <%
                InsertErrorObject errorObj = (InsertErrorObject) request.getAttribute("INVALID");
                if (errorObj != null) {
                    if (errorObj.getNameError() != null) {
            %>
            <font color="red">
            <%= errorObj.getNameError()%>
            </font>
            <%
                    }
                }
            %>
            <br>
            Price:<br> <input type="number" name="txtPrice" min="1000" step="any" value="<%= dto.getPrice()%>" required>
            <br>           
            Description: <br><input type="text" name="txtDes" value="<%= dto.getDescription()%>">
            <%
                if (errorObj != null) {
                    if (errorObj.getDescriptionError() != null) {
            %>
            <font color="red">
            <%= errorObj.getDescriptionError()%>
            </font>
            <%
                    }
                }
            %>
            <br>           
            Type:<br> <input type="text" name="txtType" value="<%= dto.getType()%>">   
            <%
                if (errorObj != null) {
                    if (errorObj.getTypeError() != null) {
            %>
            <font color="red">
            <%= errorObj.getTypeError()%>
            </font>
            <%
                    }
                }
            %>
            <br>
            Status: <br><input type="radio" name="txtStatus" value="Available" checked>Available
            <br><input type="radio" name="txtStatus" value="Unavailable">Unavailable
            <%
                if (errorObj != null) {
                    if (errorObj.getStatusError() != null) {
            %>
            <font color="red">
            <%= errorObj.getStatusError()%>
            </font>
            <%
                    }
                }
            %>
            <br>
            <input type="hidden" name="txtId" value="<%= request.getParameter("txtId") %>">
            <input type="hidden" name="txtMin" value="<%= request.getParameter("txtMin") %>">
            <input type="hidden" name="txtMax" value="<%= request.getParameter("txtMax") %>">
            <input type="submit" name="action" value="update">
        </form>
    </body>
</html>
