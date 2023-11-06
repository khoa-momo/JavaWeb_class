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
        <link href="/SE1607_DemoDBConnection8/css/inputI.css" rel="stylesheet" />
        <link href="/SE1607_DemoDBConnection8/css/styles.css" rel="stylesheet" />
        <link href="/SE1607_DemoDBConnection8/css/styleBoot.css" rel="stylesheet" />
        <%
            ArrayList<Department> deptList = new DepartmentDAO().getAllDepartments();
            int depid = 2; 
        %> 
    </head>
    <body>
        <div>
            <form action="employeeFillter" method="post"> 
                Name: <input type="text" name="ename" value="${ename}"><br>
                Sex:
                Male<input type="radio" name="esex" value="Male"${esex.equalsIgnoreCase("Male")?"checked":""}/>  
                Female<input type="radio" name="esex" value="Female"${esex.equalsIgnoreCase("Female")?"checked":""}/>
                All<input type="radio" name="esex" value="All"/>
                <br>
                Date From: <input type="date" name="dateFrom" value="${dateFrom}"><br>
                Date To: <input type="date" name="dateTo" value="${dateTo}"><br> 
                Department:  
                <select name="deparment"> 
                    <c:forEach items="${deptList}" var="dept">
                        <option value="${dept.getId()} ${depid==dept.getId()?"selected":""}">
                            ${dept.getName()}
                        </option>
                    </c:forEach>    
                </select><br>
                <input type="submit" value="Search!">
            </form>
        </div>     
                
        <h3>List</h3> 
        <!-------------------------- Paging -------------------------->
        <c:choose>
            <c:when test="${emplist==null || emplist.size()==0}">
                Not founds
            </c:when>
            <c:otherwise>
                <nav aria-label="Page navigation example" class="d-flex justify-content-center">
                    <ul class="pagination">
                        <li class="page-item"><a class="page-link" href="employeeFillter?page=${page-1}">Previous</a></li>
                            <c:forEach begin="1" end="${totalPage}" var="i">
                            <li class="page-item ${i == page?"active":""}"><a class="page-link" href="employeeFillter?page=${i}">${i}</a></li>
                            </c:forEach>
                        <li class="page-item"><a class="page-link" href="employeeFillter?page=${page+1}">Next</a></li>
                    </ul>
                </nav>
            </c:otherwise>
        </c:choose> 
        <!-------------------------- Products -------------------------->        
                
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
         
    </body>
</html>
