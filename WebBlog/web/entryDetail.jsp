<%-- 
    Document   : entryDetail
    Created on : 27-Feb-2022, 20:16:45
    Author     : DELL
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>   
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link href="css/styles.css" rel="stylesheet" />
    </head>
    <body>
        <div> 
            <a href="homeController">Blog</a>
            <a href="categoryCon?bid=${entry.blogId}">Category</a>
            <a href="entryCon?cid=${entry.categoryId}&bid=${entry.blogId}">Entry</a> 
        </div>
        <div>
            <table border="1" width="80%" align="center" id="table">
                <thead>
                    <tr> 
                        <th>Title</th>
                        <th>Content</th>  
                        <th>Date Created</th> 
                        <th>Date Modified</th>  
                    </tr>
                </thead> 
                <tbody> 
                    <tr>
                        <td>${entry.title}</td>
                        <td>${entry.entryContent}</td>  
                        <td>${entry.dateCreated}</td> 
                        <td>${entry.dateModified}</td>  
                    </tr>             
                </tbody>
            </table> 
        </div>
        <br/>            
        <div>
            <table border="1" width="80%" align="center" id="table">
                <thead>
                    <tr> 
                        <th>Comment Content</th> 
                        <th>Date Created</th> 
                        <th>Date Modified</th>  
                    </tr>
                </thead> 
                <tbody> 
                    <c:forEach items="${comment}" var="c">
                    <tr>
                        <td>${c.commentContent}</td>
                        <td>${c.dateCreated}</td>  
                        <td>${c.dateModified}</td>   
                    </tr>                           
                    </c:forEach>        
                </tbody>
            </table> 
        </div>
                    
    </body>
</html> 