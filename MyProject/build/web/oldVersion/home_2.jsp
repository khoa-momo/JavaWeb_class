<%-- 
    Document   : home
    Created on : 05-Mar-2022, 11:29:24
    Author     : DELL
--%> 
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"> 
        <title>Home</title>  
        <link href="/MyProject/css/styles.css" rel="stylesheet" />
    </head>
    <body> 
        <!--------------------------------------- Navi Bar ----------------------------------------->
        <%@include file="components/naviBar.jsp"%> 
        
        <!--------------------------------------- Header ----------------------------------------->
        <header class="bg-dark py-5">
            <div class="container px-4 px-lg-5 my-5">
                <div class="text-center text-white">
                    <h1 class="display-4 fw-bolder">Cho thuê - Tìm nhà trọ</h1>
                    <p class="lead fw-normal text-white-50 mb-0">
                    </p>
                </div>
            </div>
        </header>
        
        <!--------------------------------------- Section ----------------------------------------->
        <section class="py-5">
            <div class="container px-4 px-lg-5 mt-5">
                <div class="row">
                    <h1>Tìm kiếm</h1>
                    <!-------------------------- List Categories --------------------------> 
                    <!-------------------------- Search --------------------------> 
                    <div> 
                        <form action="Home" method="post"> 
                            City:  
                            <select name="province"> 
                                <option ${provinceName eq "All"?"selected":""} value="All">All</option>
                                <c:forEach items="${provinceList}" var="p">
                                    <option ${p.provinceName==sessionScope.province?"selected":""} value="${p.provinceName}">${p.provinceName}</option>
                                </c:forEach>    
                            </select> 
                            District:  
                            <select name="district"> 
                                <option ${districtName eq "All"?"selected":""} value="All">All</option>
                                <c:forEach items="${districtList}" var="d">
                                    <option ${d.provinceName==sessionScope.district?"selected":""} value="${d.provinceName}">${d.provinceName}</option>
                                </c:forEach>    
                            </select> 
                            Street: <input type="text" name="address" value="${address}">
                            <br/>
                            AreaFrom: <input type="text" name="areaFrom" value="${areaFrom}">
                            AreaTo: <input type="text" name="areaTo" value="${areaTo}">
                            <br/>
                            CostFrom: <input type="text" name="costFrom" value="${costFrom}"> 
                            CostTo: <input type="text" name="costTo" value="${costTo}"> 
                            <br/>
                            <input type="submit" value="Search">
                        </form>
                    </div>
                    <!-------------------------- List Products -------------------------->
                    <div class="col-md-9">
                        <h3>List Rooms</h3> 
                        <!-------------------------- Paging -------------------------->
                        <c:choose>
                            <c:when test="${rolist==null || rolist.size()==0}">
                                Hiện tại chưa có tin đăng cho danh mục này
                            </c:when>
                            <c:otherwise>
                                <nav aria-label="Page navigation example" class="d-flex justify-content-center">
                                    <ul class="pagination">
                                        <li class="page-item"><a class="page-link" href="Home?page=${page-1}">Previous</a></li>
                                            <c:forEach begin="1" end="${totalPage}" var="i">
                                            <li class="page-item ${i == page?"active":""}"><a class="page-link" href="Home?page=${i}">${i}</a></li>
                                            </c:forEach>
                                        <li class="page-item"><a class="page-link" href="Home?page=${page+1}">Next</a></li>
                                    </ul>
                                </nav>
                            </c:otherwise>
                        </c:choose> 
                        <!-------------------------- Products -------------------------->
                        <div class="row gx-4 gx-lg-5 row-cols-2 row-cols-md-3 justify-content-center"> <!--Row-col-->
                            <c:forEach items="${rolist}" var="r">
                                <div class="col mb-5">
                                    #${r.roomId}
                                    <div class="card h-100">
                                        <!-- Sale badge-->
                                        <div class="badge bg-dark text-white position-absolute"
                                             style="top: 0.5rem; right: 0.5rem">
                                            Sale
                                        </div>
                                        <!-- Product image-->
                                        <a href="Detail?roomId=${r.roomId}"> 
                                            <img class="card-img-top" src="${r.firstImage}" alt="No Image"/> 
                                        </a>
                                        <!-- Product details-->
                                        <div class="card-body p-4">
                                            <div class="text-center">
                                                <!-- Product name-->
                                                <h5 class="fw-bolder">${r.title}</h5>
                                                <!-- Product reviews-->
                                                <div class="d-flex justify-content-center small text-warning mb-2">
                                                    <div class="bi-star-fill"></div>
                                                    <div class="bi-star-fill"></div>
                                                    <div class="bi-star-fill"></div>
                                                    <div class="bi-star-fill"></div>
                                                    <div class="bi-star-fill"></div>
                                                </div>
                                                <!-- Product price--> 
                                                ${r.cost}₫ ${r.area}m² ${r.dateCreated}
                                                <span class="text-muted">${r.description}</span> 
                                            </div>
                                        </div>
                                        <!-- Product actions-->
                                        <div class="card-footer p-4 pt-0 border-top-0 bg-transparent">
                                            <div class="text-center">
                                                <a href="Detail?roomId=${r.roomId}" class="btn btn-outline-dark mt-auto">
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
        </section>
        <!--------------------------------------- Footer ----------------------------------------->
        <%@include file="components/footer.jsp" %>
    </body>
</html>
