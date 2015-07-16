<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
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
                    <!--<li role="presentation"><a href="${pageContext.request.contextPath}/mainAjaxPage">Blog</a></li>-->
                    <li role="presentation">
                    <sec:authorize access="hasRole('ROLE_ADMIN')">
                        <a href="${pageContext.request.contextPath}/Admin1">Admin</a>
                    </sec:authorize>
                    </li>
                                        <!--<li role="presentation"><a href="${pageContext.request.contextPath}/Admin2">Admin 2</a></li>-->
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
                <hr/>
            </div>
            <div class="col-sm-9" class="container">
                <h3 align="center">
                    ${staticPage.pageTitle}
                </h3>
                <hr/>
                <p>
                    ${staticPage.pageContent}
                </p>
                <hr />
            </div>
            <div class="col-sm-3" class="container">
                <div id ="right-menu">
                    <div style="background-color: orange  ; width:275px;height:75px;border:1px solid #000;">

                        <button type="submit" id ="recentEntries" class="btn btn-default">Recent entries</button>
                        <!--                        <button type="submit" id="recentComments" class="btn btn-default">Recent Comments</button>-->
                        <button type="submit" id="tags" class="btn btn-default">Tags</button>
                        <!--                        <button type="submit" id="archives" class="btn btn-default">Archives</button>-->
                        <button type="submit" id="categories" class="btn btn-default">Categories</button>
                    </div>
                </div>
                <div id ="ajaxMenu" style="width:275px">
                    <br>
                </div>
            </div>

        </div>
        <footer>
            <p>
            <center>Created by: Mike, Jim and Andrew</center>
        </p>
    </footer>
    <!-- Placed at the end of the document so the pages load faster -->
    <script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>
    <script src="${pageContext.request.contextPath}/js/mainPage.js"></script>

</body>
</html>

