<%-- 
    Document   : login
    Created on : 04-Mar-2022, 15:01:42
    Author     : DELL
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"> 
        <title>Login Page</title>
    </head>
    <body> 
        <h1>Login</h1>
        <div>
            <form action="Login" method="post">
                <div>
                    Username:<input type="text" name="username"><br/>
                    Password:<input type="text" name="password"><br/>
                </div>
                <div>
                    <input type="submit" value="Login!">
                </div>
            </form>
            ${mess}
        </div>  
    </body>
</html>
