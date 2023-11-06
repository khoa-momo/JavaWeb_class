<%-- 
    Document   : page5jsp
    Created on : 12-Jan-2022, 10:52:12
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
        <form action='page5' method='post'> 
        <center><table>
        <div id="current-time"></div>
        
        <script>
            var curDate = new Date(); 
            var curDay = curDate.getDate(); 
            var curMonth = curDate.getMonth() + 1; 
            var curYear = curDate.getFullYear(); 
            var curHour = curDate.getHours();
            var curMinute = curDate.getMinutes();  
            document.getElementById('current-time').innerHTML = curDay + "/" + curMonth + "/" + curYear +" "+curHour+":"+curMinute;
        </script>
         
        Choose time: 
        <select name="time">
            <option value="1">Minute</option>
            <option value="2">Hour</option>
            <option value="3">Day</option>
            <option value="4">Month</option>
            <option value="5">Year</option>
        </select>  
        <br>
        <input type='submit' value='Submit'> 
        </center></table>
        </form>
        
        <center>
        <!-- Hien thi ket qua -->
        <%
            String responeTime;
            if (request.getAttribute("responeTime") == null)
                responeTime = "";
            else responeTime = request.getAttribute("responeTime").toString();
        %> 
        <h2><%=responeTime%></h2> 
        </center>
    </body>
</html>
