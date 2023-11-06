<%-- 
    Document   : customerweb
    Created on : 20-Jan-2022, 16:01:58
    Author     : DELL
--%>
<%@page import="models.Customer"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <%
        ArrayList<Customer> cus = (ArrayList<Customer>)request.getAttribute("cus");
    %>
    <body>
        <h1>List of customers</h1>
        <table border="1">
            <thead>
                <tr>
                    <th>ID</th>
                    <th>LastName</th>
                    <th>FirstName</th>
                    <th>Sex</th>
                    <th>State</th>
                </tr>
            </thead>
            <tbody>
                <% for(Customer c : cus) {%>
                <tr>
                    <td><%= c.getID()%></td>
                    <td><%= c.getLastName()%></td>
                    <td><%= c.getFirstName()%></td>
                    <td><%= c.getSex()%></td>
                    <td><%= c.getState()%></td>
                </tr>
                <%}%>
            </tbody>
        </table> 
    </body>
</html>
