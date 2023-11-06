<%-- 
    Document   : home
    Created on : 13-Mar-2022, 11:29:24
    Author     : DELL
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link href="css/table.css" rel="stylesheet"/>
    </head>
    <body> 
        <!--------------------------------------- Navi Bar ----------------------------------------->
        <%@include file="components/naviBar.jsp"%> 
        
        <!--------------------------------------- Header ----------------------------------------->
        <header class="bg-dark py-5">
            <div class="container px-4 px-lg-5 my-5">
                <div class="text-center text-white">
                    <h1 class="display-4 fw-bolder">Shop in style</h1>
                    <p class="lead fw-normal text-white-50 mb-0">
                        With this shop hompeage template
                    </p>
                </div>
            </div>
        </header>
        
        <!--------------------------------------- Section ----------------------------------------->
        <section>
            <h1>Home!</h1>
            <div>
                <form action="employeeFillter" method="post"> 
                    Address: <input type="text" name="address" value="${address}">
                    Area: <input type="text" name="area" value="${area}">
                    Cost: <input type="text" name="cost" value="${cost}">
                    <input type="Search" value="Search">
                    <input type="submit">
                </form>
            </div>     

            <!------------------------------ List of rooms ----------------------------------->
            <table border="1" width="30%" align="left" id="table">
                <thead>
                    <tr>
                        <th>Address</th>
                        <th>Area</th>
                        <th>Description</th>
                        <th>Cost</th>
                        <th>Note</th> 
                    </tr>
                </thead>
                <tbody>  
                    <c:forEach items="${rolist}" var="r">
                    <tr>
                        <td>${r.getAddress()}</td>
                        <td>${r.getArea()}</td> 
                        <td>${r.getDescription()}</td> 
                        <td>${r.getCost()}</td> 
                        <td>${r.getNote()}</td>   
                    </tr>                     
                    </c:forEach>    
                </tbody> 
            </table> 
        </section>
        <!--------------------------------------- Footer ----------------------------------------->
        <%@include file="components/footerComponent.jsp" %>
    </body>
</html>
