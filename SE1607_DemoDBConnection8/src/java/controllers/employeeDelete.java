/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import dal.EmployeeDAO;

import java.io.IOException; 
import java.sql.SQLException;
import javax.servlet.RequestDispatcher;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import models.Employee;
 

/**
 *
 * @author DELL
 */
@WebServlet(name = "employeeDelete", urlPatterns = {"/employeeDelete"})
public class employeeDelete extends HttpServlet {

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
        try{
            int empID = Integer.parseInt(request.getParameter("empID"));
            EmployeeDAO dao = new EmployeeDAO();
            dao.deleteEmployee(empID);
            request.setAttribute("mess", "Delete employee thanh cong.");
        }catch(NumberFormatException | SQLException e){
            request.setAttribute("mess", "Co loi!");
        } 
        RequestDispatcher dispatcher = request.getRequestDispatcher("employeeDelete.jsp");
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
//        request.setAttribute("mess", "");
//        processRequest(request, response);
//        String masp = request.getParameter("id");

        int empID = Integer.parseInt(request.getParameter("empID"));
        EmployeeDAO dao = new EmployeeDAO();
        Employee emp = new EmployeeDAO().getEmployeeById(empID);
        int depid = emp.getDepartment().getId();
        try {
            if (dao.deleteEmployee(empID)) {
                response.sendRedirect("./employees?did="+depid); 
            } else {
                response.sendRedirect("err.jsp");
            }
        } catch (IOException | SQLException e) {
        }
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
