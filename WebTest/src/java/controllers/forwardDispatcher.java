/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author DELL
 */
@WebServlet(name = "forwardDispatcher", urlPatterns = {"/forwardDispatcher"})
public class forwardDispatcher extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    
    //----------------forwardDispatcher.Servlet----------------
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
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
        
        
        //=========================I>sendRedirect<==============================
        
//        response.sendRedirect("./send.jsp");//SendRedirected! 
//        response.sendRedirect("./forward.jsp");//Forward!
 
//        response.sendRedirect("sendRedirect");// ./sendRedirect
//        response.sendRedirect("./sendRedirect");// ./sendRedirect

//        response.sendRedirect("forwardDispatcher");//localhost redirected you too many times.
//        response.sendRedirect("./forwardDispatcher");//localhost redirected you too many times.

        //=========================II>getRequestDispatcher<==============================
        
//        request.getRequestDispatcher("send.jsp").forward(request, response);//SendRedirected! 
//        request.getRequestDispatcher("forward.jsp").forward(request, response);//Forward!


//        request.getRequestDispatcher("./forwardDispatcher").forward(request, response);// AS-WEB-CORE-00089
//        request.getRequestDispatcher("forwardDispatcher").forward(request, response);// AS-WEB-CORE-00089

//        request.getRequestDispatcher("./sendRedirect").forward(request, response);//  
//        request.getRequestDispatcher("sendRedirect").forward(request, response);//  

//        request.getRequestDispatcher("./test1").forward(request, response);
        
        int x = 1;
        if (x == 2){
            response.sendRedirect("sendRedirect");// ./sendRedirect 
        }else{
            request.getRequestDispatcher("forward.jsp").forward(request, response);//Forward!
        }
//        processRequest(request, response);
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
