$(document).ready(function () {


    loadCategories();
    loadBlogs();

    $('#submitCategory').click(function (event) {
        event.preventDefault();
        $.ajax({
            type: 'POST',
            url: 'Category',
            data: JSON.stringify({
                category: $('#addCategory').val()
            }),
            headers: {
                'Accept': 'application/json',
                'Content-Type': 'application/json'
            },
            'dataType': 'json'
        }).success(function (data, status) {
            $('#addCategory').val('');
            loadCategories();
        });
    });


});


function loadBlogs() {

    clearBlogTable();

    var blogTable = $('#blogRows');

    $.ajax({
        url: 'Blogs'
    }).success(function (data, status) {
        $.each(data, function (index, blog) {
            blogTable.append($('<tr>')
                    .append($('<td>')
                            .append($('<a>')
                                    .attr({
                                        'onClick': 'goToBlog(' + blog.blogId + ')',
                                        'data-blog-id': blog.blogId,
                                        'style': 'cursor:pointer'
                                    }).text(blog.blogTitle)
                                    )
                            )
                    .append($('<td>')
                            .append($('<input>')
                                    .attr({
                                        'type': 'checkbox',
                                        'id': 'blogPublished' + blog.blogId,
                                        'checked': blog.published,
                                        'onClick': 'publish(' + blog.blogId + ')',
                                        'data-blog-id': blog.blogId,
                                        'style': 'cursor:pointer'
                                    })
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
function clearCategoryTable() {
    $('#categoryRows').empty();
}

function loadCategories() {

    clearCategoryTable();

    var categoryTable = $('#categoryRows');

    $.ajax({
        url: 'Categories'
    }).success(function (data, status) {
        $.each(data, function (index, category) {
            categoryTable.append($('<tr>')
                    .append($('<td>')
                            .append($('<a>')
                                    .attr({
                                        'onClick': 'goToCategory(' + category.categoryId + ')',
                                        'data-blog-id': category.categoryId,
                                        'style': 'cursor:pointer'
                                    })
                                    .text(category.category)
                                    )
                            )
                    .append($('<td>')
                            .append($('<a>')
                                    .attr({
                                        'onClick': 'deleteCategory(' + category.categoryId + ')',
                                        'style': 'cursor:pointer'
                                    }).text('Delete')
                                    )
                            )
                    );
        });
    });

}

function deleteBlog(id) {
    var answer = confirm("Really delete this blog entry?");

    if (answer === true) {
        $.ajax({
            type: 'DELETE',
            url: 'Blog/' + id
        }).success(function () {
            loadBlogs();
        });
    }
}

function deleteCategory(id) {
    var answer = confirm("Really delete this category?");

    if (answer === true) {
        $.ajax({
            type: 'DELETE',
            url: 'Category/' + id
        }).success(function () {
            loadCategories();
        });
    }
}

function goToBlog(id) {
    $.ajax({
        type: 'GET',
        url: 'EachBlog/' + id
    }).success(function () {
        window.location.replace("EachBlog/" + id);
    });
}

function goToCategory(id) {

    window.location.replace("/Group3Capstone/EachBlog/cat?categoryId=" + id);
}


function clearBlogTable() {
    $('#blogRows').empty();
}


function publish(id){
    var status = document.getElementById('blogPublished'+id).checked;
    $.ajax({url: "publish/"+id+"/"+status});
}