<%-- 
    Document   : UpdateCate
    Created on : Mar 9, 2024, 9:16:22 PM
    Author     : admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Update category  </title>
        <%@include file="includes/head.jsp" %>
        <link rel="icon" href="images/update.png"
              type="images/x-icon"/>
        <style>
            .container {
                max-width: 400px;
                margin: 0 auto;
                padding: 20px;
                border: 1px solid #ccc;
                border-radius: 5px;
                box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
            }

            h3 {
                font-size: 1.5rem;
                margin-top: 20px;
            }

            p {
                margin-bottom: 10px;
            }

            form {
                text-align: center;
            }

            input[type="number"],
            input[type="text"],
            button {
                width: 100%;
                padding: 10px;
                margin-top: 10px;
                border: 1px solid #ccc;
                border-radius: 5px;
                box-sizing: border-box;
            }

            button {
                background-color: #007bff;
                color: #fff;
                font-size: 1rem;
                cursor: pointer;
            }

            button:hover {
                background-color: #0056b3;
            }

            .btn-info {
                margin-top: 20px;
            }


        </style>
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
                    <a class="nav-item nav-link" href="#">Add Category</a>
                </div>
            </div>
        </nav>
        <br>
        <div class="container">
            <h3 class="mt-3" style="text-align: center;">Update Category</h3>
            <form action="update-cate" class="text-center" method="post">
                <input type="number" name="cid" value="${cute.cid}" readonly><br>
                <input name="cname" value="${cute.cname}" type="text" class="form-control mb-2" placeholder="Enter Category Name">
                <button class="btn btn-info" type="submit">Submit</button>     
            </form>
        </div>
    </body>
</html>
