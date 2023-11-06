<%-- 
    Document   : roomManager
    Created on : 23-Mar-2022, 10:25:35
    Author     : DELL
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Room Manager</title>
        <link href="/MyProject/css/styles.css" rel="stylesheet" />
        
        <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Roboto|Varela+Round">
        <link rel="stylesheet" href="https://fonts.googleapis.com/icon?family=Material+Icons">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
        
        <style>
            img{
                width: 50px;
                height: 120px;
            }
        </style>
    </head>
    <body>
        <!--------------------------------------- Navi Bar ----------------------------------------->
        <%@include file="components/naviBar.jsp" %> 
        <div class="container">
            <div class="table-wrapper">
                <div class="table-title">
                    <div class="row">
                        <div class="col-sm-6">
                            <h2><b>Quản lý tin đăng</b></h2>
                        </div> 
                    </div>
                </div>
                <table class="table table-striped table-hover">
                    <thead>
                        <tr> 
                            <th>ID</th>
                            <th>Title</th>
                            <th>Image</th>
                            <th>Date</th>
                            <th>Actions</th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach items="${roomByacc}" var="r">
                            <tr>
                                <td>${r.roomId}</td>
                                <td>${r.title}</td>
                                <td>
                                    <a href="Detail?roomId=${r.roomId}"> 
                                        <img class="card-img" src="${r.firstImage}" alt="No Image"/> 
                                    </a>
                                </td> 
                                <td>${r.dateCreated} </td>
                                <td> 
                                    <a href="DeleteRoom?rid=${r.roomId}" class="delete" data-toggle="modal"><i class="material-icons" data-toggle="tooltip" title="Delete">&#xE872;</i></a>
                                </td>
                            </tr>
                        </c:forEach>
                    </tbody>
                </table> 
            </div> 

        </div>
        
    </body>
</html>
