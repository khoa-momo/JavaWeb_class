/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import dao.CategoryDAO;
import dao.ProductDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import models.Category;
import models.Product;

/**
 *
 * @author DELL
 */
@WebServlet(name = "ProductController", urlPatterns = {"/ProductController"})
public class ProductController extends HttpServlet {

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
        loadCategories(request, response);
        loadProducts(request, response);
        request.getRequestDispatcher("HomeProduct.jsp").forward(request, response);
    }
    
    private void loadCategories(HttpServletRequest request, HttpServletResponse response){
        CategoryDAO cateDao = new CategoryDAO();
        ArrayList<Category> cateList = cateDao.getAllCategories();
        request.setAttribute("cateList", cateList);
    }
    private void loadProducts(HttpServletRequest request, HttpServletResponse response){
        int cateId;
        ProductDAO proDao = new ProductDAO();
        ArrayList<Product> prolist;
        if (request.getParameter("cid")!=null) { 
            cateId = Integer.parseInt(request.getParameter("cid"));    
            prolist = proDao.getAllProductsByCate(cateId);
            request.setAttribute("cateId", cateId);
        }else{
            prolist = proDao.getAllProducts();
        }
        request.setAttribute("prolist", prolist);
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
