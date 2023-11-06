<%-- 
    Document   : productlist
    Created on : 19-Feb-2022, 11:23:44
    Author     : DELL
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<link href="css/style.css" rel="stylesheet" type="text/css"/>
<!DOCTYPE html> 

<div class="col-sm-9">
    <div id="content" class="row">
        <c:forEach items="${prolist}" var="p">
            <div class="product col-12 col-md-6 col-lg-4">
                <div class="card"> 
                    <img class="card-img-top" src="image/download.jpg" alt="..."/>
                    <div class="card-body">
                        <h4 class="card-title show_txt">${p.getProductName()}</h4>
                        <p class="card-text show_txt">Quantity: ${p.getUnitsInStock()}</p>
                        <div class="row">
                            <div class="col">
                                <p class="btn btn-danger color btn-block">${p.getUnitPrice()}$</p>
                            </div>
                            <div class="col">
                                <a href="AddToCart?pid=${p.getProductId()}&cid=${p.getCategory().getCatId()}" class="btn btn-success btn-block">Add to cart</a>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </c:forEach>
    </div> 
</div> 
         