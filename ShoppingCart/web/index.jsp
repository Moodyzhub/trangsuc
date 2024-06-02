<%@page import="dal.ProductDAO" %>
<%@page import="java.util.*"%>
<%@page import="model.*" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%
  User auth = (User) request.getSession().getAttribute("auth");
  if(auth !=null){
      request.setAttribute("auth",auth);
    }
    
%>

<%
  ArrayList<Cart> cart_list = (ArrayList<Cart>) session.getAttribute("cart-list");
  if(cart_list !=null){
      request.setAttribute("cart_list", cart_list);
    }
%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <%@include file="includes/head.jsp" %>
        <link rel="stylesheet" href="css/homecss.css"/>
        <link rel="icon" href="images/3d-house.png"
              type="images/x-icon"/>
        <title>Welcome to shopping cart</title>
        <link href='https://unpkg.com/boxicons@2.1.4/css/boxicons.min.css' rel='stylesheet'>
        <style>
            /* CSS for image hover effect */
            .card-img-top:hover {
                transform: scale(1.1); /* Scale up the image by 10% */
                transition: transform 0.3s ease; /* Smooth transition effect */
            }

            #loadMore {
                width: 200px;
                color: #fff;
                display: block;
                text-align: center;
                margin: 20px auto;
                padding: 10px;
                border-radius: 10px;
                border: 1px solid transparent;
                background-color: #4C93B9;
                transition: .3s;
            }
            #loadMore:hover {
                color: #435d7d;
                background-color: #fff;
                border: 1px solid blue;
                text-decoration: none;
            }

        </style>
    </head>
    <body>
        <%@include file="includes/navbar.jsp"%>
        <section class="jumbotron text-center" style="padding: 0;">
            <div class="">
                <div id="carouselExampleControls" class="carousel slide" data-ride="carousel">
                    <div class="carousel-inner">
                        <div class="carousel-item active">
                            <img class="d-block w-100" src="https://cdn.caratlane.com/media/static/images/V4/2024/CL/02-FEB/AppBanner/Blog/02/Desktop_1920x694.jpg" alt="First slide">
                        </div>
                        <div class="carousel-item">
                            <img class="d-block w-100" src="https://cdn.caratlane.com/media/static/images/V4/2024/CL/03_MAR/AppBanner/Work-wear_curation/01/Desktop_1920x694.jpg" alt="Second slide">
                        </div>
                        <div class="carousel-item">
                            <img class="d-block w-100" src="https://cdn.caratlane.com/media/static/images/V4/2024/CL/03_MAR/AppBanner/Newin/01/Desktop_1920x694.jpg" alt="Third slide">
                        </div>
                    </div>
                    <a class="carousel-control-prev" style="color: #f64876 !important; width: 5%;"
                       href="#carouselExampleControls" role="button" data-slide="prev">
                        <span class="carousel-control-prev-icon" aria-hidden="true"></span>
                        <span class="sr-only">Previous</span>
                    </a>
                    <a class="carousel-control-next" style="color: #f64876 !important; width: 5%;" href="#carouselExampleControls" role="button" data-slide="next">
                        <span class="carousel-control-next-icon" aria-hidden="true"></span>
                        <span class="sr-only">Next</span>
                    </a>
                </div>
            </div>
        </section>
        <div class="container">
            <div class="row">
                <div class="col">

                </div>
            </div>
        </div>


        <div class="" style="max-width: 1200px; margin: 0 auto;">
            <div class="row">
                <!-- Menu left -->
                <div class="col-sm-3">
                    <div class="card bg-light mb-3">
                        <div class="card-header text-white text-uppercase"style="background-color: #8ba0b6;">
                            <i class="fa fa-list"></i>
                            Categories</div>
                        <ul class="list-group category_block">
                            <c:forEach items="${listC}" var="c">
                                <li class="list-group-item text-white ${view==c.cid ? "active":"" }">
                                    <a href="category?cid=${c.cid}" style="text-decoration: none;">${c.cname}</a>
                                </li>
                            </c:forEach>

                        </ul>
                    </div>
                    <div class="card bg-light mb-3">
                        <div class="card-header text-white text-uppercase" style="background-color: #9da8b4; color: #f64876;">New product</div>
                        <div class="card-body">
                            <img class="img-fluid card-img-top" src="product-image/${p.image}" />
                            <p class="card-text mt-4" style="color: green !important; font-size: 14px;">${p.gia}</p>
                            <h5 class="card-title" style="color: #537da7;">${p.name}</h5>
                            <p class="bloc_left_price" style="color: #f64876 !important; font-size: 20px;">${p.price} $</p>
                        </div>
                    </div>
                    <div class="card bg-light mb-3">
                        <div class="card-header text-white text-uppercase" style="background-color: #9da8b4; color: #f64876;"> Most Expensive</div>
                        <div class="card-body">
                            <img class="img-fluid card-img-top" src="product-image/${po.image}" />
                            <p class="card-text mt-4" style="color: green !important; font-size: 14px;">${po.gia}</p>
                            <h5 class="card-title" style="color: #537da7;">${po.name}</h5>
                            <p class="bloc_left_price" style="color: #f64876 !important; font-size: 20px;">${po.price} $</p>
                        </div>
                    </div> 
                </div>

                <div class="products col-sm-9">
                    <label for="sortBy" style=" font-family: inherit">Sort by (Price):</label>
                    <form action="home" method="get" style="border: none;
                          margin:0px;
                          padding: 0px;
                          margin-bottom: 20px;">
                        <div class="d-flex align-items-center">
                            <select id ="sortBy" name="sortBy" class="px-5 py-2" style="border: 1px solid green; border-radius: 5px; color: green">
                                <option value="Default"${empty param.sortBy ? 'selected' : ''}>Default</option>
                                <option value="LowToHigh" ${param.sortBy == 'LowToHigh' ? 'selected' : ''}>Low To High</option>
                                <option value="HighToLow" ${param.sortBy == 'HighToLow' ? 'selected' : ''}>High To Low</option>
                            </select>
                            <input type="submit" value="Sort"
                                   class="px-4 py-2 border-0 text-white" 
                                   style="border-radius: 5px; background-color: #f64876; margin-left: 5px;">
                        </div>
                    </form>
                    <div class="row" id="content">
                        <c:forEach items="${listP}" var="o">
                            <div class="products col-12 col-md-6 col-lg-4 mt-3">
                                <div class="card w-100 p-2" style="border-radius: 15px;
                                     overflow: hidden; margin-bottom: 20px; overflow: hidden;">
                                    <img class="card-img-top mb-3 img-fluid" src="product-image/${o.image}" alt="Card image cap">
                                    <h6 style="text-align: center; color: #f64876; font-size: 14px;" class="price">${o.gia}</h6>
                                    <div class="border-bottom mt-3" style="position: relative;">
                                        <a href="add-to-cart?id=${o.id}" class="text-success">
                                            <i class='bx bx-cart-alt border text-center bg-white fs-2'
                                               style="width: 30px; line-height: 30px;
                                               height: 30px; border-radius: 50%; position: absolute; left: 50%;
                                               top: 0; transform: translate(-50%, -50%);"></i>
                                        </a>
                                    </div>
                                    <div class="text-center mt-4">
                                        <h4  style="font-size: 16px" 
                                             class="card-title show_txt">
                                            <a href="detail?pid=${o.id}" style="color: #333;"
                                               title="View Product" style="color: #39434d; text-decoration: none !important;">${o.name}</a></h4>
                                        <div class="row align-items-center">
                                            <div class="col-5">
                                                <h6 class="fw-bold" style="color: #537da7;">${o.price}$</h6>
                                            </div>
                                            <div class="col-7">
                                                <div class="d-flex align-items-center">
                                                    <a class="px-3 py-2" style="border: 1px solid #00a832; text-decoration: none;color: #00a832; border-radius: 5px;"
                                                       href="order-now?quantity=1&id=${o.id}">Buy Now <i class='bx bxs-hot'></i></a>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </c:forEach>
                    </div>
                    <a href="#" onclick="loadMore()" id="loadMore">Load More</a>
                </div>

            </div>

        </div> 
        <%@include file="includes/footer.jsp"%>
        <%@include file="includes/finish.jsp"%>
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
        <script>
                        function loadMore() {
                            var amount = document.getElementsByClassName("products").length;
                            $.ajax({
                                url: "/ShoppingCart/load",
                                type: "get", //send it through get method
                                data: {
                                    exits: amount
                                },
                                success: function (data) {
                                    var row = document.getElementById("content");
                                    row.innerHTML += data;
                                },
                                error: function (xhr) {
                                    //Do Something to handle error
                                }
                            });
                        }

                        function searchByName(param) {
                            var txtSearch = param.value;
                            $.ajax({
                                url: "/ShoppingCart/search-ajax",
                                type: "get", //send it through get method
                                data: {
                                    txt: txtSearch
                                },
                                success: function (data) {
                                    var row = document.getElementById("content");
                                    row.innerHTML = data;
                                },
                                error: function (xhr) {
                                    //Do Something to handle error
                                }
                            });
                        }
        </script>
    </body>

</html>


