<%-- 
    Document   : Confirm
    Created on : 09-Mar-2022, 14:39:56
    Author     : DELL
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>  
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Confirm</title>
        <link href="css/styles.css" rel="stylesheet" />
    </head>
    <body> 
        <form action="Confirm" method="post" id="table">
            <h1>Course Detail</h1> 
            <div>
                <table border="1" width="90%" align="center">
                    <thead>
                        <tr>
                            <th>Course Code</th>
                            <th>Course Description</th>
                            <th>Term</th>
                            <th>Subject's Name</th>
                            <th>Instructor's Name</th> 
                            <th>Campus</th> 
                        </tr>
                    </thead>
                    <tbody> 
                        <tr>
                            <td>${courseCode}</td>
                            <td>${courseDes}</td>
                            <td>${teid}</td>
                            <td>${subName}</td>
                            <td>${inName.getFulltName()}</td> 
                            <td>${campid}</td> 
                        </tr>             
                    </tbody>
                </table>
            </div>
            <br>
            <h1>List of students that will be in the Course</h1> 
            <div align="center">
                <table border="1" width="30%" align="center">
                    <thead>
                        <tr>
                            <th>Student's ID</th>
                            <th>Student's Name</th> 
                        </tr>
                    </thead>
                    <tbody> 
                        <c:forEach items="${studList}" var="s"> 
                            <tr> 
                                <td>${s.getStudentId()}</td>
                                <td>${s.getFulltName()}</td>  
                            </tr>     
                        </c:forEach>  
                    </tbody>
                </table>
                
            </div>
            <input type="submit" align="center" value="Save"><br>    
        </form>
            
        
    </body>
</html>
