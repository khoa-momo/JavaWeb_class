package Begin;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
 
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
/**
 *
 * @author DELL
 */
@WebServlet(urlPatterns = {"/Begin1"})
public class Begin1 extends HttpServlet {

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
//            out.println("<title>Servlet Begin1</title>");            
//            out.println("</head>");
//            out.println("<body>");
//            out.println("<h1>Servlet Begin1 at " + request.getContextPath() + "</h1>");
//            out.println("</body>");
//            out.println("</html>");
//        }
        HttpSession session = request.getSession();
        session.setMaxInactiveInterval(20);
        RequestDispatcher dispatcher = request.getRequestDispatcher("begin1.jsp");
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
        HttpSession session = request.getSession(); 
        ArrayList<String> lista = new ArrayList<String>();
        if (session.getAttribute("lista_tojsp") != null){
            request.setAttribute("lista_tojsp", session.getAttribute("lista_tojsp"));
        }else{
            request.setAttribute("lista_tojsp", "Chua co"); 
        } 
        processRequest(request, response);
 
//        HttpSession session = request.getSession();
//        String s1="Sess100";
//        String s2="Sess200";
        
//        lista.add(s1);
//        lista.add(s2);
//        session.setAttribute("lista_tojsp",lista);
//        request.setAttribute("lista_tojsp", lista);
//        processRequest(request, response);
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
        
        String s1="Sess10";
        String s2="Sess20";
        ArrayList<String> lista = new ArrayList<String>();
        lista.add(s1);
        lista.add(s2);
        
        session.setAttribute("lista_tojsp",lista); 
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
