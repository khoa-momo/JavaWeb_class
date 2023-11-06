<%-- 
    Document   : home
    Created on : 13-Mar-2022, 11:29:24
    Author     : DELL
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link href="css/table.css" rel="stylesheet"/>
        
        
        
    </head>
    <body> 
        <!--------------------------------------- Navi Bar ----------------------------------------->
        <%@include file="components/naviBar.jsp"%> 
        
        <!--------------------------------------- Header ----------------------------------------->
        <header class="bg-dark py-5">
            <div class="container px-4 px-lg-5 my-5">
                <div class="text-center text-white">
                    <h1 class="display-4 fw-bolder">Shop in style</h1>
                    <p class="lead fw-normal text-white-50 mb-0">
                        With this shop hompeage template
                    </p>
                </div>
            </div>
        </header>
        
        <!--------------------------------------- Section ----------------------------------------->
        <section class="py-5">
            <div class="container px-4 px-lg-5 mt-5">
                <div class="row">
                    <h1>Home!</h1>
                    <!-------------------------- List Categories --------------------------> 
                    <!-------------------------- Search --------------------------> 
                    <div>
                        <form action="Search" method="post"> 
                            Address: <input type="text" name="address" value="${address}">
                            Area: <input type="text" name="area" value="${area}">
                            Cost: <input type="text" name="cost" value="${cost}">
                            <input type="Search" value="Search">
                            <input type="submit">
                        </form>
                    </div>
                    <!-------------------------- List Products -------------------------->
                    <div class="col-md-9">
                        <h3>List Rooms</h3> 
                        <!-------------------------- Paging -------------------------->
                        <c:choose>
                            <c:when test="${listProducts==null || listProducts.size()==0}">
                                Not founds
                            </c:when>
                            <c:otherwise>
                                <nav aria-label="Page navigation example" class="d-flex justify-content-center">
                                    <ul class="pagination">
                                        <li class="page-item"><a class="page-link" href="home?page=${page-1}">Previous</a></li>
                                            <c:forEach begin="1" end="${totalPage}" var="i">
                                            <li class="page-item ${i == page?"active":""}"><a class="page-link" href="home?page=${i}">${i}</a></li>
                                            </c:forEach>
                                        <li class="page-item"><a class="page-link" href="home?page=${page+1}">Next</a></li>
                                    </ul>
                                </nav>
                            </c:otherwise>
                        </c:choose> 
                        <!-------------------------- Products -------------------------->
                        <div class="row gx-4 gx-lg-5 row-cols-2 row-cols-md-3 justify-content-center"> <!--Row-col-->
                            <c:forEach items="${rolist}" var="r">
                                <div class="col mb-5">
                                    ${r.roomId}
                                    <div class="card h-100">
                                        <!-- Sale badge-->
                                        <div class="badge bg-dark text-white position-absolute"
                                             style="top: 0.5rem; right: 0.5rem">
                                            Sale
                                        </div>
                                        <!-- Product image-->
                                        <a href="detail?rId=${r.roomId}">
                                            <img
                                                class="card-img-top"
                                                src="image/phongtro2.jpg"
                                                alt="..."/>
                                        </a>
                                        <!-- Product details-->
                                        <div class="card-body p-4">
                                            <div class="text-center">
                                                <!-- Product name-->
                                                <h5 class="fw-bolder">${r.address}</h5>
                                                <!-- Product reviews-->
                                                <div class="d-flex justify-content-center small text-warning mb-2">
                                                    <div class="bi-star-fill"></div>
                                                    <div class="bi-star-fill"></div>
                                                    <div class="bi-star-fill"></div>
                                                    <div class="bi-star-fill"></div>
                                                    <div class="bi-star-fill"></div>
                                                </div>
                                                <!-- Product price-->
                                                <span class="text-muted text-decoration-line-through"
                                                      >$20.00</span>
                                                ${r.cost}₫
                                            </div>
                                        </div>
                                        <!-- Product actions-->
                                        <div class="card-footer p-4 pt-0 border-top-0 bg-transparent">
                                            <div class="text-center">
                                                <a class="btn btn-outline-dark mt-auto" onclick="addToCartAsync(${P.id})">
                                                    Go Detail</a>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </c:forEach> 
                        </div>
                    </div>
                </div>
            </div>
                            
            <!------------------------------ List of rooms ----------------------------------->
            <table border="1" width="30%" align="left" id="table">
                <thead>
                    <tr>
                        <th>Address</th>
                        <th>Area</th>
                        <th>Description</th>
                        <th>Cost</th>
                        <th>Note</th> 
                    </tr>
                </thead>
                <tbody>  
                    <c:forEach items="${rolist}" var="r">
                    <tr>
                        <td>${r.getAddress()}</td>
                        <td>${r.getArea()}</td> 
                        <td>${r.getDescription()}</td> 
                        <td>${r.getCost()}</td> 
                        <td>${r.getNote()}</td>   
                    </tr>                     
                    </c:forEach>    
                </tbody> 
            </table>                 
        </section>
         
        <!--------------------------------------- Footer ----------------------------------------->
        <%@include file="components/footerComponent.jsp" %>
    </body>
</html>
