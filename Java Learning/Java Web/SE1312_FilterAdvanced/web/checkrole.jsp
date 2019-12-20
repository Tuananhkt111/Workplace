<%-- 
    Document   : checkrole
    Created on : Jun 20, 2019, 3:04:51 PM
    Author     : tuana
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
    <c:if test="${sessionScope.USER ne 'admin'}">
        <jsp:forward page="/index.jsp"/>
    </c:if>
</body>
</html>
