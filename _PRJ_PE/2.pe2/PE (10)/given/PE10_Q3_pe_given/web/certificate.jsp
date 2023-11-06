<%-- 
    Document   : certificate
    Created on : 18-Mar-2022, 20:02:27
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
        
        <form action="certificate" method="POST">
            <div>
                <table border="1" width="80%" align="center">
                    <thead>
                        <tr>
                            <td></td>
                            <c:forEach items="${listCert}" var="c">
                                <td>${c.name}</td>
                            </c:forEach> 
                        </tr>
                    </thead>
                    <tbody>   
                        <c:forEach items="${elist}" var="e">
                            <tr>
                                <td>${e.name}</td> 
                                <c:forEach items="${e.isCer}" var="i">
                                    <td><input type="checkbox" name="checkbox" value="${e.name}" ${i==1?"checked":""}/></td>
                                </c:forEach>  
                            </tr>      
                        </c:forEach>    
                    </tbody>
                </table>
                <input type="submit" value="Save" />
            </div> 
        </form>
        
        
        <br/>
    </body>
</html>
