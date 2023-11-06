/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import com.context.DBContext;
import entity.Category;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Tuan Anh
 */
public class Process {
    public List<String> getBlogName(){
        Connection conn;
        PreparedStatement pstmt;
        ResultSet rs;
        
        DBContext dbContext = new DBContext();
        List<String> list = new ArrayList<>();
        list.add("All");
        try {
            conn = dbContext.getConnection();
            String select = "Select * From Blogs";
            pstmt = conn.prepareStatement(select);
            
            rs = pstmt.executeQuery();
            while(rs.next()){
                list.add(rs.getString("BlogName"));
            }
            
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Process.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(Process.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }
    
    public List<Category> getCategoryByBlogName(String blogName) throws ClassNotFoundException, SQLException{
        List<Category> list = new ArrayList<>();
        
        Connection conn;
        PreparedStatement pstmt;
        ResultSet rs;
        DBContext dbContext = new DBContext();
        
        conn = dbContext.getConnection();
        String select;
        if(blogName.trim().equalsIgnoreCase("All")){
            select = "Select * From Categories";
            pstmt = conn.prepareStatement(select);
            rs = pstmt.executeQuery();
            while(rs.next()){
                SimpleDateFormat fm = new SimpleDateFormat("yyyy-mm-dd");
                int categoryID = rs.getInt("CategoryID");
                int blogID = rs.getInt("BlogID");
                String categoryName = rs.getString("CategoryName");
                String date = fm.format(rs.getDate("DateCreated"));
                boolean activated = rs.getBoolean("Activated");
                
                list.add(new Category(categoryID, blogID, categoryName, date, activated));
            }
        }else{
            select = "Select Categories.CategoryID, Categories.BlogID, Categories.CategoryName, Categories.DateCreated, Categories.Activated \n"
                    +"From Categories, Blogs \n"
                    +"Where Categories.BlogID = Blogs.BlogID and BlogName = ?";
            pstmt = conn.prepareStatement(select);
            pstmt.setString(1, blogName);
            rs = pstmt.executeQuery();
            while(rs.next()){
                SimpleDateFormat fm = new SimpleDateFormat("yyyy-mm-dd");
                int categoryID = rs.getInt("CategoryID");
                int blogID = rs.getInt("BlogID");
                String categoryName = rs.getString("CategoryName");
                String date = fm.format(rs.getDate("DateCreated"));
                boolean activated = rs.getBoolean("Activated");
                
                list.add(new Category(categoryID, blogID, categoryName, date, activated));
            }
        }
        
        return list;
    }
}
