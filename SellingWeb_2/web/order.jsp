<%-- 
    Document   : order
    Created on : 19-Feb-2022, 11:44:13
    Author     : DELL
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>  
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link href="css/styling.css" rel="stylesheet" />   
    </head>
    <body>
        <!-------------------------- Navi Bar ------------------------------>
        <%@include file="components/naviBar.jsp"%>   
        <!--------------------- Product section--------------------->
        <br/>
        <div>
            <table border="1" width="80%" align="center" id="products">
            <thead>
                <tr>
                    <th>Product's Name</th> 
                    <th>Unit Price</th>
                    <th>Quantity</th>
                    <th>Total Price</th> 
                </tr>
            </thead>
            <tbody>
                <c:forEach items="${carts}" var="cart">
                <tr>   
                    <td>${cart.value.getProduct().getProductName()}</td> 
                    <td>${cart.value.product.getUnitPrice()}</td>
                    <td>${cart.value.quantity}</td>
                    <td>${cart.value.product.getUnitPrice()*C.value.quantity}</td>
                </tr>                           
                </c:forEach>     
            </tbody>
            </table>
        </div>
        
        
        <h3>Order product</h3> 
        <form action="CheckoutController" method="post">
            <table border="1" width="80%" align="center">
                <tr>
                    <td>RequiredDate:<input type="date" name="RequiredDate"></td>
                </tr> 
                <tr>
                    <td>Shipper:<select name="ShipperId"> 
                        <c:forEach items="${shipperList}" var="s">
                            <option value="${s.getShipperId()}">${s.getCompanyName()}</option>
                        </c:forEach>    
                    </select></td> 
                </tr>  
                <tr>
                    <td>ShipName:<input type="text" name="shipName"><br></td>
                </tr>
                <tr>
                    <td>ShipAdress:<input type="text" name="shipAddress"><br></td>
                </tr> 
            </table>
            <input type="submit" value="Order!">
        </form>  
        <div>${mess}</div>
    </body>
</html>
