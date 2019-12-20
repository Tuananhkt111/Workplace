<%-- 
    Document   : view
    Created on : Jun 4, 2019, 4:43:33 PM
    Author     : Hoang Dung
--%>

<%@page import="dungth.dtos.BookDTO"%>
<%@page import="dungth.controllers.ShoppingCart"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%
            ShoppingCart shoppingCart = (ShoppingCart) session.getAttribute("cart");
        %>
        <h1>Hello <%= shoppingCart.getCustomerName()%>!</h1>
        <form action="MainController" method="POST">

            <table border="1">
                <thead>
                    <tr>
                        <th>No</th>
                        <th>Name</th>
                        <th>Price</th>
                        <th>Quantity</th>
                        <th>Sub Price</th>
                        <th>Action</th>
                    </tr>
                </thead>
                <tbody>
                    <%
                        int count = 0;
                        for (BookDTO dto : shoppingCart.getCart().values()) {
                            count++;

                    %>
                    <tr>
                        <td><%= count%></td>
                        <td><%= dto.getName()%></td>
                        <td><%= dto.getPrice()%></td>
                        <td>
                            <input type="hidden" name="txtID" value="<%= dto.getId()%>" />
                            <input type="text" name="txtQuantity" value="<%= dto.getQuantity()%>" />
                        </td>
                        <td><%= dto.getPrice() * dto.getQuantity()%></td>
                        <td>
                            <input type="checkbox" name="chkId" value="<%= dto.getId()%>"/>
                        </td>
                    </tr>
                    <%
                        }
                    %>
                    <tr>
                        <td></td>
                        <td><a href="index.jsp">Continue Shopping</a></td>
                        <td>
                            <input type="submit" name="action" value="Remove"/>
                        </td>
                        <td>
                            <input type="submit" name="action" value="Update"/>
                        </td>
                        <td><%= shoppingCart.getTotal()%></td>
                        <td></td>
                    </tr>
                </tbody>
            </table>
        </form>
    </body>
</html>
