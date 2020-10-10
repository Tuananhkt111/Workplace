<%-- 
    Document   : view
    Created on : Oct 8, 2020, 1:41:46 PM
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
        <h1>View Page</h1>
        <c:if test="${requestScope.INFO != null}">
            <table border="1">
                <thead>
                    <tr>
                        <th></th>
                        <th>ID</th>
                        <th>Name</th>
                        <th>Address</th>
                        <th>City</th>
                        <th>Phone</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach var="dto" items="${requestScope.INFO}" varStatus="counter">
                        <tr>
                            <td>${counter.count}</td>
                            <td>${dto.customerid}</td>
                            <td>${dto.name}</td>
                            <td>${dto.address}</td>
                            <td>${dto.city}</td>
                            <td>${dto.phone}</td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
        </c:if>
    </body>
</html>
