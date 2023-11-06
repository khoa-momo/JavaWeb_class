/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import dao.OrderDAO;
import dao.OrderDetailDAO;
import dao.ShipperDAO; 
import java.io.IOException; 
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import logic.OrderLogic;
import models.Cart;
import models.Customer;
import models.Order;
import models.OrderDetail;
import models.Shipper;

/**
 *
 * @author Dell
 */
@WebServlet(name = "CheckoutController", urlPatterns = {"/CheckoutController"})
public class CheckoutController extends HttpServlet {

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
        System.out.println("---------Checkout_GetStart---------");
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8"); 
        
        //user da login
        if(request.getSession().getAttribute("customer")!=null){
            //1.Get cart list from session -> add to order 
            HttpSession session = request.getSession();
            Map<Integer, Cart> carts = (Map<Integer, Cart>) session.getAttribute("carts");
            if (carts == null) {
                carts = new LinkedHashMap<>();
            }
            //Calculate money
//            double totalMoney = 0;
//            for (Map.Entry<Integer, Cart> entry : carts.entrySet()) {
//                Cart cart = entry.getValue();
//                totalMoney += cart.getQuantity() * cart.getProduct().getUnitPrice();
//            }
//            request.setAttribute("totalMoney", totalMoney);
            //Shipper List
            ShipperDAO shipperDAO = new ShipperDAO();
            ArrayList<Shipper> shipperList = shipperDAO.getAllShippers();
            request.setAttribute("shipperList", shipperList);

            System.out.println("---------Checkout_GetEnd---------");
            request.getRequestDispatcher("order.jsp").forward(request, response);
        }else{
            response.sendRedirect("./LoginCon");
        }
         
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
        request.setCharacterEncoding("UTF-8"); 
        System.out.println("---------Checkout_PostStart---------");
        //Lay thong tin order
        LocalDate RequiredDate = LocalDate.parse(request.getParameter("RequiredDate"));
        Shipper shipperID = new Shipper(Integer.parseInt(request.getParameter("ShipperId")));
        String shipName = request.getParameter("shipName");
        String shipAddress = request.getParameter("shipAddress");
        //------------------------------------------------------------------//
        Order order = new Order(RequiredDate,shipperID,shipName,shipAddress);
        System.out.println("##shipName: "+shipName); 
        
        //cart
        HttpSession session = request.getSession();
        Map<Integer, Cart> carts = (Map<Integer, Cart>) session.getAttribute("carts");
        if (carts == null) {
            carts = new LinkedHashMap<>();
        }
        
        Customer customer = (Customer) request.getSession().getAttribute("customer");
        System.out.println("##customer: "+customer);
        String customerID = customer.getCustomerID();
        
        //lưu vào database od
        OrderDAO orderDAO = new OrderDAO();
        OrderDetailDAO orderDetailDAO = new OrderDetailDAO(); 
        
        int orderid = orderDAO.InsertOrderReturnKey(order, customerID);//return auto key orderID for order
        System.out.println("------------------orderid: "+orderid);
        System.out.println("------------------c:art "+carts.toString());
        orderDetailDAO.saveCartOD(orderid, carts);
         
        //xoa cart
        session.removeAttribute("carts");
        System.out.println("---------Checkout_PostEnd---------");
//        request.setAttribute("mess", "Order Successfully!");
        response.sendRedirect("./end"); 
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
