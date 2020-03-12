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


    <div class="container">
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
                <input id="price" name="price" class="text-center" type="text" step="0.01" min="0" placeholder="Price">
            </div>
            <div class="form-group">
                <label for="categoryId"></label>
                <textarea id="categoryId" name="categoryId" class="" type="text" placeholder="Category"></textarea>
            </div>

            <div class="btn-group">
                <button class="btn btn-secondary btn-sm dropdown-toggle" type="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                    Choose categories...
                </button>
                <div class="dropdown-menu">
                    <div class="input-group mb-3">
                        <div class="input-group-prepend">
                            <div class="input-group-text">
                                <input type="checkbox" aria-label="Checkbox for following text input">
                            </div>
                        </div>
                        <input type="text" class="form-control" aria-label="tool" value="">
                    </div>
                </div>
            </div>

            <input type="submit" class="submit" value="Submit">
        </form>
    </div>


        <jsp:include page="/WEB-INF/partials/scripts.jsp"/>
</body>
</html>
