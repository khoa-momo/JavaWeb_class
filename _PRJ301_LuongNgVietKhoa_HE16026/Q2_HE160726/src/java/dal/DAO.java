package dal;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Account;
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
    public ArrayList<Student> getAllStudentById(String aId){
        ArrayList<Student> list = new ArrayList<>();
        try{
            String sql = "Select s.stuid, s.stuname, s.studob, s.stugender\n" +
                            "From Student s join Account a\n" +
                            "On s.createdby = a.username\n" +
                            "Where s.createdby = ?" ;
            PreparedStatement ps = connection.prepareStatement(sql); 
            ps.setString(1, aId); //setInt
            ResultSet rs = ps.executeQuery();
            while (rs.next()){
                Student e = new Student(
                    rs.getInt(1), 
                    rs.getString(2),
                    rs.getDate(3), 
                    rs.getInt(4)); 
                list.add(e);
            }
        }
        catch(Exception ex){
            Logger.getLogger(DBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }
    
    public ArrayList<Account> getAllAccount(){
        ArrayList<Account> list = new ArrayList<>();
        try{
            String sql = "Select * From Account\n" +
                        "Where username = 'mra' and password = 'mra'";
            PreparedStatement ps = connection.prepareStatement(sql);  
            ResultSet rs = ps.executeQuery();
            while (rs.next()){
                Account e = new Account( 
                    rs.getString("username"),
                    rs.getString("displayname")); 
                list.add(e);
            }
        }
        catch(SQLException ex){
            Logger.getLogger(DBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }    
}
