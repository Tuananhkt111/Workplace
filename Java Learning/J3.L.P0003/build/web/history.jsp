<%@include file="header.jsp" %> 
<ol class="breadcrumb">
    <li class="breadcrumb-item">
        Booking History
    </li>
</ol>
<form id="form-search" action="BookingHistoryAction" method="POST" class="ml-3 mb-3">
    <div class="row" id="searchDate">
        <div class="col-8"><strong>Date</strong> <input type="date" id="txtDate" name="txtDate" class="form-control form-control-sm" value="<s:property value="%{txtDate}"/>"/></div>  
    </div>
    <button type="submit" class="btn btn-success mt-3">Search</button>
</form>
<s:if test="%{tranList != null && !tranList.isEmpty()}">
    <div>
        <s:iterator value="tranList">
            <div class="bg-dark rounded col-11 ml-3 mt-2 mb-2 pt-3 pb-3" style="color: white;padding-left: 30px;">
                <div class="row"><div class="col-12"><strong>TranID: </strong> <s:property value="%{tranID}"/></div></div>
                <s:iterator value="%{list}">
                    <div class="row mt-2 mb-2 ml-2">
                        <div class="col-4"><strong>Hotel Name:</strong> <s:property value="%{hotelName}"/></div>
                        <div class="col-4"><strong>Room Type:</strong> <s:property value="%{roomType}"/></div>
                        <div class="col-4"><strong>Quantity:</strong> <s:property value="%{quantity}"/></div>
                        <div class="col-4"><strong>Date Checkin:</strong> <s:property value="%{dateCheckin}"/></div>
                        <div class="col-4"><strong>Date Checkout:</strong> <s:property value="%{dateCheckout}"/></div>
                        <div class="col-4"><strong>Sub Price:</strong> <s:property value="%{Price}"/>$</div>
                    </div>
                </s:iterator>
                <div class="row"><div class="col-12"><strong>Total cost: </strong> <s:property value="%{totalPrice}"/>$</div></div>
                <div class="row"><div class="col-12"><strong>After discount <s:property value="%{salePercent}"/>%: </strong> <s:property value="%{totalPrice * (100 - salePercent)/100}"/>$</div></div>
                <div class="row"><div class="col-12"><strong>Date booked: </strong> <s:property value="%{dateBooked}"/></div></div>
                <div class="row"><div class="col-12"><a class="deleteBook" data-toggle="modal" data-action="DeleteTranAction" data-id="<s:property value="%{tranID}"/>" data-target="#removeModal" href="javascript:void(0)">Delete</a></div></div>
            </div>
            <br>
        </s:iterator>  
    </div>
</tbody>
</table>
</s:if>
<s:else>
    No transactions found.
</s:else>
<div class="modal fade" id="removeModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title" id="exampleModalLabel">Do you want to remove?</h5>
                <button class="close" type="button" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">×</span>
                </button>
            </div>
            <div class="modal-body">Press "Delete" if you want to delete this transaction.</div>
            <div class="modal-footer">
                <button class="btn btn-secondary" type="button" data-dismiss="modal">Cancel</button>
                <a id="deleteLink" class="btn btn-primary" href="">Delete</a>
            </div>
        </div>
    </div>
</div>
<%@include file="footer.jsp" %>
<script src="js/history.js" type="text/javascript"></script>
</body>
</html>