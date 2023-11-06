<%-- 
    Document   : page4jsp
    Created on : 10-Jan-2022, 12:07:10
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
        <form action='page4' method='post'> 
        
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
        <input type='submit' value='Submit'>
        
        </form>
    </body>
</html>
