<%-- 
    Document   : newRoom
    Created on : 20-Mar-2022, 17:59:07
    Author     : DELL
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>New Room</title>
        <link href="/MyProject/css/styles.css" rel="stylesheet" />
        <link href="/MyProject/css/register.css" rel="stylesheet" />
    </head>
    <body>
        <!--------------------------------------- Navi Bar ----------------------------------------->
        <%@include file="components/naviBar.jsp"%> 
        
        <form action="NewRoom" method="Post" style="border:1px solid #ccc">
            <div class="container">
                <h1>Đăng tin cho thuê phòng trọ</h1>  
                
                <label for="title"><b>Tiêu đề:</b></label>
                <input type="text" placeholder="Enter title" name="title" required> 
                
                <label for="description"><b>Thông tin cụ thể:</b></label>
                <input type="text" placeholder="Enter description" name="description" required>
                
                <label for="area"><b>Diện tích:</b></label>
                <input type="text" placeholder="Enter area" name="area" required> 
                
                <label for="cost"><b>Giá tiền:</b></label>
                <input type="text" placeholder="Enter cost" name="cost" required>

                <label for="note"><b>Note:</b></label>
                <input type="text" placeholder="Enter note" name="note" required> 
                
                <label for="provinceName"><b>Thành phố:</b></label>  
                <select name="provinceName"> 
                    <c:forEach items="${provinceList}" var="p">
                        <option ${p.provinceName==province?"selected":""} value="${p.provinceName}">${p.provinceName}</option>
                    </c:forEach>    
                </select> 
                
                <label for="districtName"><b>Quận:</b></label>
                <select name="districtName"> 
                    <c:forEach items="${districtList}" var="d">
                        <option ${d.provinceName==district?"selected":""} value="${d.provinceName}">${d.provinceName}</option>
                    </c:forEach>    
                </select>  
                <br/>
                <label for="streetName"><b>Đường</b></label>
                <input type="text" placeholder="Enter streetName" name="streetName" required> 
                
                <label for="url"><b>Ảnh:</b></label>
                <input type="text" placeholder="Enter image's url" name="url" required>

                <label for="urlMap"><b>Link Google Map:</b></label>
                <input type="text" placeholder="Enter google Map's url" name="urlMap" required>
                
                <div class="clearfix">
                  <button type="submit" class="signupbtn">Finnish</button>
                </div>
            </div>
        </form> 
    </body>
</html>
