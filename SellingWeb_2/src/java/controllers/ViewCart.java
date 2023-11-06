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
import java.util.LinkedHashMap;
import java.util.Map;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import models.Cart;
import models.Category;
import models.Product;

/**
 *
 * @author DELL
 */
@WebServlet(name = "ViewCart", urlPatterns = {"/ViewCart"})
public class ViewCart extends HttpServlet {

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
        //1. get Cart List from session
        HttpSession session = request.getSession();
        Map<Integer, Cart> carts = (Map<Integer, Cart>) session.getAttribute("carts");
        if(carts==null){
            carts = new LinkedHashMap<>();
        } 
        //tinh tong tien
        double totalMoney = 0;
        for (Map.Entry<Integer, Cart> entry : carts.entrySet()) { 
            Cart cart = entry.getValue(); 
            totalMoney += cart.getQuantity() * cart.getProduct().getUnitPrice();

        }
        request.setAttribute("totalMoney", totalMoney);
        //3. send it to order con
        request.setAttribute("carts", carts); 
//        String mess;
//        ArrayList<Integer> productIds = getProductsInCart(request, response);
//        ArrayList<Product> products = new ArrayList<>();
//        if (productIds == null || productIds.size()==0) {
//            mess = "Hien khong co san pham nao trong gio hang";
//        }else{
//            mess = "Danh sach san pham trong gio hang:";
//            ProductDAO dao = new ProductDAO();
//            products = dao.getCartProducts(productIds);
//        }
//        
//        request.setAttribute("prolist", products);
//        request.setAttribute("mess", mess);
        loadCategories(request, response);
        request.getRequestDispatcher("viewcart.jsp").forward(request, response);
    }

    private ArrayList<Integer> getProductsInCart(HttpServletRequest request, HttpServletResponse response){
        ArrayList<Integer> products = new ArrayList<>();
        HttpSession session = request.getSession();
        if (session.getAttribute("productids")!=null) {
            products = (ArrayList<Integer>)session.getAttribute("productids");   
        } 
        return products;
    }
    
    private void loadCategories(HttpServletRequest request, HttpServletResponse response){
        CategoryDAO cateDao = new CategoryDAO();
        ArrayList<Category> cateList = cateDao.getAllCategories();
        request.setAttribute("cateList", cateList);
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
