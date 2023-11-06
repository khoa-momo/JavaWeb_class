/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dal.DAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Skill;
import model.Student;

/**
 *
 * @author DELL
 */
public class add extends HttpServlet {

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
        DAO dao = new DAO(); 
        
        if (request.getSession().getAttribute("username")!=null) {
            ArrayList<Skill> sList = dao.getAllSkill();
            request.setAttribute("sList", sList); 
        }else{
            String mess = "Access denied!";
            request.setAttribute("mess", mess);  
        } 
        
        request.getRequestDispatcher("add.jsp").forward(request, response);  
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
        DAO dao = new DAO(); 
        String id = request.getParameter("id");
        String name = request.getParameter("name");
        LocalDate dob = LocalDate.parse(request.getParameter("date")); 
        int gender = Integer.parseInt(request.getParameter("gender"));
         
        String created = (String) request.getSession().getAttribute("username");
        System.out.println("id "+id);
        System.out.println("name "+name);
        System.out.println("dob "+dob);
        System.out.println("gender "+gender);
        System.out.println("created "+created);
        dao.addStudent(id, name, dob, gender, created);
        
        String[] skills = request.getParameterValues("skill"); 
        String[] degree = request.getParameterValues("degree");
//        String[] insertDegre = String[skills.length];
        ArrayList<String> insertDegre = new ArrayList();
        for (int i = 0; i < degree.length; i++) {
            if(!degree[i].isEmpty()){
                insertDegre.add(degree[i]);
            }
        }
        
        for (int i = 0; i < skills.length; i++) {
            dao.addCharacterSkill(skills[i], id, insertDegre.get(i));
            System.out.println("skill-degree"+skills[i]+"--"+insertDegre.get(i));
        }
        
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
