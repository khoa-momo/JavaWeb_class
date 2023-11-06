<%-- 
    Document   : calculator
    Created on : 25-Dec-2021, 13:20:35
    Author     : DELL
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>CalculatorServlet</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
    </head>
    <body>
        <form method="Post" action="Calculator_test">  
            <center><table>
                <tr><td>Calculator</td></tr>
                <tr>
                    <td>First number:<input type="text" name="first" value="<%= request.getAttribute("first")%>"/></td>
                    <td><p style="color:red">
                        <%= request.getAttribute("first_error")!= null ? request.getAttribute("first_error"): "" %> 
                    </p></td>
                </tr>  
                <tr>
                    <td>Second number:<input type="text" name="second" value="<%= request.getAttribute("second")%>"/></td> 
                    <td><p style="color:red"> 
                        <%= request.getAttribute("second_error")!= null ? request.getAttribute("second_error"): "" %> 
                    </p></td>
                </tr>   
                <tr><td>
                    Select: 
                    <select name="operator">
                        <option value="+">Add</option>
                        <option value="-">Subtract</option>
                        <option value="*">Multiply</option> 
                    </select>   
                </td></tr>   
                <tr> 
                    <td><input type="Submit" value="Calculate"/>
                </tr>                
            </table></center> 
        </form> 
        <center><table>  
        <%
            String finalResult;
            if (request.getAttribute("finalResult") == null)
                finalResult = "";
            else finalResult = request.getAttribute("finalResult").toString();
        %> 
        <tr><td><%=finalResult%></td></tr> 
        </table></center>
    </body>
</html>
