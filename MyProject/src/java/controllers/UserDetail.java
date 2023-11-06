/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import dao.AccountDAO;
import dao.RoomDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import models.Account;
import models.Location;

/**
 *
 * @author DELL
 */
@WebServlet(name = "UserDetail", urlPatterns = {"/UserDetail"})
public class UserDetail extends HttpServlet {

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
        request.getRequestDispatcher("userDetail.jsp").forward(request, response); 
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
            AccountDAO adao = new AccountDAO(); 
            RoomDAO dao = new RoomDAO(); 
            Account acc = (Account) request.getSession().getAttribute("account");
            String accName = acc.getUsername(); 
            System.out.println("accName "+accName);
            Account a = adao.getAccountByID(accName);

            
            request.setAttribute("a", a);
            System.out.println("a: "+a);

            

            System.out.println("----login: "); 
            request.getRequestDispatcher("userDetail.jsp").forward(request, response);
             
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
        AccountDAO adao = new AccountDAO(); 
        RoomDAO dao = new RoomDAO(); 
        Account acc = (Account) request.getSession().getAttribute("account");
        String accName = acc.getUsername(); 
        System.out.println("accName "+accName);
        Account a = adao.getAccountByID(accName);

        String userName = request.getParameter("userName");
        String passWord = request.getParameter("passWord");
        String fullName = request.getParameter("fullName");
        String email = request.getParameter("email");
        String gender = request.getParameter("gender");
        String phone = request.getParameter("phone");

        int accid = Integer.parseInt(dao.getAccId(accName));
        adao.update(accid, userName, passWord, fullName, email, gender, phone);
        request.setAttribute("a", a);
        System.out.println("a: "+a); 
        
        request.getSession().removeAttribute("account");
        Account updatedAccount = new Account(userName,passWord);
        request.getSession().setAttribute("account", updatedAccount);
        response.sendRedirect("./Home");
            
//        processRequest(request, response);
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
