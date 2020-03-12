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
        <jsp:include page="/WEB-INF/partials/navbar/navbar.jsp"/>

    <div class="container text-center">
        <h1 class="text-light">Welcome, ${sessionScope.user.username}!</h1>
    </div>



        <jsp:include page="/WEB-INF/partials/scripts.jsp"/>
</body>
</html>
