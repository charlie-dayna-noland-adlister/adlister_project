<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <jsp:include page="partials/head.jsp">
        <jsp:param name="title" value="Register For Our Site!" />
    </jsp:include>
</head>
<body>
<jsp:include page="partials/navbar.jsp" />
<div class="container">
    <h1>Please fill in your information.</h1>
    <form action="/register/test" method="post">
        <div class="form-group">
            <label for="username">Username</label>
            <input id="username" name="username" class="form-control" type="text">
        </div>
        <div class="form-group">
            <label for="email">Email</label>
            <input id="email" name="email" class="form-control" type="text">
        </div>
        <div class="form-group">
            <label for="password">Password</label>
            <input id="password" name="password" class="form-control" type="password">
        </div>
        <div class="form-group">
            <label for="confirm_password">Confirm Password</label>
            <input id="confirm_password" name="confirm_password" class="form-control" type="password">
        </div>
        <div class="form-group">
            <button class="button" type="button" id="picker">Pick file</button>
            <input type="hidden" id="fileupload">
        </div>
<%--        <div class="box">--%>
<%--            <form id="pick-form">--%>
<%--                <div class="field">--%>
<%--                    <div class="control">--%>
<%--                        <button class="button" type="button" id="picker">Pick file</button>--%>
<%--                        <input type="hidden" id="fileupload">--%>
<%--                    </div>--%>
<%--                    <div class="control" id="nameBox"></div>--%>
<%--                    <div class="control" id="urlBox"></div>--%>
<%--                </div>--%>
<%--                <div class="field">--%>
<%--                    <div class="control">--%>
<%--                        <input class="button" type="submit" value="Submit">--%>
<%--                    </div>--%>
<%--                </div>--%>
<%--            </form>--%>
<%--        </div>--%>
        <input type="submit" class="btn btn-primary btn-block">
    </form>
</div>
<jsp:include page="partials/body-scripts.jsp" />
</body>
</html>
