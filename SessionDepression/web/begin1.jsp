<%-- 
    Document   : begin1
    Created on : 17-Jan-2022, 22:01:35
    Author     : DELL
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.ArrayList"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>

    <body>
        <form method="Post" action="Begin1">
            
            <%
                ArrayList<String> listtoprint = null;
                listtoprint = (ArrayList)request.getSession().getAttribute("lista_tojsp");//from servlet
                if(listtoprint.size()!=0){
                    for (int i = 0; i < listtoprint.size(); i++) {
                        out.print("<tr>");
                        out.print(listtoprint.get(i));
                        out.print("</br>");
                        out.print("</tr>");
                    }
                }else{
                     out.println("List empty");
                }
            %>            
        </form>
    </body>
</html>
