<%-- 
    Document   : employeeDefault
    Created on : 08-Feb-2022, 17:14:11
    Author     : DELL
--%>

<%@page import="dal.EmployeeDAO"%>
<%@page import="models.Employee"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <% ArrayList<Employee> empList = new EmployeeDAO().getAllEmployees(); %>
    <style>
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
        <h1 align="center">List of All Employees</h1>
        <table border="1" width="80%" align="center"  id="employees"> 
            <thead>
                <tr>
                    <th>ID</th>
                    <th>Name</th>
                    <th>Sex</th>
                    <th>Dob</th>
                    <th>Position</th>
                    <th>Department</th>
                </tr>
            </thead>
            <tbody>
                <% for(Employee e: empList) {%>
                <tr>
                    <td><%= e.getId()%></td>
                    <td><%= e.getName()%></td>
                    <td><%= e.getSex() %></td>
                    <td><%= e.getDob() %></td>
                    <td><%= e.getPosition() %></td>
                    <td><%= e.getDepartment().getName() %></td> 
                </tr>
                <%}%>
            </tbody>
            </tbody>
        </table>
        <tr><a href="employeeFillter">Go Fillter</a></tr>
    </body>
</html>
