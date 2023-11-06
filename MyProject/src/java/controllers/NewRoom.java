/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import dao.RoomDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.util.ArrayList;
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
@WebServlet(name = "NewRoom", urlPatterns = {"/NewRoom"})
public class NewRoom extends HttpServlet {

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
        RoomDAO rdao = new RoomDAO(); 
        List<Location> provinceList = rdao.getAllProvince();
        List<Location> districtList = rdao.getAllDistrict(); 
        request.setAttribute("provinceList", provinceList);
        request.setAttribute("districtList", districtList);
        request.getRequestDispatcher("newRoom.jsp").forward(request, response); 
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
        
//        if (request.getSession().getAttribute("account")!=null) { 
            RoomDAO rdao = new RoomDAO(); 
            List<Location> provinceList = rdao.getAllProvince();
            List<Location> districtList = rdao.getAllDistrict(); 
            request.setAttribute("provinceList", provinceList);
            request.setAttribute("districtList", districtList);
            System.out.println("----login: "); 
            request.getRequestDispatcher("newRoom.jsp").forward(request, response);
           
//        }else{
//            response.sendRedirect("./Login");
//        } 
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
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        RoomDAO dao = new RoomDAO(); 
        String title = request.getParameter("title");
        String description = request.getParameter("description");
        int area = Integer.parseInt(request.getParameter("area"));
        int cost = Integer.parseInt(request.getParameter("cost"));
//        String status = request.getParameter("status");
//        LocalDate dateCreated = LocalDate.parse(request.getParameter("dateCreated")); 
        String note = request.getParameter("note");
        
        String provinceName = request.getParameter("provinceName");
        String districtName = request.getParameter("districtName");
        String streetName = request.getParameter("streetName");
        String url = request.getParameter("url");
        String urlMap = request.getParameter("urlMap");
            
        Account a = (Account) request.getSession().getAttribute("account");
        String accName = a.getUsername();
        String accid = dao.getAccId(accName);
        
        String status = "1";
        int locationId = dao.InsertLocationReturnKey(provinceName, districtName, streetName);
        
        int roomid = dao.addRoom(title, description, area, cost, status, note, locationId, accid);
        
        dao.addImage(url, roomid);
        
        System.out.println("title: "+title);
        System.out.println("description: "+description);
        System.out.println("area: "+area);
        System.out.println("status: "+status);
        System.out.println("note: "+note);
        System.out.println("locationId: "+locationId);
        System.out.println("accid: "+accid); 
        
        response.sendRedirect("./Home");
//        String title, String description, int area, int cost, String status, 
//            LocalDate dateCreated, String note, String locationId, String roomTypeId, String accountId
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
