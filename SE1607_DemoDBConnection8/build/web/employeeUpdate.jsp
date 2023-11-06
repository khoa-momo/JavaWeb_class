<%-- 
    Document   : employeeUpdate
    Created on : 05-Feb-2022, 15:49:23
    Author     : DELL
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>  
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Update Employee</title> 
        <link href="css/inputI.css" rel="stylesheet" />
    </head>
    <body>
        <h1>Update employee</h1> 
        <div id="input"><form action="employeeUpdate" method="post" >
            <input type="hidden" name="empID" value="${e.getId()}"> 
            Name: <input type="text" name="ename" value="${e.getName()}"><br>
            Sex:
            Male<input type="radio" name="esex" value="Male"${e.getSex().equalsIgnoreCase("Male")?"checked":""}/>
            Female<input type="radio" name="esex" value="Female"${e.getSex().equalsIgnoreCase("Female")?"checked":""}/><br>
            Day of birth: <input type="date" name="edob" value="${e.getDob()}"><br>
            Position: <input type="text" name="eposition" value="${e.getPosition()}"><br>
            Department: 
            <select name="deparment">
                <c:forEach items="${deptList}" var="dept">
                    <option ${e.getDepartment().getName()== dept.getName()?"selected":""} value="${dept.getId()}">${dept.getName()}</option>
                </c:forEach>                
            </select><br> 
            <input type="submit" value="Update employee!">
        </form></div>
    </body>
</html>
