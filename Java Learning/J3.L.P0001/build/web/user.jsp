<%@include file="header.jsp" %> 
<div class="row">
    <div class="col-6">
        <ol class="breadcrumb">
            <li class="breadcrumb-item">
                Profile
            </li>
        </ol>
        <div>
            <form id="form-updt" method="POST" action="MainController" enctype="multipart/form-data">
                <div class="row">
                    <div class="col-md-4">
                        <div class="form-group">
                            <label for="txtUserID"><strong>UserID</strong></label>
                            <input type="text" class="form-control" placeholder="" name="txtUserID" id="txtUserID" readonly value="${requestScope.DTO.userID}">
                            <p class="error" id="Username-exist"></p>
                        </div>
                    </div>
                    <div class="col-md-7">
                        <div class="form-group">
                            <label for="txtUsername"><strong>Username</strong></label>
                            <input type="text" class="form-control" placeholder="" name="txtUsername" id="txtUsername" pattern=".{1,40}" value="${requestScope.DTO.username}">
                        </div>
                    </div>
                </div>
                <!--  row   -->
                <div class="row">
                    <div class="col-md-7">
                        <div class="form-group">
                            <label for="txtEmail"><strong>Email</strong></label>
                            <input type="email" class="form-control" placeholder="" name="txtEmail" id="txtEmail" value="${requestScope.DTO.email}">
                        </div>
                    </div>
                    <!--  col-md-6   -->
                    <div class="col-md-4">
                        <div class="form-group">
                            <label for="txtPhone"><strong>Phone</strong></label>
                            <input type="tel" class="form-control" name="txtPhone" id="txtPhone" placeholder="" pattern="[0-9]{10,16}" value="${requestScope.DTO.phone}">
                        </div>
                    </div>
                    <!--  col-md-6   -->
                </div>
                <div class="row">                        
                    <div class="col-md-4">
                        <div class="row ml-1"><strong>Current photo:</strong></div>
                        <div class="row ml-1"><img src="data:image/png;base64,${requestScope.DTO.base64Img}" width="250" height="200"/></div>
                    </div>
                    <div class="col-md-4">
                        <div class="form-group">
                            <label for="file"><strong>Photo(Choose file to change photo)</strong></label>
                            <input type="file" class="form-control" placeholder="" name="file" id="file" accept="image/jpeg, image/png">
                        </div>
                    </div>
                    <!--  col-md-6   -->
                    <div class="col-md-4">
                        <div class="form-group">
                            <label for="txtRole"><strong>Role</strong></label>
                            <input type="text" class="form-control" name="txtRole" id="txtRole" placeholder="" pattern=".{1,40}" readonly value="${requestScope.DTO.role}">
                        </div>
                    </div>
                    <!--  col-md-6   -->
                </div>
                <button type="submit" class="btn btn-success mb-3" value="Update" name="action">Update</button>
            </form>
        </div>
    </div>
    <div class="col-6">
        <ol class="breadcrumb">
            <li class="breadcrumb-item">
                Change Password
            </li>
        </ol>
        <form id="form-change-pwd" method="POST" action="MainController">
            <div class="row">
                <div class="col-md-12">
                    <div class="form-group">
                        <label for="txtPassOld"><strong>Old Password</strong></label>
                        <input type="password" class="form-control" placeholder="" name="txtPassOld" id="txtPassOld" pattern="(?=.*[A-Z])(?=.*[a-z])[A-Za-z0-9]{8,16}">
                    </div>
                </div>
            </div>
            <!--  row   -->
            <div class="row">
                <div class="col-md-12">
                    <div class="form-group">
                        <label for="txtPassNew"><strong>New Password</strong></label>
                        <input type="password" class="form-control" placeholder="" name="txtPassNew" id="txtPassNew" pattern="(?=.*[A-Z])(?=.*[a-z])[A-Za-z0-9]{8,16}">
                    </div>
                </div>
            </div>
            <div class="row">
                <div class="col-md-12">
                    <div class="form-group">
                        <label for="txtRepPass"><strong>Repeat Password</strong></label>
                        <input type="password" class="form-control" placeholder="" name="txtRepPass" id="txtRepPass" pattern="(?=.*[A-Z])(?=.*[a-z])[A-Za-z0-9]{8,16}">
                    </div>
                </div>
            </div>
            <button type="submit" class="btn btn-success mb-3" name="action" value="ChangePass">Change</button>
        </form>
    </div>
</div>
<div>
    <ol class="breadcrumb">
        <li class="breadcrumb-item">
            View promotion History
        </li>
    </ol>
    <c:if test="${requestScope.PROHIS ne null}">
        <c:if test="${not empty requestScope.PROHIS}" var="checkList2">
            <table class="table table-hover table-bordered table-dark">
                <thead>
                    <tr>
                        <th>PlID</th>
                        <th>Rank</th>
                        <th>Time Assigned</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach items="${requestScope.PROHIS}" var="dto">
                        <tr>
                            <td>${dto.value.phID}</td>
                            <td>${dto.value.rank}</td>
                            <td>${dto.value.timeAssigned}</td>
                        </tr>
                    </c:forEach>                            
                </tbody>
            </table>
        </c:if>
        <c:if test="${!checkList2}">
            No record found.
        </c:if>
    </c:if>
</div>
<%@include file="footer.jsp" %>
<script src="js/user.js" type="text/javascript"></script>
</body>
</html>