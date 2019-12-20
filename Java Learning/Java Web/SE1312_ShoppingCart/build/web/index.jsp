<%-- 
    Document   : index
    Created on : May 30, 2019, 4:50:20 PM
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
        <h1>Book Store</h1>
        <form action="MainController" method="POST">
            Please choose your book: <select name="listBook">
                <option value="B001-Java Desktop-100">PRJ311</option>
                <option value="B002-Java Web-200">PRJ321</option>
                <option value="B003-Mobile-300">PRM391</option>
                <option value="B004-XML-400">PRX301</option>
            </select>
            <br/>
            <input type="submit" name="action" value="Add to Cart"/>
        </form>
        <a href="view.jsp">View your cart</a>
    </body>
</html>
