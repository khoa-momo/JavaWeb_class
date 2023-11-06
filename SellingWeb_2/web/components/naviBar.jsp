<%-- 
    Document   : naviBar 
    Created on : Mar 16, 2022, 9:00:41 PM
    Author     : Dell
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!-- Navigation-->
<nav class="navbar navbar-expand-lg navbar-light bg-light">
    <div class="container px-4 px-lg-5">
        <a class="navbar-brand" href="ProductController">Home</a>
        <button
            class="navbar-toggler"
            type="button"
            data-bs-toggle="collapse"
            data-bs-target="#navbarSupportedContent"
            aria-controls="navbarSupportedContent"
            aria-expanded="false"
            aria-label="Toggle navigation"
            >
            <span class="navbar-toggler-icon"></span>
        </button>
        
        
        <div class="collapse navbar-collapse" id="navbarSupportedContent">  
            
            <!--------------------------------------- Searching bar ---------------------------------------
            <form action="search" class="d-flex mx-auto">
                <input
                    class="form-control me-2"
                    type="search"
                    placeholder="Search"
                    aria-label="Search"
                    name="keyword"
                    />
                <button class="btn btn-outline-success" type="submit">
                    Search
                </button>
            </form>-->
            
            <!--------------------------------------- Cart icon ----------------------------------------->
            <div class="d-flex my-2">
                <a class="btn btn-outline-dark" href="ViewCart">
                    <i class="bi-cart-fill me-1"></i>
                    Cart
                    <span id="cart_number" class="badge bg-dark text-white ms-1 rounded-pill">${sessionScope.carts.size()}</span>
                </a>
            </div>
                    
            <!--------------------------------------- Login/Logout ----------------------------------------->    
            <c:choose>
                <c:when test="${sessionScope.customer != null}">
                    <button class="btn btn-outline-primary ms-lg-2">${sessionScope.customer.username}</button>
                    <a href="LogoutCon" class="btn btn-outline-primary ms-lg-2">Logout!</a>
                </c:when>
                <c:otherwise>
                    <a href="LoginCon" class="btn btn-outline-primary ms-lg-2">Login</a>
                </c:otherwise>
            </c:choose>
                    
        </div>
    </div>       
</nav>
