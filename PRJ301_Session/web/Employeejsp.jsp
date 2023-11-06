<%-- 
    Document   : Employeejsp
    Created on : 15-Jan-2022, 10:30:44
    Author     : DELL
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.ArrayList"%>
<%
    String name = request.getAttribute("name").toString(); 
    String gender = request.getAttribute("gender").toString();
    String position = request.getAttribute("position").toString(); 
    String salary = request.getAttribute("salary").toString();    
%>
            
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <form method="Post" action="Employee">  
            <center><table>
                <tr><td>--Employee Information--</td></tr>
                <tr>
                    <td>Name:<input type="text" name="name"/></td> 
                </tr>  
                <tr>
                    <td colspan="1">Male:<input type="radio" name="gender"/></td>  
                    <td colspan="1">Female:<input type="radio" name="gender"/></td>  
                </tr>   
                <tr><td>
                    Position: 
                    <select name="position">
                        <option value="Tester">Tester</option>
                        <option value="Manager">Manager</option>
                        <option value="Developer">Developer</option> 
                    </select>   
                </td></tr>  
                <tr>
                    <td>Salary:<input type="text" name="salary"/></td>  
                </tr>  
                <tr> 
                    <td><input type="submit" value="Add to list"/>
                </tr>           
                
                <tr><td>Employee: <%=" "+name+" "+gender+" "+position+" "+salary%></td></tr>
                <!--listtoprint = (ArrayList)request.getSession().getAttribute("lista_tojsp");//from servlet-->
                <%
                    ArrayList<String> s = new ArrayList<String>();
                    s = (ArrayList)request.getAttribute("empList");//from servlet 
                    if(s.size()!=0){
                        for (int i = 0; i < s.size(); i++) {
                            out.print("<tr>");
                            out.print(s.get(i));
                            out.print("</br>");
                            out.print("</tr>");
                        }
                    }else{
                        out.print("nothing");
                    }
                %>      
                
            </table></center>  
        </form> 
    </body>
</html>
