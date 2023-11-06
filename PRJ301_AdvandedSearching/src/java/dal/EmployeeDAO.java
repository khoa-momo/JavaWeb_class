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
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import models.Employee;

/**
 *
 * @author lephu
 */
public class EmployeeDAO extends DBContext{
//------------------------------------------------Get SQL---------------------------------------------------------
    public ArrayList<Employee> getAllEmployees(){
        ArrayList<Employee> list = new ArrayList<>();
        try{
            String sql = "Select e.*, d.deptName [departmentname] from Employee e, Department d "
                    + "where e.deptID = d.deptID";
            PreparedStatement ps = connection.prepareStatement(sql);  
            ResultSet rs = ps.executeQuery();
            while (rs.next()){
                Employee e = new Employee(
                    rs.getInt("empID"), 
                    rs.getString("empName"),
                    rs.getDate("dob"), 
                    rs.getString("sex"));
                    e.addDepartment(rs.getInt("deptID"), rs.getString("departmentname"));
                list.add(e);
            }
        }
        catch(SQLException ex){
            Logger.getLogger(DBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }    
    
//------------------------------------------------Get SQL---------------------------------------------------------    
    
    public ArrayList<Employee> getEmployeesByFillter(String name, LocalDate dateFrom,  LocalDate dateTo, String sex, String position, int deptID){
        ArrayList<Employee> list = new ArrayList<>();
        try{
            String sql = "";    
            PreparedStatement ps = connection.prepareStatement(sql);  
            
            ps.setString(1, "%"+name+"%");
            ps.setString(2, "%"+sex);
            ps.setString(3, "%"+position+"%");
            ps.setDate(4, Date.valueOf(dateFrom));
            ps.setDate(5, Date.valueOf(dateTo)); 
            ps.setInt(6, deptID); 
             
            ResultSet rs = ps.executeQuery();
            while (rs.next()){
                Employee e = new Employee(
                    rs.getInt("empID"), 
                    rs.getString("empName"),
                    rs.getDate("dob"), 
                    rs.getString("sex"));
                    e.addDepartment(rs.getInt("deptID"), rs.getString("departmentname"));
                list.add(e);
            }
        }
        catch(SQLException ex){
            Logger.getLogger(DBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }
    
    public ArrayList<Employee> getEmployeesByFillterPaging(String name, LocalDate dateFrom,  LocalDate dateTo, String sex, int deptID, int page, int PAGE_SIZE){
        ArrayList<Employee> list = new ArrayList<>();
        try{
            String sql1 = 
                    "Select e.*, d.name [deptname]\n" +
                    "From Employees e join Departments d\n" +
                    "On e.did = d.id\n" +
                    "Where e.name like ?\n" +
                    "and e.gender like ?\n" +
                    "and e.did like ?\n" +
                    "and Year(e.dob) between Year(?) and Year(?)\n" +
                    "and Month(e.dob) between Month(?) and Month(?)\n" +
                    "and Day(e.dob) between Day(?) and Day(?)\n"; 
            String sql2 = 
                    "Order By empId \n" +
                    "offset (?-1)*? row fetch next ? rows only";  
            String sql = sql1 + sql2;
            PreparedStatement ps = connection.prepareStatement(sql);   
            ps.setString(1, "%"+name+"%");//empty --> all  
            ps.setString(2, sex);
            ps.setInt(3, deptID); 
            
            ps.setDate(4, Date.valueOf(dateFrom));
            ps.setDate(5, Date.valueOf(dateTo)); 
            ps.setDate(6, Date.valueOf(dateFrom));
            ps.setDate(7, Date.valueOf(dateTo)); 
            ps.setDate(8, Date.valueOf(dateFrom));
            ps.setDate(9, Date.valueOf(dateTo)); 
            
            ps.setInt(10, page);
            ps.setInt(11, PAGE_SIZE);
            ps.setInt(12, PAGE_SIZE);
            ResultSet rs = ps.executeQuery();
            while (rs.next()){
                Employee e = new Employee(
                    rs.getInt("id"), 
                    rs.getString("name"),
                    rs.getDate("dob"), 
                    rs.getString("gender"));
                    e.addDepartment(rs.getInt("did"), rs.getString("deptname"));
                list.add(e);
            }
        }
        catch(SQLException ex){
            Logger.getLogger(DBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }
    
    public int getTotalEmployeeFillterPaging(String name, LocalDate dateFrom,  LocalDate dateTo, String sex, int deptID) {
        try {
            String sql = "Select e.*, d.name [deptname]\n" +
                    "From Employees e join Departments d\n" +
                    "On e.did = d.id\n" +
                    "Where e.name like ?\n" +
                    "Where e.name like ?\n" +
                    "and e.gender like ?\n" +
                    "and e.did like ?\n" +
                    "and Year(e.dob) between Year(?) and Year(?)\n" +
                    "and Month(e.dob) between Month(?) and Month(?)\n" +
                    "and Day(e.dob) between Day(?) and Day(?)\n"; 
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, "%"+name+"%");//empty --> all  
            ps.setString(2, sex);
            ps.setInt(3, deptID); 
            
            ps.setDate(4, Date.valueOf(dateFrom));
            ps.setDate(5, Date.valueOf(dateTo)); 
            ps.setDate(6, Date.valueOf(dateFrom));
            ps.setDate(7, Date.valueOf(dateTo)); 
            ps.setDate(8, Date.valueOf(dateFrom));
            ps.setDate(9, Date.valueOf(dateTo)); 
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                return rs.getInt(1);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 0;
    }
     
//==============================================Paging============================================== 

    
 //-------------------------------------------------CRUD--------------------------------------------------------------------
  

}/////////////////////////////////////////End//////////////////////////////////////////////////////////////////////////
