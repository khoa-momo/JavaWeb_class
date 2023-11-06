<%-- 
    Document   : detail
    Created on : 19-Mar-2022, 11:26:16
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
        <c:forEach items="${entry}" var="o">
            Entry's info<br/>
            EntryID: ${o.getEntryID()} <br/>
            EntryTitle: ${o.getTitle()} <br/>
            EntryContent: ${o.getEntryContent()} <br/>
            Entry dateModified: ${o.getDateModified()} <br/> 
        </c:forEach>   
        <table border="1" width="80%" align="center">
            <thead>
                <tr>
                    <th>Comment ID</th>
                    <th>Comment Content</th>
                    <th></th>  
                </tr>
            </thead>
            <tbody>
                <c:forEach items="${cList}" var="o">
                    <tr>
                        <td>${o.getCommentID()}</td>
                        <td>${o.getCommentContent()}</td> 
                        <td><a href="delete?cID=${o.getCommentID()}&eid=${id}">Delete</a></td>    
                    </tr>                     
                </c:forEach>     
            </tbody>
        </table>
    </body>
</html>
