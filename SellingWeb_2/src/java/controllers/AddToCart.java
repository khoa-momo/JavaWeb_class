/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import dao.ProductDAO;
import java.io.IOException; 
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
import models.Product;

/**
 *
 * @author DELL
 */
@WebServlet(name = "AddToCart", urlPatterns = {"/AddToCart"})
public class AddToCart extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");   
        
        int productId = Integer.parseInt(request.getParameter("pid"));
        //map productId | cart
        HttpSession session = request.getSession();
        Map<Integer, Cart> carts = (Map<Integer, Cart>) session.getAttribute("carts");
        //session empty
        if (carts == null) {
            carts = new LinkedHashMap<>();
        }
        //cart already in session --> update quantity
        if (carts.containsKey(productId)) {
            int oldQuantity = carts.get(productId).getQuantity(); 
            carts.get(productId).setQuantity(oldQuantity + 1);
        } else {
            //cart empty
            Product product = new ProductDAO().getProductById(productId);
            Cart cart = new Cart(product, 1);
            carts.put(productId, cart);
//            carts.put(productId, Cart.builder().product(product).quantity(1).build()); //loombok
        }
        //save carts to session
        session.setAttribute("carts", carts); 
 
        int cid = Integer.parseInt(request.getParameter("cid"));
        response.sendRedirect("ProductController?cid="+cid);//go back
        
        System.out.println("--AddtoCart-EndGet--"); 
    }

    //scrap
    private ArrayList<Integer> getProductsInCart(HttpServletRequest request, HttpServletResponse response){
        ArrayList<Integer> products = new ArrayList<>();
        HttpSession session = request.getSession();
        if(session.getAttribute("productids")!=null) {//
            products = (ArrayList<Integer>)session.getAttribute("productids");   
        } 
        return products;
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
