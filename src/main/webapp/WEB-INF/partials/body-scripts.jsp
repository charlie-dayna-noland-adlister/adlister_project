<script>src="resources/js/keys.js"</script>
<script src="https://static.filestackapi.com/filestack-js/3.x.x/filestack.min.js"></script>
<script>
    let deleteButtonClass = document.querySelectorAll(".delete-button");
    deleteButtonClass.forEach(button => {
        button.addEventListener("click", function() {
            console.log("DELETED?");
            let idSplit = this.getAttribute("id").split("-");
            let adId = idSplit[1];
            fetch('http://localhost:8080/ads?id=' + adId, {
                method: 'DELETE',
            })
                .then(res => {
                    console.log("DELETED?");
                    location.reload(true);
                })
        })
    })

    //delete review
    let deleteReviewButtonClass = document.querySelectorAll(".delete-review-button");
    deleteReviewButtonClass.forEach(button => {
        button.addEventListener("click", function() {
            let idSplit = this.getAttribute("id").split("-");
            let reviewId = idSplit[1];
            fetch('http://localhost:8080/reviews?id=' + reviewId, {
                method: 'DELETE',
            })
                .then(res => {
                    location.reload(true);
                })
        })
    })

    // Set up the picker
    const client = filestack.init(FILESTACK_API_KEY);
    const options = {
        onUploadDone: updateForm,
        maxSize: 10 * 1024 * 1024,
        accept: 'image/*',
        uploadInBackground: false,
    };
    const picker = client.picker(options);

    // Get references to the DOM elements

    const form = document.getElementById('pick-form');
    const fileInput = document.getElementById('fileupload');
    const btn = document.getElementById('picker');
    const nameBox = document.getElementById('nameBox');
    const urlBox = document.getElementById('urlBox');

    // Add our event listeners

    btn.addEventListener('click', function (e) {
        e.preventDefault();
        picker.open();
    });


    function updateForm (result) {
        const fileData = result.filesUploaded[0];
        fileInput.value = fileData.url; //this is the good part
        console.log(fileData.url);
        console.log(fileInput.value);
    };
</script>