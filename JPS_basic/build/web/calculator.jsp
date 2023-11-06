<%-- 
    Document   : calculator
    Created on : 25-Dec-2021, 13:20:35
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
        <form method="Post" action="Calculator">
        <center><table>
            <tr><th colpsan="2">Calculator</th></tr>
            <%-- First number --%>
            <tr>
                <td colspan="2">First number</td>
                <td colspan="2"><input type="text" name="first" value="<%= request.getAttribute("first")%>"/></td>
            </tr> 
            <tr>
                <td colspan="4"> <p style="color:red"> <%= request.getAttribute("first_error") 
                        != null ? request.getAttribute("first_error"): "" %> </p></td>
            </tr>
            <%-- Second number --%>
            <tr>
                <td colspan="2">Second number</td>
                <td colspan="2"><input type="text" name="second" value="<%= request.getAttribute("second")%>"/></td>
            </tr>        
            <tr>
                <td colspan="4"> <p style="color:red"> <%= request.getAttribute("second_error")  
                        != null ? request.getAttribute("second_error"): "" %> </p></td>
            </tr>
            
            
            
            <%-- Result --%>
            <tr> 
                <td>+<input type="radio" value="+" name="operator" checked=
                            "<%= "+".equals(request.getAttribute("operator"))?"checked":""%> " /></td>
                &nbsp; <!-- blank space -->
                <td>-<input type="radio" value="-" name="operator" checked=
                            "<%= "-".equals(request.getAttribute("operator"))?"checked":""%>" /></td>
                &nbsp; <!-- blank space -->
                <td>*<input type="radio" value="*" name="operator" checked=
                            "<%= "*".equals(request.getAttribute("operator"))?"checked":""%>" /></td>
                &nbsp; <!-- blank space -->
                <td>/<input type="radio" value="/" name="operator" checked=
                            "<%= "/".equals(request.getAttribute("operator"))?"checked":""%>" /></td>
            </tr>   
            <tr>
                <td colspan="2"><input type="submit" value="Caculate" /></td>
                <td colspan="2"><input type="reset" name="Clear" /></td>
            </tr>  
            <tr>
                <td colspan="2">Result</td>
                <td colspan="2"><input type="text" name="result" value= "<%= request.getAttribute("result")%>"/></td>
            </tr>          
        </table></center>
        </form> 
    </body>
</html>
