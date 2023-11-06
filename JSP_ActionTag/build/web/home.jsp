<%-- 
    Document   : home
    Created on : 27-Dec-2021, 15:32:50
    Author     : DELL
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <jsp:include page="header.jsp" flush="true" /> 
        <jsp:useBean id="student" scope="request" class="Myjava.Student" />
        <jsp:setProperty name="student" property="roll" value="SE1" />
        <jsp:setProperty name="student" property="name" value="ABC" />
        <jsp:setProperty name="student" property="phone" value="0123" />
        <jsp:setProperty name="student" property="email" value="SE1@gm" />
        
        <div style="height: 500px; background-color: greenyellow">
            <h1><jsp:getProperty name="student" property="roll" /></h1>
            <h1><jsp:getProperty name="student" property="name" /></h1>
            <h1><jsp:getProperty name="student" property="phone" /></h1>
            <h1><jsp:getProperty name="student" property="email" /></h1>       
            <hr>
            
            <jsp:useBean id="stud" scope="request" type="Myjava.Student" beanName="student">
                <jsp:setProperty name="stud" property="*" />
            </jsp:useBean>
            
            <h1><jsp:getProperty name="stud" property="roll" /></h1>
            <h1><jsp:getProperty name="stud" property="name" /></h1>
            <h1><jsp:getProperty name="stud" property="phone" /></h1>
            <h1><jsp:getProperty name="stud" property="email" /></h1>
            
        </div>
        <jsp:include page="footer.jsp" flush="true" />
    </body>
</html>
