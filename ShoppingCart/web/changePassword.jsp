<%-- 
    Document   : changePassword
    Created on : Feb 6, 2024, 9:26:10 PM
    Author     : admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Change Password</title>
        <link rel="icon" href="images/seb.png"
               type="images/x-icon"/>
        <link rel="stylesheet" href="css/changepass.css"/>
        <!-- bootstrap css 4.5.0 -->
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/4.5.0/css/bootstrap.min.css" />
        <!-- font awesome 5.13.1 -->
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.13.1/css/all.min.css" />
        <style>
            #signupForm a {
                color: blue; /* Change the color */
                text-decoration: none; /* Remove underline */
                display: inline-block; /* Make it inline with padding */
                margin-top: 10px; /* Adjust spacing */
                transition: color 0.3s ease; /* Smooth transition for color change */
            }

            #signupForm a:hover {
                color: #da0606; /* Change color on hover */
                text-shadow: 1px 1px 2px rgba(0, 0, 0, 0.5); /* Add a subtle text shadow on hover */
            }


        </style>
    </head>
    <body>
        <div class="mainDiv">
            <div class="cardStyle">       
                <form action="change-password" method="post" name="signupForm" id="signupForm">

                    <img src="images/Screenshot 2024-02-09 070629.png" id="signupLogo"/>

                    <h2 class="formTitle">
                        Change Password
                    </h2>

                    <div class="inputDiv">
                        <label class="inputLabel" for="email">Email</label>
                        <input type="email" id="email" name="email" required>
                        <p style="color: red ;font-size: 12px;">${e_email}</p>
                    </div>
                    <div class="inputDiv">
                        <label class="inputLabel" for="password">New Password</label>
                        <div class="input-group">
                            <input type="password" id="password" name="password" class="form-control" placeholder="Enter your password" required>
                            <button class="btn btn-outline-secondary" type="button" id="btnPassword">
                                <span class="fas fa-eye"></span>
                            </button>
                        </div>
                        <p style="color: red ;font-size: 12px;">${e_password}</p>
                    </div>

                    <div class="inputDiv">
                        <label class="inputLabel" for="confirmPassword">Confirm Password</label>
                        <div class="input-group">
                            <input type="password" id="confirmPassword" name="cpassword" class="form-control" placeholder="Confirm your password" required>
                            <button class="btn btn-outline-secondary" type="button" id="btnConfirmPassword">
                                <span class="fas fa-eye"></span>
                            </button>
                        </div>
                        <p style="color: red;font-size: 12px;">${e_confirmPassword}</p>
                    </div>
                    <div class="buttonWrapper">
                        <button type="submit" id="submitButton"  class="submitButton pure-button pure-button-primary">
                            <span>Continue</span>
                            <span id="loader"></span>
                        </button>
                    </div>

                    <a href="user-login">
                        <i class="fa fa-long-arrow-left"></i>
                        <span class="ml-1">->Back</span>
                    </a>
                </form>
            </div>
        </div>

    </body>
    <script>
        // step 1
        const ipnElement = document.querySelector('#password');
        const btnElement = document.querySelector('#btnPassword');
        const ipnElement1 = document.querySelector('#confirmPassword');
        const btnElement1 = document.querySelector('#btnConfirmPassword');
        // step 2
        btnElement.addEventListener('click', function () {
            // step 3
            const currentType = ipnElement.getAttribute('type');

            // step 4
            ipnElement.setAttribute(
                    'type',
                    currentType === 'password' ? 'text' : 'password'
                    );
        });

        btnElement1.addEventListener('click', function () {
            // step 3
            const currentType1 = ipnElement1.getAttribute('type');
            // step 4
            ipnElement1.setAttribute(
                    'type',
                    currentType1 === 'password' ? 'text' : 'password'
                    );
        });


    </script>
</html>
