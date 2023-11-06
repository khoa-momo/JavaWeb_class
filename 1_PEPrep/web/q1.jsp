<%-- 
    Document   : q1
    Created on : 19-Mar-2022, 13:17:13
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
        <form action="Cal" method="post">
            First<input type="text" name="first"><br/>
            Second<input type="text" name="second"><br/> 
            Operator
            <select name="Operator">  
                <option value="Concats">Concats</option> 
                <option value="Contains">Contains</option> 
            </select> 
            <input type="submit" value="Submit">
        </form>
        
        
    </body>
</html>
