<%-- 
    Document   : search
    Created on : Oct 15, 2020, 1:09:56 PM
    Author     : tranh
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="x" uri="http://java.sun.com/jsp/jstl/xml" %>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <x:set var="currentAcc" select="$doc//*[@username=$username]"/>
        <font color="green">
        <h1>Welcome, <x:out select="$currentAcc/fullname"/></h1>
        </font>
        <br/>
        Your balance is: <x:out select="$currentAcc/@balance"/>
        <h2>Transaction List</h2>
        <form action="search.jsp">
            From Date: <input type="text" name="txtFromDate" value="${param.txtFromDate}" /> (yyyy/mm/dd)
            <br/>
            To Date: <input type="text" name="txtToDate" value="${param.txtToDate}" /> (yyyy/mm/dd)
            <br/>
            <input type="submit" value="List" />
        </form>
        <c:set var="fromDate" value="${param.txtFromDate}"/>
        <c:set var="toDate" value="${param.txtToDate}"/>
        <c:set var="fromDate" value="${fn:replace(fromDate,'/','')}"/>
        <c:set var="toDate" value="${fn:replace(toDate,'/','')}"/>
        <x:set var="transaction" 
               select="$currentAcc//transaction[translate(date,'/','') >= $fromDate 
               and translate(date,'/','') <= $toDate]"/>
        <x:if select="$transaction">
            <table border="1">
                <thead>
                    <tr>
                        <th>No</th>
                        <th>Date</th>
                        <th>Amount</th>
                        <th>Type</th>
                    </tr>
                </thead>
                <tbody>
                    <tr>
                        <x:forEach var="trans" select="$transaction" varStatus="counter">
                            <td>${counter.count}</td>
                            <td><x:out select="$trans/date"/></td>
                            <td><x:out select="$trans/amount"/></td>
                            <td>
                                <x:choose>
                                    <x:when select="$trans[type=0]">Withdrawn</x:when>
                                    <x:when select="$trans[type=1]">Deposit</x:when>
                                    <x:when select="$trans[type=2]">Transfer</x:when>
                                    <x:otherwise>Đ biết</x:otherwise>
                                </x:choose>
                            </td>
                        </tr>
                    </x:forEach>
                </tbody>
            </table>

        </x:if>
    </body>
</html>
