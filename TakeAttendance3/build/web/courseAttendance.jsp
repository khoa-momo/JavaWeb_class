<%-- 
    Document   : courseAttendance
    Created on : 26-Feb-2022, 15:25:51
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
            <c:when test="${cList==null||cList.size()==0}">
                <h1>List is Empty</h1>
            </c:when> 
            <c:otherwise>
                <div><h1 align="center">List of Course by Subject</h1></div>
                <div>
                    <table border="1" width="80%" align="center" id="table">
                    <thead>
                        <tr> 
                            <th>Subject Code</th>
                            <th>Subject Name</th>
                            <th>Course Name</th> 
                        </tr>
                    </thead> 
                    <tbody> 
                        <c:forEach items="${cList}" var="course">
                        <tr>
                            <td>${course.getSubject().getSubjectCode()}</td> 
                            <td>${course.getSubject().getSubjectName()}</td> 
                            <td>${course.getCourseCode()}</td> 
                            <td><a href="takeAttendance?cid=${course.getCourseId()}">Take Attendance</a></td> 
                        </tr>                           
                        </c:forEach>    
                    </tbody>
                    </table>
                </div>
            </c:otherwise> 
        </c:choose> 
    </body>
</html>
