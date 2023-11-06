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
import models.Room;

/**
 *
 * @author DELL
 */
public class RoomDAO extends DBContext{
    public ArrayList<Room> getAllRoom(){
        ArrayList<Room> list = new ArrayList<>();
        try{
            String sql = "Select r.*, rt.Square \n" +
                        " From Room r join RoomType rt\n" +
                        " On r.RoomType = rt.Title ";
            PreparedStatement ps = connection.prepareStatement(sql);   
            ResultSet rs = ps.executeQuery();
            while (rs.next()){
                Room r = new Room(
                    rs.getInt("id"), 
                    rs.getString("title"), 
                    rs.getString("status"), 
                    rs.getString("roomType"), 
                    rs.getString("square"));
                list.add(r);
            }
        }
        catch(SQLException ex){
            Logger.getLogger(DBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }
    
    
    public ArrayList<Room> getRoomByType(String type){
        ArrayList<Room> list = new ArrayList<>();
        try{
            String sql = " Select r.*, rt.Square \n" +
                        " From Room r join RoomType rt\n" +
                        " On r.RoomType = rt.Title \n" +
                        " Where r.RoomType = ?";
            PreparedStatement ps = connection.prepareStatement(sql);   
            ps.setString(1, type);
            ResultSet rs = ps.executeQuery();
            while (rs.next()){
                Room r = new Room(
                    rs.getInt("id"), 
                    rs.getString("title"), 
                    rs.getString("status"), 
                    rs.getString("roomType"), 
                    rs.getString("square"));
                list.add(r);
            }
        }
        catch(SQLException ex){
            Logger.getLogger(DBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }
    
    public ArrayList<Room> getRoomType(){
        ArrayList<Room> list = new ArrayList<>();
        try{
            String sql = " Select distinct r.RoomType\n" +
                        "From Room r join RoomType rt\n" +
                        "On r.RoomType = rt.Title  ";
            PreparedStatement ps = connection.prepareStatement(sql);    
            ResultSet rs = ps.executeQuery();
            while (rs.next()){
                Room r = new Room( 
                    rs.getString("roomType"));
                list.add(r);
            }
        }
        catch(SQLException ex){
            Logger.getLogger(DBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }
//    public boolean deleteRoom(int id) throws SQLException {
//            String sql = " delete from Room \n" +
//                        " Where id = ?";
//            PreparedStatement stm = connection.prepareStatement(sql);
//            stm.setInt(1, id); 
//        return stm.executeUpdate() > 0;
//    }    
    
    public void deleteRoom(int id){
        try{
            String sql = "DELETE FROM Room "
                    + "WHERE ID = ?";
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setInt(1, id); 
            stm.executeUpdate();
        }
        catch(Exception ex){
            Logger.getLogger(DBContext.class.getName()).log(Level.SEVERE, null, ex);
        }   
    }
}
 
