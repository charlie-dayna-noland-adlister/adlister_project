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

    <div class="container d-flex justify-content-center align-items-center text-light">
        <h1>Welcome, ${sessionScope.user.username}!</h1>
<%--        <img src="${sessionScope.user.}" alt="">--%>
    </div>

    
    <jsp:include page="/WEB-INF/partials/scripts.jsp"/>
</body>
</html>
