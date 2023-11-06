<%-- 
    Document   : JS_checkedAll2
    Created on : 10-Mar-2022, 16:55:37
    Author     : DELL
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Javascript Example</title>
    </head>
    <body>
        <h2>Tạo check all và uncheck all trong Javascript</h2>
        
        <table border='1' cellspacing='0' cellpadding='10'>
            
            <tr style="font-weight: bold">
                <td><input type='checkbox' name='name[]' id='check_all' value='' /></td>
                <td>Nguyễn Văn Cường</td>
            </tr>
            
            
            <tr style="font-weight: bold">
                <td><input type='checkbox' name='name[]' id='check_all' value='' /></td>
                <td>Vũ Thị Thu Tình</td>
            </tr>
            <tr style="font-weight: bold">
                <td><input type='checkbox' name='name[]' id='check_all' value='' /></td>
                <td>Nguyễn Văn Thiên</td>
            </tr>
            <tr style="font-weight: bold">
                <td><input type='checkbox' name='name[]' id='check_all' value='' /></td>
                <td>Nguyễn Thị Thanh Thu</td>
            </tr>
            
            
            
        </table>
        <br/>
        <br/>
        <input type="button" id="btn1" value="Chọn hết"/>
        <input type="button" id="btn2" value="Bỏ chọn"/>
         
         
        <script language="javascript">
 
            // Chức năng chọn hết
            document.getElementById("btn1").onclick = function () {
                // Lấy danh sách checkbox
                var checkboxes = document.getElementsByName('name[]');
 
                // Lặp và thiết lập checked
                for (var i = 0; i < checkboxes.length; i++){
                    checkboxes[i].checked = true;
                }
            };
 
            // Chức năng bỏ chọn hết
            document.getElementById("btn2").onclick = function () {
                // Lấy danh sách checkbox
                var checkboxes = document.getElementsByName('name[]');
 
                // Lặp và thiết lập Uncheck
                for (var i = 0; i < checkboxes.length; i++){
                    checkboxes[i].checked = false;
                }
            };
 
        </script>
    </body>
</html>
