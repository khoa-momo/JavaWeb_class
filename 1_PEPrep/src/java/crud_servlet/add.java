/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package crud_servlet;

//import dal.DepartmentDAO;
//import dal.EmployeeDAO;

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

//import models.Department;

/**
 *
 * @author lephu
 */
@WebServlet(name = "add", urlPatterns = {"/add"})
public class add extends HttpServlet {

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
        request.getRequestDispatcher("Add.jsp").forward(request, response);  
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
        CrudDAO dao = new CrudDAO();
        //Send deptList
        ArrayList<Object> selectedList = dao.getAllObjectById(0);
        request.setAttribute("selectedList", selectedList);
        //Send dept id
        int did;
        if ((request.getParameter("did")) != null) {
            did = Integer.parseInt(request.getParameter("did"));
            request.setAttribute("did", did); 
        }
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
        
//        String empname = request.getParameter("ename");
//        LocalDate dob = LocalDate.parse(request.getParameter("edob")); 
//        String sex = request.getParameter("esex");
//        dao.addEmployee(e);
        
//        String id = request.getParameter("id");
//        String name = request.getParameter("name");
//        boolean gender = Boolean.parseBoolean(request.getParameter("gender"));
//
//        String[] skills = request.getParameterValues("skill");
//        new CharacterDAO().addCharacter(id, name, gender);
//        new CharacterDAO().addCharacterSkill(id, skills);

        try{
            //get All Parameter
            String empname = request.getParameter("ename");
            LocalDate dob = LocalDate.parse(request.getParameter("edob")); 
            String sex = request.getParameter("esex");
            String position = request.getParameter("eposition");
            int depid = Integer.parseInt(request.getParameter("deparment"));
            //Make emp object
//            Employee e = new Employee(0, empname, dob, sex, position);
//            e.setDepartment(new Department(depid));
            //Call func 
//            dao.addEmployee(e);
            //sendRedirect
            response.sendRedirect("./employees?did="+depid);//back to lastest dept
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
