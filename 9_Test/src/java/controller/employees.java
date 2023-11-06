/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import models.Student;
/**
 *
 * @author DELL
 */
public class employees extends HttpServlet {

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
        request.getRequestDispatcher("employee.jsp").forward(request, response);
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
        HttpSession hs = request.getSession();
        List<Student> listS = (List<Student>) hs.getAttribute("listS");
        if (listS != null) {
            hs.setAttribute("listS", listS);
            request.setAttribute("listS", listS); 
        } else {
            String alert = "There are no employees on the list yet";
            request.setAttribute("alert", alert); 
        }
        
//        int name = Integer.parseInt(request.getParameter("name"));
        
//        List<Student> listSchoolYears = new ArrayList();
//        request.setAttribute("listSchoolYears", listSchoolYears);
//        request.setAttribute("listStudents", listStudents);
        
        
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
        List<Student> listS = new ArrayList<>();
        HttpSession session = request.getSession();
        if (session.getAttribute("listS") != null) {
            listS = (List<Student>) session.getAttribute("listS");
        } 
         
//        List<Student> listS = (List<Student>) session.getAttribute("listS") == null ? new ArrayList<>():(List<Student>) session.getAttribute("listS");
        
        String name = request.getParameter("name");
        String gender = request.getParameter("gender");
        listS.add(new Student(name, gender));
        session.setAttribute("listS", listS);
//        response.sendRedirect("employees");
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
