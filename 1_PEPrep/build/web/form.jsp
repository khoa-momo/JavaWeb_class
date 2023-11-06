<%-- 
    Document   : form
    Created on : 09-Mar-2022, 09:38:01
    Author     : DELL
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>  
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Input form</h1>
        <%-- Table horizontally 1--%>
        <div>
            <form action="" method="post">
                <table border="1" align="center">
                    <tr>
                        <td>Name:<input type="text" name="name"></td>
                    </tr>
                    
                    <tr>
                        <td>Date:<input type="date" name="dob"></td>
                    </tr>
                    
                    <tr>
                        <td>Radio:
                            Male<input type="radio" name="radio" value="Male"/>
                            Female<input type="radio" name="radio" value="Female"/>
                        </td>
                    </tr>
                    
                    <tr>
                        <td>Check box1:</br> 
                            <input type="checkbox" name="checkbox" value="check1">check1<br>  
                            <input type="checkbox" name="checkbox" value="check2">check2<br>  
                        </td> 
                    </tr>  
                    <tr>
                        <td>Check box2:</br>
                            <c:forEach items="${checkbox}" var="s">
                                <input type="checkbox" name="checkbox" value="${checkbox}">${checkbox}<br> 
                            </c:forEach>    
                        </td> 
                    </tr>   
                    
                    <tr>
                        <td>
                            Option Drop-down:  
                            <select name="option"> 
                                <c:forEach items="${option}" var="option">
                                    <option ${option.getId()==option?"selected":""} value="${option}">${option}</option>
                                </c:forEach>    
                            </select> 
                        </td> 
                    </tr>   
                </table>
                <br>
                <input type="submit" value="Add">
            </form>
        </div> 
        </br></br></br>
        <%-- Table horizontally 2--%>
        <div>
            <form action="create" method="post">
                <table border="1" align="center">
                    <tr>
                        <td>StudentID:</td><td><input type="text" name="id"></td>
                    </tr>
                    
                    <tr>
                        <td>Student Name:</td><td><input type="text" name="name"></td>
                    </tr>
                    
                    <tr>
                        <td>DOB</td><td><input type="date" name="dob"></td>
                    </tr>
                    
                    <tr>
                        <td>Student Gender:</td>
                        <td>
                            Male<input type="radio" name="gender" value="Male"/>
                            Female<input type="radio" name="gender" value="Female"/>
                        </td>
                    </tr> 
                    <tr>
                        <td>Check box1:</td>
                        <td>  
                            <input type="checkbox" name="checkbox" value="isScholar" checked/>is Scholar<br>    
                        </td> 
                    </tr>      
                    <tr>
                        <td>
                            Option Drop-down:  
                            <select name="option"> 
                                <c:forEach items="${option}" var="option">
                                    <option ${option.getId()==option?"selected":""} value="${option}">${option}</option>
                                </c:forEach>    
                            </select> 
                        </td> 
                    </tr>   
                    
                    <tr>
                        <td>Submit</td>
                        <td>  
                            <input type="submit" value="Create">
                        </td> 
                    </tr>    
                </table>  
            </form>
        </div> 
        
        </br></br></br>
        <%-- NO table --%>
        <div>
            <form action="" method="post">
                Name:<input type="text" name="name"><br/>
                Date:<input type="date" name="date"><br/>
                
                Radio:
                Male<input type="radio" name="radio" value="Male"/>
                Female<input type="radio" name="radio" value="Female"/>
                <br/>
                Check box:</br> 
                <input type="checkbox" name="checkbox" value="check1">check1<br/>  
                <input type="checkbox" name="checkbox" value="check2">check2<br/>  

                Option Drop-down: 
                <select name="option"> 
                    <c:forEach items="${option}" var="option">
                        <option ${option.getId()==option?"selected":""} value="${option}">${option}</option>
                    </c:forEach>    
                </select> 
                <br/>   
                <textarea name="boxtext" rows="4" cols="20">
                </textarea>
                
                <input type="submit" value="Add">
            </form>
        </div>
        
         
        
    </body>
</html>
