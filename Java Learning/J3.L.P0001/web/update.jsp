<%@include file="header.jsp" %> 
<ol class="breadcrumb">
    <li class="breadcrumb-item">
        Update user
    </li>
</ol>
<div class="row">
    <div class="col-md-8 ml-3">
        <form id="form-updt" method="POST" action="MainController" enctype="multipart/form-data">
            <div class="row">
                <div class="col-md-4">
                    <div class="form-group">
                        <label for="txtUserID"><strong>UserID</strong></label>
                        <input type="text" class="form-control" name="txtUserID" id="txtUserID" readonly value="${requestScope.DTO.userID}">
                    </div>
                </div>
                <div class="col-md-8">
                    <div class="form-group">
                        <label for="txtUsername"><strong>Username</strong></label>
                        <input type="text" class="form-control" name="txtUsername" id="txtUsername" pattern=".{1,40}" value="${requestScope.DTO.username}">
                    </div>
                </div>
            </div>
            <div class="row">
                <div class="col-md-8">
                    <div class="form-group">
                        <label for="txtEmail"><strong>Email</strong></label>
                        <input type="email" class="form-control" name="txtEmail" id="txtEmail" value="${requestScope.DTO.email}">
                    </div>
                </div>
                <!--  col-md-6   -->
                <div class="col-md-4">
                    <div class="form-group">
                        <label for="txtPhone"><strong>Phone</strong></label>
                        <input type="tel" class="form-control" name="txtPhone" id="txtPhone" pattern="[0-9]{10,16}" value="${requestScope.DTO.phone}">
                    </div>
                </div>
                <!--  col-md-6   -->
            </div>
            <div class="row">
                <div class="col-md-4">
                    <div class="form-group">
                        <label for="file"><strong>Photo(Choose file to change photo)</strong></label>
                        <input type="file" class="form-control" name="file" id="file" accept="image/jpeg, image/png">
                    </div>
                </div>
                <!--  col-md-6   -->
                <div class="col-md-4">
                    <div class="form-group">
                        <label for="txtRole"><strong>Role</strong></label>
                        <input type="text" class="form-control" name="txtRole" id="txtRole" pattern=".{1,40}" value="${requestScope.DTO.role}" <c:if test="${sessionScope.ROLE eq requestScope.DTO.role}">readonly</c:if>>
                        </div>
                    </div>
                    <!--  col-md-6   -->
                </div>
                <button type="submit" class="btn btn-success mb-3" value="Update" name="action">Update</button>
            </form>
        </div>
        <div class="col-md-3">
            <div class="row">Current photo:</div>
            <div class="row"><img src="data:image;base64,${requestScope.DTO.base64Img}" width="350" height="300"/></div>
    </div>
</div>
<c:if test="${requestScope.DTO.role eq 'admin'}">
    <div>
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
</c:if>
<%@include file="footer.jsp" %>
<script src="js/update.js" type="text/javascript"></script>
</body>
</html>