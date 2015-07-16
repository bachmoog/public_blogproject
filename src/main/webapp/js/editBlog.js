$(document).ready(function () {
    $('#submitBlog').click(function (event) {
        homeFromEdit();
    });
});

function homeFromEdit() {
    window.location.replace("/mainPage");
}