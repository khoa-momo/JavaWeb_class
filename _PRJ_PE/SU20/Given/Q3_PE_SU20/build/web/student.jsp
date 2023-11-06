<%-- 
    Document   : student
    Created on : 04-Mar-2022, 10:16:21
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
        <div><form action="StudentCon" method="post">
            <table border="1" width="80%" align="center">
                <tr>
                    <td>ID:<input type="text" name="id"></td>
                </tr>
                <tr>
                    <td>Name:<input type="text" name="name"></td>
                </tr>
                <tr>
                    <td>Gender:
                        Male<input type="radio" name="gender" value="1"/>
                        Female<input type="radio" name="gender" value="0"/>
                    </td>
                </tr>
                <tr>
                    <td>Day of birth: <input type="date" name="dob"><br></td>
                </tr> 
                <tr>
                    <td>Skills:</br>
                        <c:forEach items="${sList}" var="s">
                            <input type="checkbox" name="skill" value="${s.getId()}">${s.getName()}<br> 
                        </c:forEach>    
                    </td> 
                </tr>  
            </table>
            <input type="submit" value="Add!">
        </form></div>  
    </body>
</html>
