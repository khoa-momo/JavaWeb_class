<%-- 
    Document   : cookie_Demo
    Created on : 18-Jan-2022, 20:03:54
    Author     : DELL
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Cookie Demo</title>
        <%
            String rollnum = request.getAttribute("roll").toString();
            String name = request.getAttribute("name").toString();
        %>
    </head>
    <body>
        <form action="Demo_Cookie" method="post">
            <input type="text" name="roll" value="<%=rollnum%>">
            <input type="text" name="name" value="<%=name%>">
            <input type="submit" name ="btSubmit" value="Submit">
        </form>
            
    </body>
</html>
