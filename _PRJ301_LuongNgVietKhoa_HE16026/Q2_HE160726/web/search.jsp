<%-- 
    Document   : search
    Created on : 19-Mar-2022, 14:13:56
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
        <div>
            <form action="search" method="post"> 
                Account: 
                <select name="option"> 
                    <c:forEach items="${alist}" var="a">
                        <option value="${a.username}">${a.displayName}</option>
                    </c:forEach>    
                </select> 
                <input type="submit" value="Search">
            </form>
            
            <table border="1" width="80%" align="center"> 
            <tbody>
                <c:choose>
                    <c:when test="${slist.size()!=0}">
                         <c:forEach items="${slist}" var="o">
                            <tr>
                                <td>${o.studentId}</td>
                                <td>${o.name}</td>
                                <td>${o.date}</td>  
                                <td>${o.gender eq "1"?"Male":"Female"}</td>  
                            </tr>                     
                        </c:forEach> 
                    </c:when>
                    <c:otherwise> 
                        <td></td> 
                    </c:otherwise>
                </c:choose>  
            </tbody>
            </table>
        </div> 
    </body>
</html>
