$(document).ready(function () {
    loadBlogSnippets();

});


function loadBlogSnippets() {

    var bsColumn = $('#blogSnips');
    $.ajax({
        url: 'home/getPosts'
    }).success(function (data, status) {
        $.each(data, function (index, blog) {
            
            var contentSnip = blog.content.substring(0,250);
            
            bsColumn.append($('<div>').attr({
                'id': 'blogSnip' + blog.blogId,
                'class': 'row'})
                    .append($('<div>')
                            .attr({
                                'id': 'blogSnip' + blog.blogId + '_title',
                                'class': 'col-sm-2'
                            })
                            .append($('<a>')
                                    .attr({
                                        'data-blog-id': blog.blogId
                                    }).text('Title' + blog.blogId)))
                    .append($('<div>')
                            .attr({
                                'id': 'blogSnip' + blog.blogId + '_author',
                                'class': 'col-sm-2'
                            }).append($('<a>')
                            .attr({
                                'data-contact-id': blog.blogId
                            }).text('Author:' + blog.userId)))
                    .append($('<div>')
                            .attr({
                                'id': 'blogSnip' + blog.blogId + '_cat',
                                'class': 'col-sm-offset-4 col-sm-2'
                            }).text('Category12345:'))
                    .append($('<div>').attr({'class': 'row'})
                            .append($('<div>')
                                    .attr({
                                        'id': 'blogSnip' + blog.blogId + '_content',
                                        'class': 'col-sm-9'
                                    }).text(contentSnip)))

                    .append($('<div>').attr({'class': 'row'})
                            .append($('<a>')
                                    .attr({
                                        'data-contact-id': blog.blogId,
                                        'class': 'col-sm-9'
                                    }).text('Continue')))
                    ).append($('<br>'))
        })
    })
}