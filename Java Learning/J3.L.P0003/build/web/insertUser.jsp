<%@include file="header.jsp" %>
<ol class="breadcrumb">
    <li class="breadcrumb-item">
        Register
    </li>
</ol>
<div class="row">
    <div class="col-md-11 ml-3">
        <s:if test="%{#session.ROLE == 'admin'}">
            <form id="form-insert" method="POST" action="InsertAction">
        </s:if>
        <s:else>
            <form id="form-insert" method="POST" action="InsertUserAction">
        </s:else>
            <div class="row">
                <div class="col-md-6">
                    <div class="form-group">
                        <label for="txtEmail"><strong>Email</strong></label>
                        <input type="email" class="form-control" name="txtEmail" id="txtEmail"  value="<s:property value="%{txtEmail}"/>">
                    </div>
                </div>
                <div class="col-md-6">
                    <div class="form-group">
                        <label for="txtUsername"><strong>Username</strong></label>
                        <input type="text" class="form-control" name="txtUsername" id="txtUsername" pattern=".{1,40}" value="<s:property value="%{txtUsername}"/>">
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
                <div class="col-md-4">
                    <div class="form-group">
                        <label for="txtPhone"><strong>Phone</strong></label>
                        <input type="tel" class="form-control" name="txtPhone" id="txtPhone" pattern="[0-9]{10,16}" value="<s:property value="%{txtPhone}"/>">
                    </div>
                </div>
                <div class="col-md-4">
                    <div class="form-group">
                        <label for="txtAddress"><strong>Address</strong></label>
                        <input type="text" class="form-control" name="txtAddress" id="txtAddress" pattern=".{1,100}" value="<s:property value="%{txtAddress}"/>">
                    </div>
                </div>
                <div class="col-md-4">
                    <div class="form-group">

                        <s:if test="%{#session.ROLE == 'admin'}">
                            <label for="cbRole"><strong>Role</strong></label>
                            <select class="form-control" id="cbRole" name="cbRole">
                                <s:iterator value="%{roleList}">
                                    <option value="<s:property value="roleID"/>" <s:if test="%{cbRole == roleID}">selected</s:if>><s:property value="%{roleName}"/></option>
                                </s:iterator>
                            </select>
                        </s:if>
                        <s:else>
                            <input type="hidden" id="cbRole" name="cbRole" value="R0002"/>
                        </s:else>
                    </div>
                </div>
                <!--  col-md-6   -->
            </div>
            <button type="submit" class="btn btn-success mb-3">Insert</button>
        </form>
        <a href="LoginPageAction">Already have account? Sign in now</a>
    </div>
</div>
<%@include file="footer.jsp" %>
<script src="js/insertUser.js" type="text/javascript"></script>
</body>
</html>
