/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MyServlet;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author DELL
 */
public class Login_Servlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        
        Cookie[] cookies = request.getCookies();
        Cookie user = null;
        Cookie pass = null;
        
        if(cookies != null){ 
            for(Cookie c : cookies){
                if (c.getName().equals("username")) {
                    user = c;
                }
                if (c.getName().equals("password")) {
                    pass = c;
                } 
            }
        }
        
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            
            out.println("<head>");
            out.println("<title>Servlet Login_Servlet</title>");            
            out.println("</head>");
            
            out.println("<body>");
            out.println("<form method='post' action='LoginProcessServlet'>");
            out.println("<center><table>");
            out.println("<tr>");
                out.println("<th colspan='2'>Login</th>");
            out.println("</tr>");
            
            out.println("<tr>");
                out.println("<td>Username</td>");            
                out.println("<td>");
                    out.print("<input type='text' name='username' value='");
                    if(user!=null){
                        out.print(user.getValue());
                    }
                    out.print("' />");
                out.println("</td>");
            out.println("</tr>");
            
            out.println("<tr>");      
                out.println("<td>Password</td>");    
                out.println("<td>");
                    out.println("<input type='password' name='password' value='");
                    if(pass!=null){
                        out.print(user.getValue());
                    }
                    out.print("' />");
                out.println("</td>");         
            out.println("</tr>");
            
            out.println("<tr>");            
                out.println("<td colspan='2'>");
                out.println("Remember username&password? <input type='checkbox' name='save' />");
                out.println("</td>"); 
            out.println("</tr>");
            
            out.println("<tr>");
                out.println("<td> <input type='submit' value='Login' /></td>"); 
                out.println("<td>");
                out.println("<input type='reset' value='clear' />");
                out.println("</td>"); 
            out.println("</tr>");
            
            out.println("</table></center>");
            out.println("</form>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
