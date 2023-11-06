<%-- 
    Document   : add
    Created on : 19-Mar-2022, 14:41:15
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
                <c:when test="${username!=null}">
                    <form action="add" method="post">
                        Id:<input type="text" name="id"><br/>
                        Name:<input type="text" name="name"><br/>
                        Dob:<input type="date" name="date"><br/> 
                        Radio:
                        Male<input type="radio" name="gender" value="1"/>
                        Female<input type="radio" name="gender" value="0"/>
                        <br/> 
                        Skills:</br>
                        <c:forEach items="${sList}" var="s">
                            <input type="checkbox" name="skill" value="${s.sid}">${s.sname} with<input type="text" name="degree"><br/> 
                        </c:forEach>   
                        <input type="submit" value="Save">
                    </form>
                </c:when>
                <c:otherwise> 
                    <%-- User has not logged--%>
                    <h3>${mess}</h3>
                </c:otherwise>
            </c:choose>    
            
            
        </div>
    </body>
</html>
