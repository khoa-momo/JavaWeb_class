<%-- 
    Document   : employees
    Created on : Jan 21, 2022, 11:35:55 AM
    Author     : lephu
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>   s
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Show Employee</title> 
    <style>
        #employees {
          font-family: Arial, Helvetica, sans-serif;
          border-collapse: collapse;
          width: 60%;
        }
        #employees td, #employees th {
          border: 1px solid #ddd;
          padding: 8px;
        }
        #employees tr:nth-child(even){background-color: #f2f2f2;}
        #employees tr:hover {background-color: #ddd;}
        #employees th {
          padding-top: 12px;
          padding-bottom: 12px;
          text-align: left;
          background-color: #04AA6D;
          color: white;
        } 
        a:link, a:visited {
        background-color: #00BFFF;
        color: white;
        padding: 8px 12px;
        text-align: center; 
        display: inline-block;
        }
        a:hover, a:active {
            background-color: red;
        }
    </style>
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
