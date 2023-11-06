<%-- 
    Document   : room
    Created on : 07-Mar-2022, 12:14:07
    Author     : DELL
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>  
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body> 
        <div class="img" style="background-image: url(https://media.istockphoto.com/photos/blurred-bangkok-city-night-background-picture-id1289383957);"></div>
        <table border="1" width="30%" align="left" id="departments">
            <thead>
                <tr>
                    <th>Address</th>
                    <th>Area</th>
                    <th>Description</th>
                    <th>Cost</th>
                    <th>Note</th> 
                </tr>
            </thead>
            <tbody>  
                <c:forEach items="${rolist}" var="r">
                <tr>
                    <td>${r.getAddress()}</td>
                    <td>${r.getArea()}</td> 
                    <td>${r.getDescription()}</td> 
                    <td>${r.getCost()}</td> 
                    <td>${r.getNote()}</td>   
                </tr>                     
                </c:forEach>    
            </tbody> 
        </table> 
            
    </body>
</html>
