<%-- 
    Document   : student
    Created on : 04-Mar-2022, 09:56:02
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
        <form action="studentCon" method="post"> 
        Search:<input type="text" name="code" value="${code}"> 
        <br>
            <div>
                <table border="1" width="80%" align="center">
                <thead>
                    <tr> 
                        <th>Id</th>
                        <th>Name</th> 
                        <th>Dob</th> 
                        <th>Gender</th> 
                    </tr>
                </thead> 
                <tbody>
                    <c:forEach items="${sList}" var="s">
                    <tr>
                        <td>${s.id}</td>
                        <td>${s.name}</td>  
                        <td>${s.dob}</td>  
                        <td>${s.gender}</td>   
                    </tr>                           
                    </c:forEach>     
                </tbody>
                </table>
            </div>
        </form>
    </body>
</html> 