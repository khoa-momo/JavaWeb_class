<%-- 
    Document   : create
    Created on : 14-Mar-2022, 16:42:22
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
                    <form action="create" method="post">
                        <table border="1">
                            <tr>
                                <td>To:</td>
                                <td>
                                    <select name="to"> 
                                        <c:forEach items="${userList}" var="o">
                                            <option value="${o.userid}">${o.userid}</option>
                                        </c:forEach>    
                                    </select> 
                                </td> 
                            </tr> 
                            <tr>
                                <td>Title:</td><td><input type="text" name="title"></td>
                            </tr>
                            <tr>
                                <td>Content:</td><td><input type="text" name="content"></td>
                            </tr>
                            <tr>
                                <td></td><td><input type="submit" value="Save"></td>
                            </tr>   
                        </table>
                    </form>  
                    <h3>${successMess}</h3>
                </c:when>
                <c:otherwise> 
                    <%-- User has not logged--%>
                    <h3>${mess4}</h3>
                </c:otherwise>
            </c:choose>   
        </div> 
    </body>
</html>
