/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import java.io.IOException;
import java.io.PrintWriter;

import java.text.SimpleDateFormat;
import java.util.Date;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author DELL
 */
@WebServlet(name = "page2", urlPatterns = {"/page2"})
public class page2 extends HttpServlet {

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
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet page2</title>");            
            out.println("</head>");
            out.println("<body>");
                
//            java.util.Date date = new java.util.Date();
//            out.println("<h2>"+"Current Date & Time: " +date.toString()+ "</h2>");
//             
//             // Create Formatter class object
//            Formatter format = new Formatter();  
//            Calendar gfg_calender = Calendar.getInstance(); 
//            // Displaying hour using Format clas using  format 
//            format = new Formatter();
//            format.format("%tl:%tM", gfg_calender,gfg_calender); 
//            // Printing the current hour and minute
//            out.println("<h2>"+format+"</h2>"); 

            String title = "Display Current Date & Time";
            Date dNow = new Date();
            SimpleDateFormat sdf = new SimpleDateFormat ("E dd/MM/yyyy hh:mm a zzz");    
            out.println("<h1 align = \"center\">" + title + "</h1>");
            out.println("<h2 align = \"center\">" + sdf.format(dNow) + "</h2>");
            
            out.println("<a href=\"page1\">Visit page 1</a>");
            out.println("</body>");
            out.println("</html>");
        }
        
//        PrintWriter out = response.getWriter();

      
//      out.println(docType +
//         "<html>\n" +
//            "<head><title>" + title + "</title></head>\n" +
//            "<body bgcolor = \"#f0f0f0\">\n" +
//               "<h1 align = \"center\">" + title + "</h1>\n" +
//               "<h2 align = \"center\">" + ft.format(dNow) + "</h2>\n" +
//            "</body>
//         </html>"
//      );
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
