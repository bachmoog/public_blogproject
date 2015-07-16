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
                    <li role="presentation"><a href="${pageContext.request.contextPath}/">Home</a></li>
                    <li role="presentation"><a href="${pageContext.request.contextPath}/">Log In</a></li>
                    <li role="presentation"><a href="${pageContext.request.contextPath}/Author">About the Author</a></li>
                    <li role="presentation"><a href="${pageContext.request.contextPath}/AddBlog">Add an Entry</a></li>
                    <li role="presentation"><a href="${pageContext.request.contextPath}/ReadBlog">Sample Read Blog</a></li>
                    <li role="presentation"><a href="${pageContext.request.contextPath}/Admin1">Admin 1</a></li>
                    <li role="presentation"><a href="${pageContext.request.contextPath}/Admin2">Admin 2</a></li>
                </ul>    
            </div>
            <div class="col-lg-9" class="container">
                <h1><i><b>Capstone Blog</b></i></h1>
                <hr/>
            </div>
            <div class="col-lg-3" class="container">

            </div>
            <hr />

            <div class="row">
                <div class="container col-lg-7">



                    <div id="blogSnips" class="">
                    </div>



                </div>
                <div class="container col-lg-5">

                    <div class="">
                        <div style="background-color: lightslategrey ; width:280px;height:100px;border:1px solid #000;">
                            <div class="row">
                                <a href ="${pageContext.request.contextPath}/recentEntries" class="col-lg-5">Recent entries</a>                            
                                <a href ="${pageContext.request.contextPath}/recentComments" class="col-lg-7">Recent Comments</a>                            
                            </div>
                            <div class="row">
                                <a href ="${pageContext.request.contextPath}/tags" class="col-lg-5">Tags</a>                            
                                <a href ="${pageContext.request.contextPath}/archives" class="col-lg-7">Archives</a>                            
                            </div>
                            <div class="row">
                                <a href ="${pageContext.request.contextPath}/categories" class="col-lg-9">Categories</a>                            
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <footer>


            <p align="center">   Created by: Mike, Jim and Andrew</p>
        </footer>
        <!-- Placed at the end of the document so the pages load faster -->
        <!--<script src="${pageContext.request.contextPath}/js/jquery-1.11.1.min.js"></script>-->
        <script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>
        <script src="${pageContext.request.contextPath}/js/blog.js"></script>

</body>
</html>

