<%-- 
    Document   : view
    Created on : Oct 15, 2020, 1:54:58 PM
    Author     : tranh
--%>

<%@ taglib prefix="x" uri="http://java.sun.com/jsp/jstl/xml" %>
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
        <c:set var="DOC" value="${requestScope.DOC}"/>
        <x:parse var="strDOC" doc="${requestScope.STR}"/>
        <c:set var="roleFilter" value="admin"/>
        <x:set var="listUser" select="$doc//account[role=$roleFilter]"/>
        <x:if select="$listUser">
            <table border="1">
                <thead>
                    <tr>
                        <th>No</th>
                        <th>Username</th>
                        <th>Fullname</th>
                        <th>Role</th>
                    </tr>
                </thead>
                <tbody>
                    <x:forEach var="user" select="$listUser" varStatus="counter">
                        <tr>
                            <td>${counter.count}</td>
                            <td><x:out select="$user/username"/></td>
                            <td><x:out select="$user/fullname"/></td>
                            <td><x:out select="$user/role"/></td>
                        </tr>
                    </x:forEach>
                </tbody>
            </table>
        </x:if>
    </body>
</html>
