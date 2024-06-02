<%@page import="dal.DBContext" %>
<%@page import="model.*" %>
<%@page import="java.util.*" %>
<%@page import="dal.ProductDAO" %>
<%@page import="java.text.DecimalFormat" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%
  DecimalFormat dcf = new DecimalFormat("#.##");
  request.setAttribute("dcf", dcf);

  ArrayList<Cart> cart_list = (ArrayList<Cart>) session.getAttribute("cart-list");
  List<Cart> cartProduct = null;
  if(cart_list !=null){
      ProductDAO pDao = new ProductDAO();
      cartProduct =  pDao. getCartProducts(cart_list);
      double total =  pDao.getTotalCartPrice(cart_list);
      request.setAttribute("cart_list", cart_list);
      request.setAttribute("total", total);
    }



%>
<%
  User auth = (User) request.getSession().getAttribute("auth");
  if(auth !=null){
      request.setAttribute("auth",auth);
    }
    
%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>E-Commerce Cart</title>
        <link rel="icon" href="images/shopping.png"
              type="images/x-icon"/>
        <link rel="stylesheet" href="css/cart.css"/>
        <style type="text/css">

            .table tbody td{
                vertical-align: middle;
            }
            .btn-incre, .btn-decre{
                box-shadow: none;
                font-size: 25px;
            }
            .table tbody tr:hover {
                background-color: #f5f5f5; /* Màu nền khi di chuột qua */
            }
        </style>
        <%@include file="includes/head.jsp" %>

    </head>
    <body>
        <%@include file="/includes/navbar.jsp"%>
        <div class="container">
            <% if (cart_list == null || cart_list.isEmpty()) { %>
            <div class="container-fluid  mt-100">
                <div class="row">

                    <div class="col-md-12">

                        <div class="card">
                            <div class="card-header">
                               <h5>Cart <i class="fa-solid fa-cart-shopping"></i></h5>
                            </div>
                            <div class="card-body cart">
                                <div class="col-sm-12 empty-cart-cls text-center">
                                    <img src="https://i.imgur.com/dCdflKN.png" width="130" height="130" class="img-fluid mb-4 mr-3">
                                    <h3><strong>Your Cart is Empty</strong></h3>
                                    <h4>Add something to make me happy  😊</h4>
                                    <a href="home" class="btn btn-primary cart-btn-transform m-3" data-abc="true">continue shopping</a>


                                </div>
                            </div>
                        </div>


                    </div>

                </div>

            </div>
            <% } else { %>
            <div class="d-flex py-3"><h3>Total:$  ${ (total >0)?dcf.format(total):0 }</h3><a class="mx-3 btn btn-primary" href="cart-check-out">Check Out</a></div>
            <table class="table table-light">
                <thead>
                    <tr>
                        <th scope="col">Image Product</th> 
                        <th scope="col">Name</th> 
                        <th scope="col">Seri</th>
                        <th scope="col">Price</th>
                        <th scope="col">Buy Now</th>
                        <th scope="col">Cancel</th>
                    </tr>
                </thead>
                <tbody>
                    <% if(cart_list !=null){
                          for(Cart c: cartProduct){%>
                    <tr>
                        <td> 
                            <img src="product-image/<%= c.getImage() %>" style="width: 100px; height: auto;"/> 
                        </td>
                        <td><%= c.getName()%></td> 
                        <td><%= c.getGia()%></td> 
                        <td><%= dcf.format(c.getPrice())%> $</td>
                        <td>
                            <div class="row">
                                <div class="col-md-6">
                                    <form action="order-now" method="post" class="form-inline">
                                        <input type="hidden" name="id" value="<%= c.getId() %>" class="form-input">
                                        <div class="form-group d-flex justify-content-between align-items-center"">
                                            <a class="btn bnt-sm btn-incre" style="font-size: 25px;" href="quantity-inc-dec?action=inc&id=<%=c.getId()%>"><i class="fas fa-plus-square" ></i></a>
                                            <input type="text" name="quantity" value="<%=c.getQuantity()%>" class="form-control" readonly>
                                            <a  class="btn btn-sm btn-decre" style="font-size: 25px;"  href="quantity-inc-dec?action=dec&id=<%=c.getId()%>"><i class="fas fa-minus-square" ></i></a>
                                            <button type="submit" class="btn btn-primary btn-sm" style="margin-left:  20px">Buy</button>
                                        </div>

                                    </form>
                                </div>
                            </div>
                        </td>
                        <td><a class="btn btn-sm btn-danger"  href="remove-from-cart?id=<%=c.getId()%>">Remove</a></td>

                    </tr>    
                    <%}
                    } 
                    %>
                </tbody>
            </table>
            <% } %>
        </div>
        <%@include file="/includes/footer.jsp"%>
        <%@include file="includes/finish.jsp"%>
    </body>
</html>
