/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import java.io.IOException;
import java.io.PrintWriter;

import java.text.SimpleDateFormat;
import java.util.Date;

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
@WebServlet(name = "page5", urlPatterns = {"/page5"})
public class page5 extends HttpServlet {

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
        RequestDispatcher dispatcher = request.getRequestDispatcher("page5jsp.jsp");
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
         
        Date dNow = new Date();
        SimpleDateFormat min = new SimpleDateFormat("mm");    
        SimpleDateFormat hour = new SimpleDateFormat("hh");    
        SimpleDateFormat day = new SimpleDateFormat("dd");    
        SimpleDateFormat month = new SimpleDateFormat("MM");    
        SimpleDateFormat year = new SimpleDateFormat("yyyy");
            
        String responeTime = request.getParameter("responeTime");

        String time = request.getParameter("time"); 
        switch (time) {
            case "1": 
                responeTime="Minute: "+min.format(dNow);
                break;
            case "2": 
                responeTime="Hour: "+hour.format(dNow);
                break;
            case "3": 
                responeTime="Day: "+day.format(dNow);
                break; 
            case "4": 
                responeTime="Month: "+month.format(dNow);
                break; 
            case "5": 
                responeTime="Year: "+year.format(dNow);
                break; 
        }
        request.setAttribute("responeTime", responeTime);   
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
