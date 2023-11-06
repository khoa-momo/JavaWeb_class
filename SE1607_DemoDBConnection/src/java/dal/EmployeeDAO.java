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
import java.util.logging.Level;
import java.util.logging.Logger;
import models.Department;
import models.Employee;

/**
 *
 * @author lephu
 */
public class EmployeeDAO extends DBContext{
    
    public ArrayList<Employee> getAllEmployeesByDeptId(int deptId){
        ArrayList<Employee> list = new ArrayList<>();
        try{
            String sql = "select e.*, d.name [departmentname] from Employee e, Department d "
                    + "where e.Department = d.ID "
                    + "and e.Department = ?" ;
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setInt(1, deptId);//setInt
            ResultSet rs = stm.executeQuery();
            while (rs.next()){
                Employee e = new Employee(
                    rs.getInt("id"), 
                    rs.getString("name"),
                    rs.getDate("dob").toLocalDate(), 
                    rs.getString("sex"),
                    rs.getString("position"));
                e.addDepartment(rs.getInt("department"), rs.getString("departmentname"));
                list.add(e);
            }
        }
        catch(Exception ex){
            Logger.getLogger(DBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }
    
    //addEmployee
    public void addEmployee(Employee e){
        try{
            String sql = "insert into Employee(name, sex, dob, position, department)"
                    + "values (?,?,?,?,?)";
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setString(1, e.getName());
            stm.setString(2, e.getSex());
            stm.setDate(3, Date.valueOf(e.getDob()));
            stm.setString(4, e.getPosition());
            stm.setInt(5, e.getDepartment().getId());
            
            stm.executeUpdate();
        }
        catch(Exception ex){
            Logger.getLogger(DBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
