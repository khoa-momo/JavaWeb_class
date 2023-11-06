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
import java.util.List;
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
@WebServlet(name = "employeeFillter", urlPatterns = {"/employeeFillter"})
public class Searching extends HttpServlet {

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
        CrudDAO dao = new CrudDAO();
        //Option List
        ArrayList<Object> selectedList = dao.getAllObjectById(0);
        request.setAttribute("selectedList", selectedList);
        
        //Send dept id
        int did;
        if ((request.getParameter("did")) != null) {
            did = Integer.parseInt(request.getParameter("did"));
            request.setAttribute("did", did); 
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
        //Get ALL
        CrudDAO edao = new CrudDAO(); 
        if (request.getSession().getAttribute("ename") != null) {
            String ename =  (String) request.getSession().getAttribute("ename");  
            LocalDate dateFrom = (LocalDate) request.getSession().getAttribute("dateFrom"); 
            LocalDate dateTo = (LocalDate) request.getSession().getAttribute("dateTo"); 
            
            String esex = (String) request.getSession().getAttribute("esex");
            String eposition = (String) request.getSession().getAttribute("eposition");
            int depid = (Integer) request.getSession().getAttribute("depid");
             
             
            ArrayList<Object> list = edao.getAllObjectById(0);
             
            request.setAttribute("list", list);
        }else{
            ArrayList<Object> list = edao.getAllObjectById(0);
            request.setAttribute("list", list);
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
        //Get search
        try{
            CrudDAO edao = new CrudDAO(); 
            
            String ename = request.getParameter("ename");//empty -> all
            LocalDate dateFrom = LocalDate.parse(request.getParameter("dateFrom")); 
            LocalDate dateTo = LocalDate.parse(request.getParameter("dateTo")); 
            String esex = request.getParameter("esex");//
            String eposition = request.getParameter("eposition");
            int depid = Integer.parseInt(request.getParameter("deparment"));
             
            System.out.println("ename: "+ename);
            System.out.println("dateFrom: "+dateFrom);
            System.out.println("dateTo: "+dateTo);
            System.out.println("esex: "+esex);
            System.out.println("eposition: "+eposition);
            System.out.println("depid: "+depid);
              
            
            //show data
            request.setAttribute("ename", ename);
            request.setAttribute("esex", esex);
            request.setAttribute("eposition", eposition); 
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

     
}
