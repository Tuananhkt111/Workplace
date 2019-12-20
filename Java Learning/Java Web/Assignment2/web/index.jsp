<%-- 
    Document   : index
    Created on : Jun 17, 2019, 9:03:05 AM
    Author     : tuana
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Accessories Manager</title>
    </head>
    <body>
        <h1>Accessories Manager</h1>
        <a href="insert.jsp">Add new accessory</a><br>
        <s:form method="POST" action="searchAction">
            <s:textfield name="searchValue" label="Brand"/>
            <s:submit value="Search"/>
        </s:form><br>
        <s:if test="%{searchValue != null}">
            <s:if test="%{list.size() > 0}">
                <table border="1">
                    <thead>
                        <tr>
                            <th>AccessoryID</th>
                            <th>AccessoryName</th>
                            <th>Brand</th>
                            <th>Description</th>
                            <th>Price</th>
                            <th>isDelete</th>
                            <th>Delete</th>
                            <th>Edit</th>
                        </tr>
                    </thead>
                    <tbody>
                        <s:iterator value="list">
                            <tr>
                                <td>
                                    <s:property value="%{id}"/>
                                </td>
                                <td>
                                    <s:property value="%{name}"/>
                                </td>
                                <td>
                                    <s:property value="%{brand}"/>
                                </td>
                                <td>
                                    <s:property value="%{description}"/>
                                </td>
                                <td>
                                    <s:property value="%{price}"/>
                                </td>
                                <td>
                                    <s:property value="%{isDelete}"/>
                                </td>
                                <td>
                                    <s:url action="deleteAction" id="deleteLink">
                                        <s:param name="id" value="%{id}"/>
                                        <s:param name="searchValue" value="%{searchValue}"/>
                                    </s:url>
                                    <s:a href="%{deleteLink}">Delete</s:a>
                                </td>
                                <td>
                                <s:form method="POST" action="editAction">
                                    <s:hidden name="id" value="%{id}"/>
                                    <s:hidden name="searchValue" value="%{searchValue}"/>
                                    <s:submit value="Edit"/>
                                </s:form>
                                </td>
                            </tr>
                        </s:iterator>
                    </tbody>
                </table>
            </s:if>
            <s:else>
                No record found.
            </s:else>
        </s:if>
    </body>
</html>
