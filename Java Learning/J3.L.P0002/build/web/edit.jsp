<%@include file="header.jsp" %>
<ol class="breadcrumb">
    <li class="breadcrumb-item">
        Update book
    </li>
</ol>
<div class="row">
    <div class="col-md-11 ml-3">
        <form id="form-insert" method="POST" action="Update" enctype="multipart/form-data">
            <div class="row">
                <div class="col-md-4">
                    <div class="form-group">
                        <label for="txtBookID"><strong>ISBN</strong></label>
                        <input type="text" class="form-control" name="txtBookID" id="txtBookID" pattern="(\d){13}" value="${requestScope.DTO.bookID}" readonly>
                    </div>
                </div>
                <div class="col-md-8">
                    <div class="form-group">
                        <label for="txtTitle"><strong>Title</strong></label>
                        <input type="text" class="form-control" name="txtTitle" id="txtTitle" pattern=".{1,50}" value="${requestScope.DTO.title}">
                    </div>
                </div>
            </div>
            <div class="row">
                <div class="col-md-6">
                    <div class="form-group">
                        <label for="txtAuthor"><strong>Author</strong></label>
                        <input type="text" class="form-control" name="txtAuthor" id="txtAuthor" pattern=".{1,40}" value="${requestScope.DTO.author}">
                    </div>
                </div>
                <div class="col-md-6">
                    <div class="form-group">
                        <label for="cbCat"><strong>Category</strong></label>
                        <select class="form-control" id="cbCat" name="cbCat">
                            <c:forEach items="${requestScope.CATLIST}" var="dto">
                                <option value="${dto.catID}" <c:if test="${requestScope.DTO.catID eq dto.catID}">selected</c:if>>${dto.catName}</option>
                            </c:forEach>
                        </select>
                    </div>
                </div>
            </div>
            <div class="row">
                <div class="col-md-12">
                    <div class="form-group">
                        <label for="txtDes"><strong>Description</strong></label>
                        <textarea rows="3" class="form-control" name="txtDes" id="txtDes" pattern=".{1,500}">${requestScope.DTO.description}</textarea>
                    </div>
                </div>
            </div>
            <div class="row">
                <!--  col-md-6   -->
                <div class="col-md-4">
                    <div class="form-group">
                        <label for="txtPrice"><strong>Price</strong></label>
                        <input type="number" class="form-control" name="txtPrice" id="txtPrice" value="${requestScope.DTO.price}" min="1" step="any">
                    </div>
                </div>
                <div class="col-md-4">
                    <div class="form-group">
                        <label for="txtQuantity"><strong>Quantity</strong></label>
                        <input type="number" class="form-control" name="txtQuantity" id="txtQuantity" min="1" step="1" value="${requestScope.DTO.quantity}">
                    </div>
                </div>
                <div class="col-md-4">
                    <div class="form-group">
                        <label for="file"><strong>Change Image</strong></label>
                        <input type="file" class="form-control" name="file" id="file" accept="image/jpeg, image/png">
                    </div>
                </div>
                <!--  col-md-6   -->
            </div>
            <div class="row">
                <div class="col-4"><button type="submit" class="btn btn-success mb-3">Update</button></div>
                <div class="col-4 ml-auto"><img src="bookImage/${requestScope.DTO.image}" width="350" height="200"/></div>
            </div>
        </form>
    </div>
</div>
<%@include file="footer.jsp" %>
<script src="js/update.js" type="text/javascript"></script>
</body>
</html>
