$(document).ready(function () {

    loadStaticPages();

});

function loadStaticPages() {

    clearStaticPageTable();

    var staticPageTable = $('#staticPageRows');

    $.ajax({
        url: 'StaticPages'
    }).success(function (data, status) {
        $.each(data, function (index, staticPage) {
            staticPageTable.append($('<tr>')
                    .append($('<td>')
                            .append($('<a>')
                                    .attr({
                                        'onClick': 'goToStaticPage(' + staticPage.staticPageId + ')',
                                        'data-staticPage-id': staticPage.staticPageId,
                                        'style': 'cursor:pointer'
                                    }).text(staticPage.pageTitle)
                                    )
                            )
                    .append($('<td>')
                            .append($('<a>')
                                    .attr({
                                        'data-staticPage-id': staticPage.staticPageId,
                                        'href': 'EditStaticPage/' + staticPage.staticPageId + '',
//                                        'data-toggle': 'modal',
//                                        'data-target': '#editModal',
                                        'style': 'cursor:pointer'
                                    }).text('Edit')
                                    )
                            )
                    .append($('<td>')
                            .append($('<a>')
                                    .attr({
                                        'onClick': 'deleteStaticPage(' + staticPage.staticPageId + ')',
                                        'style': 'cursor:pointer'
                                    }).text('Delete')
                                    )
                            )
                    );
        });
    });
}


function deleteStaticPage(id) {
    var answer = confirm("Really delete this static page?");

    if (answer === true) {
        $.ajax({
            type: 'DELETE',
            url: 'StaticPage/' + id
        }).success(function () {
            loadStaticPages();
        });
    }
}


function goToStaticPage(id) {
    $.ajax({
        type: 'GET',
        url: 'ReadStaticPage/' + id
    }).success(function () {
        window.location.replace("ReadStaticPage/" + id);
    });
}


function clearStaticPageTable() {
    $('#staticPageRows').empty();
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
