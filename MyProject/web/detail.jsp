<%-- 
    Document   : detail
    Created on : 13-Mar-2022, 21:56:05
    Author     : DELL
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Detail</title>
        <link href="/MyProject/css/styles.css" rel="stylesheet" />
    </head>
    <body>
        <!--------------------------------------- Navi Bar ----------------------------------------->
        <%@include file="components/naviBar.jsp" %> 
        <!--------------------------------------- Product Section -----------------------------------------> 
        <section class="py-5">  
            <div class="container px-4 px-lg-5 my-5"> 
                <div class="row">    
                    <div class="col-md-7"> 
                        <div class="row gx-4 gx-lg-5 align-items-center"> 
                            <!--------  Image --------> 
                            <img class="card-img-top mb-5 mb-md-0" src="${room.firstImage}" alt="..." />
                            
                            
                            <!--------  Detail -------->  
                            <h3 class="display-18 fw-bolder text-danger" ><div class="small mb-1">${room.title}</div></h3>
                            <h4 class="display-18 fw-bolder">Địa chỉ: ${room.locationId}</h4>
                            <div class="fs-5 mb-5"> 
                                <span>Giá cả:${room.cost}₫</span>
                                <span>Diện tích:${room.area}m²</span>
                                <span>Ngày đăng tin:${room.dateCreated}</span><br/>
                                <span>Mã đăng: #${room.roomId}</span>
                            </div>
                            
                            
                            <div class="fs-5 mb-5">         
                                <h4 class="fw-bolder">###Thông tin chi tiết:###</h4>
                                <p class="lead">${room.description}</p>
                                <br/>
                                <h4 class="fw-bolder">###Thông tin liên hệ###</h4>     
                                <p class="lead">Người đăng tin: ${account.fullname}</p>
                                <p class="lead">Email: ${account.email}</p>
                                <p class="lead">Số điện thoại: ${account.phone}</p>  
                            </div> 
                            
                            <h4 class="fw-bolder">###Bản đồ###</h4>
                            <div>
                                <iframe src="https://www.google.com/maps/embed?pb=!1m18!1m12!1m3!1d17843.1504792418!2d105.81843779111456!3d21.029718158177566!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0x3135ab9926e7bd67%3A0x580e078874d5df1e!2sTemple%20Of%20Literature!5e0!3m2!1sen!2s!4v1648106282874!5m2!1sen!2s" width="600" height="450" style="border:0;" allowfullscreen="" loading="lazy"></iframe>
                            </div>
                        </div> 
                    </div>
                            
                    <div class="col-md-2">    
                        <div class="row gx-4 gx-lg-5 row-cols-2 row-cols-md-1 justify-content-center">
                            <h4 class="fw-bolder">Tin mới nhất</h4>
                            <c:forEach items="${lastest}" var="r">
                                <div class="col mb-2"> 
                                    <div class="card h-100"> 
                                        <!-- Product image-->
                                        <a href="Detail?roomId=${r.roomId}"> 
                                            <img class="card-img" src="${r.firstImage}" alt="No Image"/> 
                                        </a>
                                        <!-- Product details-->
                                        <div class="card-body p-1">
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
                                                ${r.cost}₫ ${r.dateCreated} 
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
                                
                                
                                
        <!-- Related items section-->  
        <%@include file="components/footer.jsp" %>
    </body>
</html>
