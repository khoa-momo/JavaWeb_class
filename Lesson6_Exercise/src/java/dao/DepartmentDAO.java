/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;  

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import models.Department; 

/**
 *
 * @author DELL
 */ 
public class DepartmentDAO { 
    public List<Department> getAllDepartmentss() {
        List<Department> list = new ArrayList<>();
        try {
            String sql = "Select *\n" +
                         "From Departments\n";
            Connection conn = new DBContext().getConnection(); 
            PreparedStatement ps = conn.prepareStatement(sql); 
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Department department = Department.builder()
                        .did(rs.getInt("did"))
                        .dname(rs.getString("dname")).build();  
                list.add(department);
            }
        } catch (Exception ex) {
            Logger.getLogger(StudentDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }
}
