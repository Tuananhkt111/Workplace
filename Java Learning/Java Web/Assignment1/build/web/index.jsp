<%-- 
    Document   : index
    Created on : Jun 12, 2019, 7:24:27 PM
    Author     : tuana
--%>

<%@page import="java.util.List"%>
<%@page import="anhht.dto.FoodDTO"%>
<%@page import="anhht.dto.SearchErrorObject"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Food Manager</h1>
        <a href="insert.jsp">Add new food</a> 
        <br>
        <br>
        <form method="POST" action="MainController">
            Min: <input type="number" name="txtMin" value="1000" min="1000" step="any">
            <br>
            <br>
            Max: <input type="number" name="txtMax" value="1000" min="1000" step="any">
            <br>
            
            <%
                SearchErrorObject errorObj = (SearchErrorObject) request.getAttribute("INVALID");
                if (errorObj != null) {
                    if (errorObj.getMinMaxError() != null) {
            %>
            <font color="red">
            <%= errorObj.getMinMaxError()%>
            </font>
            <%
                    }
                }
            %>
            <br>
            <input type="submit" name="action" value="search">
        </form>
        <%
            List<FoodDTO> list = (List<FoodDTO>) request.getAttribute("INFO");
            if (list != null) {
                if (list.size() > 0) {
        %>
        <table border="1">
            <thead>
                <tr>
                    <th>FoodID</th>
                    <th>FoodName</th>
                    <th>Price</th>
                    <th>Description</th>
                    <th>Type</th>
                    <th>Status</th>
                    <th>Delete</th>
                    <th>Edit</th>
                </tr>
            </thead>
            <tbody>
                <%
                    for (FoodDTO dto : list) {
                %>
                <tr>
                    <td><%= dto.getId()%></td>
                    <td><%= dto.getName()%></td>
                    <td><%= dto.getPrice()%></td>
                    <td><%= dto.getDescription()%></td>
                    <td><%= dto.getType()%></td>
                    <td><%= dto.getStatus()%></td>
                    <td><a href="MainController?action=delete&txtId=<%= dto.getId() %>&txtMin=<%= request.getParameter("txtMin") %>&txtMax=<%= request.getParameter("txtMax") %>">Delete</a></td>
                    <td>
                        <form action="MainController" method="POST">
                            <input type="hidden" name="txtId" value="<%= dto.getId() %>">
                            <input type="hidden" name="txtMin" value="<%= request.getParameter("txtMin") %>">
                            <input type="hidden" name="txtMax" value="<%= request.getParameter("txtMax") %>">       
                            <input type="submit" name="action" value="edit">
                        </form>
                    </td>
                </tr>
                <%
                    }
                %>
            </tbody>
        </table>
        <%
        } else {
        %>
        No record found.
        <%
                }
            }
        %>    
    </body>
</html>
