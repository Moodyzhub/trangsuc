<%-- 
    Document   : profile
    Created on : Feb 21, 2024, 4:05:51 PM
    Author     : admin
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Account Details</title>
        <link rel="icon" href="images/person.png"
              type="images/x-icon"/>
        <%@include file="includes/head.jsp" %>
    </head>
    <body>
        <%@include file="includes/navbar.jsp"%>
        <div class="container bootstrap snippets bootdey">
            <nav aria-label="breadcrumb">
                <ol class="breadcrumb">
                    <li class="breadcrumb-item"><a href="home">Home</a></li>
                    <li class="breadcrumb-item active" aria-current="page">My Acount</li>
                </ol>
            </nav>

            <hr>
            <div class="row">
                <!-- left column -->
                <div class="col-md-3">
                    <div class="text-center">
                        <img src="images/header.jpg" class="avatar img-circle img-thumbnail" alt="avatar">
                        <div class="contact">
                            <a href="profile.jsp" class="btn btn-block btn-danger"><i class="fa-solid fa-user"></i> Account Detail</a>
                            <a href="orders.jsp" class="btn btn-block btn-success"><i class="fa fa-book"></i>My Order</a>
                        </div>
                    </div>
                </div>

                <!-- edit form column -->
                <div class="col-md-9 personal-info">
                    <c:choose>
                        <c:when test="${sessionScope.auth.isAdmin == 1}">
                            <h3 class="card-text"><strong>Account</strong>  Admin</h3>
                        </c:when>
                        <c:when test="${sessionScope.auth.isSeller == 1}">
                            <h3 class="card-text"><strong>Account</strong> Sales Admin</h3>
                        </c:when>
                        <c:otherwise>
                            <h3 class="card-text"><strong>Account</strong> Customer</h3>
                        </c:otherwise>
                    </c:choose>
                    <c:if test="${requestScope.msg !=null }">
                        <div class="alert alert-info alert-dismissable">
                            <a class="panel-close close" data-dismiss="alert">×</a> 
                           <i class="fa-solid fa-check"></i>
                            ${requestScope.msg}
                        </div>

                    </c:if>
                    <form id="form-1" action="edit-profile" method="get" class="form-horizontal" role="form">
                        <div class="form-group">
                            <label class="col-lg-3 control-label input_type">Roll Number:</label>
                            <div class="col-lg-8">
                                <input class="form-control input_type" type="text" name="id" value="${sessionScope.auth.id}"readonly>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-lg-3 control-label input_type">Use name:</label>
                            <div class="col-lg-8">
                                <input class="form-control input_type" type="text" name="name" value="${sessionScope.auth.name}"readonly>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-lg-3 control-label">Email:</label>
                            <div class="col-lg-8">
                                <input class="form-control input_type" type="text" name="email" value="${sessionScope.auth.email}" readonly>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-lg-3 control-label">Country:</label>
                            <div class="col-lg-8">
                                <input class="form-control input_type" type="text"  name="country" value="${sessionScope.auth.country}" readonly>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-lg-3 control-label">Phone:</label>
                            <div class="col-lg-8">
                                <input class="form-control input_type" type="text"  name="contact" value="${sessionScope.auth.contact}" readonly>
                            </div>
                        </div>
                        <div class="form-group">
                            <div class="col-lg-offset-3 col-lg-8">
                                <button onclick="changeType(this)" id="edit" type="button" class="btn btn-primary">Edit</button>
                            </div>
                        </div> 
                        <script>
                            function changeType(button) {
                                var inputElements = document.querySelectorAll(".input_type");
                                if (button.id === "edit") {
                                    button.id = "save";
                                    button.textContent = "Save";
                                    inputElements.forEach(x => {
                                        if (x.name !== "name" && x.name !== "id") {
                                            x.readOnly = false;
                                            x.classList.add("default_input");
                                        }
                                    });
                                } else {
                                    document.getElementById("form-1").submit();
                                    button.id = "edit";
                                    button.textContent = "Edit";
                                    inputElements.forEach(x => {
                                        if (x.name !== "name" && x.name !== "id") {
                                            x.readOnly = true;
                                            x.classList.remove("default_input");
                                        }
                                    });
                                }

                            }
                        </script>
                    </form>
                </div>
            </div>
        </div>
        <hr>
        <%@include file="includes/finish.jsp"%>                    
        <%@include file="includes/footer.jsp"%>

    </body> 
</html>
