<%-- 
    Document   : employees
    Created on : Jan 21, 2022, 11:35:55 AM
    Author     : lephu
--%>

<%@page import="models.Employee"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <%
            ArrayList<Employee> emps = (ArrayList<Employee>) request.getAttribute("emps");
        %>
    </head>
    <body>
        <h1>List of departments:</h1>
        <table border="1">
            <thead>
                <tr>
                    <th>ID</th>
                    <th>Name</th>
                    <th>Sex</th>
                    <th>Dob</th>
                    <th>Position</th>
                    <th>Department</th>
                    <th></th>
                    <th></th>
                </tr>
            </thead>
            <tbody>
                <% for(Employee e: emps) {%>
                <tr>
                    <td><%= e.getId()%></td>
                    <td><%= e.getName()%></td>
                    <td><%= e.getSex() %></td>
                    <td><%= e.getDob() %></td>
                    <td><%= e.getPosition() %></td>
                    <td><%= e.getDepartment().getName() %></td>
                    <td><a href="">Edit</a></td>
                    <td><a href="">Delete</a></td>
                </tr>
                <%}%>
            </tbody>
        </table>
            <a href="addemployee">Add new Employee</a>
    </body>
</html>
