<%-- 
    Document   : login
    Created on : 04-Mar-2022, 15:01:42
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
        <h1>Login</h1>  
            <form action="login" method="post">
                <table border="1">
                    <tr>
                        <td>Username:</td><td><input type="text" name="username"></td>
                    </tr> 
                    <tr>
                        <td>Password::</td><td><input type="text" name="password"></td>
                    </tr>
                    <tr>
                        <td></td><td><input type="submit" value="Login!"></td>
                    </tr>   
                </table>
            </form>  
        <br/> 
            <h3>${mess}</h3>
            <a href="inbox">Go to inbox</a> 
            <a href="create">Go to create</a> 
    </body>
</html>
