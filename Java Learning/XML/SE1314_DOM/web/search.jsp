<%-- 
    Document   : search
    Created on : Oct 6, 2020, 2:23:08 PM
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
        <h1>Search Page</h1>
        <h3>Welcome, ${sessionScope.FULLNAME}</h3>
        <form action="SearchController" method="POST">
            Address: <input type="text" name="txtAddress"/> <br/>
            <input type="submit" value="Search"/>
        </form>
        <c:if test="${requestScope.INFO != null}">
            <c:if test="${not empty requestScope.INFO}" var="checkList">
                <table border="1">
                    <thead>
                        <tr>
                            <th></th>
                            <th>Name</th>
                            <th>Address</th>
                            <th>Status</th>
                            <th>Delete</th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach var="dto" items="${requestScope.INFO}" varStatus="counter">
                            <tr>
                                <td>${counter.count}</td>
                                <td>${dto.firstname} ${dto.middlename} ${dto.lastname}</td>
                                <td>${dto.address}</td>
                                <td>${dto.status}</td>
                                <td>
                                    <c:url value="DeleteController" var="DeleteLink">
                                        <c:param name="id" value="${dto.id}"/>
                                        <c:param name="txtAddress" value="${param.txtAddress}"/>
                                    </c:url>
                                    <a href="${DeleteLink}">Delete</a>
                                </td>
                            </tr>
                        </c:forEach>
                    </tbody>
                </table>
            </c:if>
            <c:if test="${!checkList}">
                <p>Not found<p>
                </c:if>
            </c:if>
    </body>
</html>
