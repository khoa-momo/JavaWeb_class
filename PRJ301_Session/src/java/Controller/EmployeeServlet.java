/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.ArrayList;


import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author DELL
 */
@WebServlet(name = "Employee", urlPatterns = {"/Employee"})
public class EmployeeServlet extends HttpServlet {

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
//        try (PrintWriter out = response.getWriter()) {
//            /* TODO output your page here. You may use following sample code. */
//            out.println("<!DOCTYPE html>");
//            out.println("<html>");
//            out.println("<head>");
//            out.println("<title>Servlet EmployeeServlet</title>");            
//            out.println("</head>");
//            out.println("<body>");
//            out.println("<h1>Servlet EmployeeServlet at " + request.getContextPath() + "</h1>");
//            out.println("</body>");
//            out.println("</html>");
//        }
        RequestDispatcher dispatcher = request.getRequestDispatcher("Employeejsp.jsp");
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
//        HttpSession session = request.getSession();
        List<String> empList = new ArrayList<String>();
        request.setAttribute("name", "");
        request.setAttribute("gender", "");
        request.setAttribute("position", "");    
        request.setAttribute("salary", "");     
        request.setAttribute("empList", empList); 
//        String name = request.getParameter("name"); 
//        String gender = request.getParameter("gender");
//        String position = request.getParameter("position");
//        String salary = request.getParameter("salary"); 
//        HttpSession session = request.getSession();
//        
//        List<String> empList = new ArrayList<>();
//        String s = name+" "+gender+" "+position+" "+salary;
//        empList.add(s);
//        
//        session.setAttribute("lista_tojsp",empList); 
//        request.setAttribute("name", name); 
//        request.setAttribute("gender", gender);
//        request.setAttribute("position", position);
//        request.setAttribute("salary", salary);    
        
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
        String name = request.getParameter("name"); 
        String gender = request.getParameter("gender");
        String position = request.getParameter("position");
        String salary = request.getParameter("salary"); 
        
        
        String s = "";
        List<String> empList = new ArrayList<String>();
//        if(session.getAttribute("empList")!=null){
//            empList = (List<String> session.getAttribute("empList"));
//        }else{
//            empList = new ArrayList<>();
//        }
//        ArrayList<String> lista = new ArrayList<String>();
        
        s = name+" "+gender+" "+position+" "+salary;
        empList.add(s); 
//        session.setAttribute("lista_tojsp",empList); 
        
        request.setAttribute("name", name);
        request.setAttribute("gender", gender);
        request.setAttribute("position", position);
        request.setAttribute("salary", salary);  
        request.setAttribute("s", empList); 
        //String result = name+" "+gender+" "+position+" "+salary; 
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
