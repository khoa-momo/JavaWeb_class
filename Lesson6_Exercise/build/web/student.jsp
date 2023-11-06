<%-- 
    Document   : student
    Created on : 22-Feb-2022, 17:08:21
    Author     : DELL
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>  
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
        <div><form action="StudentController" method="post">   
            Department:
            <select name="did"> 
                    <option value="0">All Department</option>
                <c:forEach items="${listDepartments}" var="d"> 
                    <option ${did==d.did?"selected":""} value="${d.did}">${d.dname}</option>
                </c:forEach>    
            </select>
            <input type="submit" value="Search!">   
        </form></div>  
           
        <div>
            <h1 align="center">List of Student</h1> 
            <table border="1" width="80%" align="center" id="employees">   
                <thead>
                    <tr> 
                        <th>Student Name</th>
                        <th>Day of birth</th>
                        <th>Gender</th> 
                        <th>Department Name</th> 
                    </tr>
                </thead>
                <tbody>
                    <c:forEach items="${listStudents}" var="s">
                    <tr> 
                        <td>${s.sname}</td>
                        <td>${s.dob}</td>
                        <td>${s.gender}</td>
                        <td>${s.department.dname}</td> 
                    </tr>                     
                    </c:forEach>     
                </tbody>
            </table>
        </div> 
                 
    </body>
</html>

