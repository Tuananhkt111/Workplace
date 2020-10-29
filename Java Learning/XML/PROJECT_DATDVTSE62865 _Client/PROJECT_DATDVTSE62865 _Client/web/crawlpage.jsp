<%-- 
    Document   : crawlpage
    Created on : 7-Jul-2020, 4:36:59 PM
    Author     : Admin
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="./admin.css" rel="stylesheet" type="text/css">
        <title>Crawl Page</title>
    </head>
    <body>
        <header>
            <img src="./assets/img/logo.png" class="logo-img"/>
            <p class = "p-seperate" > | </p>
            <img src="https://fitin.vn//images/logo-footer.png" class="logo-brand-img"/>
            <p class = "p-seperate" > | </p>
            <img src="https://www.noithatamber.vn/images/thumbs/000/0001470.png" style="height:60px; margin-top: -5px"/>
            <a class="link-header" href="crawlpage.jsp">Crawl</a>
            <a class="link-header" href="InitialCustomerController">Customer</a>
        </header>
        <div class="main-container">
            <h1>Crawl Page</h1><br/>
            <form action="CrawlController" method="POST">
                <label>Choose Website</label>
                <a href="CrawlController?website=fitin">Fitin</a>
                <a href="CrawlController?website=amber">Nội thất Amber</a>

                <br/>
                <c:if test="${requestScope.CATEGORY != null}">
                    <p>Choose category to crawl</p>
                    <c:forEach items="${requestScope.CATEGORY}" var="dto" varStatus="counter">
                        <c:url var="getCategory" value="CrawlController">
                            <c:param name="category" value="${dto.url}"/>
                            <c:param name="website" value="${sessionScope.WEBSITE}"/>
                        </c:url>
                        <a id="website${counter.count}" href="${getCategory}">${dto.name}</a>
                    </c:forEach>
                </c:if>
                <br/>
                <c:if test="${requestScope.MESSAGE != null}">
                    <label>The message:</label>
                    <br/>
                    <p>${requestScope.MESSAGE}</p>
                </c:if>
            </form>
        </div>
    </body>
</html>
.