<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <jsp:include page="/WEB-INF/partials/head.jsp">
        <jsp:param name="title" value="Adlister | Home"/>
    </jsp:include>
    <style>
        <%@ include file="/WEB-INF/resources/CSS/custom.css" %>
    </style>
</head>
<body>
<jsp:include page="/WEB-INF/partials/navbar/navbar.jsp"/>


<div class="container d-flex justify-content-center align-items-center">
    <div class="container create-container text-center">
        <div class="row">
            <div class="col">
                <h1 class="text-light">Create a new Ad</h1>
                <form action="/ads/create" method="post">
                    <div class="form-group m-0">
                        <label for="title"></label>
                        <input id="title" name="title" class="text-center" type="text" placeholder="Title">
                    </div>
                    <div class="form-group m-0">
                        <label for="description"></label>
                        <textarea id="description" name="description" class="text-center mb-0" type="text"
                                  placeholder="Type out your ads description"></textarea>
                    </div>
                    <div class="form-group">
                        <label for="price"></label>
                        <input id="price" name="price" class="text-center" type="text" step="0.01" min="0"
                               placeholder="Price">
                    </div>
<%--                    <div class="form-group">--%>
<%--                        <label for="categoryId"></label>--%>
<%--                        <textarea id="categoryId" name="categoryId" class="" type="text"--%>
<%--                                  placeholder="Category"></textarea>--%>
<%--                    </div>--%>
                    <div class="form-group">
                        <button class="button photo-upload" type="button" id="picker">Upload Profile
                            Image</button>
                        <input type="hidden" name="fileupload" class="" id="fileupload">
                    </div>
                    <div class="dropdown-container">
                        <jsp:include page="../partials/dropdown.jsp" />
                    </div>

                    <input type="submit" class="submit" value="Submit">
                </form>
            </div>
        </div>
    </div>
</div>

<jsp:include page="/WEB-INF/partials/scripts.jsp"/>
<jsp:include page="/WEB-INF/partials/body-scripts.jsp"/>
</body>
</html>
