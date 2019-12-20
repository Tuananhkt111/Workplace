<%-- 
    Document   : admin
    Created on : Jun 6, 2019, 5:22:02 PM
    Author     : Hoang Dung
--%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>

        <h1>Welcome, ${sessionScope.USER}</h1>
        <form action="MainController" method="POST">
            Fullname: <input type="text" name="txtSearch"/>
            <br>
            <input type="submit" name="action" value="Search"/>
        </form>
        <c:if test="${requestScope.INFO ne null}">
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
                                    <c:url value="MainController" var="DeleteLink">
                                        <c:param name="action" value="Delete"></c:param>
                                        <c:param name="id" value="${dto.username}"></c:param>
                                        <c:param name="txtSearch" value="${param.txtSearch}"></c:param>
                                    </c:url>
                                    <a href="${DeleteLink}">Delete</a>
                                </td>
                                <td>
                                    <form action="MainController" method="POST">
                                        <input type="hidden" name="id" value="${dto.username}">
                                        <input type="hidden" name="txtSearch" value="${param.txtSearch}">
                                        <input type="submit" name="action" value="Edit">
                                    </form>
                                </td>
                            </tr>
                        </c:forEach>                            
                    </tbody>
                </table>
            </c:if>
            <c:if test="${!checkList}">
                No record found.
            </c:if>
        </c:if>
    </body>
</html>
