<%-- 
    Document   : thanks
    Created on : Mar 4, 2024, 8:51:25 PM
    Author     : admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <style>
            body {
                font-family: Arial, sans-serif;
                background-color: #f0f0f0;
                margin: 0;
                padding: 0;
            }

            .container {
                max-width: 800px;
                margin: 50px auto;
                background-color: #fff;
                padding: 20px;
                border-radius: 10px;
                box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
            }

            h1 {
                text-align: center;
                color: #333;
            }

            p {
                text-align: center;
                color: #666;
            }

            .btn {
                display: inline-block;
                padding: 10px 20px;
                background-color: #007bff;
                color: #fff;
                text-decoration: none;
                border-radius: 5px;
            }

            .btn:hover {
                background-color: #0056b3;
            }
        </style>
         <%@include file="includes/head.jsp" %>
    </head>
    <body>
        <%@include file="includes/navbar.jsp" %>
        <div class="container">
            <h1>Order Successfully</h1>
            <p>Thank you very much for your order.</p>
            <p>Your order has been successfully placed.</p>
            <p><a href="home" class="btn">Continue Shopping</a></p>
        </div>
        <%@include file="/includes/footer.jsp"%>
        <%@include file="includes/finish.jsp"%>
    </body>
</html>
