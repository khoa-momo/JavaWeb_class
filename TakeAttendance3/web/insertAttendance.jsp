<%-- 
    Document   : insertAttendance
    Created on : 01-Mar-2022, 20:05:15
    Author     : DELL
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>   0
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <div><h1 align="center">Take attendance</h1></div> 
        
        <div>  
            <form action="takeAttendancebyDate" method="post" id="table">
                <input type="submit" align="center" value="Save">
                <table border="1" width="80%" align="center">
                    <thead>
                        <tr> 
                            <th>Roll</th>
                            <th>Name</th> 
                            <th>Absent</th> 
                            <th>Present</th> 
                            <th>Comment</th> 
                        </tr>
                    </thead>  
                    <tbody>
                        <c:forEach items="${attendList}" var="al"> 
                        <tr>     
                            <td>${al.getStudent().getRoll()}</td>
                            <td>${al.getStudent().getFulltName()}</td>  
                            <td><input type="radio" name="${al.getStudent().getStudentId()}" value="0"${al.getIsAbsent()==0?"checked":""}/></td>
                            <td><input type="radio" name="${al.getStudent().getStudentId()}" value="1"${al.getIsAbsent()==1?"checked":""}/></td>
                            <td><input type="text" name="comment" value="${al.getComment()}"></td>  
                        </tr>
                        </c:forEach>   
                    </tbody>
                </table>    
                
                <input type="hidden" name="cid" value="${cid}">
                <input type="hidden" name="date" value="${date}">
                <input type="hidden" name="slot" value="${slot}"> 
                
            </form>   
        </div>
    </body>
</html>
