<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
<c:choose>
    <c:when test="${empty user}">
        <jsp:include page="/WEB-INF/partials/navbar/guest-navbar.jsp"/>
    </c:when>
    <c:otherwise>
        <jsp:include page="/WEB-INF/partials/navbar/navbar.jsp"/>
    </c:otherwise>
</c:choose>

<div class="container d-flex justify-content-center align-items-center">
    <div class="container register-container text-center">
        <div class="row">
            <div class="col">


        <div class="row">
            <div class="col">
                <h1 class="text-light pb-3 pt-2 pr-3">Register</h1>
                <h4 class="text-center pb-2"><i class="far fa-user fa-4x"></i></h4>
            </div>
        </div>
        <form action="/register" method="POST" class="d-flex flex-column justify-content-center align-items-center">
                    <div class="form-group mb-0">
                        <label for="username"></label>
                        <input id="username" name="username" class="text-center" type="text" placeholder="Username">
                    </div>
                    <div class="form-group mb-2">
                        <label for="email"></label>
                        <input id="email" name="email" class="text-center" type="email" placeholder="Email">
                    </div>

                    <div class="form-group mb-0">
                        <label for="password"></label>
                        <input id="password" name="password" class="text-center" type="password" placeholder="Password">
                    </div>
                    <div class="form-group mb-2">
                        <label for="confirm_password"></label>
                        <input id="confirm_password" name="confirm_password" class="text-center" type="password"
                               placeholder="Confirm Password">
                    </div>
                    <div class="form-group mb-2">
                        <label for="zipcode"></label>
                        <input id="zipcode" name="zipcode" class="text-center" type="text" placeholder="Zicode">
                    </div>
                    <div class="form-group">
                        <button class="button photo-upload" type="button" id="picker">Upload Profile
                            Image</button>
                        <input type="hidden" name="fileupload" class="" id="fileupload">
                    </div>
                    <input type="submit" class="submit">
        </form>
    </div>
</div>
    </div>
</div>



    <jsp:include page="/WEB-INF/partials/scripts.jsp"/>
</body>
</html>
