/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import dao.RoomDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import models.Location;
import models.Room;

/**
 *
 * @author DELL
 */
@WebServlet(name = "Home", urlPatterns = {"/Home"})
public class Home extends HttpServlet {

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
        List<Location> districtList = new ArrayList(); 
        request.setAttribute("provinceList", provinceList);
         
        
//--------------------------Special filter-----------------------------
        List<Room> lastest = rdao.getRoomLatest();
        request.setAttribute("lastest", lastest);
        
        
//-------------------------------------------------------
        System.out.println("====================Start Home_Filter======================");  
        //------------------------------------------------------
        String province_raw = (String) request.getSession().getAttribute("province"); 
        String district_raw = (String) request.getSession().getAttribute("district");  
        String address = (String) request.getSession().getAttribute("address"); 
        //------------------------------------------------------
        String areaFrom_str = (String) request.getSession().getAttribute("areaFrom"); 
        String areaTo_str = (String) request.getSession().getAttribute("areaTo"); 
        String costFrom_str = (String) request.getSession().getAttribute("costFrom"); 
        String costTo_str = (String) request.getSession().getAttribute("costTo"); 
           
        
        System.out.println("province_raw: "+province_raw);
        System.out.println("district_raw: "+district_raw); 
        
        String province = (province_raw == null || province_raw.equals("")) 
                ? null : (province_raw);
        if(province_raw != null && province_raw.equals("All")){
            province = "";
        }
        
        System.out.println("province: "+province);  
        if (province != null) {
            districtList = rdao.getDistrictByCity(province);
            request.setAttribute("districtList", districtList); 
        }
        System.out.println("districtList: "+districtList);  
        
        String district = (district_raw == null || district_raw.equals("")) 
                ? null : (district_raw);
//        String district = district_raw;
        if(district_raw != null && district_raw.equals("All")){
            district = "";
        }
        
        System.out.println("--inputData--");
        System.out.println("province: "+province);
        System.out.println("district: "+district);
        System.out.println("address: "+address);
//        String province = (province_raw.equals("All")) ? null : (province_raw); 
//        String district = (province_raw.equals("All")) ? null : (district_raw); 
        
        Integer areaFrom = (areaFrom_str == null || areaFrom_str.equals("")) ? null : Integer.parseInt(areaFrom_str);
        Integer areaTo = (areaTo_str == null || areaTo_str.equals("")) ? null : Integer.parseInt(areaTo_str);
        Integer costFrom = (costFrom_str == null || costFrom_str.equals("")) ? null : Integer.parseInt(costFrom_str);
        Integer costTo = (costTo_str == null || costTo_str.equals("")) ? null : Integer.parseInt(costTo_str);
        
       
        System.out.println("areaFrom: "+areaFrom);
        System.out.println("areaTo: "+areaTo); 
        System.out.println("costFrom: "+costFrom); 
        System.out.println("costTo: "+costTo); 
            
//===========================Paging with sql====================================
        final int PAGE_SIZE = 24;
        int page = 1;
        String pageStr = request.getParameter("page");
        if (pageStr != null) {
            page = Integer.parseInt(pageStr);
            if(page<=0){
                page=1;
            }
        }  
        System.out.println("page: "+page); 
        
        List<Room> paginglist = rdao.getRoomSpecial(province, district, address, 
                areaFrom, areaTo, costFrom, costTo, page, PAGE_SIZE);
        int totalProducts = rdao.getCountRoomSpecial(province, district, address, 
                areaFrom, areaTo, costFrom, costTo);
        int totalPage = totalProducts / PAGE_SIZE;
        if (totalProducts % PAGE_SIZE != 0) {
            totalPage += 1;
        }
        request.setAttribute("page", page);
        request.setAttribute("totalPage", totalPage);
        request.setAttribute("rolist", paginglist);

        
        System.out.println("totalProducts: "+totalProducts);
        System.out.println("totalPage: "+totalPage);
        System.out.println("paginglist: "+paginglist);
              
        //session input
//        request.getSession().setAttribute("provinceName", province);
//        request.getSession().setAttribute("districtName", district);
//        request.getSession().setAttribute("address", address);
//        request.getSession().setAttribute("areaFrom", areaFrom);
//        request.getSession().setAttribute("areaTo", areaTo);
//        request.getSession().setAttribute("costFrom", costFrom);
//        request.getSession().setAttribute("costTo", costTo);
        
        System.out.println("====================End Home_Filter======================");  

        request.getRequestDispatcher("home.jsp").forward(request, response); 
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
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");  
        System.out.println("====================Start Home_Filter_GET======================"); 
        //delete session
        System.out.println("check: "+request.getParameter("check"));
        if(request.getParameter("check")!=null&&request.getParameter("check").equals("1")){ 
            request.getSession().removeAttribute("province");
            request.getSession().removeAttribute("district");
            request.getSession().removeAttribute("address");
            request.getSession().removeAttribute("areaFrom");
            request.getSession().removeAttribute("areaTo");
            request.getSession().removeAttribute("costFrom");
            request.getSession().removeAttribute("costTo");
            
//            request.getSession().setAttribute("flag", "true");
        }
        
//        if (request.getParameter("flag")!=null&&request.getParameter("flag").equals("true")) {
//            
//        }
        
        //raw input
        String areaFrom = request.getParameter("areaFrom"); 
        String areaTo = request.getParameter("areaTo"); 
        String costFrom = request.getParameter("costFrom"); 
        String costTo = request.getParameter("costTo"); 
        
        
        //process raw input
//        String areaFrom = (areaFrom_str == null || areaFrom_str.equals("")) ? null : Integer.parseInt(areaFrom_str);
//        String areaTo = (areaTo_str == null || areaTo_str.equals("")) ? null : Integer.parseInt(areaTo_str);
//        String costFrom = (costFrom_str == null || costFrom_str.equals("")) ? null : Integer.parseInt(costFrom_str);
//        String costTo = (costTo_str == null || costTo_str.equals("")) ? null : Integer.parseInt(costTo_str);
        
        System.out.println("areaFrom: "+areaFrom);
        System.out.println("areaTo: "+areaTo); 
        System.out.println("costFrom: "+costFrom); 
        System.out.println("costTo: "+costTo); 
        
        //session input
        request.getSession().setAttribute("areaFrom", areaFrom);
        request.getSession().setAttribute("areaTo", areaTo);
        request.getSession().setAttribute("costFrom", costFrom);
        request.getSession().setAttribute("costTo", costTo);
        System.out.println("====================End Home_Filter_GET======================"); 
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
        response.setCharacterEncoding("UTF-8"); 
        //-------------------------------------------------------
        String flag = (String) request.getSession().getAttribute("flag"); 
        request.getSession().setAttribute("flag", "1");
        System.out.println("====================Start Home_Filter_POST======================");  
        //raw input
        String province_raw = request.getParameter("province"); 
        String district_raw = request.getParameter("district");  
        String address = request.getParameter("address"); 
        
        String areaFrom = request.getParameter("areaFrom"); 
        String areaTo = request.getParameter("areaTo"); 
        String costFrom = request.getParameter("costFrom"); 
        String costTo = request.getParameter("costTo"); 
           
        System.out.println("province_raw: "+province_raw);
        System.out.println("district_raw: "+district_raw); 
        
        
        //process raw input
        String province = (province_raw == null || province_raw.equals("")) 
                ? null : (province_raw);
        if(province_raw != null && province_raw.equals("All")){
            province = "";
        } 
        String district = (district_raw == null || district_raw.equals("")) 
                ? null : (district_raw); 
        if(district_raw != null && district_raw.equals("All")){
            district = "";
        }
        
        System.out.println("--inputData--");
        System.out.println("province: "+province);
        System.out.println("district: "+district);
        System.out.println("address: "+address); 
        
//        String areaFrom = (areaFrom_str == null || areaFrom_str.equals("")) ? null : Integer.parseInt(areaFrom_str);
//        String areaTo = (areaTo_str == null || areaTo_str.equals("")) ? null : Integer.parseInt(areaTo_str);
//        String costFrom = (costFrom_str == null || costFrom_str.equals("")) ? null : Integer.parseInt(costFrom_str);
//        String costTo = (costTo_str == null || costTo_str.equals("")) ? null : Integer.parseInt(costTo_str);
         
        System.out.println("areaFrom: "+areaFrom);
        System.out.println("areaTo: "+areaTo); 
        System.out.println("costFrom: "+costFrom); 
        System.out.println("costTo: "+costTo); 
        
        //session input
        request.getSession().setAttribute("province", province);
        request.getSession().setAttribute("district", district);
        request.getSession().setAttribute("address", address);
        request.getSession().setAttribute("areaFrom", areaFrom);
        request.getSession().setAttribute("areaTo", areaTo);
        request.getSession().setAttribute("costFrom", costFrom);
        request.getSession().setAttribute("costTo", costTo);
        
        System.out.println("====================End Home_Filter_POST======================");        
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
