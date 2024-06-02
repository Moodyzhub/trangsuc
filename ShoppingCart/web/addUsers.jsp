<%-- 
    Document   : addUsers
    Created on : Jan 26, 2024, 3:39:04 PM
    Author     : admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Add Users</title>
        <%@include file="includes/head.jsp" %>
        <link rel="stylesheet" href="css/main.css"/>
        <style>
            .container{
                display: flex;
                justify-content: center;
                align-items: center;
                flex-direction: column;
            }
            .container form{
                width: 500px;
                padding: 20px;
                border-radius: 10px;
                box-shadow: 0 4px 8px 0 rgba(0,0,0,0.2),0 6px 20px 0 rgba(0,0,0,0.19)
            }

        </style>
    </head>
    <body>
        <%@include file="includes/nav.jsp"%>
        <div class="container">
            <h3 class="text-center">Add Users</h3>
            <hr>
            <form action="add-user" method="post">
                <div class="form-group">
                    <label for="exampleInputName">Name</label>
                    <input type="text" name="name" class="form-control" id="exampleInputName" placeholder="Name">   
                </div>
                <div class="form-group">
                    <label for="exampleInputEmail1">Email address</label>
                    <input type="email" name="email" class="form-control" id="exampleInputEmail1" placeholder="Email" required>   
                </div>
                <div class="form-group">
                    <label for="exampleInputPassword1">Password</label>
                    <input type="password" name="pass" class="form-control" id="exampleInputPassword1" placeholder="Pass">
                </div>
                <div class="form-group">
                    <label for="exampleInputCountry">Country</label>
                    <input type="text" name="country" class="form-control" id="exampleInputCountry" placeholder="Country">
                </div>
                <div class="form-group">
                    <label for="exampleInputContact">Contact</label>
                    <input type="number" name="contact" class="form-control" id="exampleInputContact" placeholder="Contact">
                </div>

                <button type="submit" class="btn btn-primary">Add</button>

            </form>
            <p style="color: #e72734">${msg}</p>
        </div>
    </body>
    <%@include file="includes/footer.jsp" %>
</html>
