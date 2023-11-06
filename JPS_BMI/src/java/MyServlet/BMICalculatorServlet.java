/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MyServlet;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author DELL
 */
public class BMICalculatorServlet extends HttpServlet {

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
            /* TODO output your page here. You may use following sample code. */
        String height = request.getParameter("height");
        String weight = request.getParameter("weight");

        double h = 0;
        double w = 0;
            
        boolean check = true;
    //height
        try {
            h = Double.parseDouble(height);
            if(h <= 0){
                check = false;
                request.setAttribute("h_error", "Height value must be positive!");
            }
        } catch (NumberFormatException e) {
            check = false;
            request.setAttribute("h_error", "Height value is invalid!");
        }
    //weight
        try {
            w = Double.parseDouble(weight);
            if(w <= 0){
                check = false;
                request.setAttribute("w_error", "Weight value must be positive!");
            }
        } catch (NumberFormatException e) {
            check = false;
            request.setAttribute("w_error", "Weight value is invalid!");
        }
        
        if (check) {
            double bmi  = w/(h*h);
            if (bmi<18.5) {
                request.setAttribute("result", "Underweight");
            }else if (bmi>=18.5 && bmi<25) {
                request.setAttribute("result", "Normalweight");
            }else if (bmi>=30 && bmi<35) {
                request.setAttribute("result", "Obesity class 1");
            }else if (bmi>=35 && bmi<40) {
                request.setAttribute("result", "Obesity class 2");
            }else{
                request.setAttribute("result", "Unknown");
            } 
        }
        
        request.getRequestDispatcher("BMIcalculator.jsp").forward(request, response);
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
