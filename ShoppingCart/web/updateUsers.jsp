<%-- 
    Document   : updateUsers
    Created on : Jan 26, 2024, 9:36:31 PM
    Author     : admin
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
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
            <h3 class="text-center">Update Users</h3>
            <hr>
            <form action="update-user" method="post">
                <input type="hidden" name="id" value="${user.id}">
                <div class="form-group">
                    <label for="exampleInputName">Name</label>
                    <input type="text" name="name" value="${user.name}" class="form-control" id="exampleInputName" placeholder="Name">   
                </div>
                <div class="form-group">
                    <label for="exampleInputEmail1">Email address</label>
                    <input type="email" name="email" value="${user.email}" class="form-control" id="exampleInputEmail1" placeholder="Email">   
                </div>
                <div class="form-group">
                    <label for="exampleInputPassword1">Password</label>
                    <input type="password" value="${user.password}" name="pass" class="form-control" id="exampleInputPassword1" placeholder="Pass" readonly="">
                </div>
                <div class="form-group">
                    <label for="exampleInputCountry">Country</label>
                    <input type="text" name="country" value="${user.country}" class="form-control" id="exampleInputCountry" placeholder="Country">
                </div>
                <div class="form-group">
                    <label for="exampleInputContact">Contact</label>
                    <input type="text" name="contact" value="${user.contact}" class="form-control" id="exampleInputContact" placeholder="Contact">
                </div>
                <div class="form-group">
                    <label for="exampleInputRole">Choose Role</label><br>
                   Seller: <input type="number" name="role1" value="${user.isSeller}" class="form-control" id="exampleInputRole">
                   Admin: <input type="number" name="role2" value="${user.isAdmin}" class="form-control" id="exampleInputRole">
                </div>

                <button type="submit" class="btn btn-primary">Update</button>

            </form>

        </div>
    </body>
    <%@include file="includes/footer.jsp" %>
</html>
