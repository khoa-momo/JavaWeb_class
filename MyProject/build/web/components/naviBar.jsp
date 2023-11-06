<%-- 
    Document   : naviBar
    Created on : 12-Mar-2022, 09:59:20
    Author     : DELL
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!-- Navigation-->
<nav class="navbar navbar-expand-lg navbar-light bg-light">
    <div class="container px-4 px-lg-5">
        <a class="navbar-brand" href="/MyProject/Home">Home</a>
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
            <ul class="navbar-nav me-auto mb-2 mb-lg-0 ms-lg-4">
                <li class="nav-item">
                    <a class="nav-link active" aria-current="page" href="/MyProject/NewRoom">Đăng tin tức</a>
                </li> 
                <li class="nav-item">
                    <a class="nav-link active" aria-current="page" href="/MyProject/RoomManager">Quản lý</a>
                </li> 
            </ul>
            
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
            
            <!--------------------------------------- Cart icon ---------------------------------------
            <div class="d-flex my-2">
                <a class="btn btn-outline-dark" href="carts">
                    <i class="bi-cart-fill me-1"></i>
                    Quan ly tai khoan
                    <span id="cart_number" class="badge bg-dark text-white ms-1 rounded-pill">${sessionScope.carts.size()}</span>
                </a>
            </div>-->
                    
            <!--------------------------------------- Login/Logout ----------------------------------------->    
            <c:choose>
                <c:when test="${sessionScope.account != null}">
                    <a href="UserDetail" class="btn btn-outline-primary ms-lg-2">
                        ${sessionScope.account.username}
                    </a>
                    <a href="Logout" class="btn btn-outline-primary ms-lg-2">Logout</a>
                </c:when>
                <c:otherwise>
                    <a href="Login" class="btn btn-outline-primary ms-lg-2">Login</a>
                </c:otherwise>
            </c:choose>
                    
        </div>
    </div>       
</nav>
