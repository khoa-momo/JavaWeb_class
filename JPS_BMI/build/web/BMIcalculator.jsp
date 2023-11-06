<%-- 
    Document   : bmicalculator
    Created on : 26-Dec-2021, 15:26:46
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
        <form method="Post" action="BMICalculatorServlet">
            <center>
                <table>
                    <tr>
                        <th colspan="2">BMICalculator</th>
                    </tr>
                    <tr>
                        <td>Height</td>
                        <td><input type="text" name="height"/>(Meters)
                        <%=request.getAttribute("h_error")!=null?request.getAttribute("h_error"):""%>
                        </td>
                    </tr>
                    <tr>
                        <td>Weight</td>
                        <td><input type="text" name="weight"/>(Kilograms)
                        <%=request.getAttribute("w_error")!=null?request.getAttribute("w_error"):""%>
                        </td>
                    </tr>            
                    <tr>
                        <td><input type="submit" value="Calculate"/></td>
                        <td><input type="reset" value="Clear"/></td>
                    </tr>      
                    <tr>
                        <td>Result</td>
                            <td><%=request.getAttribute("result")!=null?request.getAttribute("result"):""%> 
                        </td>
                    </tr>
                </table>
            </center>
        </form>
    </body>
</html>
