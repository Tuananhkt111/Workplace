<%-- 
    Document   : LoginController
    Created on : Jun 6, 2019, 3:20:46 PM
    Author     : Hoang Dung
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%
            String username = request.getParameter("Username");
        %>
        <jsp:useBean id ="ProcessBean" class="dungth.models.TestBean" scope="session"/>
        <jsp:setProperty name="ProcessBean" property="username" value="<%= username%>"/>
        <jsp:setProperty name="ProcessBean" property="password" value="${param.password}"/> 
        <jsp:setProperty name="ProcessBean" property="*"/>

        <%
            String role = ProcessBean.checkLogin();
            if (role.equals("admin")) {
                response.sendRedirect("admin.jsp");
            } else if (role.equals("user")) {
                response.sendRedirect("user.jsp");
            } else {
                response.sendRedirect("error.jsp");
            }
        %>
    </body>
</html>
