<%-- 
    Document   : EmployeeJob
    Created on : 17-Mar-2022, 11:56:39
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
        List of employee in:</br>
        <c:forEach items="${elist}" var="e">
            ${e.fullName}<input type="checkbox" name="checkbox" ${e.isemp==1?"checked":""}/><br/>
        </c:forEach>  
        <a href="ArrangeJob?jid=${jid}">Arrange Job</a>
           
    </body>
</html> 
 