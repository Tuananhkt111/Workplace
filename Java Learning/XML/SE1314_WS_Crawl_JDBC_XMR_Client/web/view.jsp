<%-- 
    Document   : view
    Created on : Oct 15, 2020, 1:54:58 PM
    Author     : tranh
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
        <h1>List User</h1>
        <table border="1">
            <thead>
                <tr>
                    <th>Title</th>
                    <th>Description</th>
                    <th>Link</th>
                    <th>PubDate</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach var="dto" items="${requestScope.INFO}">
                    <tr>
                        <td>${dto.title}</td>
                        <td>${dto.description}</td>
                        <td>${dto.link}</td>
                        <td>${dto.pubDate}</td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
    </body>
</html>
