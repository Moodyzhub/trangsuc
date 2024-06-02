<%-- 
    Document   : CategoryList
    Created on : Mar 9, 2024, 3:09:19 PM
    Author     : admin
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>List Category</title>
        <%@include file="includes/head.jsp" %>
        <link rel="icon" href="images/categories.png"
              type="images/x-icon"/>
    </head>
    <body>
        <nav class="navbar navbar-expand-lg navbar-light bg-info">
            <a class="navbar-brand" href="home">Home</a>
            <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNavAltMarkup" aria-controls="navbarNavAltMarkup" aria-expanded="false" aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
            </button>
            <div class="collapse navbar-collapse" id="navbarNavAltMarkup">
                <div class="navbar-nav">
                    <a class="nav-item nav-link" href="list-cate">List Category</a>
                    <a class="nav-item nav-link" href="addCate.jsp">Add Category</a>
                </div>
            </div>
        </nav>

        <div class="container mt-4">
            <h3 class="text-center mb-4">Category List</h3>
            <table class="table">
                <thead style="background: #566787">
                    <tr>
                        <th scope="col">ID</th>
                        <th scope="col">Name</th>
                        <th scope="col">Actions</th>
                    </tr>
                </thead>
                <tbody style="background: #6dabe4">
                    <c:forEach items="${cate}" var="o">
                        <tr>
                            <td>${o. cid}</td>
                            <td>${o. cname}</td>
                            <td>
                                <a href="update-cate?id=${o.cid}" class="btn btn-primary mr-2">Update</a>
                                <a href="delete-cate?id=${o.cid}"class="btn btn-danger">Delete</a>
                            </td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
        </div>
    </body>
</html>
