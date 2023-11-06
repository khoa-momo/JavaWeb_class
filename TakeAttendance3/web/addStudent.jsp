<%-- 
    Document   : addStudent
    Created on : 09-Mar-2022, 12:14:56
    Author     : DELL
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>   
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        
        <h1>List of Student</h1> 
        <input type="button" id="checked" value="Chọn hết"/>
        <input type="button" id="unchecked" value="Bỏ chọn"/>
        <form action="addStudent" method="post" id="table"> 
            <input type="submit" align="center" value="Save"><br>
            
            <div>
                <table border='1' align="left" cellspacing='0' cellpadding='10'>
                    <c:forEach items="${studList}" var="s">
                        <tr style="font-weight: bold">
                            <td><input type="checkbox" name="studId" value="${s.getStudentId()}"/>
                            </td><td>${s.getFulltName()}</td>
                        </tr>  
                    </c:forEach> 
                </table>
            
            </div>
        </form>
        
        <script language="javascript">
 
            //checked
            document.getElementById("checked").onclick = function () {
                // checkbox List
                var checkboxes = document.getElementsByName('studId'); 
                // checked
                for (var i = 0; i < checkboxes.length; i++){
                    checkboxes[i].checked = true;
                }
            };
 
            //unchecked
            document.getElementById("unchecked").onclick = function () {
                // checkbox List
                var checkboxes = document.getElementsByName('studId'); 
                // unchecked
                for (var i = 0; i < checkboxes.length; i++){
                    checkboxes[i].checked = false;
                }
            };
 
        </script>
    </body>
</html>
