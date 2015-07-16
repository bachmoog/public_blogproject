$(document).ready(function () {
    loadSavedDrafts();
    loadMarketingBlogs();

});

function loadSavedDrafts() {

    clearBlogTable();

    var blogTable = $('#savedRows');

    $.ajax({
        url: 'SavedDrafts'
    }).success(function (data, status) {
        $.each(data, function (index, blog) {
            blogTable.append($('<tr>')
                    .append($('<td>')
                            .append($('<input>')
                                    .attr({
                                        'type': 'checkbox',
                                        'id': 'blogPublished' + blog.blogId,
                                        'onClick': 'publish(' + blog.blogId + ')',
                                        'data-blog-id': blog.blogId,
                                        'style': 'cursor:pointer'
                                    })
                                    )
                            )
                    .append($('<td>')
                            .append($('<a>')
                                    .attr({
                                        'onClick': 'publish(' + blog.blogId + ')',
                                        'data-blog-id': blog.blogId,
                                        'style': 'cursor:pointer'
                                    }).text(blog.blogTitle)
                                    )
                            )
                    .append($('<td>')
                            .append($('<a>')
                                    .attr({
                                        'data-blog-id': blog.blogId,
                                        'href': 'EditBlog/' + blog.blogId + '',
//                                        'data-toggle': 'modal',
//                                        'data-target': '#editModal',
                                        'style': 'cursor:pointer'
                                    }).text('Edit')
                                    )
                            )
                    .append($('<td>')
                            .append($('<a>')
                                    .attr({
                                        'onClick': 'deleteBlog(' + blog.blogId + ')',
                                        'style': 'cursor:pointer'
                                    }).text('Delete')
                                    )
                            )
                    );
        });
    });
}


function clearBlogTable() {
    
}


