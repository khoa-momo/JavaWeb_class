/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dal;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import models.Student;
import models.Skill;
/**
 *
 * @author DELL
 */
public class StudentDAO extends DBContext{
    public ArrayList<Skill> getAllSkill(){
        ArrayList<Skill> list = new ArrayList<>();
        try{
            String sql = "Select * From Skill";
            PreparedStatement ps = connection.prepareStatement(sql);  
            ResultSet rs = ps.executeQuery();
            while (rs.next()){
                Skill s = new Skill(
                    rs.getInt("id"),    
                    rs.getString("name"));
                list.add(s);
            }
        }
        catch(SQLException ex){
            Logger.getLogger(DBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }    
    
    public void addEStudent(Student e){
        try{
            String sql = "insert into Student(id, name, dob, gender)\n"
                    + "values (?,?,?,?)";
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setInt(1, e.getId()); 
            stm.setString(2, e.getName());
            stm.setDate(3, Date.valueOf(e.getDob()));
            stm.setString(4, e.getGender());  
            stm.executeUpdate();
        }
        catch(SQLException ex){
            Logger.getLogger(DBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void addStuSkill(int suid, String skid){
        try{
            String sql = "insert into Student_Skill(suid, skid)\n"
                    + "values (?,?)";
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setInt(1, suid); 
            stm.setString(2, skid); 
            stm.executeUpdate();
        }
        catch(SQLException ex){
            Logger.getLogger(DBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
