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

import models.Blog;
import models.Category;
import models.Comment;
import models.Entry;

/**
 *
 * @author DELL
 */
public class BlogDAO extends DBContext{ 
    
    public ArrayList<Blog> getAllBlogs(){
        ArrayList<Blog> list = new ArrayList<>();
        try{
            String sql = "Select * From Blogs";
            PreparedStatement ps = connection.prepareStatement(sql);  
            ResultSet rs = ps.executeQuery();
            while (rs.next()){
                Blog b = new Blog(
                    rs.getInt("blogId"), 
                    rs.getString("blogName"),  
                    rs.getString("BlogDescription"),  
                    rs.getString("DateCreated")); 
                list.add(b);
            }
        }
        catch(SQLException ex){
            Logger.getLogger(DBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }    
    
    public ArrayList<Category> getAllBlogsByCategory(int blogId){
        ArrayList<Category> list = new ArrayList<>();
        try{
            String sql = "Select * From Categories \n"
                    + "Where BlogID = ?";
            PreparedStatement ps = connection.prepareStatement(sql); 
            ps.setInt(1, blogId);  
            ResultSet rs = ps.executeQuery();
            while (rs.next()){
                Category c = new Category(
                    rs.getInt("categoryId"), 
                    rs.getInt("blogId"), 
                    rs.getString("categoryName"),  
                    rs.getString("dateCreated"),  
                    rs.getString("dateModified")); 
                list.add(c);
            }
        }
        catch(SQLException ex){
            Logger.getLogger(DBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    } 
    
    public ArrayList<Entry> getAllEntriesByCategory(int cateId){
        ArrayList<Entry> list = new ArrayList<>();
        try{
            String sql = "Select * From Entries \n" +
                        "Where CategoryID = ?";
            PreparedStatement ps = connection.prepareStatement(sql);  
            ps.setInt(1, cateId);
            ResultSet rs = ps.executeQuery();
            while (rs.next()){
                Entry c = new Entry(
                    rs.getInt("entryId"), 
                    rs.getInt("blogId"), 
                    rs.getInt("categoryId"), 
                    rs.getString("title"),  
                    rs.getString("entryContent"),  
                    rs.getString("dateCreated"),  
                    rs.getString("dateModified")); 
                list.add(c);
            } 
        }
        catch(SQLException ex){
            Logger.getLogger(DBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }
    
    public Entry getEntryByiD(int eId){ 
        try{
            String sql = "Select * From Entries \n" +
                        "Where entryId = ?";
            PreparedStatement ps = connection.prepareStatement(sql);  
            ps.setInt(1, eId);
            ResultSet rs = ps.executeQuery();
            while (rs.next()){
                Entry e = new Entry(
                    rs.getInt("entryId"), 
                    rs.getInt("blogId"), 
                    rs.getInt("categoryId"), 
                    rs.getString("title"),  
                    rs.getString("entryContent"),  
                    rs.getString("dateCreated"),  
                    rs.getString("dateModified")); 
                return e;
            } 
        }
        catch(SQLException ex){
            Logger.getLogger(DBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
     
    public ArrayList<Comment> getCommentByEntry(int eId){
        ArrayList<Comment> list = new ArrayList<>();
        try{
            String sql = "Select * From Comments\n" +
                        "Where EntryID = ?";
            PreparedStatement ps = connection.prepareStatement(sql);  
            ps.setInt(1, eId);
            ResultSet rs = ps.executeQuery();
            while (rs.next()){
                Comment c = new Comment(
                    rs.getInt("commentId"), 
                    rs.getInt("entryId"), 
                    rs.getInt("authorID"), 
                    rs.getString("commentContent"),   
                    rs.getString("dateCreated"),  
                    rs.getString("dateModified")); 
                list.add(c);
            } 
        }
        catch(SQLException ex){
            Logger.getLogger(DBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }
}
 
