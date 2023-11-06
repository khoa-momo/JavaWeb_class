<%-- 
    Document   : page3jsp
    Created on : 10-Jan-2022, 11:29:20
    Author     : DELL
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page3</title>
    </head>
    <body>
        <form action='page3' method='post'>
        Ten: <input name='name' type='text'><br>
        MaSo: <input name='roll' type='text'><br>
        <input type='submit' name='btsubmit' value='Submit'>
        </form>
        
        <!-- Hien thi mess ket qua -->
        <%
            String mess;
            if (request.getAttribute("mess") == null)
                mess = "";
            else mess = request.getAttribute("mess").toString();
        %>
        <%=mess%>
    </body>
</html>
