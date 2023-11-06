<%-- 
    Document   : newjspinbox
    Created on : 14-Mar-2022, 11:56:43
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
            <c:choose>
                <%-- User has logged--%>
                <c:when test="${userid!=null}">
                     <table border="1" width="50%" align="center">
                        <thead>
                            <tr>
                                <th>Title</th>
                                <th>From</th>
                                <th>At</th>
                                <th>Sees</th> 
                            </tr>
                        </thead>
                        <tbody>
                            <c:forEach items="${messlist}" var="m">
                            <tr>
                                <td><a href="message?id=${m.messageid}">${m.messagetitle}</td>
                                <td>${m.from}</td>
                                <td>${m.messagetime}</td>  
                                <c:choose>
                                    <c:when test="${m.isread==1}">
                                        <td><img src="image/eye.png" alt=""/></td> 
                                    </c:when>
                                    <c:otherwise> 
                                        <td></td> 
                                    </c:otherwise>
                                </c:choose>  
                            </tr>                     
                            </c:forEach>     
                        </tbody>
                    </table> 
                </c:when>
                <c:otherwise> 
                    <%-- User has not logged--%>
                    <h1>${mess2}</h1>
                </c:otherwise>
            </c:choose>   
        </div> 
    </body>
</html>
