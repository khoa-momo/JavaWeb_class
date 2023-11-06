<%-- 
    Document   : paging
    Created on : Feb 16, 2022, 6:56:22 AM
    Author     : lephu
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
