/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import dao.CourseDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import models.Course_Schedules;
import models.Student;

/**
 *
 * @author DELL
 */
@WebServlet(name = "insertAttendance", urlPatterns = {"/insertAttendance"})
public class insertAttendance extends HttpServlet {

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
        CourseDAO c = new CourseDAO();   
        //for sendredirect
        int cid = Integer.parseInt(request.getParameter("cid"));    
        int slot = Integer.parseInt(request.getParameter("slot"));    
        String date = request.getParameter("date");
        int teachingid = Integer.parseInt(request.getParameter("teachingid"));    
        
//        ArrayList<Student> studList = c.getStudentByCourse(cid);
        ArrayList<Course_Schedules> scheList = c.getStudentByCourse(cid, date, slot);
        ArrayList<Integer> studentIdList = new ArrayList<>();
        for(Course_Schedules std : scheList){
            studentIdList.add(std.getStudent().getStudentId());
        }  
        
        int size = scheList.size(); 
        int[] absentArr = new int[size]; 
        int isAbsent = 0; 
        
        String[] comments = new String[size];
        comments = request.getParameterValues("comment");//get submitted comment list - String Array
        
        System.out.println("size: "+size);
        for (int i = 0; i < size; i++) {
            System.out.println("comment"+studentIdList.get(i));
            isAbsent = Integer.parseInt(request.getParameter(""+studentIdList.get(i)));//get submitted absent list 
            absentArr[i] = isAbsent;  

            c.InsertRollCall(teachingid, studentIdList.get(i), absentArr[i], comments[i]);
                          //unchange      ArrayList<Integer>    
            System.out.println("######loop: "+i+"---"+
                    "teachingid: "+teachingid+"---"+
                    "studentIdList: "+studentIdList.get(i)+"---"+
                    "absentArr: "+absentArr[i]+
                    "comment: "+comments[i]+"---");
            
        }  
        System.out.println("------------------------checklogPost(insert)---------------------"); 
        System.out.println("isAbsent: "+Arrays.toString(absentArr));//abbsent
//        request.setAttribute("update", "List has update!");
        response.sendRedirect("takeAttendancebyDate?cid="+cid+"&date="+date+"&slot="+slot); 
//        processRequest(request, response);
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
