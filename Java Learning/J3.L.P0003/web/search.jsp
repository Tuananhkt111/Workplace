<%@include file="header.jsp" %>
<ol class="breadcrumb">
    <li class="breadcrumb-item">
        Search
    </li>
</ol>
<form id="form-search" action="SearchAction" method="POST" class="ml-3">
    <div class="row">
        <div class="col-4">
            <div class="form-group">
                <label for="txtSearch"><strong>Search Type</strong></label>
                <select class="form-control" id="txtSearch" name="txtSearch">
                    <option value="HotelName" <s:if test="%{txtSearch == 'HotelName'}">selected</s:if>>Search By Name</option>
                    <option value="HotelArea" <s:if test="%{txtSearch == 'HotelArea' || txtSearch == null}">selected</s:if>>Search By Area</option>
                    </select>
                </div>
            </div>
        </div>
    </div>
    <div class="row" id="searchArea">
        <div class="col-8">
            <strong>Area:</strong> <input type="text" name="txtArea" class="form-control form-control-sm" value="<s:property value="%{txtArea}"/>" maxlength="100"/>
    </div>
</div>
<div class="row" id="searchName">
    <div class="col-8">
        <strong>Name:</strong> <input type="text" name="txtName" class="form-control form-control-sm" value="<s:property value="%{txtName}"/>" maxlength="100"/>
    </div>
</div>
<div class="row">
    <div class="col-3"><strong>Checkin:</strong> <input type="date" id="txtCheckinDate" name="txtCheckinDate" class="form-control form-control-sm" value="<s:property value="%{txtCheckinDate}"/>" min="<s:property value="%{beginDateText}"/>"/></div>
    <div class="col-3"><strong>Checkout:</strong> <input type="date" id="txtCheckoutDate" name="txtCheckoutDate" class="form-control form-control-sm" value="<s:property value="%{txtCheckoutDate}"/>" min="<s:property value="%{endDateText}"/>"/></div>
    <div class="col-3"><strong>Number of rooms:</strong> <input type="number" id="txtQuantity" name="txtQuantity" class="form-control form-control-sm" value="<s:property value="%{txtQuantity}"/>" min="1" step="1" maxlength="9"/></div>
</div>
<p class="error" id="date-error"></p>
<button id="searchBtn" type="submit" class="btn btn-success mt-2 mb-3">Search</button>
</form>
<s:if test="%{hotelList != null && !hotelList.isEmpty()}">
    <s:iterator value="hotelList">
        <div class="col-11">
            <div class="row ml-2 mr-2 mt-2 pt-2 pb-2 border rounded bg-muted">
                <div class="col-3">
                    <img src="img/<s:property value="photo"/>" width="300px" height="200px"/>
                </div>
                <div class="col-6">
                    <s:url value="SearchRoomAction" var="searchRoomURL" escapeAmp="false">
                        <s:param name="txtHotelName"><s:property value="%{hotelName}"/></s:param>
                        <s:param name="txtHotelID"><s:property value="hotelID"/></s:param>  
                        <s:param name="txtCheckinDate"><s:property value="%{txtCheckinDate}"/></s:param>
                        <s:param name="txtCheckoutDate"><s:property value="%{txtCheckoutDate}"/></s:param>
                        <s:param name="txtQuantity"><s:property value="%{txtQuantity}"/></s:param>
                    </s:url>
                    <div class=""><a href="<s:property value="%{searchRoomURL}"/>"><s:property value="hotelName"/></a></div>
                    <div class=""><s:property value="address"/></div>
                    <div class=""><s:property value="description"/></div>
                    <div class="">Tel: <s:property value="phone"/></div>
                    <div class="">Min Price: <s:property value="minPrice"/>$</div>
                </div>
            </div>
        </div>
    </s:iterator>
</s:if>
<s:else>
    <span class="ml-2">No hotels have available rooms.</span>
</s:else>
<%@include file="footer.jsp" %>
<script src="js/search.js" type="text/javascript"></script>
</body>
</html>
