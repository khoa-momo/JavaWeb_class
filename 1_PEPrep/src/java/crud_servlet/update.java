/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package crud_servlet;
 

import dao.CrudDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.util.ArrayList;

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
@WebServlet(name = "employeeUpdate", urlPatterns = {"/employeeUpdate"})
public class update extends HttpServlet {

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
        request.getRequestDispatcher("employeeUpdate.jsp").forward(request, response); 
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
        //Send up SelectedList
        CrudDAO dao = new CrudDAO();
        ArrayList<Object> deptList = dao.getAllObjectById(0);
        request.setAttribute("deptList", deptList); 
        int empid = 0; //From employees.jsp
        if ((request.getParameter("empID")) != null) {
            empid = Integer.parseInt(request.getParameter("empID")); 
        }
        
        //Send up object for update
//        Object e = dao.getAllEmployeesByName(empName, LocalDate.MAX, sex, position);
//        request.setAttribute("e", e); 
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
            CrudDAO dao = new CrudDAO();
        
            String empname = request.getParameter("ename");
            LocalDate dob = LocalDate.parse(request.getParameter("edob")); 
            String sex = request.getParameter("esex");
            String position = request.getParameter("eposition");
            int depid = Integer.parseInt(request.getParameter("deparment"));
            int empID = Integer.parseInt(request.getParameter("empID")); 
        
            dao.update2(empname, dob, sex, position, depid, empID);
            response.sendRedirect("./employees?did="+depid); 
            
        try{
//            String empname = request.getParameter("ename");
//            LocalDate dob = LocalDate.parse(request.getParameter("edob")); 
//            String sex = request.getParameter("esex");
//            String position = request.getParameter("eposition");
//            int depid = Integer.parseInt(request.getParameter("deparment"));
//            int empID = Integer.parseInt(request.getParameter("empID")); 
            
//            Object e = new Object(0, empname, dob, sex, position);
//            e.setDepartment(new Department(depid));
            
            
//            dao.updateEmployee(e, empID);
            
            response.sendRedirect("./employees?did="+depid); 
        }catch(IOException | NumberFormatException e){ 
        } 
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
