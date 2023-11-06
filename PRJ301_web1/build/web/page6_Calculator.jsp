<%-- 
    Document   : page6_Calculator
    Created on : 12-Jan-2022, 11:54:51
    Author     : DELL
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>page6_Calculator</title>
    </head>
    <body>
        <form method="Post" action="page6_Calculator"></form> 
        <center><table>
                
            <tr>Calculator</tr> 
            <%-- First number --%>
            <tr>
                <td>First number:</td>
                <td><input type="text" name="first"</td> 
                           <!--value="<%= request.getAttribute("first")%>"/></td>-->
            </tr>  
            <%-- Second number --%>
            <tr>
                <td>Second number:</td>
                <td><input type="text" name="second"</td> 
                           <!--value="<%= request.getAttribute("second")%>"/></td>-->
            </tr>        
            <tr><td>
                Select: 
                <select name="operator">
                    <option value="1">Add</option>
                    <option value="2">Subtract</option>
                    <option value="3">Multiply</option> 
                </select>   
            </td></tr>    
            <tr>
                <td><input type="submit" value="Caculate"/></td> 
            </tr>   
            <%
                String result;
                if (request.getAttribute("result") == null)
                    result = "";
                else result = request.getAttribute("responeTime").toString();
            %>  
            <tr>
                <td>Result:</td>
                <td><input type="text" name="result"</td> 
                <h2><%=result%></h2>
                <!--value="<%= request.getAttribute("result")%>"/></td>-->
            </tr>       
        </table></center>
        </form>
    </body>
</html>
