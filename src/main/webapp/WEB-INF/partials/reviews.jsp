<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <jsp:include page="/WEB-INF/partials/head.jsp">
        <jsp:param name="title" value="Create a New Review" />
    </jsp:include>
    <%--    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.9.0/css/all.css">--%>
    <style><%@include file="/WEB-INF/css/style.css"%></style>
</head>
<body>
<jsp:include page="/WEB-INF/partials/navbar.jsp" />
<div class="container">
    <h1>Review an Ad</h1>
    <form action="/ads/review" method="post">
        <%--        <div class="form-group">--%>
        <%--            <label for="title">Title</label>--%>
        <%--            <input id="title" name="title" class="form-control" type="text">--%>
        <%--        </div>--%>
        <div class="form-group">
            <label for="rating">Rate this ad:</label>
            <select id="rating" name="rating">
                <option value="0">0</option>
                <option value="1">*</option>
                <option value="2">**</option>
                <option value="3">***</option>
                <option value="4">****</option>
                <option value="5">*****</option>
                <%--                <i class="fas fa-star"></i>--%>
            </select>
        </div>
        <div class="form-group">
            <label for="reviewText">Review this ad:</label>
            <textarea id="reviewText" name="reviewText" class="form-control" type="text"></textarea>
        </div>
        <div class="form-group">
            <button class="button" type="button" id="picker">Upload Image</button>
            <input type="hidden" name="fileupload" id="fileupload">
        </div>
        <input type="submit" class="btn btn-block btn-primary">
    </form>
</div>
</body>
</html>
