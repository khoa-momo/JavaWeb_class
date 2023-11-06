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
import models.Shipper;

/**
 *
 * @author DELL
 */
public class ShipperDAO extends DBContext{
    public ArrayList<Shipper> getAllShippers(){
        ArrayList<Shipper> list = new ArrayList<>();
        try{
            String sql = "Select ShipperId, CompanyName\n" +
                        "From Shippers";
            PreparedStatement ps = connection.prepareStatement(sql);  
            ResultSet rs = ps.executeQuery();
            while (rs.next()){
                Shipper s = new Shipper(
                    rs.getInt("ShipperId"),  
                    rs.getString("CompanyName"));
                list.add(s);
            }
        }
        catch(SQLException ex){
            Logger.getLogger(DBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }
}
