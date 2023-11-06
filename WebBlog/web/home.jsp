<%-- 
    Document   : home
    Created on : 23-Feb-2022, 11:57:49
    Author     : DELL
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>   
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <!--======================================Head======================================-->
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Home</title>
        <link href="css/styles.css" rel="stylesheet" />
        <style>
            body {
              margin: 0;
              font-family: Arial, Helvetica, sans-serif;
            }

            .topnav {
              overflow: hidden;
              background-color: #333;
            }

            .topnav a {
              float: left;
              color: #f2f2f2;
              text-align: center;
              padding: 14px 16px;
              text-decoration: none;
              font-size: 17px;
            }

            .topnav a:hover {
              background-color: #ddd;
              color: black;
            }

            .topnav a.active {
              background-color: #04AA6D;
              color: white;
            }
            </style>
    </head>
    
    <!--======================================Body======================================-->
    <body>
        <div>
          <a href="homeController">Blog</a>
        </div>
        <br/>
        <div>
            <table border="1" width="80%" align="center" id="table">
                <thead>
                    <tr> 
                        <th>Blog Name</th>
                        <th>Blog Des</th> 
                        <th>Created Date</th> 
                    </tr>
                </thead> 
                <tbody>
                    <c:forEach items="${blogList}" var="b">
                    <tr>
                        <td>${b.blogName}</td>
                        <td>${b.blogDes}</td>  
                        <td>${b.createdDate}</td>  
                        <td><a href="categoryCon?bid=${b.blogId}">Go detail</a></td> 
                    </tr>                           
                    </c:forEach>     
                </tbody>
            </table>
        </div>
    </body>
    
    
    <!--======================================Footer======================================--> 
</html>
