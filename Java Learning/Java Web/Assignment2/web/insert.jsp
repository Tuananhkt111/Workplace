<%-- 
    Document   : insert
    Created on : Jun 17, 2019, 1:09:42 PM
    Author     : tuana
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Insert</title>
    </head>
    <body>
        <h1>Add new accessory</h1>
        <s:form method="POST" action="insertAction">
            <s:textfield name="id" label="ID" pattern="A\d{5}" title="Format of ID: Axxxxx, x is a digit."/>
            <font color="red">
            <s:property value="%{errorObj.idError}"/>
            </font><br>
            <s:textfield name="name" label="Name"/>
            <font color="red">
            <s:property value="%{errorObj.nameError}"/>
            </font><br>
            <s:textfield name="brand" label="Brand"/>
            <font color="red">
            <s:property value="%{errorObj.brandError}"/>
            </font><br>
            <s:textarea name="description" label="Description"/>
            <font color="red">
            <s:property value="%{errorObj.desError}"/>
            </font><br>
            <s:textfield  name="price" type="number" min="1000" step="any" label="Price" value="1000"/>
            <s:radio name="isDelete" label="isDelete" list="#@java.util.LinkedHashMap@{true:'True',false:'False'}" value="true"/>
            <s:submit name="Insert"/>
        </s:form>
    </body>
</html>
