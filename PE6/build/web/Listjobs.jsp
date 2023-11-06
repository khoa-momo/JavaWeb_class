<%-- 
    Document   : Listjobs
    Created on : 17-Mar-2022, 10:32:52
    Author     : DELL
--%>

<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%> 
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>  
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <div>
            <table border="1" width="80%" align="center">
            <thead>
                <tr>
                    <th>Job ID</th>
                    <th>Job Name</th>
                    <th>Job Salary</th>
                    <th>Hire Date</th>
                    <th>Activate(Yes/No)</th> 
                </tr>
            </thead>
            <tbody>
                <c:forEach items="${jobList}" var="o">
                <tr>
                    <td><a href="EmployeeJob?jid=${o.jobId}">${o.jobId}</a></td>
                    <td><a href="EmployeeJob?jid=${o.jobId}">${o.name}</a></td>
                    <td>${o.salary}</td> 
                    <td><fmt:formatDate value="${o.dateCreated}" pattern="dd/MM/yyyy"/></td>
                    <td> 
                        ${o.activate eq "1"?"Yes":"No"}
                    </td> 
                </tr>                     
                </c:forEach>     
            </tbody>
            </table>
        </div>  
    </body>
</html>
