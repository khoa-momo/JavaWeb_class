/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author DELL
 */
public class page3 extends HttpServlet {

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
        RequestDispatcher dispatcher = request.getRequestDispatcher("page3jsp.jsp");
        dispatcher.forward(request, response);
//        try (PrintWriter out = response.getWriter()) {
//            /* TODO output your page here. You may use following sample code. */
//            out.println("<!DOCTYPE html>");
//            out.println("<html>");
//            out.println("<head>");
//            out.println("<title>Servlet page3</title>");            
//            out.println("</head>");
//            out.println("<body>");
//            out.println("<h1>Servlet page3 at " + request.getContextPath() + "</h1>");
//            out.println("</body>");
//            out.println("</html>");
//        }
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
//        try (PrintWriter out = response.getWriter()) {
//            /* TODO output your page here. You may use following sample code. */
//            out.println("<!DOCTYPE html>");
//            out.println("<html>");
//            out.println("<head>");
//            out.println("<title>Servlet page3</title>");            
//            out.println("</head>");
//            out.println("<body>");  
//            out.println("<form action='page3' method='post'>");
//            out.println("MaSV: <input name='name' type='text'><br>");
//            out.println("Number: <input name='number' type='text'><br>");
//            out.println("<input type='submit' name='btsubmit' value='Submit'>");
//            out.println("</body>");
//            out.println("</html>");
//        }
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
        
//        try (PrintWriter out = response.getWriter()) {
//            //lay du lieu, tinh toan, xu ly 

//            String studName = request.getParameter("name");
//            String number = request.getParameter("number");
//            int n = Integer.parseInt(number);
//            
//            String substring = "";
//            if (studName.length()>n) {
//                for (int i = 0; i < n; i++) {
//                    substring += studName.charAt(i); 
//                }
//            }else{
//                out.println("Number invalid!");
//            }  
//            out.println("<!DOCTYPE html>");
//            out.println("<html>");
//            out.println("<head>");
//            out.println("<title>Servlet ThirdServlet</title>");            
//            out.println("</head>");
//            out.println("<body>");
//            out.println("<div>" + substring + "</div>");
//            out.println("</body>");
//            out.println("</html>");       
//        }
        
        String stuName = request.getParameter("name");
        String rollNumber = request.getParameter("roll");
        String mess=""; 
        if (rollNumber.startsWith("SE"))
            mess = "SV " + stuName + ", ma so: " + rollNumber + " la sinh vien nganh SE";
        else
            mess = "SV " + stuName + ", ma so: " + rollNumber + " khong la sinh vien nganh SE";
        
        request.setAttribute("mess", mess); 
        processRequest(request, response);
        
//        try (PrintWriter out = response.getWriter()) {
//            /* TODO output your page here. You may use following sample code. */
//            out.println("<!DOCTYPE html>");
//            out.println("<html>");
//            out.println("<head>");
//            out.println("<title>Servlet ThirdServlet</title>");            
//            out.println("</head>");
//            out.println("<body>");
//            out.println("<div>" + mess + "</div>");
//            out.println("</body>");
//            out.println("</html>");
//        } 

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
