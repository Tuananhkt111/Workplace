<%@include file="header.jsp" %> 
<ol class="breadcrumb">
    <li class="breadcrumb-item">
        Promotion List
    </li>
</ol>
<a href="prolist.jsp" class="ml-3">Promotion List</a>
<ol class="breadcrumb">
    <li class="breadcrumb-item">
        Insert user
    </li>
</ol>
<a href="insert.jsp" class="ml-3">Insert user</a>
<ol class="breadcrumb">
    <li class="breadcrumb-item">
        User Search
    </li>
</ol>
<ul class="nav nav-tabs bg-dark">
    <c:url var="allUrl" value="MainController">
        <c:param name="action" value="Search"/>
    </c:url>
    <li class="nav-item"><a class="nav-link <c:if test="${param.role eq null || param.role eq ''}">active</c:if>" href="${allUrl}">All</a></li>
        <c:if test="${not empty requestScope.ROLELIST}" var="checkList">
            <c:forEach items="${requestScope.ROLELIST}" var="dto" varStatus="counter">
            <li class="nav-item"><a class="nav-link <c:if test="${param.role eq dto}">active</c:if>" href="MainController?action=Search&role=${dto}">${dto}</a></li>
            </c:forEach>
        </c:if>
</ul>
<form action="MainController" method="POST">
    Username: <input type="text" name="name" class="form-control form-control-sm" value="${param.name}"/>
    <input type="hidden" name="role" value="${param.role}"/>
    <button type="submit" name="action" value="Search" class="btn btn-success">Search</button>
</form>
<c:if test="${not empty requestScope.DTOLIST}" var="checkList2">
    <table class="table table-hover table-bordered table-dark">
        <thead>
            <tr>
                <th>UserID</th>
                <th>Username</th>
                <th>Email</th>
                <th>Phone</th>
                <th>Photo</th>
                <th>Role</th>
                <th></th>
            </tr>
        </thead>
        <tbody>
            <c:forEach items="${requestScope.DTOLIST}" var="dto">
                <tr>
                    <td>${dto.userID}</td>
                    <td>${dto.username}</td>
                    <td>${dto.email}</td>
                    <td>${dto.phone}</td>
                    <td><img src="data:image/png;base64,${dto.base64Img}" width="350" height="300"/></td>
                    <td>${dto.role}</td>
                    <td><a href="MainController?action=Delete&userID=${dto.userID}">Delete</a>/<a href="MainController?action=Edit&userID=${dto.userID}">Edit</a>/<a href="MainController?action=AddToProList&userID=${dto.userID}">Add to promotion list</a></td>
                </tr>
            </c:forEach>                            
        </tbody>
    </table>
</c:if>
<c:if test="${!checkList2}">
    No record found.
</c:if>
<%@include file="footer.jsp" %>
</body>
</html>
