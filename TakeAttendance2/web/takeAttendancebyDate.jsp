<%-- 
    Document   : takeAttendancebyDate
    Created on : 27-Feb-2022, 15:19:49
    Author     : DELL
--%>

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
                                <th><input type="radio" name="absent" value="1"${al.getIsAbsent()==1?"checked":""}/></th> 
                            </td> 
                            <td> 
                                <th><input type="radio" name="absent" value="0"${al.getIsAbsent()==0?"checked":""}/></th> 
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
