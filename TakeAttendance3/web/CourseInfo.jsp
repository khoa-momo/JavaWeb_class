<%-- 
    Document   : CourseInfo
    Created on : 09-Mar-2022, 11:51:23
    Author     : DELL
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>  
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>CourseInfo</title>
        <link href="css/styles.css" rel="stylesheet" />
    </head>
    <body>
        <div>
            <form action="CourseInfo" method="post" id="table">
                <table border="1" align="center">
                    <tr>
                        <td>Course Code</td><td><input type="text" name="courseCode"></td>
                    </tr>
                    <tr>
                        <td>Course Description</td><td><input type="text" name="courseDes"></td>
                    </tr>
                    <tr>
                        <td>Subject Id</td><td><input type="text" name="subid"></td>
                    </tr>
                    <tr>
                        <td>Instructor Id</td><td><input type="text" name="inid"></td>
                    </tr>
                    <tr>
                        <td>Term Id</td><td><input type="text" name="teid"></td>
                    </tr>
                    <tr>
                        <td>Campus ID</td><td><input type="text" name="campid"></td>
                    </tr>  
                    <input type="submit" value="Confirm">
                </table>
            </form>
        </div>
    </body>
</html>
