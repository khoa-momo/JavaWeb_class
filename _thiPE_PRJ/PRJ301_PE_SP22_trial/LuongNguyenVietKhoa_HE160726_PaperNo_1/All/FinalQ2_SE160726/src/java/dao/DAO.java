/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao; 
import context.DBContext;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import models.Message;
import models.User;

/**
 *
 * @author DELL
 */
public class DAO {
    public ArrayList<Message> getMessbyId(String user) {
        ArrayList<Message> list = new ArrayList<>();
        try {
            String sql = "select * from MessageTBL\n"
                        + "Where [to] = ?";
            Connection conn = new DBContext().getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, user);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){ 
                Message m = new Message( 
                    rs.getInt(1),
                    rs.getString(2),
                    rs.getString(3),
                    rs.getString(4),
                    rs.getString(5),
                    rs.getString(6), 
                    rs.getInt(7));
                list.add(m);
            }
        } catch (Exception ex) {
            Logger.getLogger(DAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }
    
    public ArrayList<Message> getMessbyMId(int messId) {
        ArrayList<Message> list = new ArrayList<>();
        try {
            String sql = "Select * From MessageTBL\n" +
                        "Where messageid = ?";
            Connection conn = new DBContext().getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, messId);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){ 
                Message m = new Message( 
                    rs.getInt(1),
                    rs.getString(2),
                    rs.getString(3),
                    rs.getString(4),
                    rs.getString(5),
                    rs.getString(6), 
                    rs.getInt(7));
                list.add(m);
            }
        } catch (Exception ex) {
            Logger.getLogger(DAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }
     
    public void updateIsRead(int messID){
        try{
            String sql = "UPDATE MessageTBL\n" +
                        "SET isread = 1 \n" +
                        "WHERE messageid = ?";
            Connection conn = new DBContext().getConnection();
            PreparedStatement stm = conn.prepareStatement(sql);
            stm.setInt(1, messID); 
            stm.executeUpdate();
        }
        catch(Exception ex){
            Logger.getLogger(DAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
    //check account login
    public User checkLogin(String username, String password){ 
            String sql = "Select * From UserTBL \n" +
                    "Where userid = ? and password = ?";
        try{
            Connection connection = new DBContext().getConnection();
            PreparedStatement ps = connection.prepareStatement(sql);  
            ps.setString(1, username); 
            ps.setString(2, password); 
            ResultSet rs = ps.executeQuery();
            while (rs.next()){ 
                return new User(rs.getString(1),
                        rs.getString(2));
            }
        } catch (Exception ex) {
            Logger.getLogger(DAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }    
    
    public ArrayList<User> getUser(String username){ 
        String usernameStr = "('"+username+"')";
        ArrayList<User> list = new ArrayList<>();
        String sql = "Select * From UserTBL \n" +
                    "Where userid not in "+usernameStr;
        try{
            Connection connection = new DBContext().getConnection();
            PreparedStatement ps = connection.prepareStatement(sql);   
            ResultSet rs = ps.executeQuery();
            while (rs.next()){ 
                User u = new User(  
                    rs.getString("userid"),
                    rs.getString("password"));
                list.add(u); 
            }
        } catch (Exception ex) {
            Logger.getLogger(DAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }  
    
    //insert
     public void insertmess(String title, String from, String to, String content){
        try{
            String sql = "insert into MessageTBL (messagetitle, messagetime, [from], [to], messagecontent, isread) \n" +
                        "values (?, GETDATE(), ?, ?, ?, 0)";
            Connection connection = new DBContext().getConnection();
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setString(1, title);
            stm.setString(2, from);
            stm.setString(3, to);
            stm.setString(4, content); 
            stm.executeUpdate();
        }
        catch(Exception ex){
            Logger.getLogger(DAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
} 