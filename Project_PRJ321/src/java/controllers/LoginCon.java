/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import dao.AccountDAO;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import models.Account;

/**
 *
 * @author DELL
 */
@WebServlet(name = "LoginCon", urlPatterns = {"/Login"})
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
        HttpSession session = request.getSession();
        if (session.getAttribute("Success") != null && session.getAttribute("Success").toString().equals("logged")) { 
            System.out.println("###Login servlet - right pass: "+session.getAttribute("Success").toString());
            response.sendRedirect("./room");
        }else{
            request.getRequestDispatcher("login.jsp").forward(request, response); 
        } 
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
        AccountDAO dao = new AccountDAO();
        
        //kiem tra thong tin nguoi dung dung hay ko? 
        //Neu dung -> tao Session["Success"] = "logged"
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        
        HttpSession session = request.getSession(); 
        System.out.println("###username: "+username);
        System.out.println("###password: "+password); 
        Account a = dao.checkLogin(username, password);
        
        System.out.println("acc: "+a);
        if (a!=null) {
            session.setAttribute("account", new Account(username, password));  
            session.setAttribute("Success", "logged"); 
            
            System.out.println("###Login servlet - right pass: "+session.getAttribute("Success").toString());
            response.sendRedirect("./room");
        }else{
            System.out.println("###Login servlet - wrong pass");
            request.getRequestDispatcher("login.jsp").forward(request, response); 
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
