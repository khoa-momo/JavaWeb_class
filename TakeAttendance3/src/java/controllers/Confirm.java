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
import dao.CourseDAO;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import models.Instructor;
import models.Student;

/**
 *
 * @author DELL
 */
@WebServlet(name = "Confirm", urlPatterns = {"/Confirm"})
public class Confirm extends HttpServlet {

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
        request.getRequestDispatcher("Confirm.jsp").forward(request, response);   
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
        HttpSession session = request.getSession();  
        CourseDAO dao = new CourseDAO();
    //Course
        String courseCode = (String) session.getAttribute("courseCode");
        String courseDes = (String) session.getAttribute("courseDes"); 
        int subid = (Integer) session.getAttribute("subid");  
        int inid = (Integer) session.getAttribute("inid");  
        int teid = (Integer) session.getAttribute("teid");  
        int campid = (Integer) session.getAttribute("campid"); 
        
        Instructor inName = dao.getInstructorName(inid);
        String subName = dao.getSubjectNameById(subid);
        request.setAttribute("courseCode", courseCode);
        request.setAttribute("courseDes", courseDes);
        request.setAttribute("subName", subName);
        request.setAttribute("inName", inName);
        request.setAttribute("teid", teid);
        request.setAttribute("campid", campid);
        
    //Student  
        //Get studentid session
        List<String> studId = new ArrayList<>();
        studId = (List<String>) session.getAttribute("studId");  
        //get student list by the id list
        ArrayList<Student> studList = new ArrayList<>();
        studList = dao.getSessionStudent(studId);//return ArrayList
//        System.out.println(studList);
        request.setAttribute("studList", studList); 
        
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
        CourseDAO dao = new CourseDAO();
    //Course
        String courseCode = (String) session.getAttribute("courseCode");
        String courseDes = (String) session.getAttribute("courseDes"); 
        int subid = (Integer) session.getAttribute("subid");  
        int inid = (Integer) session.getAttribute("inid");  
        int teid = (Integer) session.getAttribute("teid");  
        int campid = (Integer) session.getAttribute("campid");
    //insert to db
        int courseid = dao.insertCourses(courseCode, courseDes, subid, inid, teid, campid);
         
    //Student's Id List
        //Get studentid session
        List<String> studId = new ArrayList<>();
        studId = (List<String>) session.getAttribute("studId");   
        
    //Insert to DB
        for (int i = 0; i < studId.size(); i++) {
            System.out.println("courseid: "+courseid);
            System.out.println("studId: "+studId.get(i));
            dao.insertStudent_Courses(courseid, studId.get(i));
        }
        
        System.out.println("courseCode: "+courseCode);
        System.out.println("courseDes: "+courseDes);
        System.out.println("subid: "+subid);
        System.out.println("inid: "+inid);
        System.out.println("teid: "+teid);
        System.out.println("campid: "+campid); 
        
          
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
