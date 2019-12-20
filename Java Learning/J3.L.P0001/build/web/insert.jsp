<%@include file="header.jsp" %>
<ol class="breadcrumb">
    <li class="breadcrumb-item">
        Insert user
    </li>
</ol>
<div class="row">
    <div class="col-md-8 ml-3">
        <form id="form-register" method="POST" action="MainController" enctype="multipart/form-data">
            <div class="row">
                <div class="col-md-4">
                    <div class="form-group">
                        <label for="txtUserID"><strong>UserID</strong></label>
                        <input type="text" class="form-control" name="txtUserID" id="txtUserID" pattern="(\d|\w){1,30}">
                        <p class="error" id="Username-exist"></p>
                    </div>
                </div>
                <div class="col-md-8">
                    <div class="form-group">
                        <label for="txtUsername"><strong>Username</strong></label>
                        <input type="text" class="form-control" name="txtUsername" id="txtUsername" pattern=".{1,40}">
                    </div>
                </div>
            </div>
            <!--  row   -->
            <div class="row">
                <div class="col-md-6">
                    <div class="form-group">
                        <label for="txtPassword"><strong>Password</strong></label>
                        <input type="password" class="form-control" name="txtPassword" id="txtPassword" pattern="(?=.*[A-Z])(?=.*[a-z])[A-Za-z0-9]{8,16}">
                    </div>
                </div>
                <!--  col-md-6   -->
                <div class="col-md-6">
                    <div class="form-group">
                        <label for="txtRepPass"><strong>Repeat Password</strong></label>
                        <input type="password" class="form-control" name="txtRepPass" id="txtRepPass" pattern="(?=.*[A-Z])(?=.*[a-z])[A-Za-z0-9]{8,16}">
                    </div>
                </div>
            </div>
            <div class="row">
                <div class="col-md-8">
                    <div class="form-group">
                        <label for="txtEmail"><strong>Email</strong></label>
                        <input type="email" class="form-control" name="txtEmail" id="txtEmail">
                    </div>
                </div>
                <!--  col-md-6   -->
                <div class="col-md-4">
                    <div class="form-group">
                        <label for="txtPhone"><strong>Phone</strong></label>
                        <input type="tel" class="form-control" name="txtPhone" id="txtPhone" pattern="[0-9]{10,16}">
                    </div>
                </div>
                <!--  col-md-6   -->
            </div>
            <div class="row">
                <div class="col-md-4">
                    <div class="form-group">
                        <label for="file"><strong>Photo</strong></label>
                        <input type="file" class="form-control" name="file" id="file" accept="image/jpeg, image/png" required>
                    </div>
                </div>
                <!--  col-md-6   -->
                <div class="col-md-4">
                    <div class="form-group">
                        <label for="txtRole"><strong>Role</strong></label>
                        <input type="text" class="form-control" name="txtRole" id="txtRole" pattern=".{1,40}">
                    </div>
                </div>
                <!--  col-md-6   -->
            </div>
            <button type="submit" class="btn btn-success mb-3" value="Insert" name="action">Insert</button>
        </form>
    </div>
</div>
<%@include file="footer.jsp" %>
<script src="js/insert.js" type="text/javascript"></script>
</body>
</html>
