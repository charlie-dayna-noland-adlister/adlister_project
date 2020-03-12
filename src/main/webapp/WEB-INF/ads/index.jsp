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

<div class="container">
    <h1 class="text-light">All ads!</h1>
        <div class="row row-cols-1 row-cols-md-3">
            <c:forEach var="ad" items="${ads}">
                <div class="col mb-4">
                    <div class="card">
                        <img src="${ad.imageText}" class="card-img-top" alt="ad-image">
                        <div class="card-body">
                                <h5 class="card-title">${ad.title}</h5>
                                <p class="card-text">${ad.description}</p>
                                <small>Price: $${ad.price}</small>
                        </div>
                        <div class="card-footer text-center">
                            <small class="text-light">Rating</small>
                        </div>

                        <!-- Button trigger modal -->
                        <div class="text-center m-2">
                        <button type="button" class="learn-btn py-0 mb-2" data-toggle="modal"
                                data-target="#modal-${ad.id}">Learn more</button>
                        </div>
                        <!-- Modal -->
                        <div class="modal fade" id="modal-${ad.id}" tabindex="-1" role="dialog"
                             aria-labelledby="exampleModalLongTitle" aria-hidden="true">
                            <div class="modal-dialog modal-dialog-centered" role="document">
                                <div class="modal-content">
                                    <div class="modal-header border-0 py-1">
                                        <h5 class="modal-title" id="exampleModalLongTitle">${ad.title}</h5>
                                        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                                            <span>&times;</span>
                                        </button>
                                    </div>
                                    <div class="modal-body pt-0">
                                        <div class="row">
                                            <div class="col br-1 px-0 modal-image">
                                                    <img src="https://previews.123rf.com/images/zurijeta/zurijeta1701/zurijeta170101294/70642941-kid-working-on-computer.jpg" class="ad-image" alt="ad-image">
                                            </div>
                                            <div class="col modal-desc-container d-flex flex-column justify-content-center align-items-center">
                                                <div class="modal-desc text-center">
                                                    <p class="card-text m-1">${ad.description}</p>
                                                    <small class="text-center">Price: $${ad.price}</small>
                                                </div>
                                                <div class="pb-3 pt-5">
                                                    <input type="button" class="contact text-light"
                                                           value="Contact user">
                                                </div>
                                            </div>
                                        </div>

                                    </div>
                                </div>
                            </div>
                        </div>

                    </div>
                </div>
            </c:forEach>
        </div>
</div>
<%--<div class="container">--%>
<%--    <h1>Here Are all the ads!</h1>--%>
<%--    --%>
<%--    <c:forEach var="ad" items="${ads}">--%>
<%--        <div class="row">--%>
<%--            <div class="col-md-6">--%>
<%--                <h2>Title: ${ad.title}</h2>--%>
<%--                <h6>Review Average: ${ad.reviewAvr}</h6>--%>
<%--                <p>Description: ${ad.description}</p>--%>
<%--                <h6>Price: ${ad.price}</h6>--%>
<%--                <small>Date Posted: ${ad.datePosted}</small>--%>
<%--&lt;%&ndash;                <p>Categories: ${ad.categoryIdList}</p>&ndash;%&gt;--%>
<%--                <p>ID: ${ad.id}</p>--%>
<%--                <p>User ID: ${ad.userId}</p>--%>
<%--                <img src="${ad.imageText}" alt="ad-image"/>--%>
<%--            </div>--%>
<%--        </div>--%>
<%--        <div class="row">--%>
<%--            <div class="col-md-6">--%>
<%--                <p>Quantity Reported: ${ad.quantityReported}</p>--%>
<%--&lt;%&ndash;                <p>Users Who Reported: ${ad.usersReportedList}</p>&ndash;%&gt;--%>
<%--            </div>--%>
<%--        </div>--%>
<%--    </c:forEach>--%>
<%--</div>--%>

<jsp:include page="/WEB-INF/partials/scripts.jsp"/>
</body>
</html>
