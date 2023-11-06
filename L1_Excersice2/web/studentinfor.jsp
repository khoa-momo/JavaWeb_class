<%-- 
    Document   : studentinfor
    Created on : 07-Feb-2022, 22:23:57
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
        <form action="StudentInfor" method="post"> 
            <table>
                <thead>
                    <tr>
                        Enter information of student
                    </tr>
                </thead>
                <tbody>
                    <tr>
                        <td>Student ID:</td>
                        <td><input type="text" name="studentID"/></td>
                    </tr>
                    <tr>
                        <td>Student Name:</td>
                        <td><input type="text" name="studentName"/></td>
                    </tr>
                    <tr>
                        <td>Student Gender:</td>  
                        <td>Male<input type="radio" name="gender" value="Male"/>
                        Female<input type="radio" name="gender" value="Female"/>
                        Other<input type="radio" name="gender" value="Other"/></td>  
                    </tr>  
                    <tr>
                        <td>Student Address:</td>  
                        <td><textarea name="studentAddress" rows="4" cols="20"></textarea></td>  
                    </tr>  
                    <tr>
                        <td>Is active:</td>   
                        <td><input type="checkbox" name="active" value="Is active" />Yes</td>  
                    </tr>  
                    <tr>
                        <td><input type="reset" value="Reset" /></td>
                        <td><input type="submit" name="Save" /></td>
                    </tr> 
                </tbody> 
            </table> 
        </form>
        
        <table border="1" width="80%" align="center"> 
            <thead>
                <tr>
                    <th>ID</th>
                    <th>Name</th>
                    <th>Gender</th>
                    <th>Address</th>
                    <th>Active</th> 
                </tr>
            </thead>
            <tbody> 
                <c:forEach items="${studentList}" var="s">
                <tr>
                    <td>${s.id}</td>
                    <td>${s.name}</td>
                    <td>${s.gender}</td>
                    <td>${s.address}</td>
                    <td>${s.active}</td>  
                </tr>
                </c:forEach>
            </tbody>
        </table>   
        
        
    </body>
</html>
