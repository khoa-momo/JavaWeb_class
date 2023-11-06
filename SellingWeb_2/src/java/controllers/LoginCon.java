/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import dao.CustomerDAO;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import models.Customer;

/**
 *
 * @author DELL
 */
@WebServlet(name = "LoginCon", urlPatterns = {"/LoginCon"})
public class LoginCon extends HttpServlet {

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
        System.out.println("===LoginCon Get Start===");
        CustomerDAO dao = new CustomerDAO();  
        //--------check cookie----------
        Cookie[] cookies = request.getCookies();
        String username = null;
        String password = null;
        for (Cookie cooky : cookies) {
            if (cooky.getName().equals("username")) {
                username = cooky.getValue();
            }
            if (cooky.getName().equals("password")) {
                password = cooky.getValue();
            }
            if (username != null && password != null) {
                break;
            }
        }
//        if (username != null && password != null) {
////            Account account = new AccountDAO().login(username, password);
//            Customer customer = dao.checkLogin(username, password); 
//            if (customer != null) { //cookie hợp lệ
//                request.getSession().setAttribute("customer", customer);
//                response.sendRedirect("./ProductController");
//                return;
//            }
//        }
        if(request.getSession().getAttribute("customer")!=null){
            System.out.println("===Logged===");
            response.sendRedirect("./ProductController"); 
        }else{
            request.getRequestDispatcher("login.jsp").forward(request, response); 
        }
        System.out.println("===LoginCon Get End==="); 
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
        System.out.println("===LoginCon Post Start===");
        CustomerDAO dao = new CustomerDAO();  
        //Check login
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        boolean remember = request.getParameter("remember") != null; 
        Customer customer = dao.checkLogin(username, password);  
        System.out.println("customer: "+customer);
        if (customer != null) {  
            //remember customer
            if (remember) {
                Cookie usernameCookie = new Cookie("username", username);
                usernameCookie.setMaxAge(60 * 60 * 24 * 2);
                Cookie passwordCookie = new Cookie("password", password);
                passwordCookie.setMaxAge(60 * 60 * 24 * 2);
                response.addCookie(usernameCookie);
                response.addCookie(passwordCookie);
            }
            //dont use cookie
            request.getSession().setAttribute("customer", customer);//get account to session
            response.sendRedirect("./ProductController"); 
        } else {//Không hợp lệ -> trả về lỗi
            request.setAttribute("mess", "Username or password incorrect");
            request.getRequestDispatcher("login.jsp").forward(request, response);
        }
        System.out.println("===LoginCon Post End===");
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
