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
                    rs.getDate("dob").toLocalDate(), 
                    rs.getString("sex"),
                    rs.getString("position"));
                    e.addDepartment(rs.getInt("deptID"), rs.getString("departmentname"));
                list.add(e);
            }
        }
        catch(SQLException ex){
            Logger.getLogger(DBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }    
    
    public ArrayList<Employee> getAllEmployeesByDeptId(int deptId){
        ArrayList<Employee> list = new ArrayList<>();
        try{
            String sql = "select e.*, d.deptName [departmentname] from Employee e, Department d "
                    + "where e.deptID = d.deptID "
                    + "and e.deptID = ?" ;
            PreparedStatement ps = connection.prepareStatement(sql); 
            ps.setInt(1, deptId); //setInt
            ResultSet rs = ps.executeQuery();
            while (rs.next()){
                Employee e = new Employee(
                    rs.getInt("empID"), 
                    rs.getString("empName"),
                    rs.getDate("dob").toLocalDate(), 
                    rs.getString("sex"),
                    rs.getString("position"));
                    e.addDepartment(rs.getInt("deptID"), rs.getString("departmentname"));
                list.add(e);
            }
        }
        catch(Exception ex){
            Logger.getLogger(DBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }
        
    public ArrayList<Employee> getAllEmployeesByName(String empName, LocalDate date, String sex, String position){
        ArrayList<Employee> list = new ArrayList<>();
        try{
            String sql = "select e.*, d.deptName [departmentname] "
                    + "from Employee e, Department d "
                    + "where e.deptID = d.deptID "
                    + "and e.empName like ? and e.dob=? and e.sex=? and e.position=?" ;
            PreparedStatement ps = connection.prepareStatement(sql); 
            ps.setString(1, "%"+empName+"%");  
            ps.setDate(2, Date.valueOf(date));
            ps.setString(3, sex);
            ps.setString(4, position);
            ResultSet rs = ps.executeQuery();
            while (rs.next()){
                Employee e = new Employee(
                    rs.getInt("empID"), 
                    rs.getString("empName"),
                    rs.getDate("dob").toLocalDate(), 
                    rs.getString("sex"),
                    rs.getString("position"));
                    e.addDepartment(rs.getInt("deptID"), rs.getString("departmentname"));
                list.add(e);
            }
        }
        catch(SQLException ex){
            Logger.getLogger(DBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }
    
    public Employee getEmployeeById(int empid){
        try {
            String sql = "select e.*, d.deptName [departmentname] from Employee e, Department d "
                    + "where e.deptID = d.deptID "
                    + "and e.empID = ?" ;
            PreparedStatement ps = connection.prepareStatement(sql); 
            ps.setInt(1, empid); //setInt
            ResultSet rs = ps.executeQuery();
            
            while (rs.next()) {
                Employee e = new Employee(
                    rs.getInt("empID"), 
                    rs.getString("empName"),
                    rs.getDate("dob").toLocalDate(), 
                    rs.getString("sex"),
                    rs.getString("position"));
                    e.addDepartment(rs.getInt("deptID"), rs.getString("departmentname"));
                return e;
            }
        } catch (SQLException ex) {
            Logger.getLogger(EmployeeDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
//------------------------------------------------Get SQL---------------------------------------------------------    
    
    public ArrayList<Employee> getEmployeesByFillter(String name, LocalDate dateFrom,  LocalDate dateTo, String sex, String position, int deptID){
        ArrayList<Employee> list = new ArrayList<>();
        try{
            String sql = "";
            //
            sql = "Select e.*, d.deptName [departmentname] "
                    + "From Employee e join Department d "
                    + "On e.deptID = d.deptID "
                    + "Where e.empName like ? "
                    + "and e.sex like ? and e.position like ? "  
                    + "and Year(e.dob) between Year(?) and Year(?) "
//                    + "and Month(e.dob) between Month(?) and Month(?) "
//                    + "and Day(e.dob) between Day(?) and Day(?) "
                    + "and e.deptID = ?" ;  
            
            String sql2 = "select e.*, d.deptName [departmentname] "
                    + "from Employee e, Department d "
                    + "where e.deptID = d.deptID "
                    + "and e.empName like ? "
                    + "and Year(e.dob) between Year(?) and Year(?) "
//                    + "and Month(e.dob) between Month(?) and Month(?) "
//                    + "and Day(e.dob) between Day(?) and Day(?) "
                    + "and e.sex=? and e.position=? and e.deptID=?" ;   
            PreparedStatement ps = connection.prepareStatement(sql);  
            
            ps.setString(1, "%"+name+"%");
            ps.setString(2, "%"+sex);
            ps.setString(3, "%"+position+"%");
            ps.setDate(4, Date.valueOf(dateFrom));
            ps.setDate(5, Date.valueOf(dateTo));
//            ps.setDate(6, Date.valueOf(dateFrom));
//            ps.setDate(7, Date.valueOf(dateTo));
//            ps.setDate(8, Date.valueOf(dateFrom));
//            ps.setDate(9, Date.valueOf(dateTo));
            ps.setInt(6, deptID); 
            
//            ps.setString(1, "%" + name + "%");
//            ps.setDate(2, Date.valueOf(dateFrom));
//            ps.setDate(3, Date.valueOf(dateTo));
////            ps.setDate(4, Date.valueOf(dateFrom));
////            ps.setDate(5, Date.valueOf(dateTo));
////            ps.setDate(6, Date.valueOf(dateFrom));
////            ps.setDate(7, Date.valueOf(dateTo));
//            ps.setString(4, sex);
//            ps.setString(5, position);
//            ps.setInt(6, deptID); 
            
            ResultSet rs = ps.executeQuery();
            while (rs.next()){
                Employee e = new Employee(
                    rs.getInt("empID"), 
                    rs.getString("empName"),
                    rs.getDate("dob").toLocalDate(), 
                    rs.getString("sex"),
                    rs.getString("position"));
                    e.addDepartment(rs.getInt("deptID"), rs.getString("departmentname"));
                list.add(e);
            }
        }
        catch(SQLException ex){
            Logger.getLogger(DBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }
    
    public ArrayList<Employee> getEmployeesByFillterPaging(String name, LocalDate dateFrom,  LocalDate dateTo, String sex, String position, int deptID, int page, int PAGE_SIZE){
        ArrayList<Employee> list = new ArrayList<>();
        try{
            String sql1 = 
                    "select e.*, d.deptName [departmentname] \n" +
                    "From Employee e join Department d \n" +
                    "On e.deptID = d.deptID \n" +
                    "Where e.empName like ? \n" + 
                    "and position like ? \n" +
                    "and Year(e.dob) between Year(?) and Year(?) \n" + 
                    "and e.deptID = ? \n";
            if (!sex.equals("All")) {//Female&Male
                sql1 += "and e.sex = ? \n";
            }   
            String sql2 = 
                    "Order By empId \n" +
                    "offset (?-1)*? row fetch next ? rows only";  
            String sql = sql1 + sql2;
            PreparedStatement ps = connection.prepareStatement(sql);   
            ps.setString(1, "%"+name+"%");//empty --> all 
            ps.setString(2, "%"+position+"%");//empty --> all
            ps.setDate(3, Date.valueOf(dateFrom));
            ps.setDate(4, Date.valueOf(dateTo)); 
            ps.setInt(5, deptID); 
            ps.setString(6, sex);//all --> ''
            ps.setInt(7, page);
            ps.setInt(8, PAGE_SIZE);
            ps.setInt(9, PAGE_SIZE);
            ResultSet rs = ps.executeQuery();
            while (rs.next()){
                Employee e = new Employee(
                    rs.getInt("empID"), 
                    rs.getString("empName"),
                    rs.getDate("dob").toLocalDate(), 
                    rs.getString("sex"),
                    rs.getString("position"));
                    e.addDepartment(rs.getInt("deptID"), rs.getString("departmentname"));
                list.add(e);
            }
        }
        catch(SQLException ex){
            Logger.getLogger(DBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }
    
    public int getTotalEmployeeFillterPaging(String name, LocalDate dateFrom,  LocalDate dateTo, String sex, String position, int deptID) {
        try {
            String sql = "select count(*)\n" +
                        "From Employee e join Department d \n" +
                        "On e.deptID = d.deptID\n" +
                        "Where e.empName like ? \n" +
                        "and e.sex = ?\n" +
                        "and position like ?\n" +
                        "and Year(e.dob) between Year(?) and Year(?)\n" + 
                        "and e.deptID = ?\n";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, "%"+name+"%");
            ps.setString(2, sex);
            ps.setString(3, "%"+position+"%");
            ps.setDate(4, Date.valueOf(dateFrom));
            ps.setDate(5, Date.valueOf(dateTo)); 
            ps.setInt(6, deptID);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                return rs.getInt(1);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 0;
    }
    
    public ArrayList<Employee> getEmployeesByFillter1(String name, Date dob1,  Date dob2, String sex, String position, int deptID){
        ArrayList<Employee> list = new ArrayList<>();
        try{
            String sql = "";
            //
            sql = "Select e.*, d.deptName [departmentname] "
                    + "From Employee e join Department d "
                    + "On e.deptID = d.deptID "
                    + "Where e.empName like ? "
                    + "and Year(e.dob) between Year(?) and Year(?) "
                    + "and Month(e.dob) between Month(?) and Month(?) "
                    + "and Day(e.dob) between Day(?) and Day(?) "
                    + "and e.sex like ? and e.position like ? and e.deptID=?" ;  
             
            PreparedStatement ps = connection.prepareStatement(sql);  
            
            ps.setString(1, "%"+name+"%");
            ps.setDate(2, dob1);
            ps.setDate(3, dob2);
            ps.setDate(4, dob1);
            ps.setDate(5, dob2);
            ps.setDate(6, dob1);
            ps.setDate(7, dob2);
            ps.setString(8, "%"+sex);
            ps.setString(9, "%"+position+"%");
            ps.setInt(10, deptID); 
            
//            ps.setString(1, "%" + name + "%");
//            ps.setDate(2, Date.valueOf(dateFrom));
//            ps.setDate(3, Date.valueOf(dateTo));
////            ps.setDate(4, Date.valueOf(dateFrom));
////            ps.setDate(5, Date.valueOf(dateTo));
////            ps.setDate(6, Date.valueOf(dateFrom));
////            ps.setDate(7, Date.valueOf(dateTo));
//            ps.setString(4, sex);
//            ps.setString(5, position);
//            ps.setInt(6, deptID); 
            
            ResultSet rs = ps.executeQuery();
            while (rs.next()){
                Employee e = new Employee(
                    rs.getInt("empID"), 
                    rs.getString("empName"),
                    rs.getDate("dob").toLocalDate(), 
                    rs.getString("sex"),
                    rs.getString("position"));
                    e.addDepartment(rs.getInt("deptID"), rs.getString("departmentname"));
                list.add(e);
            }
        }
        catch(SQLException ex){
            Logger.getLogger(DBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }
    
    public ArrayList<Employee> getEmployeesByFillter2(String name, String sex, String position, int deptID){
        ArrayList<Employee> list = new ArrayList<>();
        try{
            String sql = "Select e.*, d.deptName [departmentname] from Employee e, Department d "
                    + "where e.deptID = d.deptID "
                    + "and e.empName like ? and e.sex=? and e.position=? and e.deptID=?" ;
            PreparedStatement ps = connection.prepareStatement(sql);  
            
            ps.setString(1, "%" + name + "%"); 
            ps.setString(2, sex);
            ps.setString(3, position);
            ps.setInt(4, deptID); 
            
            ResultSet rs = ps.executeQuery();
            while (rs.next()){
                Employee e = new Employee(
                    rs.getInt("empID"), 
                    rs.getString("empName"),
                    rs.getDate("dob").toLocalDate(), 
                    rs.getString("sex"),
                    rs.getString("position"));
                    e.addDepartment(rs.getInt("deptID"), rs.getString("departmentname"));
                list.add(e);
            }
        }
        catch(Exception ex){
            Logger.getLogger(DBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }
    
//==============================================Paging==============================================
    public ArrayList<Employee> getAllEmployeesByDeptIdPaging(int deptId, int offset, int pageSize){
        ArrayList<Employee> list = new ArrayList<>();
        try{
            String sql = "Select e.*, d.deptName [departmentname] From Employee e, Department d "
                    + "where e.deptID = d.deptID ";                   
            if(deptId!=0){
                sql+= "and e.deptID = ?";
            }
            sql += " order by e.empID offset ? rows fetch next ? rows only";
            
            System.out.println("sql:"+sql);
            PreparedStatement stm = connection.prepareStatement(sql);
            if (deptId!=0){
                stm.setInt(1, deptId);
                stm.setInt(2, offset);
                stm.setInt(3, pageSize);
            }
            else{
                stm.setInt(1, offset);
                stm.setInt(2, pageSize);
            }
            ResultSet rs = stm.executeQuery();
            while (rs.next()){
                Employee e = new Employee(
                    rs.getInt("empID"), 
                    rs.getString("empName"),
                    rs.getDate("dob").toLocalDate(), 
                    rs.getString("sex"),
                    rs.getString("position"));
                    e.addDepartment(rs.getInt("deptID"), rs.getString("departmentname"));
                list.add(e);
            }
        }
        catch(SQLException ex){
            Logger.getLogger(DBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }
    
    public int getNumberOfEmployee(int deptId){
        try{
            String sql = "select count(*) [numEmp] from Employee e ";
            if (deptId!=0){
                sql+= "where e.deptID = ?" ;
            }
            PreparedStatement stm = connection.prepareStatement(sql);
            if (deptId !=0){
                stm.setInt(1, deptId);
            }
            ResultSet rs = stm.executeQuery();
            rs.next();
            return rs.getInt("numEmp");
        }
        catch(SQLException ex){
            Logger.getLogger(DBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 0;
    }   

    
 //-------------------------------------------------CRUD--------------------------------------------------------------------
    //addEmployee
    public void addEmployee(Employee e){
        try{
            String sql = "insert into Employee(empName, dob, sex, position, deptID)"
                    + "values (?,?,?,?,?)";
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setString(1, e.getName());
            stm.setDate(2, Date.valueOf(e.getDob()));
            stm.setString(3, e.getSex());
            stm.setString(4, e.getPosition());
            stm.setInt(5, e.getDepartment().getId()); 
            stm.executeUpdate();
        }
        catch(SQLException ex){
            Logger.getLogger(DBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    //updateEmployee
    public void updateEmployee(Employee e, int empID){
        try{
            String sql = "UPDATE Employee\n" +
                        "SET empName=?, dob=?, sex=?, position=?, deptID=?\n" +
                        "WHERE empID=?";
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setString(1, e.getName());
            stm.setDate(2, Date.valueOf(e.getDob()));
            stm.setString(3, e.getSex());
            stm.setString(4, e.getPosition());
            stm.setInt(5, e.getDepartment().getId()); 
            stm.setInt(6, empID); 
            stm.executeUpdate();
        }
        catch(SQLException ex){
            Logger.getLogger(DBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
    public void updateEmployee2(String name, LocalDate date, String sex, String position, int deptID, int empID){
        try{
            String sql = "UPDATE Employee\n" +
                        "SET empName=?, dob=?, sex=?, position=?, deptID=?\n" +
                        "WHERE empID=?";
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setString(1, name);
            stm.setDate(2, Date.valueOf(date));
            stm.setString(3, sex);
            stm.setString(4, position);
            stm.setInt(5, deptID); 
            stm.setInt(6, empID); 
            stm.executeUpdate();
        }
        catch(Exception ex){
            Logger.getLogger(DBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
        
    //DELETEEmployee
    public boolean deleteEmployee(int empID) throws SQLException {
            String sql = "DELETE FROM Employee "
                    + "WHERE empID = ?";
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setInt(1, empID); 
        return stm.executeUpdate() > 0;
    }    
    
    public void deleteEmployee2(int empID){
        try{
            String sql = "DELETE FROM Employee "
                    + "WHERE empID = ?";
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setInt(1, empID); 
            stm.executeUpdate();
        }
        catch(Exception ex){
            Logger.getLogger(DBContext.class.getName()).log(Level.SEVERE, null, ex);
        }   
    }
    
//--------------------------------------------------------------------------------------------------------------------
    public ArrayList<Employee> getListByPage(ArrayList<Employee> list, int start, int end){
        ArrayList<Employee> arr = new ArrayList<>();
        for(int i = start; i<end; i++){
            arr.add(list.get(i));
        }
        return arr;
    }

}/////////////////////////////////////////End//////////////////////////////////////////////////////////////////////////
