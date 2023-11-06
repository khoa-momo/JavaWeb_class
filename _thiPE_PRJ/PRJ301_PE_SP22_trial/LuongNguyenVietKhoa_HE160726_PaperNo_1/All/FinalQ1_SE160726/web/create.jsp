<%-- 
    Document   : create
    Created on : 14-Mar-2022, 11:33:35
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
        <h3>Student ID: ${id}</h3>
        <h3>Student Name: ${name}(${gender})</h3>
        <h3>DOB: ${dob}</h3>  
        <h3>Scholarship Student: ${isScholar}</h3>
    </body>
</html> 