<%-- 
    Document   : addemployee
    Created on : Jan 21, 2022, 11:52:47 AM
    Author     : lephu
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>  
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Adding Page</title> 
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
        <h1>Add new employee</h1>
        <div><form action="addemployee" method="post">
            <table border="1" width="80%" align="center">
                <tr>
                    <td>Name:<br> <input type="text" name="ename"></td>
                </tr>
                <tr>
                    <td>Gender:
                        Male<input type="radio" name="esex" value="Male"/>
                        Female<input type="radio" name="esex" value="Female"/>
                    </td>
                </tr>
                <tr>
                    <td>Day of birth: <input type="date" name="edob"><br></td>
                </tr>
                <tr>
                    <td>Position:<br> <input type="text" name="eposition"></td>
                </tr>
                <tr>
                    <td>Department: <select name="deparment"> 
                        <c:forEach items="${deptList}" var="dept">
                        <option ${dept.getId()==did?"selected":""} value="${dept.getId()}">${dept.getName()}</option>
                        </c:forEach>    
                    </select> 
                    </td> 
                </tr>  
            </table>
            <input type="submit" value="Add new employee!">
        </form></div>  
    </body>
</html>
