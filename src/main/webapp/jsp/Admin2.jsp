<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <script src="${pageContext.request.contextPath}/js/jquery-1.11.1.min.js"></script>

        <title>Admin 2</title>
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
                    <li role="presentation"><a href="${pageContext.request.contextPath}/Admin2">Admin 2</a></li>
                    <li role="presentation"><a href="${pageContext.request.contextPath}/AdminStaticPage">Admin Static Page</a></li>
                    <c:forEach var = "page" items = "${staticPageList}">
                        <li role="presentation"><a href="${pageContext.request.contextPath}/ReadStaticPage/${page.staticPageId}">${page.pageTitle} </a></li>
                    </c:forEach>
                    <li role="presentation"><a href="${pageContext.request.contextPath}/j_spring_security_logout">Log Out</a></li>
                </ul>    
            </div>
            <div class="col-lg-9" class="container">
                <h1><i><b>Capstone Blog</b></i></h1>
                <hr/>
            </div>
            <div class="col-lg-3" class="container">

            </div>
            <hr />
            <div class="col-lg-12" class="container">
                <p>Saved Drafts</p>
                <table id="savedTable" class="table table-hover">
                    <tr>
                        <th width="20%">Publish</th>
                        <th width="40%">Saved entries</th>
                        <th width="30%">Edit Draft</th>
                        <th width="30%">Delete Draft</th>

                    </tr>
                    <tbody id="savedRows"></tbody>
               </table>
            </div>
            <!--<div class="col-lg-6" class="container">
                <p>Marketer submissions awaiting approval</p>
                <table id="marketerTable" class="table table-hover">
                    <tr>
                        <th width="10%">Approved</th>
                        <th width="10%">Published</th>
                        <th width="28%">Title</th>
                        <th width="26%">Edit</th>
                        <th width="26%">Delete</th>

                    </tr>
                    <tbody id="marketerRows"></tbody>
                </table>

            </div>-->


        </div>
        <footer>
            <p>
            <center>Created by: Mike, Jim and Andrew</center>
        </p>
    </footer>

    <!-- Placed at the end of the document so the pages load faster -->
    <script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>
    <script src="${pageContext.request.contextPath}/js/admin2.js"></script>

</body>
</html>

<!--add categories, tags, cancel, delete, save as draft, don't need menu on right for admin pages-->
