<%-- 
    Document   : employees
    Created on : Jan 21, 2022, 11:35:55 AM
    Author     : lephu
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>   
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Show Employee</title> 
        <link href="css/styles.css" rel="stylesheet" />
    </head>
    <body>
        <h1 align="center">List of Employee by Department </h1>
        <div>
            <table border="1" width="80%" align="center" id="employees">
            <thead>
                <tr>
                    <th>ID</th>
                    <th>Name</th>
                    <th>Gender</th>
                    <th>Day of birth</th>
                    <th>Position</th>
                    <th>Department</th>
                    <th colspan="2">Options</th> 
                </tr>
            </thead>
            <tbody>
                <c:forEach items="${emplist}" var="e">
                <tr>
                    <td>${e.getId()}</td>
                    <td>${e.getName()}</td>
                    <td>${e.getSex()}</td>
                    <td>${e.getDob()}</td>
                    <td>${e.getPosition()}</td>
                    <td>${e.getDepartment().getName()}</td>
                    <td><a href="employeeUpdate?empID=${e.getId()}">Update</a></td>
                    <td><a href="employeeDelete?empID=${e.getId()}">Delete</a></td>
                </tr>                     
                </c:forEach>     
            </tbody>
            </table>
        </div>
        <div>
            <table>
                <td salign="right">
                    <a href="addemployee?did=${deptid}">Add new Employee</a>
                </td> 
                <td><a href="departments">Go back</a></td>
            </table>
        </div>     
                
             
        
        <%@include file="paging.jsp" %>
    </body>
</html>
