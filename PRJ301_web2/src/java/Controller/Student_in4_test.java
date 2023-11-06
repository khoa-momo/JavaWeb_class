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
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author DELL
 */
@WebServlet(name = "Student_in4_test", urlPatterns = {"/Student_in4_test"})
public class Student_in4_test extends HttpServlet {

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
        RequestDispatcher dispatcher = request.getRequestDispatcher("Student.jsp");
        dispatcher.forward(request, response);
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
        request.setAttribute("first", "");
        request.setAttribute("last", "");
        request.setAttribute("gender", "");    
        request.setAttribute("major", "");    
        request.setAttribute("dob", "");    
        request.setAttribute("dormitory", "");    
        request.setAttribute("reservation", "");     
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
        
        String first = request.getParameter("first");
        String last = request.getParameter("last");
        String gender = request.getParameter("gender");
        String major = request.getParameter("major");
        String dob = request.getParameter("dob");
        String dormitory = request.getParameter("dormitory");
        String reservation = request.getParameter("reservation");   
        
        request.setAttribute("first", first);
        request.setAttribute("last", last);
        request.setAttribute("gender", gender);
        request.setAttribute("major", major);
        request.setAttribute("dob", dob);
        request.setAttribute("dormitory", dormitory);
        request.setAttribute("reservation", reservation);
        
        String result = first+" "+last+" "+gender+" "+major+" "+dob+" "+dormitory;
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
