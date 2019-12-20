<%-- 
    Document   : header
    Created on : Nov 13, 2019, 10:04:53 AM
    Author     : tuana
--%>
<%@taglib prefix="s" uri="/struts-tags" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="utf-8" />
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
        <title>Hotel Booking</title>
        <link href="css/bootstrap.min.css" rel="stylesheet" type="text/css"/>
        <style>
            .error {
                color: red;
                margin: 5px 0;
            }
        </style>
    </head>
    <body onload="<s:if test="%{msg != null}">showMessages()</s:if>">
            <div class="modal fade" id="myModal" role="dialog">
                <div class="modal-dialog modal-dialog-centered">
                    <!-- Modal content-->
                    <div class="modal-content">
                        <div class="modal-header">
                            <h4 class="modal-title ml-2" id="msg-modal"><s:property value="%{msg}"/></h4>
                        <button type="button" id="myBtn" class="close" data-dismiss="modal">x</button>
                    </div>
                    <div class="modal-body">
                        <pre><s:property value="%{#request.MSGDETAILS}"/></pre>
                    </div>
                </div>
            </div>
        </div>
        <nav class="navbar navbar-expand navbar-dark bg-dark static-top">
            <a class="navbar-brand mr-1" href="SearchAction">Hotel Booking</a>
            <!-- Navbar -->
            <ul class="navbar-nav ml-auto ml-auto">
                <li class="nav-item dropdown no-arrow">
                    <s:if test="%{#session.USER != null}">
                        <a class="nav-link dropdown-toggle" href="#" id="userDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                            <i class="fas fa-user-circle fa-fw"></i>
                            Welcome <s:property value="%{#session.NAME}"/>
                        </a>
                        <div class="dropdown-menu dropdown-menu-right" aria-labelledby="userDropdown">
                            <s:if test="%{#session.ROLE == 'user'}">
                                <a class="dropdown-item" href="CartPageAction">Booking Cart</a>
                                <a class="dropdown-item" href="BookingHistoryAction">Booking History</a>
                            </s:if>
                            <s:elseif test="%{#session.ROLE == 'admin'}">
                                <a class="dropdown-item" href="InsertUserPageAction">Insert User</a>
                            </s:elseif>
                            <a class="dropdown-item" href="javascript: void(0)" data-toggle="modal" data-target="#logoutModal">LogOut</a>
                        </div>
                    </s:if>
                    <s:else>
                        <div class="row">
                            <a class="nav-link" href="LoginPageAction">LogIn</a>
                            <a class="nav-link" href="InsertUserPageAction">Register</a>
                        </div>
                    </s:else>
                </li>
            </ul>
        </nav>
        <div class="modal fade" id="logoutModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
            <div class="modal-dialog" role="document">
                <div class="modal-content">
                    <div class="modal-header">
                        <h5 class="modal-title" id="exampleModalLabel">Do you want to sign out?</h5>
                        <button class="close" type="button" data-dismiss="modal" aria-label="Close">
                            <span aria-hidden="true">×</span>
                        </button>
                    </div>
                    <div class="modal-body">Press "LogOut" if you want to cancel this session.</div>
                    <div class="modal-footer">
                        <button class="btn btn-secondary" type="button" data-dismiss="modal">Cancel</button>
                        <s:url var="logoutUrl" value="LogoutAction">
                        </s:url>
                        <a class="btn btn-primary" href="<s:property value="%{logoutUrl}"/>">LogOut</a>
                    </div>
                </div>
            </div>
        </div>