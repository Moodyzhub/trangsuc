
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <%@include file="includes/head.jsp" %>
        <link rel="stylesheet" href="css/main.css"/>
        <link rel="icon" href="images/Screenshot 2024-02-09 070629.png"
              type="images/x-icon"/>
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0-beta3/css/all.min.css" integrity="sha384-vpZl2lJD5zzOykKkLrBbEPv9Wp0yqDgqQ5m9vJkzQJqJpzz/3ZvVoKHyN1p+qLiX" crossorigin="anonymous">
        <title>Manager Account</title>
            <style>
            .pagination {
                display: inline-block;
            }

            .pagination a {
                color: black;
                float: left;
                padding: 8px 16px;
                text-decoration: none;
            }
        </style>


    </style>
</head>
<body>
    <header>
        <nav class="navbar navbar-expand-md navbar-dark"

             <div>
            <a href="home" class="navbar-brand"><i class="fa-solid fa-house-chimney"></i>Home</a>
            </div>

            <ul class="navbar-nav">
                <li><a href="list-user"
                       class="nav-link"><i class="fa-solid fa-user-tie"></i>Users</a></li>
            </ul>
        </nav>
    </header>
    <br>

    <div class="row">
        <!-- <div class="alert alert-success" *ngIf='message'>{{message}}</div> -->

        <div class="container">
            <h3 class="text-center">List of Users</h3>
            <hr>
            <div class="d-flex justify-content-between">
                <form action="list-user" method="get" class="row g-2">
                    <div class="col-auto">
                        <div class="input-group">
                            <input type="text" id="inputName" name="name" placeholder="Name" class="form-control mr-1" value="${name}">
                            <input type="text" id="inputEmail" name="email" placeholder="Email" class="form-control mr-1" value="${email}">
                            <button type="submit" class="btn btn-primary mr-1">Search</button>
                            <button type="button" class="btn btn-secondary" onclick="resetInputs()">Reset</button>
                        </div>
                    </div>
                </form>

                <c:if test="${sessionScope.auth.isAdmin == 1}">
                    <a href="add-user"><button type="button" class="btn btn-success">+ Add</button></a>
                </c:if>
            </div>
            <br>


            <table class="table table-bordered">
                <thead>
                    <tr>
                        <th scope="col">No</th>
                        <th scope="col">ID</th>
                        <th scope="col">Name</th>
                        <th scope="col">Email</th>
                        <th scope="col">Password</th>
                        <th scope="col">Country</th>
                        <th scope="col">Phone</th>
                        <th scope="col">Seller</th>
                        <th scope="col">Admin</th>
                            <c:if test="${sessionScope.auth.isAdmin == 1}">
                            <th scope="col">Update</th>
                            <th scope="col">Delete</th>
                            </c:if>
                    </tr>
                </thead>
                <tbody>

                    <c:forEach  var="O" items="${list}" varStatus="loop">
                        <tr>
                            <th scope="row">${loop.index + 1}</th>
                            <td><c:out value="${O.id}" /></td>
                            <td><c:out value="${O.name}" /></td>
                            <td><c:out value="${O.email}" /></td>
                            <td><c:out value="${O.password}" /></td>
                            <td><c:out value="${O.country}" /></td>
                            <td><c:out value="${O.contact}" /></td>
                            <td><c:out value="${O.isSeller}" /></td>
                            <td><c:out value="${O.isAdmin}" /></td>
                            <c:if test="${sessionScope.auth.isAdmin == 1}"> 
                                <td style="text-align: center">
                                    <form action="update-user" method="GET">
                                        <input type="hidden" name="id" value="${O.id}">
                                        <input type="submit" value="🖊" />
                                    </form>
                                </td>
                                <td style="text-align: center">
                                    <form action="delete-user" method="POST">
                                        <input type="hidden" name="id" value="${O.id}">
                                        <input type="submit" value="✖" />
                                    </form>
                                </td>
                            </c:if>
                        </tr>
                    </c:forEach>

                </tbody>
            </table>
            <p style="color: tomato">${msg}</p>
            <c:set var="msg" value="${null}" scope="session"></c:set>
            </div>
        </div>

    </body>
    <script>
        function resetInputs() {
            document.getElementById("inputName").value = "";
            document.getElementById("inputEmail").value = "";
        }
    </script>

<%@include file="includes/footer.jsp" %>
</html>
