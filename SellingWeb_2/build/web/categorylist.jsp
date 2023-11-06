<%-- 
    Document   : categorylist
    Created on : 19-Feb-2022, 11:23:58
    Author     : DELL
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<link href="css/style.css" rel="stylesheet" type="text/css"/>
<!DOCTYPE html>
<div class="col-sm-3">
    <div class="card bg-light mb-3">
        <div class="card-header bg-primary text-white text-uppercase"><i class="fa fa-list"></i> Categories</div>
        <ul class="list-group category_block">
            <c:forEach items="${cateList}" var="c">
                <li class="list-group-item text-white ${cateId == c.getCatId() ? "active":""}">
                    <a href="ProductController?cid=${c.getCatId()}">${c.getCatName()}</a>
                </li>
            </c:forEach> 
        </ul>
    </div> 
</div> 
