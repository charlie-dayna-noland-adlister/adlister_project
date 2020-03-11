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
                <h2>Title: ${ad.title}</h2>
                <h6>Review Average: ${ad.reviewAvr}</h6>
                <p>Description: ${ad.description}</p>
                <h6>Price: ${ad.price}</h6>
                <small>Date Posted: ${ad.datePosted}</small>
<%--                <p>Categories: ${ad.categoryIdList}</p>--%>
                <p>ID: ${ad.id}</p>
                <p>User ID: ${ad.userId}</p>
                <img src="${ad.imageText}" alt="ad-image"/>
                <button class="delete-button" id="delete-${ad.id}">DELETE</button>
            </div>
        </div>
        <div class="row">
            <div class="col-md-6">
                <p>Quantity Reported: ${ad.quantityReported}</p>
<%--                <p>Users Who Reported: ${ad.usersReportedList}</p>--%>
            </div>
        </div>
    </c:forEach>
</div>
<jsp:include page="../partials/body-scripts.jsp" />
</body>
</html>
