$(document).ready(function () {
    loadEntries();
    loadCategories();

});


function loadEntries() {

    var bsColumn = $('#blogRows');
    $.ajax({
        url: 'home/getPosts'
    }).success(function (data, status) {
        $.each(data, function (index, blog) {

            var contentSnip = blog.content.substring(0, 250);

            bsColumn.append($('<div>').attr({
                'id': 'blogSnip' + blog.blogId,
                'class': 'row'})
                    .append($('<div>')
                            .attr({
                                'class': 'col-sm-3'
                            })
                            .text('Entry' + blog.blogId))
                    .append($('<div>')
                            .attr({
                                'class': 'col-sm-3',
                                'data-blog-id': blog.blogId,
                                'onClick': 'editEntry(' + blog.blogId + ')'
                            }).append($('<a>')
                            .attr({
                                'data-blog-id': blog.blogId
                            }).text('Edit')))
                    .append($('<div>')
                            .attr({
                                'class': 'col-sm-6',
                                'data-blog-id': blog.blogId,
                                'onClick': 'deleteEntry(' + blog.blogId + ')'
                            }).append($('<a>')
                            .attr({
                                'data-blog-id': blog.blogId
                            }).text('Delete')))
                    ).append($('<br>'));
        });
    });
}

function loadCategories() {

    var bsColumn = $('#categoryRows');
    $.ajax({
        url: 'home/getCategories'
    }).success(function (data, status) {
        $.each(data, function (index, blog) {

            var contentSnip = blog.content.substring(0, 250);

            bsColumn.append($('<div>').attr({
                'id': 'blogSnip' + blog.blogId,
                'class': 'row'})
                    .append($('<div>')
                            .attr({
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
                    ).append($('<br>'));
        });
    });
}


function editEntry(id) {
    alert('Edit: ' + id);
    var element = $(event.relatedTarget);
    var addressId = element.data('address-id');
    //PLACEHOLDER
    var modal = $(this);
    $.ajax({url: 'home/getBlog' + addressId}).success(function (address) {
        // go to Blog Add/Edit page
    });
};

function deleteEntry(id) {
    alert('Delete: ' + id);
}

