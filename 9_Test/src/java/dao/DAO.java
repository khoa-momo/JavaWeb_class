/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import models.Account;
import models.Comment;
import models.Entry;

/**
 *
 * @author DELL
 */
public class DAO extends DBContext{
    public ArrayList<Entry> getAllEntry(){
        ArrayList<Entry> list = new ArrayList<>();
        try{
            String sql = "Select * From Entries";
            PreparedStatement ps = connection.prepareStatement(sql);  
            ResultSet rs = ps.executeQuery();
            while (rs.next()){
                Entry e = new Entry(
                    rs.getInt("EntryID"), 
                    rs.getString("Title")); 
                list.add(e);
            }
        }
        catch(SQLException ex){
            Logger.getLogger(DBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    } 
    
    public ArrayList<Entry> getEntryDetail(int eid){
        ArrayList<Entry> list = new ArrayList<>();
        try{
            String sql = "Select * From Entries\n" +
                        "Where EntryID = ?";
            PreparedStatement ps = connection.prepareStatement(sql);  
            ps.setInt(1, eid); //setInt
            ResultSet rs = ps.executeQuery();
            while (rs.next()){
                List<Comment> listC = getAllCommentById(rs.getInt("EntryID"));
                Entry e = new Entry(
                    rs.getInt("EntryID"), 
                    rs.getString("Title"),
                    rs.getString("EntryContent"),
                    rs.getDate("DateModified"), 
                    listC); 
                list.add(e);
            }
        }
        catch(SQLException ex){
            Logger.getLogger(DBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }     
    
    public ArrayList<Comment> getAllCommentById(int eid){
        ArrayList<Comment> list = new ArrayList<>();
        try{
            String sql = "Select * From Comments c\n" +
                        "Where c.EntryID = ?" ;
            PreparedStatement ps = connection.prepareStatement(sql); 
            ps.setInt(1, eid); //setInt
            ResultSet rs = ps.executeQuery();
            while (rs.next()){
                Comment c = new Comment(
                    rs.getInt("CommentID"), 
                    rs.getString("CommentContent")); 
                list.add(c);
            }
        }
        catch(Exception ex){
            Logger.getLogger(DBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }
    
    //DELETE
    public void delete(int cID){
        try{
            String sql = "Delete From Comments \n" +
                        "Where CommentID = ?";
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setInt(1, cID); 
            stm.executeUpdate();
        }
        catch(SQLException ex){
            Logger.getLogger(DBContext.class.getName()).log(Level.SEVERE, null, ex);
        }   
    }
    
    //check account loginDAO
    public Account checkLogin(String username, String password){ 
            String sql = "Select * From Account \n" +
                    "Where username = ? and password = ?";
        try{ 
            PreparedStatement ps = connection.prepareStatement(sql);  
            ps.setString(1, username); 
            ps.setString(2, password); 
            ResultSet rs = ps.executeQuery();
            while (rs.next()){ 
                return new Account(rs.getString(1),
                        rs.getString(2));
            }
        } catch (Exception ex) {
            Logger.getLogger(DAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }    
}
