<%-- 
    Document   : cart
    Created on : 18-Feb-2022, 10:36:54
    Author     : DELL
--%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%> 
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>  
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Cart Page</title> 
        <link href="css/styling.css" rel="stylesheet" /> 
    </head>
    <body>  
        <!--------------------------------------- Navi Bar ----------------------------------------->
        <%@include file="components/naviBar.jsp"%>   
        <h1>${mess}</h1>
        
        <!-- Product section-->
        <section class="py-5">
            <div class="container" style="min-height: 1000px">
                <c:choose>
                    <c:when test="${sessionScope.carts==null||sessionScope.carts.size()==0}">
                        <h1>Cart is Empty</h1>
                    </c:when>
                    <c:otherwise>
                        <h3>List Products</h3>
                        <table class="table"> 
                            <thead>
                                <tr>
                                    <th>Product ID</th> 
                                    <th>Product's Name</th>
                                    <th>Unit Price</th>
                                    <th>Quantity</th> 
                                    <th>Total Price</th> 
                                </tr>
                            </thead>
                            <tbody> 
                                <c:forEach items="${carts}" var="C">
                                    <form action="UpdateCartQuantity">
                                        <tr>
                                            <input type="hidden" name="productId" value="${C.value.product.productId}"/>
                                            <th scope="row">${C.value.product.productId}</th>
                                            <td>${C.value.product.productName}</td> 
                                            <td>${C.value.product.unitPrice}</td>
                                            <td><input onchange="this.form.submit()" type="number" name="quantity" value="${C.value.quantity}"/></td>
                                            <td>${C.value.product.unitPrice*C.value.quantity}</td> 
                                        </tr>
                                    </form>
                                </c:forEach> 
                            </tbody>
                        </table>
                        <h4>In Total: <fmt:formatNumber value="${totalMoney}" type="currency" /></p></h4>
                        <a href="CheckoutController" class="btn btn-success w-15">Order now</a><br> 
                    </c:otherwise>
                </c:choose>
            </div>
        </section>
         
    </body>
</html>
