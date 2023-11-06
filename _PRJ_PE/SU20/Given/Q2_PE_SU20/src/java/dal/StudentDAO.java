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
import models.Student;

/**
 *
 * @author DELL
 */
public class StudentDAO extends DBContext{
    public ArrayList<Student> getAllStudentByName(String code){
        ArrayList<Student> list = new ArrayList<>();
        try{
            String sql = "Select * From STUDENT\n" +
                        "Where name like ?";
            PreparedStatement ps = connection.prepareStatement(sql);  
            ps.setString(1, "%"+code+"%"); 
            ResultSet rs = ps.executeQuery();
            while (rs.next()){
                Student s = new Student(
                    rs.getInt("id"), 
                    rs.getString("name"),  
                    rs.getDate("dob").toLocalDate(), 
                    rs.getString("gender"));
                list.add(s);
            }
        }
        catch(SQLException ex){
            Logger.getLogger(DBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }    
    
    public ArrayList<Student> getAllStudents(){
        ArrayList<Student> list = new ArrayList<>();
        try{
            String sql = "Select * From STUDENT\n";
            PreparedStatement ps = connection.prepareStatement(sql);  
            ResultSet rs = ps.executeQuery();
            while (rs.next()){
                Student s = new Student(
                    rs.getInt("id"), 
                    rs.getString("name"),  
                    rs.getDate("dob").toLocalDate(), 
                    rs.getString("gender"));
                list.add(s);
            }
        }
        catch(SQLException ex){
            Logger.getLogger(DBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }    
}
