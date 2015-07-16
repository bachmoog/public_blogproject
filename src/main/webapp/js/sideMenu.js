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
//        url: "/Blogs"
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
