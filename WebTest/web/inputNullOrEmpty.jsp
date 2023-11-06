<%-- 
    Document   : newjspinputNullOrEmpty
    Created on : 14-Mar-2022, 20:11:31
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
        <form action="inputNullOrEmpty" method="post">
            <table border="1" width="80%" align="center" id="input">
                <tr>
                    <td>input1:<br> <input type="text" name="input1"></td>
                </tr>  
                <tr>
                    <td>input2:<br> <input type="text" name="input2"></td>
                </tr> 
            </table>
            <input type="submit" value="Save!">
        </form>
    </body>
</html>
