/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import dao.CourseDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import models.Course;
import models.Course_Schedules;
import models.Roll_Call_Books;

/**
 *
 * @author DELL
 */
public class takeAttendance extends HttpServlet {

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
        request.getRequestDispatcher("takeAttendance.jsp").forward(request, response);
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
        CourseDAO c = new CourseDAO();
        int cId = Integer.parseInt(request.getParameter("cid"));    
        String date = request.getParameter("date");
//        String date = "2011-07-26";
        
        ArrayList<Course_Schedules> dateList = c.getDateByCourse(cId);
        ArrayList<Roll_Call_Books> attendList = c.getRollCallByCourse(cId, date);
        
        request.setAttribute("cId", cId);
        request.setAttribute("date", date);
        request.setAttribute("dateList", dateList);
        request.setAttribute("attendList", attendList);
        
        System.out.println("----------------------------------------------------");
        System.out.println("cId: "+cId);
        System.out.println("date: "+date);
        System.out.println("dateList: "+dateList);
        System.out.println("attendList: "+attendList);
        for (Roll_Call_Books list2 : attendList) {
            System.out.println(list2);
        }
        System.out.println("---------------------"); 
        
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