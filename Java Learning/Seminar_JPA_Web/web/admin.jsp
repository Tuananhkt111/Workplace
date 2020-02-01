<%-- 
    Document   : admin
    Created on : Jan 11, 2020, 10:57:47 AM
    Author     : NaNoPham
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
        <h1>Hello ${sessionScope.USER}!</h1>
        <h2>Search User</h2>
        <form action="SearchController" method="POST">
            Fullname: <input type="text" name="txtSearch"/>
            <input type="submit" value="Search"/>
        </form>
        
        <c:if test="${requestScope.INFO != null}">
            <c:if test="${not empty requestScope.INFO}" var="checkList">
                <table border="1">
                    <thead>
                        <tr>
                            <th>No</th>
                            <th>Username</th>
                            <th>Fullname</th>
                            <th>Role</th>
                            <th>Delete</th>
                            <th>Edit</th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach items="${requestScope.INFO}" var="dto" varStatus="counter">
                        <tr>
                            <td>${counter.count}</td>
                            <td>${dto.username}</td>
                            <td>${dto.fullname}</td>
                            <td>${dto.role}</td>
                            <td>
                                <c:url var="deleteLink" value="DeleteController">
                                    <c:param name="id" value="${dto.username}"/>
                                </c:url>
                                <a href="${deleteLink}">Delete</a>
                            </td>
                            <td>
                                <form action="UpdateController" method="POST">
                                    <input type="submit" value="Update"/>
                                </form>
                            </td>
                        </tr>
                        </c:forEach>
                    </tbody>
                </table>

            </c:if>
            <c:if test="${!checkList}">
                No record found!
            </c:if>
        </c:if>
    </body>
</html>
