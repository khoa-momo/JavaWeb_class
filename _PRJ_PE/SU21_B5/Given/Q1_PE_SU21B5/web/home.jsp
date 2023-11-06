<%-- 
    Document   : home
    Created on : 07-Mar-2022, 11:27:50
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
        <form action="home" method="post">
            Email <input type="text" name="account"><br/>
            Get: <select name="type">  
                <option value="account">account</option> 
                <option value="domain">domain</option> 
            </select> 
            <input type="submit" value="Submit">
        </form>
        ${result}     
        
    </body>
</html>
