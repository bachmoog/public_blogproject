<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <script src="${pageContext.request.contextPath}/js/jquery-1.11.1.min.js"></script>
        <script src="${pageContext.request.contextPath}/js/tinymce.min.js"></script>
        <script type ="text/javascript">
            tinymce.init({selector: "textarea#test",
                theme: "modern",
                width: 700,
                height: 300,
                plugins: [
                    "advlist autolink link image lists charmap print preview hr anchor pagebreak spellchecker",
                    "searchreplace wordcount visualblocks visualchars code fullscreen insertdatetime media nonbreaking",
                    "save table contextmenu directionality emoticons template paste textcolor"
                ],
                /*content_css: "css/content.css",*/
                toolbar: "insertfile undo redo | styleselect | bold italic | alignleft aligncenter alignright alignjustify | bullist numlist outdent indent | l      ink image | print preview media fullpage | forecolor backcolor emoticons",
                /*style_formats: [
                 {title: 'Bold text', inline: 'b'},
                 {title: 'Red text', inline: 'span', styles: {color: '#ff0000'}},
                 {title: 'Red header', block: 'h1', styles: {color: '#ff0000'}},
                 {title: 'Example 1', inline: 'span', classes: 'example1'},
                 {title: 'Example 2', inline: 'span', classes: 'example2'},
                 {title: 'Table styles'},
                 {title: 'Table row 1', selector: 'tr', classes: 'tablerow1'}
                 ]*/

            });
        </script>
        <title>Edit Blog</title>
        <!-- Bootstrap core CSS -->
        <link href="${pageContext.request.contextPath}/css/bootstrap.min.css" rel="stylesheet">

        <!-- SWC Icon -->
        <link rel="shortcut icon" href="${pageContext.request.contextPath}/img/icon.png">

    </head>
    <body style = "background-color: #91ceb7">

        <div style ="background-color: lightgray" class="container">
            <div class="navbar">
                <ul class="nav nav-pills">
                    <li role="presentation"><a href="${pageContext.request.contextPath}/mainPage">Home</a></li>
                    <!--<li role="presentation"><a href="${pageContext.request.contextPath}/">Log In</a></li>
                    <!--<li role="presentation"><a href="${pageContext.request.contextPath}/AddBlog">Add an Entry</a></li>-->
                    <!--<li role="presentation"><a href="${pageContext.request.contextPath}/ReadBlog">Sample Read Blog</a></li>-->
                    <li role="presentation"><a href="${pageContext.request.contextPath}/Admin1">Admin 1</a></li>
                    <li role="presentation"><a href="${pageContext.request.contextPath}/Admin2">Admin 2</a></li>
                        <c:forEach var = "page" items = "${staticPageList}">
                        <li role="presentation"><a href="${pageContext.request.contextPath}/ReadStaticPage/${page.staticPageId}">${page.pageTitle} </a></li>
                        </c:forEach>
                    <li role="presentation">
                        <a href="${pageContext.request.contextPath}/j_spring_security_logout">Log Out</a>
                    </li>
                </ul>    
            </div>
            <div class="col-lg-9" class="container">
                <h1><i><b>Capstone Blog</b></i></h1>
                <h3>Editing Post</h3>
                <hr/>
            </div>
            <div class="col-lg-3" class="container">

            </div>
            <hr />
            <div class="col-lg-9" class="container">


                <form method ="POST" action="${pageContext.request.contextPath}/EditBlog/${blog.blogId}">
                    <input type="text" id="title" name ="title" value ="${blog.blogTitle}">
                    <textarea id ="test" name = "text">${blog.content}</textarea>
                    <div id="catsandtags">
                        <div class ="col-xs-6" class="container">                         
                            Old Category(ies) for current blog...<br>
                            <c:forEach var = "cat" items = "${blog.catList}">
                                ${cat.category}, &nbsp;                                
                            </c:forEach>
                            <br>
                            <select size = 5  name = "category" multiple>
                                <c:forEach var = "category" items = "${categoryList}">
                                    <option value ="${category.categoryId}" selected>${category.category}</option>
                                </c:forEach>
                            </select>   


                        </div>
                        <div class="col-md-pull-6" class="container">

                            <input type="text" id="field1" name="hashTag" placeholder ="#" />
                            <button type ="button" id="addTag" class="btn btn-primary">Add Hashtag</button>

                            <br>



                            <textarea id="hashtags" name ="hashtags" rows="6" cols="35" readonly style="resize:none"><c:forEach 
                                    var = "tag" items = "${blog.hashList}">${tag.hashtag},</c:forEach></textarea>

                                <br>
                                <button type="button" id="removeTags" class="btn btn-primary">Remove Hashtags</button>
                            </div>

                        </div>
                        <button type="submit"
                                id="submitBlog"
                                class="btn btn-primary">
                            Edit Blog
                        </button>

                    </form>


                </div>
                <div class="col-lg-3" class="container">

                </div>


            </div>
            <footer>
                <p>
                <center>Created by: Mike, Jim and Andrew</center>
            </p>
        </footer>

        <!-- Placed at the end of the document so the pages load faster -->
        <script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>
    <script src="${pageContext.request.contextPath}/js/rights.js"></script>
    <script src="${pageContext.request.contextPath}/js/editBlog.js"></script>

</body>
</html>

<!--add categories, tags, cancel, delete, save as draft, don't need menu on right for admin pages-->
