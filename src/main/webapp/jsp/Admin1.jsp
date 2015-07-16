<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <script src="${pageContext.request.contextPath}/js/jquery-1.11.1.min.js"></script>

        <title>Admin 1</title>
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
                    <!--<li role="presentation"><a href="${pageContext.request.contextPath}/">Log In</a></li>-->
                    <li role="presentation"><a href="${pageContext.request.contextPath}/AddBlog">Add an Entry</a></li>
                    <!--<li role="presentation"><a href="${pageContext.request.contextPath}/ReadBlog">Sample Read Blog</a></li>-->
                    <li role="presentation"><a href="${pageContext.request.contextPath}/Admin1">Admin 1</a></li>
                    <!--<li role="presentation"><a href="${pageContext.request.contextPath}/Admin2">Admin2</a></li>-->
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

            <div class="col-lg-6" class="container">
                <a href ="${pageContext.request.contextPath}/AddBlog"><p>Add New Blog</p></a>
                <table id="blogTable" class="table table-hover">
                    <tr>
                        <th width="30%">Title</th>
                        <th width="20%">Publish</th>
                        <th width="20%">Edit</th>
                        <th width="30%">Delete</th>

                    </tr>
                    <tbody id="blogRows"></tbody>
                </table>
            </div>
            <div class="col-lg-6" class="container">
                <form method ="PUT" name ="Category">
                    <input type ="text"
                           id="addCategory"
                           placeholder="Category"/>
                    <button type="submit"
                            id="submitCategory"
                            class="btn-default">
                        Add
                    </button>
                </form>

                <table id="categoryTable" class="table table-hover">
                    <tr>
                        <th width="50%">Category</th>
                        <th width="50%">Delete</th>

                    </tr>
                    <tbody id="categoryRows"></tbody>
                </table>
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

</body>
</html>
