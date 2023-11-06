<%-- 
    Document   : employeeFillter
    Created on : 08-Feb-2022, 23:51:40
    Author     : DELL
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@page import="dal.EmployeeDAO"%>
<%@page import="models.Employee"%>
<%@page import="dal.DepartmentDAO"%>
<%@page import="models.Department"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <%
            ArrayList<Department> deptList = new DepartmentDAO().getAllDepartments();
            int depid = 1;
//            String ename = request.getParameter("ename");
        %>
        <!--ArrayList<Employee> emplistFillter = (ArrayList<Employee>) request.getAttribute("emplistFillter");  
        -->
        <style>
        input[type=text], select{
            width: 20%;
            padding: 12px 15px;
            margin: 2px 0;
            display: inline-block;
            border: 1px solid #ccc;
            border-radius: 8px;
            box-sizing: border-box;
        }
        input[type=submit]{
            width: 10%;
            background-color: #4CAF50;
            color: white;
            padding: 10px 12px;
            margin: 8px 0;
            border: none;
            border-radius: 4px;
            cursor: pointer;
        }
        input[type=submit]:hover{
            background-color: #45a049;
        }
        div{
            border-radius: 2px;
            background-color: #f2f2f2;
            padding: 10px;
        }
        #employees {
          font-family: Arial, Helvetica, sans-serif;
          border-collapse: collapse;
          width: 80%;
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
        </style>
    </head>
    <body>
        <div><form action="employeeFillter" method="post"> 
            Name: <input type="text" name="ename" value="${ename}"><br>
            Sex:
            Male<input type="radio" name="esex" value="Male"${esex.equalsIgnoreCase("Male")?"checked":""}/>  
            Female<input type="radio" name="esex" value="Female"${esex.equalsIgnoreCase("Female")?"checked":""}/>
            <br>
            Date From: <input type="date" name="dateFrom" value="${dateFrom}"><br>
            Date To: <input type="date" name="dateTo" value="${dateTo}"><br>
            Position: <input type="text" name="eposition" value="${eposition}"><br>
            Department: 
            <select name="deparment"> 
                <%for (Department d: deptList) {%>
                <option value="<%= d.getId()%>" <%= depid==d.getId()?"selected":""%>> <%= d.getName()%> </option>
                <%}%>
            </select><br>
            <input type="submit" value="Search!">
            </form></div>
                     
        <h1 align="center">List of Employee</h1>
        <table border="1" width="80%" align="center" id="employees"> 
            <thead>
                <tr>
                    <th>ID</th>
                    <th>Name</th>
                    <th>Sex</th>
                    <th>Date of birth</th>
                    <th>Position</th>
                    <th>Department</th>
                </tr>
            </thead>
            <tbody> 
                <c:forEach items="${emplist}" var="emp">
                <tr>
                    <td>${emp.id}</td>
                    <td>${emp.name}</td>
                    <td>${emp.sex}</td>
                    <td>${emp.dob}</td>
                    <td>${emp.position}</td> 
                    <td>${emp.getDepartment().getName()}</td> 
                </tr>
                </c:forEach>
            </tbody>
        </table>   
              
        <c:set var="page" value="${requestScope.page}"/>
    <div class="pagination">
        <c:forEach begin="${1}" end="${requestScope.num}" var="i">
            <a href="employeeFillter?page=${i}">${i}</a>
        </c:forEach>     
    </div>     
    </body>
</html>
