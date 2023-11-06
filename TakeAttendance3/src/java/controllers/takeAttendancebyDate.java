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
import models.Roll_Call_Books;
import models.Student;

/**
 *
 * @author DELL
 */
@WebServlet(name = "takeAttendancebyDate", urlPatterns = {"/takeAttendancebyDate"})
public class takeAttendancebyDate extends HttpServlet {

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
        request.getRequestDispatcher("takeAttendancebyDate.jsp").forward(request, response);
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
        int cid = Integer.parseInt(request.getParameter("cid"));    
        int slot = Integer.parseInt(request.getParameter("slot"));    
        String date = request.getParameter("date");
        //---------
        //get student list
        
        
        //---------
//        ArrayList<Course_Schedules> dateList = c.getDateByCourse(cid); 
        ArrayList<Roll_Call_Books> attendList = c.getRollCallByCourse(cid, date, slot);// -> teachingid?
//        System.out.println("attendList size: "+attendList.size());
//        request.setAttribute("attendListSize", attendList.size());
        
        //get teachingid 
        
//        response.sendRedirect("insertAttendance?cid="+cid+"&date="+date+"&slot="+slot); 

        ArrayList<Course_Schedules> scheList = c.getStudentByCourse(cid, date, slot);
        int teachingid = scheList.get(0).getTeachingScheduleId(); 
        request.setAttribute("scheList", scheList);
        request.setAttribute("teachingid", teachingid);
        
        request.setAttribute("attendList", attendList);  
         
        //for sendredirect
        request.setAttribute("cid", cid);
        request.setAttribute("date", date);
        request.setAttribute("slot", slot); 
        String code = c.getCourseName(cid);
        request.setAttribute("code", code); 
        
        System.out.println("------------------------checklogGet---------------------");
        System.out.println("scheList: "+scheList);
        System.out.println("attendList: "+attendList);
        System.out.println("teachingid: "+teachingid);
        System.out.println("cid: "+cid);
        System.out.println("date: "+date); 
        System.out.println("slot: "+slot); 
        System.out.println("--------------------------EndOfLog-----------------------");         
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
        //for update absent
        CourseDAO c = new CourseDAO();   
        //for sendredirect
        int cid = Integer.parseInt(request.getParameter("cid"));    
        int slot = Integer.parseInt(request.getParameter("slot"));    
        String date = request.getParameter("date");
        
        
        ArrayList<Roll_Call_Books> atllist = c.getRollCallByCourse(cid, date, slot);// get current roll call list
        ArrayList<Integer> rcList = new ArrayList<>(); 
        ArrayList<Integer> studentIdList = new ArrayList<>();
         
        for(Roll_Call_Books rollcallBooks : atllist){
            rcList.add(rollcallBooks.getRollCallBookId()); 
        }    
        for(Roll_Call_Books rollcallBooks : atllist){
            studentIdList.add(rollcallBooks.getStudent().getStudentId());
        }  
        
        System.out.println("check first rcid: "+rcList.get(0));
       
        int size = rcList.size(); 
        int[] absentArr = new int[size];
        int isAbsent = 0;
        
        String[] comments = new String[size];
        comments = request.getParameterValues("comment");//get submitted comment list
        
        System.out.println("size: "+size);
        for (int i = 0; i < size; i++) {
            
            isAbsent = Integer.parseInt(request.getParameter(""+studentIdList.get(i)));//get submitted absent list
            absentArr[i] = isAbsent;
            c.updateRollCall(rcList.get(i), absentArr[i], comments[i]);
            System.out.println("loop: "+i+"---"+
                    "rc: "+rcList.get(i)+"---"+
                    "absentArr: "+absentArr[i]);
            
        }  
        
        System.out.println("------------------------checklogPost---------------------"); 
        System.out.println("isAbsent: "+Arrays.toString(absentArr));//abbsent 
        
        response.sendRedirect("takeAttendancebyDate?cid="+cid+"&date="+date+"&slot="+slot); 
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
//<a href="CourseAttendance?cid=${cid}">Go back</a>
//<td><input type="text" name="comment"></td>
