<%-- 
    Document   : LoginProcessjsp
    Created on : 18-Jan-2022, 22:43:33
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
        <form method="post" action="LoginProcess">
            <center><table>
            <tr><th colspan="2">Login</th></tr> 
            <tr>
                <td>Username</td>          
                <td><input type="text" name="username"/></td>
            </tr>
            <tr>
                <td>Password</td>          
                <td><input type="text" name="password"/></td>
            </tr>
            <tr>         
                <td colspan="2">Remember username&password?<input type='checkbox' name='save'/></td>
            </tr>
            <tr><td><input type='submit' value='Login'/></td></tr>
            </table></center>
        </form>
    </body>
</html>
