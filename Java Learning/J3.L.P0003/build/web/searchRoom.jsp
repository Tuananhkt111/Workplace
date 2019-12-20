<%@include file="header.jsp" %>
<ol class="breadcrumb">
    <li class="breadcrumb-item">
        Search
    </li>
</ol>
<div class="row ml-2">
    <h3 style="color: blue;">Hotel: <s:property value="txtHotelName"/></h3>
</div>
<s:if test="%{roomTypeList != null && !roomTypeList.isEmpty()}">
    <s:iterator value="roomTypeList">
        <div class="ml-2 mr-2 mt-2 pt-2 pb-2 border rounded bg-muted row">
            <div class="col-8">
                <div class="ml-2"><strong class="mr-2">Room Type:</strong><s:property value="roomType"/></div>
                <div class="ml-2"><strong class="mr-2">Description:</strong><s:property value="description"/></div>
                <div class="ml-2"><strong class="mr-2">Max People:</strong> <s:property value="maxPeople"/></div>
                <div class="ml-2"><strong class="mr-2">AvailableRoom: </strong><s:property value="availableRoom"/></div>
                <div class="ml-2"><strong class="mr-2">Price: </strong><s:property value="Price"/>$</div>
            </div>
            <div class="col-3">
                <s:if test="%{#session.ROLE == 'user'}">
                    <form action="AddToCartAction" method="POST" id="form-book">
                        <input type="hidden" name="txtHotelID" value="<s:property value="%{txtHotelID}"/>"/>
                        <input type="hidden" name="txtHotelName" value="<s:property value="%{txtHotelName}"/>"/>
                        <input type="hidden" name="txtCheckinDate" value="<s:property value="%{txtCheckinDate}"/>"/>
                        <input type="hidden" name="txtCheckoutDate" value="<s:property value="%{txtCheckoutDate}"/>"/>
                        <input type="hidden" name="txtRoomTypeID" value="<s:property value="%{roomTypeID}"/>"/>
                        <div class=""><strong>Number of rooms:</strong> <input type="number" id="txtQuantity" name="txtQuantity" class="form-control form-control-sm" value="<s:property value="%{txtQuantity}"/>" min="1" step="1" maxlength="9"  max="<s:property value="%{availableRoom}"/>"/></div>
                        <div class=""><button type="submit" class="btn btn-success mt-2">Add to cart</button></div>
                    </form>
                </s:if>
                <s:elseif test="%{#session.ROLE == 'admin'}">
                    
                </s:elseif>
                <s:else>
                    <a href="LoginPageAction">Add to cart</a>
                </s:else>
            </div>
        </div>
    </s:iterator>
</s:if>
<s:else>
    <span class="ml-2">No hotels have available rooms.</span>
</s:else>
<%@include file="footer.jsp" %>
<script src="js/searchRoom.js" type="text/javascript"></script>
</body>
</html>
