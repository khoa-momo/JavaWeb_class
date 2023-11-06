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
@WebServlet(name = "employeeFillter", urlPatterns = {"/employeeFillter"})
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
            ArrayList<Department> deptList = new DepartmentDAO().getAllDepartments();
            request.setAttribute("deptList", deptList);
            //forward
            request.getRequestDispatcher("employeeFillter.jsp").forward(request, response);
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
         //Get all emp
        EmployeeDAO edao = new EmployeeDAO();
//        ArrayList<Employee> list = dao.getAllEmployees();//SQL 
//        int page, numberpage = 6;
//        int size = list.size();
//        int num = (size%6==0?(size/6):((size/6))+1);
//        String xpage = request.getParameter("page");
//        if(xpage==null){
//            page=1;
//        }else{
//            page=Integer.parseInt(xpage);
//        }
//        int start, end;
//        start = (page-1)*numberpage;
//        end=Math.min(page*numberpage, size);
//        ArrayList<Employee> paginglist = dao.getListByPage(list, start, end);
//
//        request.setAttribute("emplist", paginglist);
//        request.setAttribute("page", page);
//        request.setAttribute("num", num);
        if (request.getSession().getAttribute("ename") != null) {
            String ename =  (String) request.getSession().getAttribute("ename"); 
            
            LocalDate dateFrom = (LocalDate) request.getSession().getAttribute("dateFrom");
            System.out.println("dateFrom: "+dateFrom); 
            LocalDate dateTo = (LocalDate) request.getSession().getAttribute("dateTo");
            System.out.println("dateTo: "+dateTo); 
            
            String esex = (String) request.getSession().getAttribute("esex");
            String eposition = (String) request.getSession().getAttribute("eposition");
            int depid = (Integer) request.getSession().getAttribute("depid");
             
            //Paging with sql
            final int PAGE_SIZE = 6;
            int page = 1;
            String pageStr = request.getParameter("page");
            if (pageStr != null) {
                page = Integer.parseInt(pageStr);
            }  

            List<Employee> paginglist = edao.getEmployeesByFillterPaging(ename, dateFrom, dateTo, esex, depid, page, PAGE_SIZE);
            int totalProducts = edao.getTotalEmployeeFillterPaging(ename, dateFrom, dateTo, esex, depid);
            int totalPage = totalProducts / PAGE_SIZE;
            if (totalProducts % PAGE_SIZE != 0) {
                totalPage += 1;
            }
            request.setAttribute("page", page);
            request.setAttribute("totalPage", totalPage);
            request.setAttribute("emplist", paginglist);
        }else{
            ArrayList<Employee> list = edao.getAllEmployees();
            request.setAttribute("emplist", list);
        } 
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
            EmployeeDAO edao = new EmployeeDAO(); 
            String ename = request.getParameter("ename");//empty -> all
            LocalDate dateFrom = LocalDate.parse(request.getParameter("dateFrom")); 
            LocalDate dateTo = LocalDate.parse(request.getParameter("dateTo")); 
            String esex = request.getParameter("esex");//
            int depid = Integer.parseInt(request.getParameter("deparment"));
             
            if(esex.equals("All")){
                esex = "";
            }
            System.out.println("ename: "+ename);
            System.out.println("dateFrom: "+dateFrom);
            System.out.println("dateTo: "+dateTo);
            System.out.println("esex: "+esex);
            System.out.println("depid: "+depid);
              
            //Paging with sql
            final int PAGE_SIZE = 6;
            int page = 1;
            String pageStr = request.getParameter("page");
            if (pageStr != null) {
                page = Integer.parseInt(pageStr);
            }  
            
            List<Employee> paginglist = edao.getEmployeesByFillterPaging(ename, dateFrom, dateTo, esex, depid, page, PAGE_SIZE);
            int totalProducts = edao.getTotalEmployeeFillterPaging(ename, dateFrom, dateTo, esex, depid);
            int totalPage = totalProducts / PAGE_SIZE;
            if (totalProducts % PAGE_SIZE != 0) {
                totalPage += 1;
            }
            request.getSession().setAttribute("page", page);
            request.getSession().setAttribute("totalPage", totalPage);
            request.getSession().setAttribute("emplist", paginglist);
             
            System.out.println("page: "+page);
            System.out.println("totalProducts: "+totalProducts);
            System.out.println("totalPage: "+totalPage);
            System.out.println("paginglist: "+paginglist);
            
            
//            if (esex == null) {
//                esex = "";
//                emplist = new EmployeeDAO().getEmployeesByFillter(ename, dateFrom, dateTo, esex, eposition, depid);         
//            }else{
//                emplist = new EmployeeDAO().getEmployeesByFillter(ename, dateFrom, dateTo, esex, eposition, depid);                
//            }  
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
//            request.setAttribute("paginglist", paginglist);
            
            //show data
            request.getSession().setAttribute("ename", ename);
            request.getSession().setAttribute("esex", esex); 
            request.getSession().setAttribute("dateFrom", dateFrom);
            request.getSession().setAttribute("dateTo", dateTo);
            request.getSession().setAttribute("depid", depid); 
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
