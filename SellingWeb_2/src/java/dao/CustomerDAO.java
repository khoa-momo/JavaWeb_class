/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import models.Customer;

/**
 *
 * @author DELL
 */
public class CustomerDAO extends DBContext{
    public Customer checkLogin(String username, String password){ 
            String sql = "Select c.customerID, c.username, c.[password]\n" +
                        "From Customers c\n" +
                        "Where c.username = ? and c.[password] = ?";
        try{
            PreparedStatement ps = connection.prepareStatement(sql);  
            ps.setString(1, username); 
            ps.setString(2, password); 
            ResultSet rs = ps.executeQuery();
            while (rs.next()){ 
                return new Customer(
                    rs.getString("customerID"),
                    rs.getString("username"),
                    rs.getString("password"));
            }
        }
        catch(SQLException ex){
            Logger.getLogger(DBContext.class.getName()).log(Level.SEVERE, null, ex);
        } 
        return null;
    }    
}
