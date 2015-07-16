<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <script src="${pageContext.request.contextPath}/js/jquery-1.11.1.min.js"></script>
        <script src="${pageContext.request.contextPath}/js/tinymce.min.js"></script>
        <script type ="text/javascript">
            tinymce.init({selector: "textarea#pageContent",
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
        <title>Index Page</title>
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
                    <li role="presentation"><a href="${pageContext.request.contextPath}/AddBlog">Add an Entry</a></li>
                    <!--<li role="presentation"><a href="${pageContext.request.contextPath}/ReadBlog">Sample Read Blog</a></li>-->
                    <li role="presentation"><a href="${pageContext.request.contextPath}/Admin1">Admin 1</a></li>
                    <li role="presentation"><a href="${pageContext.request.contextPath}/AdminStaticPage">Admin Static Page</a></li>
                    <c:forEach var = "page" items = "${staticPageList}">
                        <li role="presentation"><a href="${pageContext.request.contextPath}/ReadStaticPage/${page.staticPageId}">${page.pageTitle} </a></li>
                    </c:forEach>
                </ul>    
            </div>
            <div class="col-lg-9" class="container">
                <h1><i><b>Capstone Blog</b></i></h1>
                <hr/>
            </div>
            <div class="col-lg-3" class="container">

            </div>
            <hr />
            <div class="col-lg-9" class="container">

                <form method ="POST" action=""${pageContext.request.contextPath}/EditStaticPage/${staticPage.staticPageId}">

                    <input type="text" id="title" name ="title" value="${staticPage.pageTitle}">
                    <br/>

                    <textarea id ="pageContent" name = "pageContent" value=${staticPage.pageContent}></textarea>

                    <button type="submit"
                            id="editStaticPage"
                            class="btn btn-primary">
                        Submit Static Page
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
    <script src="${pageContext.request.contextPath}/js/editStaticPage.js"></script>

</body>
</html>

<!--add categories, tags, cancel, delete, save as draft, don't need menu on right for admin pages-->
