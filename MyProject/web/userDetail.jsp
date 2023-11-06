<%-- 
    Document   : userDetail
    Created on : 20-Mar-2022, 13:40:41
    Author     : DELL
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>User</title>
        <link href="/MyProject/css/styles.css" rel="stylesheet" />
        <link href="/MyProject/css/register.css" rel="stylesheet" />
    </head>
    <body>
        <!--------------------------------------- Navi Bar ----------------------------------------->
        <%@include file="components/naviBar.jsp"%> 
        
        <form action="UserDetail" method="Post" style="border:1px solid #ccc">
            <div class="container">
                <h1>Update information</h1> 
                
                <label for="userName"><b>User Name</b></label>
                <input type="text"   name="userName" value="${a.username}" required> 
                
                <label for="password"><b>Password</b></label>
                <input type="text"  name="passWord" value="${a.password}" required>
                
                <label for="fullName"><b>Full Name</b></label>
                <input type="text"   name="fullName" value="${a.fullname}" required> 
                
                <label for="email"><b>Email</b></label>
                <input type="text"   name="email" value="${a.email}" required>

                <label for="gender"><b>Gender</b></label>
                Male<input type="radio" name="gender" value="Male" ${a.gender.equalsIgnoreCase("Male")?"checked":""}/>
                Female<input type="radio" name="gender" value="Female" ${a.gender.equalsIgnoreCase("Female")?"checked":""}/>
                <br/>
                <label for="phone"><b>Phone</b></label>
                <input type="text" placeholder="" name="phone" value="${a.phone}" required> 
                  
                <div class="clearfix">
                  <button type="submit" class="signupbtn">Update</button>
                </div>
            </div>
        </form> 
    </body>
</html>
