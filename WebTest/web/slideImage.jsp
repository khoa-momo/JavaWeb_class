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
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <style>
            * {box-sizing: border-box}
            body {font-family: Verdana, sans-serif; margin:0}
            .mySlides {display: none}
            img {vertical-align: middle;}

            /* Slideshow container */
            .slideshow-container {
              max-width: 1000px;
              position: relative;
              margin: auto;
            }

            /* Next & previous buttons */
            .prev, .next {
              cursor: pointer;
              position: absolute;
              top: 50%;
              width: auto;
              padding: 16px;
              margin-top: -22px;
              color: white;
              font-weight: bold;
              font-size: 18px;
              transition: 0.6s ease;
              border-radius: 0 3px 3px 0;
              user-select: none;
            }

            /* Position the "next button" to the right */
            .next {
              right: 0;
              border-radius: 3px 0 0 3px;
            }

            /* On hover, add a black background color with a little bit see-through */
            .prev:hover, .next:hover {
              background-color: rgba(0,0,0,0.8);
            }

            /* Caption text */
            .text {
              color: #f2f2f2;
              font-size: 15px;
              padding: 8px 12px;
              position: absolute;
              bottom: 8px;
              width: 100%;
              text-align: center;
            }

            /* Number text (1/3 etc) */
            .numbertext {
              color: #f2f2f2;
              font-size: 12px;
              padding: 8px 12px;
              position: absolute;
              top: 0;
            }

            /* The dots/bullets/indicators */
            .dot {
              cursor: pointer;
              height: 15px;
              width: 15px;
              margin: 0 2px;
              background-color: #bbb;
              border-radius: 50%;
              display: inline-block;
              transition: background-color 0.6s ease;
            }

            .active, .dot:hover {
              background-color: #717171;
            }

            /* Fading animation */
            .fade {
              -webkit-animation-name: fade;
              -webkit-animation-duration: 1.5s;
              animation-name: fade;
              animation-duration: 1.5s;
            }

            @-webkit-keyframes fade {
              from {opacity: .4} 
              to {opacity: 1}
            }

            @keyframes fade {
              from {opacity: .4} 
              to {opacity: 1}
            }

            /* On smaller screens, decrease text size */
            @media only screen and (max-width: 300px) {
              .prev, .next,.text {font-size: 11px}
            }
            
            .images {
            display: flex;
            flex-wrap: wrap;
            margin: 0 50px;
            padding: 30px;
            }

            .photo {
                max-width: 31.333%;
                padding: 0 10px;
                height: 240px;
            }

            .photo img {
                width: 100%;
                height: 100%;
            }
        </style>
    </head>
    <body>
         
        <div class="slideshow-container">
            
            
                <div class="mySlides fade">
                  <div class="numbertext">1 / 3</div>
                    <div class="images">
                        <div class="photo">
                          <img src="https://bds123.cdn.static123.com/images/2022/02/22/z2513254872272-dc7e88396ed69673fcd19d9a8647b14a_1645502494.jpg" style="height:100; width:100%">
                        </div>
                    </div>
                  <div class="text">Caption Text</div>
                </div>

                <div class="mySlides fade">
                  <div class="numbertext">2 / 3</div>
                    <div class="images">
                        <div class="photo">
                          <img src="https://www.hancorp.com.vn/wp-content/uploads/2020/08/phong-tro-3.jpg" style="height:100; width:100%">
                        </div>
                    </div>
                  <div class="text">Caption Two</div>
                </div>

                <div class="mySlides fade">
                  <div class="numbertext">3 / 3</div>
                    <div class="images">
                        <div class="photo">
                          <img src="https://360nhadep.com/wp-content/uploads/2018/05/xay-nha-tro-cho-thue-thiet-ke-dep-e1470389524173.jpg" style="height:100; width:100%">
                        </div>
                    </div>
                  <div class="text">Caption Three</div>
                </div>
              
            <a class="prev" onclick="plusSlides(-1)">&#10094;</a>
            <a class="next" onclick="plusSlides(1)">&#10095;</a>

        </div>
        <br>

        <div style="text-align:center">
            <span class="dot" onclick="currentSlide(1)"></span> 
            <span class="dot" onclick="currentSlide(2)"></span> 
            <span class="dot" onclick="currentSlide(3)"></span> 
        </div>

        <script>
            var slideIndex = 1;
            showSlides(slideIndex);

            function plusSlides(n) {
              showSlides(slideIndex += n);
            }

            function currentSlide(n) {
              showSlides(slideIndex = n);
            }

            function showSlides(n) {
              var i;
              var slides = document.getElementsByClassName("mySlides");
              var dots = document.getElementsByClassName("dot");
              if (n > slides.length) {slideIndex = 1}    
              if (n < 1) {slideIndex = slides.length}
              for (i = 0; i < slides.length; i++) {
                  slides[i].style.display = "none";  
              }
              for (i = 0; i < dots.length; i++) {
                  dots[i].className = dots[i].className.replace(" active", "");
              }
              slides[slideIndex-1].style.display = "block";  
              dots[slideIndex-1].className += " active";
            }
        </script>

    </body> 
</html>
