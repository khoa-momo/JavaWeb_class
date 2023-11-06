<%-- 
    Document   : ArrangeJob
    Created on : 17-Mar-2022, 15:35:45
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
        <form action="ArrangeJob" method="POST">
            Option Drop-down:  
            <select name="empID"> 
                <c:forEach items="${elist}" var="option">
                    <option name="" value="${option.empID}">${option.fullName}</option>
                </c:forEach>    
                <input type="hidden" name="jid" value="${jid}" /> 
                <input type="submit" value="Assign"/>
            </select>   
        </form>
        
    </body>
</html>
