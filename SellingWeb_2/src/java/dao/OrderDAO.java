/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.logging.Level;
import java.util.logging.Logger;
import models.Category;
import models.Order;
import models.Shipper;

/**
 *
 * @author DELL
 */
public class OrderDAO extends DBContext{
    //use
    public int InsertOrderReturnKey(Order order, String customerID){
        try{
            String sql = "insert into Orders(OrderDate,RequiredDate, customerID, Shipvia, ShipName, ShipAddress) "
                    + "values (getDate(),?,?,?,?,?)";
            PreparedStatement ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
                ps.setDate(1, Date.valueOf(order.getRequiredDate()));
                ps.setString(2, customerID);
                ps.setInt(3, order.getShipper().getShipperId());
                ps.setString(4, order.getShipName());
                ps.setString(5, order.getShipAddress()); 
                ps.executeUpdate();
            ResultSet rs = ps.getGeneratedKeys();
            if (rs.next()){
                int orderId = Integer.parseInt(rs.getString(1));
                return orderId;
            }
        }
        catch(SQLException ex){
            Logger.getLogger(DBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return -1;
    }
    
    
    
    
    public int createReturnId(Order order){
        try {
            String sql = "insert into Orders(OrderDate, RequiredDate, Shipvia, ShipName, ShipAddress) "
                    + "values (getDate(),?,?,?,?)";
            PreparedStatement ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setDate(1, Date.valueOf(order.getRequiredDate()));
                ps.setInt(2, order.getShipper().getShipperId());
                ps.setString(3, order.getShipName());
                ps.setString(4, order.getShipAddress()); 
                ps.executeUpdate();

            ResultSet rs = ps.getGeneratedKeys();
            if (rs.next()) {
//                return rs.getInt(1);
                int orderId = Integer.parseInt(rs.getString(1));
                return orderId;
            }

        } catch (SQLException ex) {
            Logger.getLogger(DBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return -1;
    }
     
   
}
