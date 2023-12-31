<%-- 
    Document   : rangeSlider
    Created on : 20-Mar-2022, 23:05:23
    Author     : DELL
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link rel="stylesheet" href="https://demos.jquerymobile.com/1.4.2/css/themes/default/jquery.mobile-1.4.2.min.css">  
        <script src="https://demos.jquerymobile.com/1.4.2/js/jquery.js"></script> 
	<script src="https://demos.jquerymobile.com/1.4.2/js/jquery.mobile-1.4.2.min.js"></script>
        <style>
            form  {
                margin: 60px 0 0 0 !important;
             }

            .ui-slider .ui-btn-inner {
                padding: 4px 0 0 0 !important;
            }

            .ui-slider-popup {
                position: absolute !important;
                width: 64px;
                height: 64px;
                text-align: center;
                font-size: 36px;
                padding-top: 14px;
                z-index: 100;
                opacity: 0.8;
            }
        </style>
    </head>
    <body>
        <form action="rangeSlider" method="Post">
            <div data-role="rangeslider">
                <label for="range-1a">Rangeslider:</label>
                <input type="range" name="range_1a" id="range-1a" min="0" max="100" value="40" data-popup-enabled="true" data-show-value="true">
                <label for="range-1b">Rangeslider:</label>
                <input type="range" name="range_1b" id="range-1b" min="0" max="100" value="80" data-popup-enabled="true" data-show-value="true">
                <input type="submit" value="Save" />
            </div>
        </form>
        
        <script type="text/javascript">  
            $('input').popup(); 
        </script>
    </body>
</html>
