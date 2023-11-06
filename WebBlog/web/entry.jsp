<%-- 
    Document   : entr
    Created on : 27-Feb-2022, 19:53:36
    Author     : DELL
--%> 
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>   
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link href="css/styles.css" rel="stylesheet" />
    </head>
    <body>
        <div> 
            <a href="homeController">Blog</a>
            <a href="categoryCon?bid=${bid}">Category</a>
            <a href="entryCon?cid=${cid}&bid=${bid}">Entry</a>
        </div>
        <div> 
            <table border="1" width="80%" align="center" id="table">
                <thead>
                    <tr> 
                        <th>Title</th>   
                    </tr>
                </thead> 
                <tbody>
                    <c:forEach items="${enList}" var="e">
                    <tr>
                        <td>${e.title}</td> 
                        <td><a href="entryDetailCon?eid=${e.entryId}">Go detail</a></td> 
                    </tr>                           
                    </c:forEach>     
                </tbody>
            </table> 
        </div>
                    
    </body>
</html>
