<%-- 
    Document   : JS_checkedAll
    Created on : 10-Mar-2022, 16:51:36
    Author     : DELL
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <script language="javascript"> 
        document.getElementById('select-all').onclick = function() {
            var checkboxes = document.getElementsByName('vehicle');
            for (var checkbox of checkboxes) {
                checkbox.checked = this.checked;
            }
        }
        </script> 
        <p>Choose your vehicle:</p>
        <div>
            <input type="checkbox" id="bike" name="vehicle" value="bike">
            <label for="bike">Bike</label>
        </div>
        <div>
            <input type="checkbox" id="car" name="vehicle" value="car">
            <label for="car">Car</label>
        </div>
        <div>
            <input type="checkbox" id="select-all">
            <label for="car">Select All</label>
        </div>
    </body>
</html>
