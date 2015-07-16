<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <script src="${pageContext.request.contextPath}/js/jquery-1.11.1.min.js"></script>

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
                    <!--<li role="presentation"><a href="${pageContext.request.contextPath}/">Log In</a></li>-->
                    <li role="presentation"><a href="${pageContext.request.contextPath}/AddBlog">Add an Entry</a></li>
<!--                    <li role="presentation"><a href="${pageContext.request.contextPath}/ReadBlog">Sample Read Blog</a></li>-->
                    <li role="presentation"><a href="${pageContext.request.contextPath}/Admin1">Admin 1</a></li>
                    <!--<li role="presentation"><a href="${pageContext.request.contextPath}/Admin2">Admin 2</a></li>-->
                    <li role="presentation"><a href="${pageContext.request.contextPath}/AdminStaticPage">Admin Static Page</a></li>
                    <c:forEach var = "page" items = "${staticPageList}">
                        
                        
                        <li role="presentation"><a href="${pageContext.request.contextPath}/ReadStaticPage/${page.staticPageId}">${page.staticPageId} </a></li>
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

            <div class="col-lg-6" class="container">
                <a href ="${pageContext.request.contextPath}/CreateStaticPage"><p>Create New Static Web Page</p></a>
                <table id="staticPageTable" class="table table-hover">
                    <tr>
                        <th width="40%">Title</th>
                        <th width="30%">Edit</th>
                        <th width="30%">Delete</th>

                    </tr>
                    <tbody id="staticPageRows"></tbody>
                </table>
            </div>
                <div class="col-lg-6" class="container">
                    
                </div>
        <footer>
            <p>
            <center>Created by: Mike, Jim and Andrew</center>
        </p>
    </footer>

    <!-- Placed at the end of the document so the pages load faster -->
    <script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>
    <script src="${pageContext.request.contextPath}/js/adminStaticPage.js"></script>

</body>
</html>
