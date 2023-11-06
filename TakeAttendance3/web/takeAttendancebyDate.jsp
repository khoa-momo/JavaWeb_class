<%-- 
    Document   : takeAttendancebyDate
    Created on : 27-Feb-2022, 15:19:49
    Author     : DELL
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>   
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Take attendance</title>
        <link href="css/styles.css" rel="stylesheet" />
    </head>
    <body> 
        <!-- Insert/Update -->
        <div>   
        <c:choose>
            <%-- Case 1:List da duoc diem danh --%>
            <c:when test="${attendList.size()!=1}"> 
                <div><h1 align="left">FPT University Academic Portal</h1></div> 
                <div><h2 align="center">Change attendance</h2></div> 
                <div><h4 align="center">Attendance at slot ${slot} on ${date}!</h2></div> 
                <div><h3 align="center">${update}</h3></div>  
                <form action="takeAttendancebyDate" method="post" id="table">
                    <input type="submit" align="center" value="Save" id="button"> 
                    <table border="1" width="80%" align="center">
                        <thead>
                            <tr> 
                                <th>Group</th>
                                <th>Roll Number</th>
                                <th>Full Name</th> 
                                <th>Absent</th> 
                                <th>Present</th> 
                                <th>Comment</th> 
                            </tr>
                        </thead>  
                        <tbody>
                            <c:forEach items="${attendList}" var="al"> 
                            <tr>     
                                <td>${code}</td>
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
            </c:when>
            
            <%-- Case 2:List chua duoc diem danh --%>
            <c:otherwise> 
                <div><h1 align="center">Take new attendance</h1></div> 
                <form action="insertAttendance" method="post" id="table">
                    <input type="submit" align="center" value="Save"> 
                    <!-- Case 1:List da duoc diem danh -->
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
                            <c:forEach items="${scheList}" var="sche"> 
                            <tr>     
                                <td>${sche.getStudent().getRoll()}</td>
                                <td>${sche.getStudent().getFulltName()}</td>  
                                <td><input type="radio" name="${sche.getStudent().getStudentId()}" value="0" checked="checked"/></td>
                                <td><input type="radio" name="${sche.getStudent().getStudentId()}" value="1"/></td>
                                <td><input type="text" name="comment"></td>  
                            </tr>
                            </c:forEach>   
                        </tbody>
                    </table>    
                    <input type="hidden" name="teachingid" value="${teachingid}">
                    <input type="hidden" name="cid" value="${cid}">
                    <input type="hidden" name="date" value="${date}">
                    <input type="hidden" name="slot" value="${slot}">   
                </form>
            </c:otherwise> 
        </c:choose> 
        </div>
    </body>
</html>
