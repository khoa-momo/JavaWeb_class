<%-- 
    Document   : session
    Created on : 14-Jan-2022, 11:43:22
    Author     : DELL
--%>

<%@page import="java.util.ArrayList"%>
<%@page import="java.util.Date"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%
    String name = request.getAttribute("name").toString();
    String add = request.getAttribute("add").toString();
%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <div>
            <h1>Session Info: <%=request.getSession().getId()%></h1>
            <div>CreationTime: <%= new Date(request.getSession().getCreationTime()) %></div>
            <div>Last Access: <%= new Date(request.getSession().getLastAccessedTime())%></div>
        </div>
        <br> 
        Current: <%= name%> - <%= add%>
        <form action="Demo_Session" method="Post">
            Name: <input type="text" name="tbname" value="">
            Add: <input type="text" name="tbadd" value="">
            <input type='submit' value="Add info to session">
        </form>
    </body>
</html>
