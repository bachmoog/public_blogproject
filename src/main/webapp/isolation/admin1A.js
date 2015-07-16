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
            $("#blog" + index + "_title").text(blog.blogId);
        });
    });
}

function editEntry(id) {
    $.ajax({url: 'home/getPosts'}).success(function (data, status) {
        // go to Blog Add/Edit page
        var entry = data[id-1];
        //editContent = "aksjdfls";
        
    });
};

function deleteEntry(id) {
    alert('Delete: ' + id);
}

