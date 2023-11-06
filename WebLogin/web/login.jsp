<%-- 
    Document   : login
    Created on : 04-Mar-2022, 15:57:26
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
        <h1>Login</h1>
        <form action="login" method="POST">
            <table>
            <tr>
                <td>Username</td>
                <td><input type="text" name="username" value=""/></td>
            </tr>
            <tr>
               <td>Password</td>
               <td><input type="text" name="password" value=""/></td>
            </tr>
            <tr>
              <td> <input type="checkbox" name="remember" value="true" />Remember me</td>
            </tr>
            <tr>
              <td><input type="submit" value="Login" /></td>
            </tr>
           </table>
        </form>
    </body>
</html>
