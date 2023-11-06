<%-- 
    Document   : sum
    Created on : 03-Mar-2022, 22:44:37
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
        <form action="compute" method="post">
            <table>
                <tr>
                    <td>Enter a:</td>
                    <td><input type="text" name="a" /></td>
                </tr>
                <tr>
                    <td>Enter b:</td>
                    <td><input type="text" name="b" /></td>
                </tr>
                <tr>
                    <td><input type="submit" value="sum"/></td>
                    <td></td>
                </tr>
                <tr>
                    <td>Result</td>
                    <td><input type="text" value="${result}" /></td>
                </tr>
            </table> 
        </form>
    </body>
</html>
