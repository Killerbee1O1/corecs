<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
    	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
        <title>CoreCs-SignUp</title>
        <link type="text/css" rel="stylesheet" href="css/bootstrap.css">
    <!--===============================================================================================-->	
	   <link rel="icon" type="image/png" href="images/icons/favicon.ico"/>
    <!--===============================================================================================-->
        <link rel="stylesheet" type="text/css" href="vendor/bootstrap/css/bootstrap.min.css">
    <!--===============================================================================================-->
        <link rel="stylesheet" type="text/css" href="fonts/font-awesome-4.7.0/css/font-awesome.min.css">
    <!--===============================================================================================-->
        <link rel="stylesheet" type="text/css" href="fonts/iconic/css/material-design-iconic-font.min.css">
    <!--===============================================================================================-->
        <link rel="stylesheet" type="text/css" href="vendor/animate/animate.css">
    <!--===============================================================================================-->	
        <link rel="stylesheet" type="text/css" href="vendor/css-hamburgers/hamburgers.min.css">
    <!--===============================================================================================-->
        <link rel="stylesheet" type="text/css" href="vendor/animsition/css/animsition.min.css">
    <!--===============================================================================================-->
        <link rel="stylesheet" type="text/css" href="vendor/select2/select2.min.css">
    <!--===============================================================================================-->	
        <link rel="stylesheet" type="text/css" href="vendor/daterangepicker/daterangepicker.css">
    <!--===============================================================================================-->
        <link rel="stylesheet" type="text/css" href="css/util.css">
        <link rel="stylesheet" type="text/css" href="css/main.css">
    <!--===============================================================================================-->
        <link type="text/css" rel="stylesheet" href="css/style.css">
    </head>
    
    <body>
    <%@ page import="corecs.*" %>
	<%@ page import="java.util.*" %>
        <div class="form">
               <div class="container-login100">
                <div class="wrap-login100 p-l-55 p-r-55 p-t-80 p-b-30">
                    <form class="login100-form validate-form container" >
                        <span class="login100-form-title p-b-37">
                            Sign Up Form
                        </span>
                        <span class="login100-form-title p-b-37">
                            <h6>Kindly fill all details correctly</h6>
                        </span>
					
					<div>
						<label>Name</label>
                        <div class="wrap-input100 validate-input m-b-20" data-validate="Enter username or email">
                            <input class="input100" type="text" name="signUpUsername" placeholder="username">
                            <span class="focus-input100"></span>
                        </div>
					</div>
					
					<div>
						<label>Password</label>
                        <div class="wrap-input100 validate-input m-b-25" data-validate = "Enter password">
                            <input class="input100" type="password" name="signUpPassword" placeholder="password">
                            <span class="focus-input100"></span>
                        </div>
                    </div>    
                    
                    <div> 
                    	  <label>Re-Enter</label>   
                          <div class="wrap-input100 validate-input m-b-25" data-validate = "Enter password">
                            <input class="input100" type="password" name="signUpRe-password" placeholder="re-password">
                            <span class="focus-input100"></span>
                        </div>
					</div>
                        <div class="container-login100-form-btn">
                            <input type="submit" value="addMe" name="param" class="btn btn-primary">
                             
                        </div>
                        <div class="text-center p-t-10">
                        	<p>${error.message}</p>
                        </div>
						</form>
                </div>
            </div>
	</div>
	

	<div id="dropDownSelect1"></div>
	
<!--===============================================================================================-->
	<script src="vendor/jquery/jquery-3.2.1.min.js"></script>
<!--===============================================================================================-->
	<script src="vendor/animsition/js/animsition.min.js"></script>
<!--===============================================================================================-->
	<script src="vendor/bootstrap/js/popper.js"></script>
	<script src="vendor/bootstrap/js/bootstrap.min.js"></script>
<!--===============================================================================================-->
	<script src="vendor/select2/select2.min.js"></script>
<!--===============================================================================================-->
	<script src="vendor/daterangepicker/moment.min.js"></script>
	<script src="vendor/daterangepicker/daterangepicker.js"></script>
<!--===============================================================================================-->
	<script src="vendor/countdowntime/countdowntime.js"></script>
<!--===============================================================================================-->
	<script src="js/main.js"></script>
    </body>

</html>