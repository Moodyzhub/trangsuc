<%-- 
    Document   : details
    Created on : Feb 5, 2024, 9:35:29 AM
    Author     : admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="icon" href="images/profile.png"
              type="images/x-icon"/>
        <title>Profiles</title>
        <link rel="stylesheet" href="css/details.css"/>
        <style>
            #main-image {
                width: 250px;
                transition: transform 0.3s ease;
            }

            #main-image.hover-effect:hover {
                transform: scale(1.1) translate(10px, 10px); /* Phóng to hình ảnh khi di chuột qua */
            }
            
            
        </style>
    </head>
    <body>
        <%@include file="includes/navbar.jsp" %>
        <%@include file="includes/head.jsp" %>
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
        <div class="container mt-5 mb-5">
            <div class="row d-flex justify-content-center">
                <div class="col-md-10">
                    <div class="card">
                        <div class="row">
                            <div class="col-md-6">
                                <div class="images p-3">
                                    <div class="text-center p-4">
                                        <img id="main-image" class="hover-effect" src="product-image/${detail.image}" width="250" />
                                    </div>
                                    <div class="thumbnail text-center">
                                        <img onclick="change_image(this)" src="product-image-other/${detail.image1}" width="70">
                                        <img onclick="change_image(this)" src="product-image-other/${detail.image2}" width="70">
                                    </div>
                                </div>
                            </div>
                            <div class="col-md-6">
                                <div class="product p-4">
                                    <div class="d-flex justify-content-between align-items-center">
                                        <div class="d-flex align-items-center">
                                            <i class="fa fa-long-arrow-left"></i>
                                            <a href="home">
                                                <span class="ml-1">Back</span>
                                            </a>
                                        </div>
                                        <i class="fa fa-shopping-cart text-muted"></i>
                                    </div>
                                    <div class="mt-4 mb-3">
                                        <span class="text-uppercase text-muted brand">Brand: Galaxy Diamonds</span>
                                        <h5 class="text-uppcase">Seri: ${detail.gia}</h5>
                                        <h5 class="text-uppercase">Product Name: ${detail.name}</h5>
                                        <div class="price d-flex flex-row align-items-center">
                                            <span class="act-price">Price: US $ ${detail.price}</span>
                                        </div>
                                    </div>
                                    <h6 class="text-uppercase">${detail.title}</h6>
                                    <p class="about">${detail.describes}</p> <!-- Updated description -->
                                    <div class="container mt-5 mb-5">
                                        <!-- Existing content -->

                                        <!-- Product Reviews Section -->
                                    </div>

                                    <div class="cart mt-4 align-items-center">
                                        <a href="home" class="btn btn-danger text-uppercase mr-2 px-4">Go To Shop <i class="fas fa-shopping-cart"></i></a>
                                        <i class="fa fa-heart text-muted"></i>
                                        <i class="fa fa-share-alt text-muted"></i>
                                    </div>

                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <div class="row d-flex justify-content-center">
            <div class="col-md-8 col-lg-6">
                <div class="card shadow-0 border" style="background-color: #f0f2f5;">
                    <div class="card-body p-4">
                        <div class="form-outline mb-4">
                            <input type="text" id="addANote" class="form-control" placeholder="Type comment..." />
                            <label class="form-label" for="addANote" onclick="addComment(${detail.id})">+ Add a note</label>
                            <script>
                                function addComment(id) {
                                    window.location.href = "detail?pid=1&comment="+document.getElementById("addANote").value;
                                }
                            </script>
                        </div>
                            <c:forEach var="c" items="${comment}">
                        <div class="card mb-4">
                            <div class="card-body">
                                <p>${c.content}</p>

                                <div class="d-flex justify-content-between">
                                    <div class="d-flex flex-row align-items-center">
                                        <img src="images/img1.jpg" alt="avatar" width="25"
                                             height="25" />
                                        <p class="small mb-0 ms-2">${c.name}</p>
                                    </div>
                                </div>
                            </div>
                        </div>
                            </c:forEach>
                        
                    </div>
                </div>
            </div>
        </div>                                         
        <%@include file="includes/finish.jsp"%>
        <%@include file="includes/footer.jsp" %>
    </body>
    <script>
        function change_image(image) {

            var container = document.getElementById("main-image");

            container.src = image.src;
        }



        document.addEventListener("DOMContentLoaded", function (event) {







        });

        var productImage = document.getElementById("main-image");

        productImage.addEventListener("mouseenter", function () {
            this.classList.add("hover-effect"); // Thêm lớp hiệu ứng khi di chuột vào
        });

        productImage.addEventListener("mouseleave", function () {
            this.classList.remove("hover-effect"); // Loại bỏ lớp hiệu ứng khi di chuột ra
        });


    </script>
</html>
