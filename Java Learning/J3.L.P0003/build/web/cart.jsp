<%@include file="header.jsp" %> 
<ol class="breadcrumb">
    <li class="breadcrumb-item">
        Booking Cart
    </li>
</ol>
<s:if test="%{#session.CART != null && !#session.CART.cart.isEmpty()}">
    <table class="table table-hover table-bordered table-dark">
        <thead>
            <tr>
                <th>Hotel Name</th>
                <th>Room Type</th>
                <th>Quantity</th>
                <th>Price</th>
                <th>Checkin Date</th>
                <th>Checkout Date</th>
                <th>Sub Price</th>
                <th></th>
            </tr>
        </thead>
        <tbody>
            <s:set var="total" value="%{0}"/>
            <s:iterator value="%{#session.CART.cart}">
                <tr>
                    <td><s:property value="%{value.hotelName}"/></td>
                    <td><s:property value="%{value.roomType}"/></td>
                    <td><s:property value="%{value.quantity}"/></td>
                    <td><s:property value="%{value.price}"/>$</td>
                    <td><s:property value="%{value.dateCheckin}"/></td>
                    <td><s:property value="%{value.dateCheckout}"/></td>
                    <td><s:property value="%{value.subPrice}"/>$</td>
                    <td><a class="deleteBook" data-toggle="modal" data-action="DeleteCartAction" data-id="<s:property value="%{value.roomTypeID}"/>" data-target="#removeModal" href="javascript:void(0)">Delete</a>/<a class="edit-cart" data-id="<s:property value="%{value.roomTypeID}"/>" data-quantity="<s:property value="%{value.quantity}"/>" data-toggle="modal" href="javascript: void (0)" data-target="#modalUpdtAccForm">Change Quantity</a></td>
                    <s:set var="total" value="%{#total + value.subPrice}" />
                </tr>
            </s:iterator>  
            <tr>
                <td></td>
                <td></td>
                <td></td>
                <th>All cost:</th>
                <td><s:property value="%{#total}"/>$</td>
                <td></td>
            </tr>
            <s:if test="%{sale != null && sale != 0}">
                <tr>
                    <td></td>
                    <td></td>
                    <td></td>
                    <th>After discount <s:property value="%{sale}"/>%:</th>
                    <td><s:property value="%{#total*(100 - sale)/100}"/>$</td>
                    <td></td>
                </tr>
            </s:if>
        </tbody>
    </table>
    <div class="col-8 mb-3" >
        <form action="DiscountAction">
            <div class="form-inline">
                <label for="txtCode"><strong>Discount Code: </strong></label>
                <input type="text" class="form-control ml-2" name="txtCode" id="txtCode" value="<s:property value="%{txtCode}"/>" required <s:if test="%{sale != null && sale != 0}">readonly</s:if>>
                <button class="ml-2 btn btn-success" type="submit" <s:if test="%{sale != null && sale != 0}">disabled</s:if>>Apply code</button>
                </div>
            </form>
        </div>
        <form action="CheckoutAction" method="POST">
            <input type="hidden" name="txtTotalCost" value="<s:property value="%{#total}"/>">
        <s:if test="%{sale != null && sale != 0}">
            <input type="hidden" name="txtCode" value="<s:property value="%{txtCode}"/>">
        </s:if>
        <button class="ml-2 btn btn-success" type="submit">Confirm</button>
    </form>
    <form action="CreatePaymentAction" method="POST">
        <input type="hidden" name="txtTotalCost" value="<s:property value="%{#total}"/>">
        <s:if test="%{sale != null && sale != 0}">
            <input type="hidden" name="txtCode" value="<s:property value="%{txtCode}"/>">
        </s:if>
        <button class="ml-2 btn btn-success" type="submit">Pay by Paypal</button>
    </form>
</s:if>
<s:else>
    No rooms found.
</s:else>
<div class="modal fade" id="modalUpdtAccForm" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="row ml-auto mr-2 mt-2">
                <button type="button" id="myBtn" class="close" data-dismiss="modal"><i class="fas fa-times-circle"></i></button>
            </div>
            <h3 class="text-center mt-2" style="color: #00cc33">Change quantity</h3>
            <form class="modal-body" id="form-cart-updt" action="UpdateCartAction" method="POST">
                <div class="row">
                    <!--  col-md-6   -->
                    <input type="hidden" name="txtRoomTypeID" id="txtRoomTypeID"/>
                    <div class="col-md-12">
                        <div class="form-group">
                            <label for="txtQuantity"><strong>Quantity</strong></label>
                            <input type="number" class="form-control" name="txtQuantity" id="txtQuantity" min="1" step="1" required maxlength="9">
                        </div>
                    </div>
                    <!--  col-md-6   -->
                </div>
                <div class="text-center mt-2">
                    <button type="submit" class="btn btn-success mb-3 m-auto">Change</button>
                </div>
            </form>
        </div>
    </div>
</div>
<div class="modal fade" id="removeModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title" id="exampleModalLabel">Do you want to remove?</h5>
                <button class="close" type="button" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">×</span>
                </button>
            </div>
            <div class="modal-body">Press "Delete" if you want to delete these rooms.</div>
            <div class="modal-footer">
                <button class="btn btn-secondary" type="button" data-dismiss="modal">Cancel</button>
                <a id="deleteLink" class="btn btn-primary" href="">Delete</a>
            </div>
        </div>
    </div>
</div>
<%@include file="footer.jsp" %>
<script src="js/cart.js" type="text/javascript"></script>
</body>
</html>