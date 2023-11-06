/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author DELL
 */
public class Calculator_test extends HttpServlet {

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
        RequestDispatcher dispatcher = request.getRequestDispatcher("calculator.jsp");
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
        request.setAttribute("result", "");
        request.setAttribute("first", "");
        request.setAttribute("second", "");
        request.setAttribute("operator", "");
        request.setAttribute("finalResult", "");
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
        String first = request.getParameter("first");
        String second = request.getParameter("second");
        String operator = request.getParameter("operator");
        float n1 = 0;
        float n2 = 0;
        float result = 0; 
        boolean check = true; 
        try {
            n1 = Float.parseFloat(first);
        } catch (NumberFormatException e) {
            request.setAttribute("first_error", "First number is null or invalid");
            check = false;
        }
        try {
            n2 = Float.parseFloat(second);
        } catch (NumberFormatException e) {
            request.setAttribute("second_error", "Second number is null or invalid");
            check = false;
        }      
        if(check){
            switch(operator){
                case "+":
                    result = n1+n2; 
                    break;
                case "-":
                    result = n1-n2; 
                    break;
                case "*":
                    result = n1*n2; 
                    break; 
            } 
        }
        if (check) {
        String finalResult ="Output: "+first+" "+operator+" "+second+" = "+result;
//        request.setAttribute("first", first);
//        request.setAttribute("second", second);
//        request.setAttribute("operator", operator);
//        request.setAttribute("result", result);             
        request.setAttribute("finalResult", finalResult);             
        }
            

        processRequest(request, response);       
    }
//        processRequest(request, response);
    

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
