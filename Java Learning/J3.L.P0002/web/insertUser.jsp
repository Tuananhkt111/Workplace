<%@include file="header.jsp" %>
<ol class="breadcrumb">
    <li class="breadcrumb-item">
        Insert book
    </li>
</ol>
<div class="row">
    <div class="col-md-11 ml-3">
        <form id="form-insert" method="POST" action="InsertUser">
            <div class="row">
                <div class="col-md-4">
                    <div class="form-group">
                        <label for="txtUserID"><strong>UserID</strong></label>
                        <input type="text" class="form-control" name="txtUserID" id="txtUserID" pattern="(\d|\w){1,30}" value="${param.txtUserID}">
                        <p class="error" id="Username-exist"></p>
                    </div>
                </div>
                <div class="col-md-8">
                    <div class="form-group">
                        <label for="txtUsername"><strong>Username</strong></label>
                        <input type="text" class="form-control" name="txtUsername" id="txtUsername" pattern=".{1,40}" value="${param.txtUsername}">
                    </div>
                </div>
            </div>
            <!--  row   -->
            <div class="row">
                <div class="col-md-6">
                    <div class="form-group">
                        <label for="txtPassword"><strong>Password</strong></label>
                        <input type="password" class="form-control" name="txtPassword" id="txtPassword" pattern="(?=.*[A-Z])(?=.*[a-z])[A-Za-z0-9]{8,16}" value="${param.txtPassword}">
                    </div>
                </div>
                <!--  col-md-6   -->
                <div class="col-md-6">
                    <div class="form-group">
                        <label for="txtRepPass"><strong>Repeat Password</strong></label>
                        <input type="password" class="form-control" name="txtRepPass" id="txtRepPass" pattern="(?=.*[A-Z])(?=.*[a-z])[A-Za-z0-9]{8,16}" value="${param.txtRepPass}">
                    </div>
                </div>
            </div>
            <div class="row">
                <div class="col-md-8">
                    <div class="form-group">
                        <label for="txtEmail"><strong>Email</strong></label>
                        <input type="email" class="form-control" name="txtEmail" id="txtEmail"  value="${param.txtEmail}">
                    </div>
                </div>
                <!--  col-md-6   -->
                <div class="col-md-4">
                    <div class="form-group">
                        <label for="txtPhone"><strong>Phone</strong></label>
                        <input type="tel" class="form-control" name="txtPhone" id="txtPhone" pattern="[0-9]{10,16}" value="${param.txtPhone}">
                    </div>
                </div>
                <!--  col-md-6   -->
            </div>
            <div class="row">
                <div class="col-md-4">
                    <div class="form-group">
                        <label for="txtAddress"><strong>Address</strong></label>
                        <input type="text" class="form-control" name="txtAddress" id="txtAddress" pattern=".{1,100}" value="${param.txtAddress}">
                    </div>
                </div>
                <!--  col-md-6   -->
                <div class="col-md-4">
                    <div class="form-group">
                        <label for="cbRole"><strong>Role</strong></label>
                        <select class="form-control" id="cbRole" name="cbRole">
                            <c:forEach items="${requestScope.ROLELIST}" var="dto">
                                <option value="${dto.roleID}" <c:if test="${param.cbRole eq dto.roleID}">selected</c:if>>${dto.roleName}</option>
                            </c:forEach>
                        </select>
                    </div>
                </div>
                <!--  col-md-6   -->
            </div>
            <button type="submit" class="btn btn-success mb-3">Insert</button>
        </form>
    </div>
</div>
<%@include file="footer.jsp" %>
<script src="js/insertUser.js" type="text/javascript"></script>
</body>
</html>
