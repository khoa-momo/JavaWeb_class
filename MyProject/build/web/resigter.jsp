<%-- 
    Document   : resigter
    Created on : 13-Mar-2022, 09:18:04
    Author     : DELL
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Register</title>
        <link href="/MyProject/css/styles.css" rel="stylesheet" />
        <link href="/MyProject/css/register.css" rel="stylesheet" />
        
    </head>
    <body> 
        <!--------------------------------------- Navi Bar ----------------------------------------->
        <%@include file="components/naviBar.jsp"%> 
        
        <form action="Register" method="Post" style="border:1px solid #ccc">
            <div class="container">
                <h1>Sign Up</h1>
                <p>Please fill in this form to create an account.</p>
                <hr>
                
                <label for="userName"><b>User Name</b></label>
                <input type="text" placeholder="Enter username" name="userName" required> 
                
                <label for="password"><b>Password</b></label>
                <input type="text" placeholder="Enter password" name="passWord" required>
                
                <label for="fullName"><b>Full Name</b></label>
                <input type="text" placeholder="Enter full name" name="fullName" required> 
                
                <label for="email"><b>Email</b></label>
                <input type="text" placeholder="Enter email" name="email" required>

                <label for="gender"><b>Gender</b></label>
                Male<input type="radio" name="gender" value="Male" checked/>
                Female<input type="radio" name="gender" value="Female"/>
                <br/>
                <label for="phone"><b>Phone</b></label>
                <input type="text" placeholder="Enter Phone" name="phone" required> 
                
                <label>
                    <input type="checkbox" checked="checked" name="remember" style="margin-bottom:15px"> Remember me
                </label> 

                <div class="clearfix">
                  <button type="submit" class="signupbtn">Sign Up</button>
                </div>
            </div>
        </form> 
    </body>
</html>
