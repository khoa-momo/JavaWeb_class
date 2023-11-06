/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import dal.EmployeeDAO;
import java.io.IOException;
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
    private int depId = 0;
    private int page = 1;
    private int pageSize = 10;
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
        EmployeeDAO dao = new EmployeeDAO();
        
        ArrayList<Employee> emplist = new ArrayList<>();
        String nextpage = "employees.jsp";
        
        //Cases
        try{
            if (request.getParameter("did") != null)
                depId = Integer.parseInt(request.getParameter("did"));
        }catch (NumberFormatException e){            
        }
        try{
            if (request.getParameter("page") != null)
                page = Integer.parseInt(request.getParameter("page"));            
        }catch (NumberFormatException e){
            page=1;
        } 
        
        //
        int totalEmp = dao.getNumberOfEmployee(depId);
        totalPage = totalEmp/pageSize;
        if (totalEmp % pageSize != 0) totalPage++;
        if (page > totalPage) page=1;
        int offset = (page-1)*pageSize;
        
        emplist = dao.getAllEmployeesByDeptIdPaging(depId, offset, pageSize);
        request.setAttribute("emplist", emplist);
        buildPager(request, response);

        request.getRequestDispatcher(nextpage).forward(request, response);
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
        
//        int deptid = Integer.parseInt(request.getParameter("did"));//
//        EmployeeDAO dao = new EmployeeDAO();
//        ArrayList<Employee> list = dao.getAllEmployeesByDeptId(deptid);//get all by id
//
//        int page, numberpage = 6;
//        int size = list.size();
//        int num = (size%6==0?(size/6):((size/6))+1);
//        String xpage = request.getParameter("page");
//
//        if(xpage==null){
//            page=1;
//        }else{
//            page=Integer.parseInt(xpage);
//        }
//        int start, end;
//        start = (page-1)*numberpage;
//        end=Math.min(page*numberpage, size);
//
//        ArrayList<Employee> paginglist = dao.getListByPage(list, start, end);
//
//        request.setAttribute("emplist", paginglist);
//        request.setAttribute("page", page);
//        request.setAttribute("num", num);
//
//        request.setAttribute("deptid", deptid);
        
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


//<c:set var="page" value="${requestScope.page}"/>
//        <div class="pagination">
//            <c:forEach begin="${1}" end="${requestScope.num}" var="i">
//                    <a href="employees?did=${deptid}&?page=${i}">${i}</a>
//            </c:forEach>     
//        </div>    