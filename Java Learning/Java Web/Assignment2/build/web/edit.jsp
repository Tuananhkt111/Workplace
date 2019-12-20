<%-- 
    Document   : edit
    Created on : Jun 18, 2019, 10:18:59 AM
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
        <h1>Edit Accessory Info</h1>
        <s:form method="POST" action="updateAction">
            <s:textfield name="id" label="ID" value="%{dto.getId()}" readonly="true"/>
            <s:textfield name="name" label="Name" value="%{dto.getName()}"/>
                <font color="red">
                <s:property value="%{errorObj.nameError}"/>
                </font><br>
            <s:textfield name="brand" label="Brand" value="%{dto.getBrand()}"/>
                <font color="red">
                <s:property value="%{errorObj.brandError}"/>
                </font><br>
            <s:textarea name="description" label="Description" value="%{dto.getDescription()}"/>
                <font color="red">
                <s:property value="%{errorObj.desError}"/>
                </font><br>
            <s:textfield  name="price" type="number" min="1000" step="any" label="Price" value="%{dto.getPrice()}"/>
            <s:radio name="isDelete" label="isDelete" list="#@java.util.LinkedHashMap@{true:'True',false:'False'}" value="%{dto.isIsDelete()}"/>
            <s:textfield name="searchValue" value="%{searchValue}"/>
            <s:submit name="Update"/>
        </s:form>
    </body>
</html>
