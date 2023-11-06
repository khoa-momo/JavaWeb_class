/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MyServlet;

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
public class Calculator extends HttpServlet {

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
//        request.getRequestDispatcher("calculator.jsp").forward(request, response);
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
//        processRequest(request, response);
        
        String first = request.getParameter("first");
        String second = request.getParameter("second");
        String operator = request.getParameter("operator");
        
        request.setAttribute("first", first);
        request.setAttribute("second", second);
        request.setAttribute("operator", operator);
        
        double x = 0;
        double y = 0;
        boolean check = true;
        try {
            x = Double.parseDouble(first);
        } catch (NumberFormatException e) {
            request.setAttribute("first_error", "First number is invalid");
        }
        try {
            x = Double.parseDouble(second);
        } catch (NumberFormatException e) {
            request.setAttribute("second_error", "Second number is invalid");
        }       
        if(check){
            switch(operator){
                case "+":
                    request.setAttribute("result", x + y);
                    break;
                case "-":
                    request.setAttribute("result", x - y);
                    break;
                case "*":
                    request.setAttribute("result", x * y);
                    break;
                case "/":
                    if(y!=0){
                        request.setAttribute("result", x / y);
                    }else{
                        request.setAttribute("second error", "Division by 0");
                    }
                    break;
            }
        }
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
