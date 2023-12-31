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
import javax.servlet.http.HttpSession;

import models.Course;
/**
 *
 * @author DELL
 */
@WebServlet(name = "CourseInfo", urlPatterns = {"/CourseInfo"})
public class CourseInfo extends HttpServlet {

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
        request.getRequestDispatcher("CourseInfo.jsp").forward(request, response);  
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
        HttpSession session = request.getSession(); 
        
        String courseCode = request.getParameter("courseCode"); 
        String courseDes = request.getParameter("courseDes"); 
        int subid = Integer.parseInt(request.getParameter("subid"));
        int inid = Integer.parseInt(request.getParameter("inid")); 
        int teid = Integer.parseInt(request.getParameter("teid"));
        int campid = Integer.parseInt(request.getParameter("campid"));
        
//        session.setAttribute("account", new Course(courseCode, courseDes, subid, inid, teid, campid));
        session.setAttribute("courseCode", courseCode);
        session.setAttribute("courseDes", courseDes);
        session.setAttribute("subid", subid);
        session.setAttribute("inid", inid);
        session.setAttribute("teid", teid);
        session.setAttribute("campid", campid); 
        
        response.sendRedirect("./addStudent");
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
