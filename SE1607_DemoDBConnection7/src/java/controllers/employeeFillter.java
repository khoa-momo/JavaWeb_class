/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import dal.DepartmentDAO;
import dal.EmployeeDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import models.Department;
import models.Employee;

/**
 *
 * @author DELL
 */
@WebServlet(name = "employeeAll", urlPatterns = {"/employeeFillter"})
public class employeeFillter extends HttpServlet {

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
        try (PrintWriter out = response.getWriter()) {
//        EmployeeDAO dao = new EmployeeDAO();
//            DepartmentDAO dao = new DepartmentDAO();
//            ArrayList<Department> deptList = dao.getAllDepartments();
//            request.setAttribute("deptList", deptList);

        
        
            RequestDispatcher dispatcher = request.getRequestDispatcher("employeeFillter.jsp");
            dispatcher.forward(request, response);
        }
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
        ArrayList<Department> deptList = new DepartmentDAO().getAllDepartments();
//        ArrayList<Employee> emplist = new EmployeeDAO().getAllEmployees(); 
        EmployeeDAO dao = new EmployeeDAO();
        ArrayList<Employee> list = dao.getAllEmployees();//SQL

        int page, numberpage = 6;
        int size = list.size();
        int num = (size%6==0?(size/6):((size/6))+1);
        String xpage = request.getParameter("page");
        if(xpage==null){
            page=1;
        }else{
            page=Integer.parseInt(xpage);
        }
        int start, end;
        start = (page-1)*numberpage;
        end=Math.min(page*numberpage, size);
        ArrayList<Employee> paginglist = dao.getListByPage(list, start, end);

        request.setAttribute("emplist", paginglist);
        request.setAttribute("page", page);
        request.setAttribute("num", num);
        
//        request.setAttribute("emplist", emplist);
        request.setAttribute("deptList", deptList);
        processRequest(request, response);
    }
    
    /**ArrayList<Employee> emplist = null;
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
        try{
            ArrayList<Employee> emplist = new ArrayList<>();
            String ename = request.getParameter("ename"); 
            LocalDate dateFrom = LocalDate.parse(request.getParameter("dateFrom")); 
            LocalDate dateTo = LocalDate.parse(request.getParameter("dateTo")); 
            String esex = request.getParameter("esex");
            String eposition = request.getParameter("eposition");
            int depid = Integer.parseInt(request.getParameter("deparment"));
             
            if (esex == null) {
                esex = "";
                emplist = new EmployeeDAO().getEmployeesByFillter(ename, dateFrom, dateTo, esex, eposition, depid);         
            }else{
                emplist = new EmployeeDAO().getEmployeesByFillter(ename, dateFrom, dateTo, esex, eposition, depid);                
            }
//            emplist = new EmployeeDAO().getEmployeesByFillter(ename, dateFrom, dateTo, esex, eposition, depid);  
            
//            EmployeeDAO dao = new EmployeeDAO();
//            int page, numberpage = 6;
//            int size = emplist.size();
//            int num = (size%6==0?(size/6):((size/6))+1);
//            String xpage = request.getParameter("page");
//            if(xpage==null){
//                page=1;
//            }else{
//                page=Integer.parseInt(xpage);
//            }
//            int start, end;
//            start = (page-1)*numberpage;
//            end=Math.min(page*numberpage, size);
//            ArrayList<Employee> paginglist = dao.getListByPage(emplist, start, end);

//            request.setAttribute("emplist", paginglist);
//            request.setAttribute("page", page);
//            request.setAttribute("num", num);
//            ArrayList<Employee> emplist2 = new EmployeeDAO().getAllEmployees(); 
            request.setAttribute("emplist", emplist);
            
            //show data
            request.setAttribute("ename", ename);
            request.setAttribute("esex", esex);
            request.setAttribute("eposition", eposition);
            request.setAttribute("dateFrom", dateFrom);
            request.setAttribute("dateTo", dateTo);
            request.setAttribute("depid", depid);
            
        }catch(NumberFormatException e){ 
        }
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

    
    //test
//    <c:forEach items="${deptList}" var="dept">
//                    <option  value="${dept.getId()}"${dept.getId() == depid?"selected":""}>${dept.getName()}</option>
//                </c:forEach> 
}
