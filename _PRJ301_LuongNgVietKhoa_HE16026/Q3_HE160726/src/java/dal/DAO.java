package dal;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Account;
import model.Skill;
import model.Student;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author DELL
 */
public class DAO extends DBContext{
    //check account loginDAO
    public Account checkLogin(String username, String password){ 
            String sql = "Select * From Account\n" +
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
    
    public void addStudent(String stuid, String stuname, LocalDate date, int stugender, String created){
        try{
            String sql = "insert into Student(stuid, stuname, studob, stugender, createdby) "
                    + "values (?,?,?,?,?)";
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setString(1, stuid);
            stm.setString(2, stuname);
            stm.setDate(3, Date.valueOf(date));
            stm.setInt(4, stugender); 
            stm.setString(5, created); 
            stm.executeUpdate();
        }
        catch(SQLException ex){
            Logger.getLogger(DBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
    public ArrayList<Skill> getAllSkill(){
        ArrayList<Skill> list = new ArrayList<>();
        try{
            String sql = "Select * From Skill";
            PreparedStatement ps = connection.prepareStatement(sql);  
            ResultSet rs = ps.executeQuery();
            while (rs.next()){
                Skill e = new Skill(
                    rs.getInt(1), 
                    rs.getString(2)); 
                list.add(e);
            }
        }
        catch(SQLException ex){
            Logger.getLogger(DBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }    
    
    public void addCharacterSkill(String sid, String stuid, String degree) {
        try { 
            String sql = "insert into Student_Skill(sid, stuid, degree) values (?, ?, ?)";
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setString(1, sid); 
            stm.setString(2, stuid); 
            stm.setString(3, degree); 
            stm.executeUpdate();

        } catch (Exception ex) {
            ex.printStackTrace(System.out);
        }
    }
 
}
