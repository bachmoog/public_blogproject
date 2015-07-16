$(document).ready(function () {


    $('#recentEntries').click(function (event) {
        event.preventDefault();
        clearAjaxMenu();
        loadBlogTitles();

    });

    $('#tags').click(function (event) {
        event.preventDefault();
        clearAjaxMenu();
        loadBlogTags();
    });

    $('#archives').click(function (event) {
        event.preventDefault();

        $.ajax({
            type: 'GET',
            url: '/home/getArchives'
        });
    });

    $('#categories').click(function (event) {
        event.preventDefault();
        clearAjaxMenu();
        loadBlogCategories();
    });

});

function loadBlogTitles() {
    $.ajax({
        url: "/Group3Capstone/PubBlogs"
    }).success(function (data, status) {
        fillMenuTitles(data, status);
    });

}

function loadBlogCategories() {
    $.ajax({
        url: "/Group3Capstone/Categories"
    }).success(function (data, status) {
        fillCategories(data, status);
    });
}

function loadBlogTags() {
    $.ajax({
        url: "/Group3Capstone/Hashtags"
    }).success(function (data, status) {
        fillHashtags(data, status);
    });
}

function fillHashtags(tagList, status) {
    clearAjaxMenu();

    var aMenu = $('#ajaxMenu');

    $.each(tagList, function (index, hashtag) {
        aMenu.append($('<a>')
                .attr({
                    'onClick': 'goToHashtag(' + hashtag.hashtagId + ')',
                    'data-hashtag-id': hashtag.hashtagId,
                    'style': 'cursor:pointer'
                }).text(hashtag.hashtag).prepend('#').append('  ')
                );
    });
}

function fillCategories(catList, status) {
    clearAjaxMenu();

    var aMenu = $('#ajaxMenu');

    $.each(catList, function (index, category) {
        aMenu.append($('<a>')
                .attr({
                    'onClick': 'goToCategory(' + category.categoryId + ')',
                    'data-category-id': category.categoryId,
                    'style': 'cursor:pointer'
                }).text(category.category).append($('<br>'))
                );
    });
}

function fillMenuTitles(blogList, status) {
    clearAjaxMenu();

    var aMenu = $('#ajaxMenu');

//    $.ajax({
//        url: "/PubBlogs"
//    }).success(function (data, status) {
    $.each(blogList, function (index, blog) {
        aMenu.append($('<a>')
                .attr({
                    'onClick': 'goToBlog(' + blog.blogId + ')',
                    'data-blog-id': blog.blogId,
                    'style': 'cursor:pointer'
                }).text(blog.blogTitle).append($('<br>'))
                );
    });
//    });
}




function clearAjaxMenu() {
    $('#ajaxMenu').empty();
}

function goToBlog(id) {
    window.location.replace("/Group3Capstone/EachBlog/" + id);

}

function goToCategory(id) {
    window.location.replace("/Group3Capstone/EachBlog/cat?categoryId=" + id);
}

function goToHashtag(id) {
    window.location.replace("/Group3Capstone/EachBlog/tag?hashtagId=" + id);
}



function tagSearch() {

}
