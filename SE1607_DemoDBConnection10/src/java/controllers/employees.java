/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import dal.EmployeeDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import models.Employee;

/**
 *
 * @author lephu
 */
@WebServlet(name = "employees", urlPatterns = {"/employees"})
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
    private int depId=0;
    private int page=1;
    private int pageSize=10;
    private int totalPage;
    
    private void buildPager(HttpServletRequest request, HttpServletResponse response){
        request.setAttribute("totalPage", totalPage);
        request.setAttribute("curPage", page);
        String curUrl = request.getRequestURL().toString()+"?";
        if (depId!=0) curUrl += "did=" + depId + "&";
        request.setAttribute("curUrl", curUrl);
    }
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        ArrayList<Employee> emplist = new ArrayList<>();
        String nextpage = "employees.jsp";
        try{
            if (request.getParameter("did") != null)
                depId = Integer.parseInt(request.getParameter("did"));
        }
        catch (Exception e){            
        }
        try{
            if (request.getParameter("page") != null)
                page = Integer.parseInt(request.getParameter("page"));            
        }
        catch (Exception e){
            page=1;
        }
        EmployeeDAO dao = new EmployeeDAO();
        int totalEmp = dao.getNumberOfEmployee(depId);
        totalPage = totalEmp/pageSize;
        if (totalEmp % pageSize != 0) totalPage++;
        if (page > totalPage) page=1;
        
        int offset = (page-1)*pageSize;
        
        emplist = dao.getAllEmployeesByDeptIdPaging(depId, offset, pageSize);
        
        request.setAttribute("emps", emplist);
        buildPager(request, response);
        RequestDispatcher dispatcher = request.getRequestDispatcher(nextpage);
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
