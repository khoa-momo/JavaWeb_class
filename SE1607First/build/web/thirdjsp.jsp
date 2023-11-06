<%-- 
    Document   : thirdjsp
    Created on : Jan 10, 2022, 11:29:08 AM
    Author     : lephu
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>      
    </head>
    <body>
        <form action="Third" method="post">
            Ten: <input name='name' type='text'><br>
            MaSo: <input name='roll' type='text'><br>
            <input type='submit' name='btsubmit' value='Submit'>
        </form>
        <!--Hien thi mess ket qua -->    
        <%
            //lay lai du lieu gui tu servlet xuong
            String mess = request.getAttribute("mess").toString();            
        %>
        <%=mess%>
    </body>
</html>
