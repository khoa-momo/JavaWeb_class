<%-- 
    Document   : Student
    Created on : 14-Jan-2022, 00:26:10
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
        <form method="Post" action="Student_in4_test">  
            <center><table>
                <tr><td>--Student Information--</td></tr>
                <tr>
                    <td>First name:<input type="text" name="first"/></td> 
                </tr>  
                <tr>
                    <td>Last name:<input type="text" name="last"/></td>  
                </tr>   
                <tr>
                    <td colspan="1">Male:<input type="radio" name="gender"/></td>  
                    <td colspan="1">Female:<input type="radio" name="gender"/></td>  
                </tr>   
                <tr><td>
                    Major: 
                    <select name="major">
                        <option value="SE">SE</option>
                        <option value="AI">AI</option>
                        <option value="GD">GD</option> 
                    </select>   
                </td></tr>  
                <tr>
                    <td>DOB:<input type="text" name="dob"/></td>  
                </tr>  
                <tr>
                    <td>In dormitory:<input type="checkbox" name="dormitory" value="dormitory"></td>
                    <td>In reservation:<input type="checkbox" name="reservation" value="reservation"></td>
                </tr> 
                
                <tr> 
                    <td><input type="submit" value="Submit"/>
                </tr>                
            </table></center>  
                
        </form> 
        <center><table>
        <%
            String first = request.getAttribute("first").toString(); 
            String last = request.getAttribute("last").toString();
            String gender = request.getAttribute("gender").toString(); 
            String major = request.getAttribute("major").toString(); 
            String dob = request.getAttribute("dob").toString();   
            String dormitory;
            String reservation;
            if (request.getAttribute("dormitory") == null)
                dormitory = "";
            else dormitory = request.getAttribute("dormitory").toString();
            
            if (request.getAttribute("reservation") == null)
                reservation = "";
            else reservation = request.getAttribute("reservation").toString();
        %> 
        <tr><td>Output: <%="Student: "+first+" "+last+" - "+gender+" - "+major+" - "+dob+" "+dormitory+"-"+reservation%></td></tr>
        </table></center>
    </body>
</html>
