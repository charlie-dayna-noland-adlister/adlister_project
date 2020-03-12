<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <jsp:include page="/WEB-INF/partials/head.jsp">
        <jsp:param name="title" value="Your Profile" />
    </jsp:include>
    <style>
        <%@ include file="/WEB-INF/resources/CSS/custom.css" %>
    </style>
</head>
<body>
    <jsp:include page="/WEB-INF/partials/navbar/navbar.jsp" />

    <div class="container d-flex justify-content-left align-items-center">
        <img src="${sessionScope.user.profileImageText}" alt="${sessionScope.user.username} PROFILE IMAGE" class="img-thumbnail mr-5 mt-5 h-200">
<%--        <img src="https://as1.ftcdn.net/jpg/02/26/27/00/500_F_226270069_bRrObQO6Ar8pb9aiTZ5899CrP3MzPEbq.jpg" alt="${sessionScope.user.username} PROFILE IMAGE" class="img-thumbnail mr-5 mt-5">--%>
        <h1 class="text-light">Welcome, ${sessionScope.user.username}!</h1>
        <br>
    </div>

    
    <jsp:include page="/WEB-INF/partials/scripts.jsp"/>
</body>
</html>
