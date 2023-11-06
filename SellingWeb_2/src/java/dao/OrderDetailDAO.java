/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;
 
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException; 
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger; 
import models.OrderDetail;
import models.Cart;
/**
 *
 * @author DELL
 */
public class OrderDetailDAO extends DBContext{
    public void saveCartOD(int orderId, Map<Integer, Cart> carts) {
        try {

            String sql = "insert into [Order Details](OrderId, ProductID, Quantity, UnitPrice)"
                    + "values (?,?,?,?)";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, orderId);
            for (Map.Entry<Integer, Cart> entry : carts.entrySet()) {
                Cart cart = entry.getValue();
                ps.setInt(2, cart.getProduct().getProductId());
                ps.setInt(3, cart.getQuantity());
                ps.setDouble(4, cart.getProduct().getUnitPrice()); 
                ps.executeUpdate();
            }

        } catch (SQLException ex) {
            Logger.getLogger(DBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
    }   
    
    
    public int InsertOrderDetail(OrderDetail orderDetail){
        try{
            String sql = "insert into [Order Details](OrderId, ProductID, UnitPrice, Quantity)"
                    + "values (?,?,?,?)";
            PreparedStatement ps = connection.prepareStatement(sql); 
            ps.setInt(1, orderDetail.getOrderId()); 
            
            ps.setInt(2, orderDetail.getProductId());
            ps.setInt(3, orderDetail.getQuantity()); 
            ps.setDouble(4, orderDetail.getUnitPrice()); 
            ps.executeUpdate(); 
        }
        catch(SQLException ex){
            Logger.getLogger(DBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return -1;
    }
}
