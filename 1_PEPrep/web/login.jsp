<%-- 
    Document   : login
    Created on : Mar 17, 2022, 9:18:44 PM
    Author     : Le Hong Quan
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <form action="login" method="POST">
            Username:<input type="text" name="username" value="" /><br/>
            Password:<input type="text" name="password" value="" /><br/>
            <input type="submit" value="Login" />
        </form>
        <h3>${error}</h3>
        
        
        <h1>Login</h1>  
            <form action="login" method="post">
                <table border="1">
                    <tr>
                        <td>Username:</td><td><input type="text" name="username"></td>
                    </tr> 
                    <tr>
                        <td>Password:</td><td><input type="text" name="password"></td>
                    </tr>
                    <tr>
                        <td></td><td><input type="submit" value="Login!"></td>
                    </tr>   
                </table>
            </form>  
        <br/> 
        <h3>${mess}</h3>
        <a href="inbox">Go to inbox</a> 
        <a href="create">Go to create</a> 
        
        
        
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
