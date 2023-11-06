<%-- 
    Document   : dataTable
    Created on : 09-Mar-2022, 09:57:53
    Author     : DELL
--%> 
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%> 
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>  
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Data</title>
    </head>
    <body>
        
        <%-- Table vertically(Main) List--%>
        <div>
            <table border="1" width="80%" align="center">
            <thead>
                <tr>
                    <th>ID</th>
                    <th>Name</th>
                    <th>Gender</th>
                    <th>Day of birth</th>
                    <th>Position</th>
                    <th>Department</th>
                    <th colspan="2">Options</th> 
                </tr>
            </thead>
            <tbody>
                <c:forEach items="${list}" var="o">
                <tr>
                    <td>${o.getId()}</td>
                    <td>${o.getName()}</td>
                    <td>${o.getSex()}</td>
                    <td>${o.getDob()}</td>
                    <td>${o.getPosition()}</td>
                    <td>${o.getDepartment().getName()}</td>
                    <td><a href="Update?id=${o.getId()}">Update</a></td>
                    <td><a href="Delete?d=${o.getId()}">Delete</a></td>
                    <td><a href="EmployeeJob?jid=${o.jobId}">${o.jobId}</a></td>
                    <td><a href="EmployeeJob?jid=${o.jobId}">${o.name}</a></td> 
                    <td><fmt:formatDate value="${o.dateCreated}" pattern="dd/MM/yyyy"/></td>
                    <td><fmt:formatNumber value="${totalMoney}" type="currency"/></td>
                    <td>${o.activate eq "1"?"Yes":"No"}</td> 
                    <td><img src="images/${E.egender?"1":"0"}.PNG" alt=""/></td>
                    
                    <td><input type="checkbox" ${E.isEnable?"checked":""} /></td>
                    
                    <c:choose>
                        <c:when test="${m.isread==1}">
                            <td><img src="image/eye.png" alt=""/></td> 
                        </c:when>
                        <c:otherwise> 
                            <td></td> 
                        </c:otherwise>
                    </c:choose> 
                </tr>                     
                </c:forEach>     
            </tbody>
            </table>
        </div> 
        
        <%-- ???Table horizontally.// Form --%>
        <div> 
            <table border="1" align="center">
                <tr>
                    <td>StudentID:</td>
                    <td><input type="text" name="id"></td>
                </tr> 
                <tr>
                    <td>Student Name:</td>
                    <td><input type="text" name="name"></td>
                </tr> 
                <tr>
                    <td>DOB</td>
                    <td><input type="date" name="dob"></td>
                </tr> 
                <tr>
                    <td>Student Gender:</td>
                    <td>
                        Male<input type="radio" name="gender" value="Male"/>
                        Female<input type="radio" name="gender" value="Female"/>
                    </td>
                </tr> 
                <tr>
                    <td></td><td>  
                        <input type="checkbox" name="checkbox" value="isScholar" checked/>is Scholar<br>    
                    </td> 
                </tr>      
                <tr>
                    <td></td>
                    <td>  
                        <input type="submit" value="Create">
                    </td> 
                </tr>    
            </table>   
        </div> 
         
        
        
        <%-- Searching form--%>
        
        <div>
            <form action="search" method="post"> 
                Name: <input type="text" name="name" value="${ename}"><br>
                
                Radio:
                Male<input type="radio" name="sex" value="Male"${esex.equalsIgnoreCase("Male")?"checked":""}/>  
                Female<input type="radio" name="sex" value="Female"${esex.equalsIgnoreCase("Female")?"checked":""}/>
                
                <br>
                Date From: <input type="date" name="dateFrom" value="${dateFrom}"><br>
                Date To: <input type="date" name="dateTo" value="${dateTo}"><br> 
                
                Option Drop-down: 
                <select name="option"> 
                    <c:forEach items="${option}" var="option">
                        <option ${option.getId()==option?"selected":""} value="${option}">${option}</option>
                    </c:forEach>    
                </select> 
                <input type="submit" value="Search!">
            </form>
        </div>     
        
        <div>
            <form action="search" method="post">
                Name:<input type="text" name="text"><br/>
                Date:<input type="date" name="date"><br/>
                
                Radio:
                Male<input type="radio" name="radio" value="Male"/>
                Female<input type="radio" name="radio" value="Female"/>
                <br/>
                Check box:</br> 
                <input type="checkbox" name="checkbox" value="check1">check1<br/>  
                <input type="checkbox" name="checkbox" value="check2">check2<br/>  
                
                Option Drop-down 1: 
                <select name="option"> 
                        <option value="${option}">${option}</option>
                        <option value="${option}">${option}</option>
                </select>
                
                Option Drop-down 2: 
                <select name="option"> 
                    <c:forEach items="${option}" var="option">
                        <option ${option.getId()==option?"selected":""} value="${option}">${option}</option>
                    </c:forEach>    
                </select> 
                <br/>   
                <input type="submit" value="Search">
            </form>
        </div>     
                    
        
    </body>
</html>
