<%-- 
    Document   : message
    Created on : 14-Mar-2022, 16:20:25
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
        <c:choose>
            <%-- User has logged--%>
            <c:when test="${userid!=null}">
                 <table border="1" width="30%" align="center"> 
                    <tbody>
                        <c:forEach items="${messlist2}" var="m"> 
                            <tr>
                                <td>From</td><td>${m.from}</td>
                            </tr> 
                            <tr>
                                <td>Title</td><td>${m.messagetitle}</td>
                            </tr> 
                            <tr>
                                <td>Created Time</td><td>${m.messagetime}</td>
                            </tr> 
                            <tr>
                                <td>Content</td><td>${m.messagecontent}</td>
                            </tr>                        
                        </c:forEach>     
                    </tbody>
                </table> 
            </c:when>
            <c:otherwise> 
                <%-- User has not logged--%>
                <h1>${mess3}</h1>
            </c:otherwise>
        </c:choose>  
    </body>
</html>
