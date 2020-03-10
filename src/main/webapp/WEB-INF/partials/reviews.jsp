<div class="container">
    <h1>Review Ad</h1>
    <form action="/ads/review" method="post">
        <%--        <div class="form-group">--%>
        <%--            <label for="title">Title</label>--%>
        <%--            <input id="title" name="title" class="form-control" type="text">--%>
        <%--        </div>--%>
        <div class="form-group">
            <label for="rating">Rate this ad:</label>
            <select id="rating" name="rating">
                <option value="0">
                    <i class="fas fa-star gray"></i>
                    <i class="fas fa-star gray"></i>
                    <i class="fas fa-star gray"></i>
                    <i class="fas fa-star gray"></i>
                    <i class="fas fa-star gray"></i>
                </option>
                <option value="1">
                    <i class="fas fa-star gold"></i>
                    <i class="fas fa-star gray"></i>
                    <i class="fas fa-star gray"></i>
                    <i class="fas fa-star gray"></i>
                    <i class="fas fa-star gray"></i>
                </option>
                <option value="2">
                    <i class="fas fa-star gold"></i>
                    <i class="fas fa-star gold"></i>
                    <i class="fas fa-star gray"></i>
                    <i class="fas fa-star gray"></i>
                    <i class="fas fa-star gray"></i>
                </option>
                <option value="3">
                    <i class="fas fa-star gold"></i>
                    <i class="fas fa-star gold"></i>
                    <i class="fas fa-star gold"></i>
                    <i class="fas fa-star gray"></i>
                    <i class="fas fa-star gray"></i>
                </option>
                <option value="4">
                    <i class="fas fa-star gold"></i>
                    <i class="fas fa-star gold"></i>
                    <i class="fas fa-star gold"></i>
                    <i class="fas fa-star gold"></i>
                    <i class="fas fa-star gray"></i>
                </option>
                <option value="5">
                    <i class="fas fa-star gold"></i>
                    <i class="fas fa-star gold"></i>
                    <i class="fas fa-star gold"></i>
                    <i class="fas fa-star gold"></i>
                    <i class="fas fa-star gold"></i>
                </option>
                <%--                <i class="fas fa-star"></i>--%>
            </select>
        </div>
        <div class="form-group">
            <label for="reviewText">Review Ad:</label>
            <textarea id="reviewText" name="reviewText" class="form-control" type="text"></textarea>
        </div>
        <div class="form-group">
            <button class="button" type="button" id="picker">Upload Image</button>
            <input type="hidden" name="fileupload" id="fileupload">
<%--            should i change this name/id to "imageText"?--%>
        </div>
        <input type="submit" class="btn btn-block btn-primary">
    </form>
</div>

