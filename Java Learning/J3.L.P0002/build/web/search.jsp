<%@include file="header.jsp" %>
<c:if test="${sessionScope.ROLE eq 'admin'}">
    <ol class="breadcrumb">
        <li class="breadcrumb-item">
            Insert user
        </li>
    </ol>
    <div class="ml-3">
        <a href="InsertUserPage">Insert user</a>
    </div>
    <ol class="breadcrumb">
        <li class="breadcrumb-item">
            Insert book
        </li>
    </ol>
    <div class="ml-3">
        <a href="InsertPage">Insert book</a>
    </div>
</c:if>
<ol class="breadcrumb">
    <li class="breadcrumb-item">
        Search
    </li>
</ol>
<form action="Search" method="POST" class="ml-3">
    <div class="row">
        <div class="col-4">
            <div class="form-group">
                <label for="txtSearch"><strong>Search Type</strong></label>
                <select class="form-control" id="txtSearch" name="txtSearch">
                    <option value="Name" <c:if test="${param.txtSearch eq 'Name' || param.txtSearch eq null}">selected</c:if>>Search By Name</option>
                    <option value="Price" <c:if test="${param.txtSearch eq 'Price'}">selected</c:if>>Search By Price</option>
                    <option value="Category" <c:if test="${param.txtSearch eq 'Category'}">selected</c:if>>Search By Category</option>
                    </select>
                </div>
            </div>
        </div>
        <div class="row" id="searchName">
            <div class="col-8">
                <strong>Title:</strong> <input type="text" name="txtName" class="form-control form-control-sm" value="${param.txtName}"/>
        </div>
    </div>
    <div class="row" id="searchPrice">
        <div class="col-4"><strong>MinPrice:</strong> <input type="number" name="min" class="form-control form-control-sm" value="${param.min}" min="1" step="any"/></div>
        <div class="col-4"><strong>MaxPrice:</strong> <input type="number" name="max" class="form-control form-control-sm" value="${param.max}" min="1" step="any"/></div>
    </div>
    <div class="row" id="searchCat">
        <div class="col-4"> <div class="form-group">
                <label for="cbCat"><strong>Category</strong></label>
                <select class="form-control" id="cbCat" name="cbCat">
                    <c:forEach items="areaList">
                        <option value="${dto.catID}" <c:if test="${param.cbCat eq dto.catID}">selected</c:if>>${dto.catName}</option>
                    </c:forEach>
                </select>
            </div></div>
    </div>
    <button type="submit" class="btn btn-success">Search</button>
</form>
<ol class="breadcrumb">
    <li class="breadcrumb-item">
        List of books
    </li>
</ol>
<c:if test="${not empty requestScope.BOOKLIST}" var="checkList2">
    <table class="table table-hover table-bordered table-dark">
        <thead>
            <tr>
                <th>ISBN</th>
                <th>Title</th>
                <th>Category</th>
                <th>Author</th>
                <th>Description</th>
                <th>Price</th>
                <th>Quantity</th>
                <th>Image</th>
                <th>Import Date</th>
                <th></th>
            </tr>
        </thead>
        <tbody>
            <c:forEach items="${requestScope.BOOKLIST}" var="dto">
                <tr>
                    <td>${dto.bookID}</td>
                    <td>${dto.title}</td>
                    <td>${dto.catName}</td>
                    <td>${dto.author}</td>
                    <td>${dto.description}</td>
                    <td>${dto.price}$</td>
                    <td>${dto.quantity}</td>
                    <td><img src="bookImage/${dto.image}" width="350" height="250"/></td>
                    <td>${dto.importDate}</td>
                    <td><c:if test="${sessionScope.ROLE eq 'admin'}"><a class="deleteBook" data-toggle="modal" data-action="Delete" data-id="${dto.bookID}" data-target="#removeModal" href="javascript: void(0)">Delete</a>/<a href="Edit?bookID=${dto.bookID}">Edit</a></c:if>
                        <c:if test="${sessionScope.ROLE ne 'admin' && sessionScope.ROLE ne '' && sessionScope.ROLE ne null}"><a href="AddCart?bookID=${dto.bookID}">Add to cart</a></c:if>
                        <c:if test="${sessionScope.ROLE eq '' || sessionScope.ROLE eq null}"><a href="login.jsp">Add to cart</a></c:if></td>
                    </c:forEach>                            
        </tbody>
    </table>
</c:if>
<c:if test="${!checkList2}">
    No books found.
</c:if>
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
<script src="js/search.js" type="text/javascript"></script>
</body>
</html>
