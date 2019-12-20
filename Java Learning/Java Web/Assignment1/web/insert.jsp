<%-- 
    Document   : insert
    Created on : Jun 12, 2019, 10:59:54 PM
    Author     : tuana
--%>

<%@page import="anhht.dto.InsertErrorObject"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Insert new food</h1>
        <form method="POST" action="MainController">
            ID: <br>
            <input type="text" name="txtID" pattern="F\d{5}" title="Format of ID: Fxxxxx">
            <%
                InsertErrorObject errorObj = (InsertErrorObject) request.getAttribute("INVALID");
                if (errorObj != null) {
                    if (errorObj.getIdError() != null) {
            %>
            <font color="red">
            <%= errorObj.getIdError()%>
            </font>
            <%
                    }
                }
            %>
            <br>
            Name: 
            <br><input type="text" name="txtName">
            <%
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
            Price:<br> <input type="number" name="txtPrice" value="1000" min="1000" step="any" required>
            <br>           
            Description: <br><input type="text" name="txtDes">
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
            Type:<br> <input type="text" name="txtType">   
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
            <input type="submit" name="action" value="insert">
        </form>
    </body>
</html>
