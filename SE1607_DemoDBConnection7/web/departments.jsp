<%-- 
    Document   : departments
    Created on : Jan 19, 2022, 11:59:51 AM
    Author     : lephu
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>  
<%@page import="dal.DepartmentDAO"%>
<%@page import="models.Department"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Department</title> 
        <% ArrayList<Department> deptList = new DepartmentDAO().getAllDepartments(); %>
    <style>
        #departments {
          font-family: Arial, Helvetica, sans-serif;
          border-collapse: collapse;
          width: 30%;
        }
        #departments td, #departments th {
          border: 1px solid #ddd;
          padding: 8px;
        }
        #departments tr:nth-child(even){background-color: #f2f2f2;}
        #departments tr:hover {background-color: #ddd;}
        #departments th {
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
        <h1 align="center">List of Department</h1>
        <table border="1" width="20%" align="center" id="departments">
            <thead>
                <tr>
                    <th>ID</th>
                    <th>Name</th>
                    <th>Option</th>
                </tr>
            </thead>
            <tbody>  
                <c:forEach items="${deptList}" var="dept">
                <tr>
                    <td>${dept.getId()}</td>
                    <td>${dept.getName()}</td> 
                    <td><a href="employees?did=${dept.getId()}">GoDetails</a></td> 
                </tr>                     
                </c:forEach>    
            </tbody> 
        </table> 
            <a href="employeeFillter">Go to All employees</a>
    </body>
    
    <c:set var="page" value="${requestScope.page}"/>
    <div class="pagination">
        <c:forEach begin="${1}" end="${requestScope.num}" var="i">
        <a href="departments?page=${i}">${i}</a>
        </c:forEach>     
    </div>     
</html>
