<%-- 
    Document   : AddJob
    Created on : 11-Mar-2022, 15:20:55
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
        <div>
            <form action="AddJob" method="post">
                Job Name:<input type="text" name="name"><br/>
                Job Salary:<input type="text" name="salary"><br/>
                Date Created:<input type="text" name="date">(MM/dd/yyyy)<br/>
                Activated:
                Yes<input type="radio" name="activated" value="1"/>
                No<input type="radio" name="activated" value="0"/>
                <br/>   
                <input type="submit" value="Save"> 
                <button><a href="ListJobs">All Jobs</a></button>
            </form>
        </div>
    </body>
</html>
