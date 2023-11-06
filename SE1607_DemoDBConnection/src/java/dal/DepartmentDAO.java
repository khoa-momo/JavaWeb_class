/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dal;
import models.Department;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

import java.util.ArrayList; 
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author lephu
 */
public class DepartmentDAO extends DBContext{  
    public ArrayList<Department> getAllDepartments(){
        ArrayList<Department> list = new ArrayList<>();
        try{
            String sql = "Select id, name from Department";
            PreparedStatement stm = connection.prepareStatement(sql);
            ResultSet rs = stm.executeQuery();
            while(rs.next()){
                Department d = new Department(
                    rs.getInt("id"), 
                    rs.getString("name"));
                list.add(d);
            }
        }catch(Exception ex){
            Logger.getLogger(DBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }
}
