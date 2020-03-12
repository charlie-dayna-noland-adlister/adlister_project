<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <jsp:include page="/WEB-INF/partials/head.jsp">
        <jsp:param name="title" value="Adlister | Home" />
    </jsp:include>
    <style>
        <%@ include file="/WEB-INF/resources/CSS/custom.css" %>
    </style>
</head>
<body>
        <jsp:include page="/WEB-INF/partials/navbar/navbar.jsp"/>

<<<<<<< HEAD
    <div class="container text-center">
        <h1 class="text-light">Welcome, ${sessionScope.user.username}!</h1>
    </div>



        <jsp:include page="/WEB-INF/partials/scripts.jsp"/>
        <jsp:include page="/WEB-INF/partials/body-scripts.jsp"/>

=======
    <div class="container d-flex justify-content-left align-items-center">
        <img src="${sessionScope.user.profileImageText}" alt="${sessionScope.user.username} PROFILE IMAGE" class="img-thumbnail mr-5 mt-5 h-200">
        <h1 class="text-light">Welcome, ${sessionScope.user.username}!</h1>
        <br>
    </div>
    <jsp:include page="/WEB-INF/partials/scripts.jsp"/>
>>>>>>> ad03dc7d47784c6815055b635ec111e9a9d979b0
</body>
</html>
