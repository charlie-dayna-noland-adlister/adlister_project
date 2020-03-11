<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <jsp:include page="/WEB-INF/partials/head.jsp">
        <jsp:param name="title" value="Your Profile" />
    </jsp:include>

        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.9.0/css/all.css">

    <style>
        <%@include file="/WEB-INF/resources/CSS/custom.css"%>
    </style>
</head>
<body>
<jsp:include page="/WEB-INF/partials/navbar.jsp" />

<div class="container">
<%--    BLACK STAR: &#9733;--%>
<%--    BLANK STAR: &#9734;--%>
</div>
    <div class="container">
        <h1>Review ${sessionScope.ad.title} Below:</h1>
        <form action="/ads/review" method="post">
            <%--        <div class="form-group">--%>
            <%--            <label for="title">Title</label>--%>
            <%--            <input id="title" name="title" class="form-control" type="text">--%>
            <%--        </div>--%>
            <div class="form-group">
                <label for="rating" class="gold">Rate this ad:</label>
                <select id="rating" name="rating">
                    <option value="0" class="gray">
                        &#9734;
                        &#9734;
                        &#9734;
                        &#9734;
                        &#9734;

<%--                        <img src="/WEB-INF/resources/IMG/grayStar.png" alt="">--%>
<%--                        <img src="/WEB-INF/resources/IMG/grayStar.png" alt="">--%>
<%--                        <img src="/WEB-INF/resources/IMG/grayStar.png" alt="">--%>
<%--                        <img src="/WEB-INF/resources/IMG/grayStar.png" alt="">--%>
<%--                        <img src="/WEB-INF/resources/IMG/grayStar.png" alt="">--%>
                    </option>
                    <option value="1">
                        &#9733;

                        &#9734;
                        &#9734;
                        &#9734;
                        &#9734;
<%--                        <i class="fas fa-star gold"></i>--%>
<%--                        <i class="fas fa-star gray"></i>--%>
<%--                        <i class="fas fa-star gray"></i>--%>
<%--                        <i class="fas fa-star gray"></i>--%>
<%--                        <i class="fas fa-star gray"></i>--%>
                    </option>
                    <option value="2">
                        &#9733;
                        &#9733;

                        &#9734;
                        &#9734;
                        &#9734;
                    </option>
                    <option value="3">
                        &#9733;
                        &#9733;
                        &#9733;

                        &#9734;
                        &#9734;
                    </option>
                    <option value="4">
                        &#9733;
                        &#9733;
                        &#9733;
                        &#9733;

                        &#9734;
                    </option>
                    <option value="5" class="gold">
                        &#9733;
                        &#9733;
                        &#9733;
                        &#9733;
                        &#9733;
                    </option>
                    <%--                <i class="fas fa-star"></i>--%>
                </select>
            </div>
            <div class="form-group">
                <label for="reviewText">Review Ad:</label>
                <textarea id="reviewText" name="reviewText" class="form-control"></textarea>
            </div>
            <div class="form-group">
                <button class="button" type="button" id="picker">Upload Image</button>
                <input type="hidden" name="fileupload" id="fileupload">
                <%--            should i change this name/id to "imageText"?--%>
            </div>
            <input type="submit" class="btn btn-block btn-primary">
        </form>
    </div>


