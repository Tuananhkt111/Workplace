<%-- 
    Document   : index
    Created on : Jul 11, 2019, 3:55:23 PM
    Author     : popemkt
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Add News</h1>
        <s:form action="addNewsAction" method="POST">
            <s:textfield name="id" label="ID"/>
            <s:textfield name="title" label="Title"/>
            <s:textfield name="shortDes" label="Short Description"/>
            <s:textfield name="des" label="Description"/>
            <s:textfield name="author" label="Author"/>
            IsApproved: <select name="isApproved">
                <option value="true">True</option>
                <option value="false">True</option>
            </select>
            <s:submit value="Add"/>
        </s:form>
        <font color="red">
        <s:if test="%{exception.message.indexOf('duplicate') > -1}">
            <s:property value="id"/> is existed
        </s:if>
        <p><s:property value="%{msg}"/></p>
        </font>
    </body>
</html>
