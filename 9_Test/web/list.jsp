<%-- 
    Document   : list
    Created on : 19-Mar-2022, 11:16:20
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
        <div>
            <table border="1" width="80%" align="center">
            <thead>
                <tr>
                    <th>Entry ID</th>
                    <th>Entry Title</th>
                    <th>Detail</th> 
                </tr>
            </thead>
            <tbody>
                <c:forEach items="${entryList}" var="o">
                    <tr>
                        <td>${o.getEntryID()}</td>
                        <td>${o.getTitle()}</td> 
                        <td><a href="detail?ID=${o.getEntryID()}">Detail</a></td>  
                    </tr>                     
                </c:forEach>     
            </tbody>
            </table>
        </div> 
    </body>
</html>
