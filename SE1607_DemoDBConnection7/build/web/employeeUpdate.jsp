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
        <title>Update Page</title> 
        <style>
        input[type=text], select{
            width: 20%;
            padding: 12px 15px;
            margin: 8px 0;
            display: inline-block;
            border: 1px solid #ccc;
            border-radius: 8px;
            box-sizing: border-box;
        }
        input[type=submit]{
            width: 15%;
            background-color: #4CAF50;
            color: white;
            padding: 14px 20px;
            margin: 8px 0;
            border: none;
            border-radius: 4px;
            cursor: pointer;
        }
        input[type=submit]:hover{
            background-color: #45a049;
        }
        div{
            border-radius: 5px;
            background-color: #f2f2f2;
            padding: 20px;
        }
        </style>
    </head>
    <body>
        <h1>Update employee</h1> 
        <div><form action="employeeUpdate" method="post">
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
