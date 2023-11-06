<%-- 
    Document   : product
    Created on : 17-Feb-2022, 12:58:40
    Author     : DELL
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>  
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Home Product</title>
        <link href="css/styling.css" rel="stylesheet" /> 
    </head>
    <body>
        <!--------------------------------------- Navi Bar ----------------------------------------->
        <%@include file="components/naviBar.jsp"%>   
        <div class="container"> 
            <div class="alert alert-success text-center mt-2" role="alert" >
                Order successfully!
                <div class="text-center mt-9">
                    <a class="btn btn-outline-primary" href="ProductController">Return</a>
                </div>
            </div> 
        </div> 
    </body>
</html>
