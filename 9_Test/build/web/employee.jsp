<%-- 
    Document   : employee
    Created on : 19-Mar-2022, 10:18:13
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
        <form action="employees" method="post">
            Name:<input type="text" name="name"><br/>  
            Sex:
            Male<input type="radio" name="gender" value="Male" checked/>
            Female<input type="radio" name="gender" value="Female"/> 
            <br/><input type="submit" value="Submit">  
        </form>
        ${alert}
        <c:forEach var="o" items="${listS}">
            ${o.name}  
            -
            ${o.gender} <br>
        </c:forEach>    
    </body>
</html>
