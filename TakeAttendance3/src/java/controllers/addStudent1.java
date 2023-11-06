/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import models.Student;
import dao.CourseDAO;
import java.util.Arrays;
import java.util.List;
import javax.servlet.http.HttpSession;
import models.Student;
/**
 *
 * @author DELL
 */
@WebServlet(name = "addStudent1", urlPatterns = {"/addStudent1"})
public class addStudent1 extends HttpServlet {

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
        CourseDAO dao = new CourseDAO(); 
        ArrayList<Student> studList = dao.getAllStudent();
        request.setAttribute("studList", studList);
        
        ArrayList<Student> studList2 = dao.getStudentByCourseTest(1014);
        request.setAttribute("studList2", studList2);
        request.getRequestDispatcher("addStudent_1.jsp").forward(request, response);  
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
//        String[] studId = request.getParameterValues("studId");
//        ArrayList<String> objs = new ArrayList<String>(); // Create an ArrayList object
        
        List<String> studId = new ArrayList<>();
        studId = Arrays.asList(request.getParameterValues("studId"));
        
        session.setAttribute("studId", studId);
        System.out.println("SID: "+studId.toString());//ArrayList to String
//        System.out.println("SID: "+Arrays.toString(studId));//Array to String
         
        //get student list by the id list
//        ArrayList<Student> studList = new ArrayList<>();
//        studList = dao.getSessionStudent(studId);//return ArrayList
//        System.out.println(studList);
        response.sendRedirect("./Confirm");
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
