<%-- 
    Document   : cateBlog
    Created on : 27-Feb-2022, 19:38:05
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
            <a href="categoryCon?bid=${bid}">Category</a> 
        </div>
        
        <div>
            <table border="1" width="80%" align="center" id="table">
                <thead>
                    <tr> 
                        <th>Category Name</th>
                        <th>Date Created</th> 
                        <th>Date Modified</th>  
                    </tr>
                </thead> 
                <tbody>
                    <c:forEach items="${cateBlogList}" var="c">
                    <tr>
                        <td>${c.categoryName}</td>
                        <td>${c.dateCreated}</td>  
                        <td>${c.dateModified}</td>  
                        <td><a href="entryCon?cid=${c.categoryId}&bid=${c.blogId}">Go detail</a></td> 
                    </tr>                           
                    </c:forEach>   
                    <input type=hidden name="bid" value="${bid}">
                </tbody>
            </table> 
        </div>
                    
    </body>
</html>
