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
                return new Account(rs.getString("username"),
                        rs.getString("password"));
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
            String sql = "Select * From Account";
            PreparedStatement ps = connection.prepareStatement(sql);  
            
            ResultSet rs = ps.executeQuery();
            while (rs.next()){
                Account a = new Account(
                    rs.getInt("accountId"), 
                    rs.getString("username"), 
                    rs.getString("password"),
                    rs.getString("fullname"),
                    rs.getString("email"),
                    rs.getString("gender"),
                    rs.getString("phone"),
                    rs.getString("accountRole")
                    );
                list.add(a);
            }
        }
        catch(SQLException ex){
            Logger.getLogger(DBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }    
    
    public Account getAccountByID(String username){ 
        try{
            String sql = "Select * From Account a \n"
                    + "Where a.username = ?";
            PreparedStatement ps = connection.prepareStatement(sql);  
            ps.setString(1, username); 
            ResultSet rs = ps.executeQuery();
            while (rs.next()){
                Account a = new Account(
                    rs.getInt("accountId"), 
                    rs.getString("username"), 
                    rs.getString("password"),
                    rs.getString("fullname"),
                    rs.getString("email"),
                    rs.getString("gender"),
                    rs.getString("phone"),
                    rs.getString("accountRole")
                    );
                return a;
            }
        }
        catch(SQLException ex){
            Logger.getLogger(DBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }     
    
    public void insertAccount(String userName, String passWord, String fullName, String email, String gender, String phone){
        try{
            String sql = "insert into Account (userName, passWord, fullName, email, gender, phone, accountRole) "
                    + "values (?, ?, ?, ?, ?, ?, user)";
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setString(1, userName);
            stm.setString(2, passWord);
            stm.setString(3, fullName);
            stm.setString(4, email); 
            stm.setString(5, gender); 
            stm.setString(6, phone); 
            stm.executeUpdate();
        }
        catch(SQLException ex){
            Logger.getLogger(DBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void update(int accountId, String userName, String passWord, String fullName, String email, String gender, String phone){
        try{
            String sql = "UPDATE Account\n" +
                        "SET userName=?, passWord=?, fullName=?, email=?, gender=?,  phone=?\n" +
                        "WHERE accountId=?";
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setString(1, userName);
            stm.setString(2, passWord);
            stm.setString(3, fullName);
            stm.setString(4, email); 
            stm.setString(5, gender); 
            stm.setString(6, phone); 
            stm.setInt(7, accountId); 
            stm.executeUpdate();
        }
        catch(SQLException ex){
            Logger.getLogger(DBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
