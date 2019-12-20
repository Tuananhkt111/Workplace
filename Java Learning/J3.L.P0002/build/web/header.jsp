<%-- 
    Document   : header
    Created on : Nov 13, 2019, 10:04:53 AM
    Author     : tuana
--%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="utf-8" />
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
        <title>Book Store</title>
        <link href="css/bootstrap.min.css" rel="stylesheet" type="text/css"/>
        <style>
            .error {
                color: red;
                margin: 5px 0;
            }
        </style>
    </head>
    <body onload="<c:if test="${requestScope.MSG ne null}">showMessages()</c:if>">
            <div class="modal fade" id="myModal" role="dialog">
                <div class="modal-dialog modal-dialog-centered">
                    <!-- Modal content-->
                    <div class="modal-content">
                        <div class="modal-header">
                            <h4 class="modal-title ml-2" id="msg-modal">${requestScope.MSG}</h4>
                        <button type="button" id="myBtn" class="close" data-dismiss="modal">x</button>
                    </div>
                    <div class="modal-body">
                        ${requestScope.MSGDETAILS}
                    </div>
                </div>
            </div>
        </div>
        <nav class="navbar navbar-expand navbar-dark bg-dark static-top">
            <a class="navbar-brand mr-1" href="Search">Book Store</a>
            <!-- Navbar -->
            <ul class="navbar-nav ml-auto ml-auto">
                <li class="nav-item dropdown no-arrow">
                    <c:if test="${sessionScope.USER ne null}" var="checkUser">
                        <a class="nav-link dropdown-toggle" href="#" id="userDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                            <i class="fas fa-user-circle fa-fw"></i>
                            Welcome ${sessionScope.NAME}
                        </a>
                        <div class="dropdown-menu dropdown-menu-right" aria-labelledby="userDropdown">
                            <c:if test="${sessionScope.ROLE ne 'admin' && !(sessionScope.ROLE eq '')}">
                                <a class="dropdown-item" href="cart.jsp">Shopping Cart</a>
                                <a class="dropdown-item" href="ShoppingHistory">Shopping History</a>
                            </c:if>
                            <a class="dropdown-item" href="javascript: void(0)" data-toggle="modal" data-target="#logoutModal">LogOut</a>
                        </div>
                    </c:if>
                    <c:if test="${!checkUser}">
                        <a class="nav-link" href="login.jsp">LogIn</a>
                    </c:if>
                </li>
            </ul>
        </nav>