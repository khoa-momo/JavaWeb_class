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
import models.Product; 

/**
 *
 * @author DELL
 */
public class ProductDAO extends DBContext{
    public ArrayList<Product> getAllProducts(){
        ArrayList<Product> list = new ArrayList<>();
        try{
            String sql = "Select p.*, c.CategoryName, c.Description\n" +
                        "From Products p join Categories c\n" +
                        "On p.CategoryID = c.CategoryID";
            PreparedStatement ps = connection.prepareStatement(sql);  
            ResultSet rs = ps.executeQuery();
            while (rs.next()){
                Category cat = new Category(
                    rs.getInt("CategoryId"), 
                    rs.getString("CategoryName"), 
                    rs.getString("Description"));
                Product p = new Product(
                    rs.getInt("ProductId"), 
                    rs.getString("ProductName"), 
                    cat, 
                    rs.getDouble("UnitsInStock"),
                    rs.getInt("UnitsInStock")); 
                list.add(p);
            }
        }
        catch(SQLException ex){
            Logger.getLogger(DBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }

    public ArrayList<Product> getAllProductsByCate(int cateId){
        ArrayList<Product> list = new ArrayList<>();
        try{
            String sql = "Select p.*, c.CategoryName, c.Description\n" +
                        "From Products p join Categories c\n" +
                        "On p.CategoryID = c.CategoryID\n" +
                        "Where c.CategoryID = ?";
            PreparedStatement ps = connection.prepareStatement(sql);  
            ps.setInt(1, cateId);
            ResultSet rs = ps.executeQuery();
            while (rs.next()){
                Category cat = new Category(
                    rs.getInt("CategoryId"), 
                    rs.getString("CategoryName"), 
                    rs.getString("Description"));
                Product p = new Product(
                    rs.getInt("ProductId"), 
                    rs.getString("ProductName"), 
                    cat, 
                    rs.getDouble("UnitsInStock"),
                    rs.getInt("UnitsInStock")); 
                list.add(p);
            }
        }   
        catch(SQLException ex){
            Logger.getLogger(DBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }
    
    public Product getProductById(int pid){
        try {
            String sql = "Select p.*, c.CategoryName, c.Description\n" +
                        "From Products p join Categories c\n" +
                        "On p.CategoryID = c.CategoryID " +
                        "Where p.ProductId = ?" ;
            PreparedStatement ps = connection.prepareStatement(sql); 
            ps.setInt(1, pid); 
            ResultSet rs = ps.executeQuery();
            
            while (rs.next()) {
                Category cat = new Category(
                    rs.getInt("CategoryId"), 
                    rs.getString("CategoryName"), 
                    rs.getString("Description"));
                Product p = new Product(
                    rs.getInt("ProductId"), 
                    rs.getString("ProductName"), 
                    cat, 
                    rs.getDouble("UnitsInStock"),
                    rs.getInt("UnitsInStock"));  
                return p;
            }
        } catch (SQLException ex) {
            Logger.getLogger(DBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    public ArrayList<Product> getCartProducts(ArrayList<Integer> productIds){
        String productStr = productIds.toString();
        productStr = '(' + productStr.substring(1);
        productStr = productStr.substring(0, productStr.length()-1) + ')';
        ArrayList<Product> list = new ArrayList<>();
        try{
            String sql = "Select p.*, c.CategoryName, c.Description\n" +
                        "From Products p join Categories c\n" +
                        "On p.CategoryID = c.CategoryID\n" +
                        "and p.ProductId in "+productStr;
            PreparedStatement ps = connection.prepareStatement(sql);  
//            ps.setString(1, productStr);
            ResultSet rs = ps.executeQuery();
            while (rs.next()){
                Category cat = new Category(
                    rs.getInt("CategoryId"), 
                    rs.getString("CategoryName"), 
                    rs.getString("Description"));
                Product p = new Product(
                    rs.getInt("ProductId"), 
                    rs.getString("ProductName"), 
                    cat, 
                    rs.getDouble("UnitsInStock"),
                    rs.getInt("UnitsInStock")); 
                list.add(p);
            }
        }
        catch(SQLException ex){
            Logger.getLogger(DBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }
    
    public ArrayList<Product> getAllProductsPaging(int offset, int pageSize){
        ArrayList<Product> list = new ArrayList<>();
        try{
            String sql = "Select p.ProductId, p.ProductName, p.UnitPrice, p.UnitsInStock, c.CategoryName\n" +
                        "From Products p join Categories c\n" +
                        "On p.CategoryID = c.CategoryID";                
//            if(deptId!=0){
//                sql+= "and e.deptID = ?";
//            }
            sql += " order by p.ProductId offset ? rows fetch next ? rows only";
            
            System.out.println("sql:"+sql);
            PreparedStatement stm = connection.prepareStatement(sql);
//            if (deptId!=0){
//                stm.setInt(1, deptId);
//                stm.setInt(2, offset);
//                stm.setInt(3, pageSize);
//            } 
                stm.setInt(1, offset);
                stm.setInt(2, pageSize); 
            ResultSet rs = stm.executeQuery();
            while (rs.next()){
                Category cat = new Category(
                    rs.getInt("CategoryId"), 
                    rs.getString("CategoryName"), 
                    rs.getString("Description"));
                Product p = new Product(
                    rs.getInt("ProductId"), 
                    rs.getString("ProductName"), 
                    cat, 
                    rs.getDouble("UnitsInStock"),
                    rs.getInt("UnitsInStock")); 
                list.add(p);
            }
        }
        catch(SQLException ex){
            Logger.getLogger(DBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }
    
    public int getNumberOfProducts(){
        try{
            String sql = "Select count(*) [productNum] From Products p"; 
            PreparedStatement stm = connection.prepareStatement(sql); 
            ResultSet rs = stm.executeQuery();
            rs.next();
            return rs.getInt("productNum");
        }
        catch(SQLException ex){
            Logger.getLogger(DBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 0;
    }   
    
}
