<%-- 
    Document   : takeAttendance
    Created on : 27-Feb-2022, 10:25:00
    Author     : DELL
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>   
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link href="css/styles.css" rel="stylesheet" />
    </head>
    <body>
         
        <c:choose>
            <c:when test="${dateList==null||dateList.size()==0}">
                <h1>List is Empty</h1>
            </c:when>
                
            <c:otherwise>
                <div><h1 align="left">Take attendance</h1></div>
                <div>
                    <table border="1" width="80%" align="center" id="table">
                    <thead>
                        <tr> 
                            <th>Date</th> 
                            <th>Slot</th> 
                        </tr>
                    </thead>  
                    <tbody>
                        <c:forEach items="${dateList}" var="courseSche">
                        <tr>  
                            <td>${courseSche.teachingDate}</td>
                            <td>${courseSche.slot}</td>
                            <td><a href="takeAttendancebyDate?cid=${courseSche.courseId}&date=${courseSche.teachingDate}&slot=${courseSche.slot}">View</a></td> 
                        </tr>                           
                        </c:forEach>     
                    </tbody>
                    </table> 
                </div>
            </c:otherwise> 
        </c:choose>
                        
    </body>
</html>
