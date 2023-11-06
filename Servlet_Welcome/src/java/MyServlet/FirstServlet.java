/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MyServlet;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author DELL
 */
public class FirstServlet extends HttpServlet {

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
        response.setContentType("text/html;charset=UTF-8");
        
        try(PrintWriter out = response.getWriter()){
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
                out.println("<title>Welcome to 1st Servlet</title>");            
            out.println("</head>");
            out.println("<body>");
                String name = request.getParameter("name");
                out.print("<h1>doGet: Hello " + name + "</h1>");
            out.println("</body>");
            out.println("</html>");            
        }
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
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* processRequest */
            //1.Opening
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            //2.Heading
            out.println("<head>");
                out.println("<title>Welcome to 1st Servlet</title>");            
            out.println("</head>");
            //3.Body
            out.println("<body>");
                String name = request.getParameter("name");
                String color = request.getParameter("color"); 
            switch (color) {
                case "0":
                    out.print("<p style='color:red'>doPost: Hello " + name + "</p>");
                    break;
                case "1":
                    out.print("<p style='color:green'>doPost: Hello " + name + "</p>");
                    break;
                case "2":
                    out.print("<p style='color:blue'>doPost: Hello " + name + "</p>");
                    break; 
            }
            out.println("</body>");
            //4.Ending
            out.println("</html>");
        }
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
