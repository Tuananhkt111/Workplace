<%-- 
    Document   : index
    Created on : Jun 6, 2019, 4:42:22 PM
    Author     : Hoang Dung
--%>

<%@page import="dungth.dtos.RegistrationErrorObject"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Login Page</h1>
        <form action="MainController" method="POST">
            Username: <input type="text" name="txtUsername" value="${param.txtUsername}" />
            <%
                RegistrationErrorObject errorObj = (RegistrationErrorObject) request.getAttribute("INVALID");
                if (errorObj != null) {
                    if (errorObj.getUsernameError() != null) {
            %>
           <font color = "red">
            <%= errorObj.getUsernameError()%>
            </font>
            <%
            }
            }
            %>
            <br/>
            Password: <input type="password" name="txtPassword" value="${param.txtPassword}"/>
            <font color="red">
            ${requestScope.INVALID.passwordError}
            </font>
            <br/>
            <input type="submit" value="Login" name="action" />
        </form>
            <a href="insert.jsp">Insert</a>
    </body>
</html>
