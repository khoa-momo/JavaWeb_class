/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dal;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import models.Account;

/**
 *
 * @author DELL
 */
public class AccountDAO extends DBContext{
    
    public Account checkLogin(String username, String password){ 
            String sql = "Select * From Account\n" +
                        " Where username = ? and password = ?";
        try{
            PreparedStatement ps = connection.prepareStatement(sql);  
            ps.setString(1, username); 
            ps.setString(2, password); 
            ResultSet rs = ps.executeQuery();
            while (rs.next()){
//                Account s = new Account(
//                    rs.getInt(1), 
//                    rs.getString(2),  
//                    rs.getString(3));
                return new Account(rs.getString(1),
                        rs.getString(2));
            }
        }
        catch(SQLException ex){
            Logger.getLogger(DBContext.class.getName()).log(Level.SEVERE, null, ex);
        } 
        return null;
    }    
    
    
    public ArrayList<Account> getAllAccounts(){
        ArrayList<Account> list = new ArrayList<>();
        try{
            String sql = " Select * From Account";
            PreparedStatement ps = connection.prepareStatement(sql);  
            ResultSet rs = ps.executeQuery();
            while (rs.next()){
                Account a = new Account(
                    rs.getString(1), 
                    rs.getString(2));
                list.add(a);
            }
        }
        catch(SQLException ex){
            Logger.getLogger(DBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }    
}
