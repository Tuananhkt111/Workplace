<%-- 
    Document   : customer
    Created on : 12-Jul-2020, 8:01:31 AM
    Author     : Admin
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/xml" prefix="x" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="./customer_3.css" rel="stylesheet" type="text/css">
        <title>Living Room Choice</title>
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
        <form action="RecommendController" method="GET" class="form-input">
            <div class="input-field">
                <div class="input-label">
                    <label>Vui lòng chọn kích thước</label><br/>
                    <input type="text" name="width" placeholder="Chiều dài" value="${sessionScope.WIDTH}"/><label> cm &nbsp;&nbsp;&nbsp;  X</label>
                </div>

                <div class="input-label label-2">
                    <label> </label><br/>
                    <input type="text" name="depth" placeholder="Chiều rộng" value="${sessionScope.DEPTH}"/><label> cm</label>
                </div>
                <div class="input-label">
                    <label>Vui lòng nhập số tiền cần mua</label><br/>
                    <input type="text" class="input-price" name="price" placeholder=""value="${sessionScope.PRICE}"/><label> vnd</label>
                </div>
                <br/>
            </div>
            <br/>
            <div class="input-color">
                <label>Chọn màu sắc mà bạn yêu thích</label><br/>
                <div class="checkbox-container">
                    <br/>
                    <c:import var="xml" url ="WEB-INF/colorchoose.xml"/>
                    <x:parse var="doc" doc="${xml}" scope="session"/>
                    <x:forEach var="item" select="$doc//color" varStatus="counter">
                        <label class="checkbox-label">
                            <c:choose>
                                <c:when test="${sessionScope.COLORPICK != ''}">
                                    <c:set var="isChecked" value="false"/>
                                    <c:forEach items="${sessionScope.COLORPICK}" var="subitem" varStatus="counter2">
                                        <x:if select="$item[id=$subitem]">
                                            <c:set var="isChecked" value="true"/>
                                        </x:if>
                                    </c:forEach>
                                    <c:choose>
                                        <c:when test="${isChecked==true}">
                                            <input type="checkbox" name="colorPicker" value="<x:out select="$item/id"/>" checked>
                                        </c:when>
                                        <c:otherwise>
                                            <input type="checkbox" name="colorPicker" value="<x:out select="$item/id"/>">
                                        </c:otherwise>
                                    </c:choose>  
                                </c:when>
                                <c:otherwise>
                                    <input type="checkbox" name="colorPicker" value="<x:out select="$item/id"/>">
                                </c:otherwise>
                            </c:choose>
                            <span class="checkbox-custom circular" style="border-color: rgb(<x:out select="$item/r"/>,<x:out select="$item/g"/>,<x:out select="$item/b"/>)"></span>   
                        </label>
                    </x:forEach>

                </div>
            </div>
            <div class="buttons">
                <button class="btn" type="submit">Đề xuất</button>
            </div>
            <p class="message">${sessionScope.CUSMESSAGE}</p>
        </form>
        <div class="seperator"></div>
        <div class="product-contain">
            <c:if test="${sessionScope.RESULTLIST !=''}">
                <label class="title-recommend">Đề xuất dành cho bạn</label>
                <label class="sub-title-recommend">Tổng giá trị sản phẩm: ${sessionScope.TOTALPRICE} đ | Diện tích: ${sessionScope.TOTALAREA/10000} (m<sup>2</sup>)
                    <c:if test="${sessionScope.WIDTH !=''}"> / ${sessionScope.WIDTH*sessionScope.DEPTH/10000} (m<sup>2</sup>)</c:if>  </label>
                </c:if>
            <div>
                <div class="product-list">
                    <c:if test="${sessionScope.RESULTLIST == null}">
                        <p class="not-found-message">Không tìm thấy</p>
                    </c:if>
                    <c:forEach items="${sessionScope.RESULTLIST}" var="dto" varStatus="counter">
                        <c:if test="${dto.images !=[]}">


                            <div class="product-card">
                                <div class="badge">${dto.category.name}</div>
                                <div class="product-tumb">

                                    <img src="${dto.images[dto.position].url}" alt=""/>
                                </div>
                                <div class="product-details">
                                    <span class="product-catagory">${dto.category.name}</span> 
                                    <div class="color-card" style="background-color: rgb(${dto.images[dto.position].color.r},${dto.images[dto.position].color.g},${dto.images[dto.position].color.b})">
                                    </div>
                                    <h4><a target="_blank" rel="noopener noreferrer" href="${dto.images[dto.position].product.url}">${dto.images[dto.position].product.name}</a></h4>
                                    <p>Kích thước: ${dto.images[dto.position].product.width} x ${dto.images[dto.position].product.depth} x ${dto.images[dto.position].product.height} (cm)</p>
                                    <c:if test="${dto.images[dto.position].product.brand!=null}">
                                        <p>Thương hiệu: ${dto.images[dto.position].product.brand.name}</p>
                                    </c:if>
                                    <c:if test="${dto.images[dto.position].product.material!=null}">
                                        <p>Vật liệu: ${dto.images[dto.position].product.material}</p>
                                    </c:if>
                                    <div class="product-bottom-details">
                                        <div class="product-price">${dto.images[dto.position].product.price} đ</div>
                                        <c:url var="changeProduct" value="ChangeRecommendController">
                                            <c:param name="categoryChange" value="${dto.category.id}"/>
                                        </c:url>
                                        <a class="a-change" href="${changeProduct}">Thay đổi</a>
                                    </div>
                                </div>
                            </div>
                        </c:if>
                    </c:forEach>
                </div>
            </div>
            <c:if test="${sessionScope.OTHERRESULTLIST !=''}">
                <div class="seperator"></div>
                <label class="title-recommend">Các vật dụng trang trí</label>
                <c:url var="changeProduct" value="ChangeRecommendController">
                    <c:param name="categoryChange" value="categoryOther"/>
                </c:url>
                <a class="a-change a-main" href="${changeProduct}">Thay đổi</a>
            </c:if>

            <div>
                <div class="product-list">
                    <c:forEach items="${sessionScope.OTHERRESULTLIST}" var="dto" varStatus="counter">
                        <c:if test="${dto.images !=[]}">
                            <div class="product-card">
                                <div class="badge">${dto.category.name}</div>
                                <div class="product-tumb">

                                    <img src="${dto.images[dto.position].url}" alt=""/>
                                </div>
                                <div class="product-details">
                                    <span class="product-catagory">${dto.category.name}</span> 
                                    <div class="color-card" style="background-color: rgb(${dto.images[dto.position].color.r},${dto.images[dto.position].color.g},${dto.images[dto.position].color.b})">
                                    </div>
                                    <h4><a target="_blank" rel="noopener noreferrer" href="${dto.images[dto.position].product.url}">${dto.images[dto.position].product.name}</a></h4>
                                    <p>Kích thước: ${dto.images[dto.position].product.width} x ${dto.images[dto.position].product.depth} x ${dto.images[dto.position].product.height} (cm)</p>
                                    <c:if test="${dto.images[dto.position].product.brand!=null}">
                                        <p>Thương hiệu: ${dto.images[dto.position].product.brand.name}</p>
                                    </c:if>
                                    <c:if test="${dto.images[dto.position].product.material!=null}">
                                        <p>Vật liệu: ${dto.images[dto.position].product.material}</p>
                                    </c:if>
                                    <div class="product-bottom-details">
                                        <div class="product-price">${dto.images[dto.position].product.price} đ</div>
                                        <c:url var="changeProduct" value="ChangeRecommendController">
                                            <c:param name="categoryChange" value="${dto.category.id}"/>
                                        </c:url>
                                        <!--<a class="a-change" href="${changeProduct}">Thay đổi</a>-->
                                    </div>
                                </div>
                            </div>
                        </c:if>
                    </c:forEach>
                </div>
            </div>



        </div>
    </body>
</html>
