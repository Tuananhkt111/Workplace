<%@include file="header.jsp" %> 
<ol class="breadcrumb">
    <li class="breadcrumb-item">
        Shopping History
    </li>
</ol>
<form action="ShoppingHistory" method="POST" class="ml-3 mb-3">
    <div class="row">
        <div class="col-4">
            <div class="form-group">
                <label for="txtSearch"><strong>Search Type</strong></label>
                <select class="form-control" id="txtSearch" name="txtSearch">
                    <option value="Name" <c:if test="${param.txtSearch eq 'Name' || param.txtSearch eq null}">selected</c:if>>Search By Name</option>
                    <option value="ShoppingDate" <c:if test="${param.txtSearch eq 'ShoppingDate'}">selected</c:if>>Search By Shopping Date</option>
                    </select>
                </div>
            </div>
        </div>
        <div class="row" id="searchName">
            <div class="col-8">
                <strong>Title:</strong> <input type="text" name="txtName" class="form-control form-control-sm" value="${param.txtName}"/>
        </div>
    </div>
    <div class="row" id="searchDate">
        <div class="col-8"><strong>Date</strong> <input type="date" name="txtDate" class="form-control form-control-sm" value="${param.txtDate}"/></div>  
    </div>
    <button type="submit" class="btn btn-success mt-3">Search</button>
</form>
<c:if test="${not empty requestScope.TRANLIST}" var="checkList2">
    <div>
        <c:forEach items="${requestScope.TRANLIST}" var="dto">
            <div class="bg-dark rounded col-11 ml-3 mt-2 mb-2 pt-3 pb-3" style="color: white;padding-left: 30px;">
                <div class="row"><div class="col-12"><strong>TranID: </strong> ${dto.tranID}</div></div>
                <c:forEach items="${dto.list}" var="item">
                    <div class="row mt-1 mb-1 ml-2">
                        <div class="col-3"><strong>BookID:</strong> ${item.bookID}</div>
                        <div class="col-3"><strong>Title:</strong> ${item.title}</div>
                        <div class="col-3"><strong>Quantity:</strong> ${item.quantity}</div>
                        <div class="col-3"><strong>Price:</strong> ${item.price}$</div>
                    </div>
                </c:forEach>
                <div class="row"><div class="col-12"><strong>Total cost: </strong> ${dto.totalPrice}$</div></div>
                <div class="row"><div class="col-12"><strong>After discount ${dto.salePercent}%: </strong> ${dto.totalPrice * (100 - dto.salePercent)/100}$</div></div>
                <div class="row"><div class="col-12"><strong>Time bought: </strong> ${dto.timeBought}</div></div>
            </div>
            <br>
        </c:forEach>  
    </div>
</tbody>
</table>
</c:if>
<c:if test="${!checkList2}">
    No transactions found.
</c:if>
<%@include file="footer.jsp" %>
<script src="js/history.js" type="text/javascript"></script>
</body>
</html>