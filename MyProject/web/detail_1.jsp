<%-- 
    Document   : detail
    Created on : 13-Mar-2022, 21:56:05
    Author     : DELL
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
    <head>
      <title>Bootstrap Example</title>
      <meta charset="utf-8">
      <meta name="viewport" content="width=device-width, initial-scale=1"> 
      <link href="/MyProject/css/styles.css" rel="stylesheet" />
    </head>
    <body>

        <!--------------------------------------- Navi Bar ----------------------------------------->
        <%@include file="components/naviBar.jsp"%> 
        
<h1>Carousel Indicators</h1>

<div id="robotcarousel" class="carousel slide" data-bs-ride="carousel">
  
  <div class="carousel-indicators">
    <button type="button" data-bs-target="#robotcarousel" data-bs-slide-to="0" class="active" aria-current="true" aria-label="Slide 1"></button>
    <button type="button" data-bs-target="#robotcarousel" data-bs-slide-to="1" aria-label="Slide 2"></button>
  </div>
  
  <div class="carousel-inner">
    <div class="carousel-item">
      <img class="d-block w-100" src="https://dummyimage.com/450x300/dee2e6/6c757d.jpg" alt="swamp">
    </div>
    <div class="carousel-item active">
      <img class="d-block w-100" src="https://dummyimage.com/450x300/dee2e6/6c757d.jpg" alt="flight">
    </div>
  </div>
  
  <button class="carousel-control-prev" type="button" data-bs-target="#robotcarousel" data-bs-slide="prev">
    <span class="carousel-control-prev-icon" aria-hidden="true"></span>
    <span class="visually-hidden">Previous</span>
  </button>
  <button class="carousel-control-next" type="button" data-bs-target="#robotcarousel" data-bs-slide="next">
    <span class="carousel-control-next-icon" aria-hidden="true"></span>
    <span class="visually-hidden">Next</span>
  </button
  
</div>

    </body>
</html>
