<%-- 
    Document   : admin
    Created on : Jun 27, 2019, 2:54:42 PM
    Author     : tuana
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>ADMIN PAGE</h1>
        <h1>Welcome <s:property value="%{#session.USER}"/></h1>
        <h2>Search</h2>
        <s:form action="searchAction" method="POST">
            <s:textfield name="searchValue" label="Fullname"/>
            <s:submit value="Search"/>
        </s:form>
        <s:if test="%{list != null}">
            <table border="1">
                <thead>
                    <tr>
                        <th>No.</th>
                        <th>Username</th>
                        <th>Fullname</th>
                        <th>Role</th>
                        <th>Delete Link</th>
                        <th>Delete Button</th>
                    </tr>
                </thead>
                <tbody>
                    <s:iterator value="list" status="counter">
                        <tr>
                            <td><s:property value="%{counter.count}"/></td>
                            <td><s:property value="%{username}"/></td>
                            <td><s:property value="%{fullname}"/></td>
                            <td><s:property value="%{role}"/></td>
                            <td>
                                <s:url action="deleteAction" id="deleteLink">
                                    <s:param name="lastSearchValue" value="searchValue"/>
                                    <s:param name="id" value="username"/>
                                </s:url>
                                <s:a href="%{deleteLink}">Delete</s:a>
                                </td>
                                <td>
                                <s:form action="deleteAction" method="POST">
                                    <s:hidden name="id" value="%{username}"/>
                                    <s:hidden name="lastSearchValue" value="%{searchValue}"/>
                                    <s:submit value="Delete"/>
                                </s:form>
                            </td>
                        </tr>
                    </s:iterator>
                </tbody>
            </table>

        </s:if>
    </body>
</html>
