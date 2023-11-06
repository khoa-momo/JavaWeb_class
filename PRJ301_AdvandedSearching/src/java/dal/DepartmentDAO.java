/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dal;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import models.Department;
import models.Employee;

/**
 *
 * @author lephu
 */
public class DepartmentDAO extends DBContext{
    
    //getAllDepartments
    public ArrayList<Department> getAllDepartments(){
        ArrayList<Department> list = new ArrayList<>();
        try{
            //String sql = "Select id, name from Department";
            String sql = "Select * from Departments";
            PreparedStatement ps = connection.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()){
                Department d = new Department(
                        rs.getInt("id"), 
                        rs.getString("name"));
                list.add(d);
            }
        }catch(Exception ex){
            Logger.getLogger(DBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }
    
    public Department getDepartmentById(int id){
        try {
            String sql = "select * from Department where ID = ?";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, id); //setPara
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Department dept = new Department(rs.getInt(1), rs.getString(2));
                return dept; //return Department
            }
        } catch (Exception ex) {
            Logger.getLogger(DepartmentDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    public Department getDepartmentBy1(){
        try {
            String sql = "select * from Department where deptID = 1";
            PreparedStatement stm = connection.prepareStatement(sql);
            ResultSet rs = stm.executeQuery();
//            stm.setInt(1, id); 
            while (rs.next()) {
                Department dept = new Department(rs.getInt(1), rs.getString(2));
                return dept;
            }
        } catch (Exception ex) {
            Logger.getLogger(DepartmentDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    //addEmployee
    public void addDepartment1(Department d){
        try{
            String sql = "insert into Department(deptName)"
                    + "values (?)";
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setString(1, d.getName());
            stm.executeUpdate();
        }
        catch(Exception ex){
            Logger.getLogger(DBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    //addEmployee
    public void addDepartment(String d){
        try{
            String sql = "insert into Department(deptName)"
                    + "values (?)";
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setString(1, d);
            stm.executeUpdate();
        }
        catch(Exception ex){
            Logger.getLogger(DBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    
    public ArrayList<Department> getListByPage(ArrayList<Department> list, int start, int end){
        ArrayList<Department> arr = new ArrayList<>();
        for(int i = start; i<end; i++){
            arr.add(list.get(i));
        }
        return arr;
        
//        try{
//            
//        }
//        catch(Exception ex){
//            Logger.getLogger(DBContext.class.getName()).log(Level.SEVERE, null, ex);
//        }
//        return list;
    }
}
