<%@include file="header.jsp" %> 
<ol class="breadcrumb">
    <li class="breadcrumb-item">
        Shopping Cart
    </li>
</ol>
<c:if test="${not empty sessionScope.CART}" var="checkList2">
    <table class="table table-hover table-bordered table-dark">
        <thead>
            <tr>
                <th>ISBN</th>
                <th>Title</th>
                <th>Quantity</th>
                <th>Price</th>
                <th>Total Price</th>
                <th></th>
            </tr>
        </thead>
        <tbody>
            <c:set var="total" value="${0}"/>
            <c:forEach items="${sessionScope.CART.cart}" var="dto">
                <tr>
                    <td>${dto.value.bookID}</td>
                    <td>${dto.value.title}</td>
                    <td>${dto.value.quantity}</td>
                    <td>${dto.value.price}$</td>
                    <td>${dto.value.totalPrice}$</td>
                    <td><a class="deleteBook" data-toggle="modal" data-action="DeleteCart" data-id="${dto.value.bookID}" data-target="#removeModal" href="javascript:void(0)">Delete</a>/<a class="edit-cart" data-id="${dto.value.bookID}" data-quantity="${dto.value.quantity}" data-title="${dto.value.title}" data-toggle="modal" href="javascript: void (0)" data-target="#modalUpdtAccForm">Change Quantity</a></td>
                    <c:set var="total" value="${total + dto.value.totalPrice}" />
                </tr>
            </c:forEach>  
            <tr>
                <td></td>
                <td></td>
                <td></td>
                <th>All cost:</th>
                <td>${total}$</td>
                <td></td>
            </tr>
            <c:if test="${requestScope.SALE ne null}">
                <tr>
                    <td></td>
                    <td></td>
                    <td></td>
                    <th>After discount ${requestScope.SALE}%:</th>
                    <td>${total*(100 - requestScope.SALE)/100}$</td>
                    <td></td>
                </tr>
            </c:if>
        </tbody>
    </table>
    <div class="col-8 mb-3" >
        <form action="Discount">
            <div class="form-inline">
                <label for="txtCode"><strong>Discount Code: </strong></label>
                <input type="text" class="form-control ml-2" name="txtCode" id="txtCode" value="${param.txtCode}" required <c:if test="${requestScope.SALE ne null}">readonly</c:if>>
                <button class="ml-2 btn btn-success" type="submit" <c:if test="${requestScope.SALE ne null}">disabled</c:if>>Apply code</button>
            </div>
        </form>
    </div>
    <form action="Checkout" method="POST">
        <input type="hidden" name="txtTotalCost" value="${total}">
        <c:if test="${requestScope.SALE ne null}">
            <input type="hidden" name="txtSale" value="${requestScope.SALE}">
            <input type="hidden" name="txtCode" value="${param.txtCode}">
        </c:if>
        <button class="ml-2 btn btn-success" type="submit">Confirm</button>
    </form>
</c:if>
<c:if test="${!checkList2}">
    No books found.
</c:if>
<div class="modal fade" id="modalUpdtAccForm" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="row ml-auto mr-2 mt-2">
                <button type="button" id="myBtn" class="close" data-dismiss="modal"><i class="fas fa-times-circle"></i></button>
            </div>
            <h3 class="text-center mt-2" style="color: #00cc33">Change quantity</h3>
            <form class="modal-body" id="form-cart-updt" action="UpdateCart" method="POST">
                <div class="row">
                    <!--  col-md-6   -->
                    <input type="hidden" name="txtBookID" id="txtBookID"/>
                    <div class="col-md-12">
                        <div class="form-group">
                            <label for="txtQuantity"><strong>Quantity</strong></label>
                            <input type="number" class="form-control" name="txtQuantity" id="txtQuantity" min="1" step="1" required>
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
            <div class="modal-body">Press "Delete" if you want to delete this book.</div>
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