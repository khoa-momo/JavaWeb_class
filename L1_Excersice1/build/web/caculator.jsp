<%-- 
    Document   : caculator
    Created on : 14-Feb-2022, 22:14:34
    Author     : DELL
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Calculator</title>
    </head>
    <body>
        <form action="CalculateController">
            <table>
                <tr>
                    <td>Enter a:</td>
                    <td><input type="text" name="a" value="${a}" /></td>
                </tr>
                <tr>
                    <td>Enter b:</td>
                    <td><input type="text" name="b" value="${b}" /></td>
                </tr>
                <tr>
                    <td>Calculator</td>
                    <td>
                        <select name="operator">
                            <option ${operator eq "+" ? "selected":""}>+</option>
                            <option ${operator eq "-" ? "selected":""}>-</option>
                            <option ${operator eq "*" ? "selected":""}>*</option>
                            <option ${operator eq "/" ? "selected":""}>/</option>
                        </select>
                    </td>
                </tr>
                <tr>
                    <td><input type="submit" value="OK"/></td>
                    <td></td>
                </tr>
                <tr>
                    <td>Result</td>
                    <td><input type="text" value="${result}" /></td>
                </tr>
            </table>
                <h3 style="color: red">${error}</h3>
        </form>
    </body>
</html>
