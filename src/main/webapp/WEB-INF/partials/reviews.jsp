
<%--    BLACK STAR: &#9733;--%>
<%--    WHITE STAR: &#9734;--%>

<!-- Button trigger modal -->
<div class="container">
<button type="button" class="btn btn-primary" data-toggle="modal" data-target="#exampleModal">
    Review This Ad
</button>

<!-- Modal -->
<div class="modal fade" id="exampleModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
    <div class="modal-dialog" role="document">
        <div class="modal-content">

            <div class="modal-header">
                <h5 class="modal-title" id="exampleModalLabel">Rate this Ad</h5>
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
            </div>

            <div class="modal-body">
                <form action="/ads/review" method="post">
                    <div class="form-group">
                        <%--                <label for="rating" class="gold">Rate this ad:</label>--%>
                        <select id="rating" name="rating">
                            <option value="0">
                                &#9734;
                                &#9734;
                                &#9734;
                                &#9734;
                                &#9734;
                            </option>
                            <option value="1">
                                &#9733;

                                &#9734;
                                &#9734;
                                &#9734;
                                &#9734;
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
                            <option value="5">
                                &#9733;
                                &#9733;
                                &#9733;
                                &#9733;
                                &#9733;
                            </option>
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

            <div class="modal-footer">
                <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
            </div>
        </div>
    </div>
</div>
</div>

<%--THIS MAY NEED TO BE REMOVED --%>
<jsp:include page="scripts.jsp" />


