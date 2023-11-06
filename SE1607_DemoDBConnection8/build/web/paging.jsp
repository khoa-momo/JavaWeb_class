<%-- 
    Document   : paging
    Created on : 17-Feb-2022, 11:20:34
    Author     : DELL
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<% 
   int totalPage = Integer.parseInt(request.getAttribute("totalPage").toString());
   int curPage = Integer.parseInt(request.getAttribute("curPage").toString());
   String curUrl = request.getAttribute("curUrl").toString();
%>
<div class="paging">
    <% for(int i=1; i<=totalPage; i++){%>
    <a<%= (i==curPage)? "class=curPage":"" %> href="<%=curUrl%>page=<%=i%>"> 
        <%=i%> 
    </a>
    <%}%>
</div>