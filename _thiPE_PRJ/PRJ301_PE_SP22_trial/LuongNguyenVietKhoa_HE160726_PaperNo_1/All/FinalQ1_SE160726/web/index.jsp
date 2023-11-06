<%-- 
    Document   : index
    Created on : 14-Mar-2022, 11:18:29
    Author     : DELL
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body> 
        <%-- Table form--%>
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
                        <td>Student Gender:</td><td>
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
                        <td></td><td>  
                            <input type="submit" value="Create">
                        </td> 
                    </tr>    
                </table>  
            </form>
        </div> 
    </body>
</html>
