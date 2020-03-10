<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <jsp:include page="/WEB-INF/partials/head.jsp">
        <jsp:param name="title" value="Viewing All The Ads" />
    </jsp:include>
</head>
<body>
<jsp:include page="/WEB-INF/partials/navbar.jsp" />

<div class="container">
    <h1>Here Are all the ads!</h1>
    
    <c:forEach var="ad" items="${ads}">
        <div class="row">
            <div class="col-md-6">
                <h2>${ad.title}</h2>
                <h6>${ad.reviewAvr}</h6>
                <p>${ad.description}</p>
                <h6>${ad.price}</h6>
                <small>${ad.datePosted}</small>
                <p>${ad.categoryId}</p>
            </div>
        </div>
        <div class="row">
            <div class="col-md-6">
                <p>${ad.quantityReported}</p>
                <p>${ad.usersReported}</p>
            </div>
        </div>
    </c:forEach>
</div>

</body>
</html>
