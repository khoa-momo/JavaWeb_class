/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import models.Category;

/**
 *
 * @author DELL
 */
public class CategoryDAO extends DBContext{
    public ArrayList<Category> getAllCategories(){
        ArrayList<Category> list = new ArrayList<>();
        try{
            String sql = "Select *\n" +
                        "From Categories";
            PreparedStatement ps = connection.prepareStatement(sql);  
            ResultSet rs = ps.executeQuery();
            while (rs.next()){
                Category c = new Category(
                    rs.getInt("CategoryId"),  
                    rs.getString("CategoryName"),
                    rs.getString("Description"));
                list.add(c);
            }
        }
        catch(SQLException ex){
            Logger.getLogger(DBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }    
}
