<%-- 
    Document   : login
    Created on : 04-Mar-2022, 15:01:42
    Author     : DELL
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
  	<title>Login!</title>
        <meta charset="utf-8">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no"> 
        <link href="https://fonts.googleapis.com/css?family=Lato:300,400,700&display=swap" rel="stylesheet"> 
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css"> 
        <link href="/Project_PRJ321/css/login.css" rel="stylesheet" /> 
    </head>
    
    <body>
        <section class="ftco-section">
            <!-- ======= A.Section div ======= -->
            <div class="container">
                <!-- ======= 1.Login ======= -->
                <div class="row justify-content-center">
                    <div class="col-md-6 text-center mb-5">
                        <h2 class="heading-section">!Login!</h2>
                    </div>
                </div> 
                <!-- ======= 2.Sign in table ======= -->
                <div class="row justify-content-center">
                    <div class="col-md-7 col-lg-5">
                        <div class="wrap">
                            <div class="img" style="background-image: url(images/bg-1.jpg);"></div><!-- Image -->
                            
                            <div class="login-wrap p-4 p-md-5">
                                <div class="d-flex">
                                    <div class="w-100"><h3 class="mb-4">Sign In</h3></div>
                                    <!-- ======= Facebook - Twitter round icon ======= -->
                                    <div class="w-100">
                                        <p class="social-media d-flex justify-content-end">
                                            <a href="#" class="social-icon d-flex align-items-center justify-content-center"><span class="fa fa-facebook"></span></a>
                                            <a href="#" class="social-icon d-flex align-items-center justify-content-center"><span class="fa fa-twitter"></span></a>
                                        </p>
                                    </div>
                                </div> 
                                <!-- ======= Form ======= -->
                                <form action="Login" class="signin-form">
                                    <div class="form-group mt-3">
                                        <input type="text" class="form-control" name="username" required>
                                        <label class="form-control-placeholder" for="username">Username</label>
                                    </div> 
                                    <div class="form-group">
                                        <input id="password-field" type="password" class="form-control" name="password" required>
                                        <label class="form-control-placeholder" for="password">Password</label> 
                                    </div>
                                    
                                    <div class="form-group">
                                        <button type="submit" class="form-control btn btn-primary rounded submit px-3">Sign In</button>
                                    </div>

                                    <div class="form-group d-md-flex">
                                        <!--Remember Me-->
                                        <div class="w-50 text-left">
                                            <label class="checkbox-wrap checkbox-primary mb-0">Remember Me
                                                <input type="checkbox" checked>
                                                <span class="checkmark"></span>
                                            </label>
                                        </div>
                                        <!--Forgot Password-->
                                        <div class="w-50 text-md-right">
                                            <a href="#">Forgot Password</a>
                                        </div>
                                    </div>
                                </form>
                                <p class="text-center">Not a member? <a data-toggle="tab" href="#signup">Sign Up</a></p>
                            </div>
                        </div>
                    </div>
                </div>
            </div>  
        </section>  
    </body>
</html>
