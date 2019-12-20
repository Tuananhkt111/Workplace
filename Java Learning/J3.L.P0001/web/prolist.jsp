<%@include file="header.jsp" %> 
<ol class="breadcrumb">
    <li class="breadcrumb-item">
        Promotion List
    </li>
</ol>
<c:if test="${sessionScope.PROLIST ne null}">
    <c:if test="${not empty sessionScope.PROLIST}" var="checkList2">
        <table class="table table-hover table-bordered table-dark">
            <thead>
                <tr>
                    <th>UserID</th>
                    <th>Mark</th>
                    <th></th>
                </tr>
            </thead>
            <tbody>
                <c:forEach items="${sessionScope.PROLIST.list}" var="dto">
                    <tr>
                        <td>${dto.value.userID}</td>
                        <td>${dto.value.rank}</td>
                        <td><a href="MainController?action=DeleteProList&userID=${dto.value.userID}">Delete</a>/<a class="edit-pro-list" data-id="${dto.value.userID}" data-rank="${dto.value.rank}" data-toggle="modal" href="javascript: void (0)" data-target="#modalUpdtAccForm">Edit</a></td>
                    </tr>
                </c:forEach>                            
            </tbody>
        </table>
    </c:if>
    <c:if test="${!checkList2}">
        No record found.
    </c:if>
    <form action="MainController" method="POST">
        <button class="ml-2 btn btn-success" type="submit" name="action" value="SaveProList">Submit</button>
    </form>
</c:if>
<div class="modal fade" id="modalUpdtAccForm" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
    <div class="modal-dialog modal-lg" role="document">
        <div class="modal-content">
            <div class="row ml-auto mr-2 mt-2">
                <button type="button" id="myBtn" class="close" data-dismiss="modal"><i class="fas fa-times-circle"></i></button>
            </div>
            <h3 class="text-center mt-2" style="color: #00cc33">Edit</h3>
            <form class="modal-body" id="form-pro-list-updt" action="MainController" method="POST">
                <div class="row">
                    <div class="col-lg-6">
                        <div class="form-group">
                            <label for="txtUserID"><strong>UserID</strong></label>
                            <input type="text" class="form-control" name="txtUserID" id="txtUserID" readonly>
                        </div>
                    </div>
                    <!--  col-md-6   -->
                    <div class="col-lg-6">
                        <div class="form-group">
                            <label for="txtRank"><strong>Rank</strong></label>
                            <input type="number" class="form-control" name="txtRank" id="txtRank" min="1" max="10" step="any" maxlength="3" required>
                        </div>
                    </div>
                    <!--  col-md-6   -->
                </div>
                <div class="text-center mt-2">
                    <button type="submit" class="btn btn-success mb-3 m-auto" value="UpdateProList" name="action">Update</button>
                </div>
            </form>
        </div>
    </div>
</div>
<%@include file="footer.jsp" %>
<script src="js/prolist.js" type="text/javascript"></script>
</body>
</html>