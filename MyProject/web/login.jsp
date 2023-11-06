<%-- 
    Document   : login
    Created on : 13-Mar-2022, 09:56:18
    Author     : DELL
--%>
<link href="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"> 
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta http-equiv="X-UA-Compatible" content="ie=edge">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
        <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.3.1/css/all.css" integrity="sha384-mzrmE5qonljUremFsqc01SB46JvROS7bZs3IO2EmfFsd15uHvIt+Y8vEf7N7fWAU" crossorigin="anonymous">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link href="/MyProject/css/login.css" rel="stylesheet" type="text/css"/>
        <link href="/MyProject/css/styles.css" rel="stylesheet" />
        <title>Login Form</title> 
    </head>
    <body> 
        <!--------------------------------------- Navi Bar ----------------------------------------->
        <%@include file="components/naviBar.jsp"%>  
       <div id="logreg-forms">
           
            <form class="form-signin" action="Login" method="post">
                <h1 class="h3 mb-3 font-weight-normal" style="text-align: center">Sign in</h1>
                <p class="text-danger">${error}</p>
                <input name="username"  type="text" id="inputEmail" class="form-control" placeholder="Enter Username" required="" autofocus="">
                <input name="password"  type="password" id="inputPassword" class="form-control" placeholder="Enter Password" required="">

                 

                <button class="btn btn-success btn-block" type="submit"><i class="fas fa-sign-in-alt"></i>Sign in</button>
                <hr>
                <a href="Register" id="cancel_signup">
                    <button class="btn btn-primary btn-block" type="button" id="btn-signup"><i class="fas fa-user-plus"></i>Sign up New Account</button>
                </a>
            </form> 
            <br> 
        </div> 

    </body>
</html>

