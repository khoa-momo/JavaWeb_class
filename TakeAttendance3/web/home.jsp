<%-- 
    Document   : home
    Created on : 25-Feb-2022, 12:06:42
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
        <a href="CourseInfo">Courseinfo</a>
        <div><h1 align="center">List of Subjects</h1></div>
        <div><form action="home" method="post"> 
            Search:<input type="text" name="code" value="${code}"></form>
        </div>
        <br>
        <div>
            <table border="1" width="80%" align="center" id="table">
            <thead>
                <tr> 
                    <th>Subject Code</th>
                    <th>Subject Name</th> 
                </tr>
            </thead> 
            <tbody>
                <c:forEach items="${subList}" var="s">
                <tr>
                    <td>${s.subjectCode}</td>
                    <td>${s.subjectName}</td>  
                    <td><a href="CourseAttendance?sid=${s.subjectId}">Go to take attendance</a></td> 
                </tr>                           
                </c:forEach>     
            </tbody>
            </table>
        </div>
    </body>
</html>
