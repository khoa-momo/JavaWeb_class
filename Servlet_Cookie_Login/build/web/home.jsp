<%-- 
    Document   : home
    Created on : 19-Jan-2022, 08:08:52
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
        <h1>Home</h1>
        Welcome : <%= session.getAttribute("username")%>
        <a href="LogoutController?logout=ok">return</a>
    </body>
</html>
