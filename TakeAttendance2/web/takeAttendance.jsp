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
    </head>
    <body>
        <div><h1 align="center">Take attendance</h1></div>
        <div>
            <table border="1" width="10%" align="left" id="products">
            <thead>
                <tr> 
                    <th>Date</th> 
                </tr>
            </thead>  
            <tbody>
                <c:forEach items="${dateList}" var="d">
                <tr>  
                    <td><a href="takeAttendance?cid=${cId}&?date=${d.getTeachingDate()}">${d.getTeachingDate()}</a></td> 
                </tr>                           
                </c:forEach>     
            </tbody>
            </table>
                
            <form action="takeAttendance" method="post">
                <table border="1" width="80%" align="center">
                    <thead>
                        <tr> 
                            <th>Roll</th>
                            <th>Name</th> 
                            <th>Absent</th> 
                            <th>Present</th> 
                        </tr>
                    </thead> 
                         
                    
                    <tbody>
                        <c:forEach items="${attendList}" var="al"> 
                        <tr>    
                            
                            <td>${al.getStudentId()}</td>
                            <td>${al.getStudentId()}</td>  
                            <td> 
                                <input type="radio" name="absent" value="1"${al.getIsAbsent()==1?"checked":""}/>
                            </td> 
                            <td> 
                                <input type="radio" name="absent" value="0"${al.getIsAbsent()==0?"checked":""}/>
                            </td>
                        
                        </tr>
                        </c:forEach>     
                    </tbody>
            
                </table>    
                <input type="submit" value="Submit">
            </form>  
        </div>
    </body>
</html>
