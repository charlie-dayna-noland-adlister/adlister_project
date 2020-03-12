<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <jsp:include page="./WEB-INF/partials/head.jsp">
        <jsp:param name="title" value="Adlister | Home" />
    </jsp:include>
    <style>
        <%@ include file="/WEB-INF/resources/CSS/custom.css" %>
    </style>
</head>
<body class="home-body">
    <div class="container d-flex flex-column justify-content-center align-items-center">
        <div class="text-center pb-4">
        <h1 class="welcome-head display-3">Welcome to <span>WhatTheJunk!</span> </h1>
            <h5 class="text-light"><em>Where your junk is someone's luck</em></h5>
        </div>

        <div class="d-inline-flex">
            <form action="/login" method="GET" class="pr-1 mb-1">
                <input type="submit" value="Login" id="login-btn">
            </form>
            <form action="/register" method="GET" class="pl-1 mb-1">
                <input type="submit" value="Register" id="register-btn">
            </form>
        </div>
        <a href="/ads" class="guest-continue">continue as guest</a>
    </div>



    <jsp:include page="/WEB-INF/partials/scripts.jsp" />
</body>
</html>
