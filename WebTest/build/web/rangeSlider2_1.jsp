<%-- 
    Document   : rangeSlider2
    Created on : 23-Mar-2022, 14:58:00
    Author     : DELL
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link href="/WebTest/css/rs.css" rel="stylesheet" /> 
    </head>
    <body>
        
        <div class="container">
          <div class="row">
            <div class="col-sm-12">
              <div id="slider-range"></div>
            </div>
          </div>
          <div class="row slider-labels">
            <div class="col-xs-6 caption">
              <strong>Min:</strong> <span id="slider-range-value1"></span>
            </div>
            <div class="col-xs-6 text-right caption">
              <strong>Max:</strong> <span id="slider-range-value2"></span>
            </div>
          </div>
          <div class="row">
            <div class="col-sm-12">
              <form>
                <input type="hidden" name="min-value" value="">
                <input type="hidden" name="max-value" value="">
              </form>
            </div>
          </div>
        </div>
        
        <script src="newjs.js"></script>
    </body>
    

</html>
