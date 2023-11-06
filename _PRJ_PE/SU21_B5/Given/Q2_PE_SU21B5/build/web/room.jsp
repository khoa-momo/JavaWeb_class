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
        <form action="rooms" method="post">
            <div>
                <select name="roomType">
                    <c:forEach items="${typeList}" var="t">
                        <option value="${t.getRoomType()}">${t.getRoomType()}</option>
                    </c:forEach>                
                </select> 
                <input type="submit" value="Filter!">
            </div>
        </form>  
        <table border="1" width="30%" align="left" id="departments">
            <thead>
                <tr>
                    <th>ID</th>
                    <th>Title</th>
                    <th>Status</th>
                    <th>RoomType</th>
                    <th>Square</th>
                    <th>Action</th>
                </tr>
            </thead>
            <tbody>  
                <c:forEach items="${rolist}" var="r">
                <tr>
                    <td>${r.getId()}</td>
                    <td>${r.getTitle()}</td> 
                    <td>${r.getStatus()}</td> 
                    <td>${r.getRoomType()}</td> 
                    <td>${r.getSquare()}</td>  
                    <td><a href="delete?rid=${r.getId()}">Delete</a></td> 
                </tr>                     
                </c:forEach>    
            </tbody> 
        </table> 
            
    </body>
</html>
