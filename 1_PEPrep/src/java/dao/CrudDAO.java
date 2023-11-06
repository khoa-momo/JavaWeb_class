/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author DELL
 */
public class CrudDAO extends DBContext{
    //check account loginDAO
    public User checkLogin(String username, String password){ 
            String sql = "Select * From UserTBL \n" +
                    "Where userid = ? and password = ?";
        try{
            Connection connection = new DBContext().getConnection();
            PreparedStatement ps = connection.prepareStatement(sql);  
            ps.setString(1, username); 
            ps.setString(2, password); 
            ResultSet rs = ps.executeQuery();
            while (rs.next()){ 
                return new User(rs.getString(1),
                        rs.getString(2));
            }
        } catch (Exception ex) {
            Logger.getLogger(DAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }    
    
//------------------------------------------------Get SQL---------------------------------------------------------
    public ArrayList<Object> getAllObject(){
        ArrayList<Object> list = new ArrayList<>();
        try{
            String sql = "Select e.*, d.deptName [departmentname] from Employee e, Department d "
                    + "where e.deptID = d.deptID";
            PreparedStatement ps = connection.prepareStatement(sql);  
            ResultSet rs = ps.executeQuery();
            while (rs.next()){
                Object e = new Object(
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
    
    public List<Object> getAll() {
        try {
            List<Object> list = new ArrayList<>();
            //mo ket noi
//            Connection conn = new DBContext().getConnection();
            String sql = "select * from Characters";
            PreparedStatement ps = connection.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
//                List<Object> listSkills = new SkillDAO().getSkillsByCid(rs.getString(1));
//                CharacterModel characterModel = new CharacterModel(rs.getString(1), rs.getString(2), rs.getBoolean(3), rs.getDate(4), listSkills);
//                list.add(characterModel);
            }
            return list;
        } catch (Exception ex) {
            ex.printStackTrace(System.out);
        }
        return null;
    }
    
    public ArrayList<Object> getAllObjectById(int deptId){
        ArrayList<Object> list = new ArrayList<>();
        try{
            String sql = "select e.*, d.deptName [departmentname] from Employee e, Department d "
                    + "where e.deptID = d.deptID "
                    + "and e.deptID = ?" ;
            PreparedStatement ps = connection.prepareStatement(sql); 
            ps.setInt(1, deptId); //setInt
            ResultSet rs = ps.executeQuery();
            while (rs.next()){
                Object e = new Object(
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
    
    public Object getObjectById(int empid){
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
            ps.setInt(6, deptID);  
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
    
     
     
 //===========================================CRUD===========================================
    //addEmployee
    public void add(Object o){
        try{
            String sql = "Insert into Employee(empName, dob, sex, position, deptID)"
                    + "values (?,?,?,?,?)";
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setString(1, o.getName());
            stm.setDate(2, Date.valueOf(o.getDob()));
            stm.setString(3, o.getSex());
            stm.setString(4, o.getPosition());
            stm.setInt(5, o.getDepartment().getId()); 
            stm.executeUpdate();
        }
        catch(SQLException ex){
            Logger.getLogger(DBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void add2(String aaaa, String bbbb, int ccc, int dddd){
        try{
            String sql = "Insert into Table(a, b, c, d)"
                    + "values (?,?,?,?)";
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setString(1, aaaa);
            stm.setString(2, bbbb);
            stm.setInt(3, ccc);
            stm.setInt(4, dddd); 
            stm.executeUpdate();
        }
        catch(SQLException ex){
            Logger.getLogger(DBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    //updateEmployee
    public void updateObject(Object o, int empID){
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
    
    
    public void update2(String name, LocalDate date, String sex, String position, int deptID, int empID){
        try{
            String sql = "UPDATE \n" +
                        "SET a=?, b=?, c=?, d=?, e=?\n" +
                        "WHERE f=?";
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setString(1, name);
            stm.setDate(2, Date.valueOf(date));
            stm.setString(3, sex);
            stm.setString(4, position);
            stm.setInt(5, deptID); 
            stm.setInt(6, empID); 
            stm.executeUpdate();
        }
        catch(SQLException ex){
            Logger.getLogger(DBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
        
    //DELETE
    public void delete1(int empID){
        try{
            String sql = "DELETE FROM  " +
                         "WHERE  = ?";
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setInt(1, empID); 
            stm.executeUpdate();
        }
        catch(SQLException ex){
            Logger.getLogger(DBContext.class.getName()).log(Level.SEVERE, null, ex);
        }   
    }

    public boolean delete2(int empID) throws SQLException {
        String sql = "DELETE FROM Employee " +
                     "WHERE  = ?";
        PreparedStatement stm = connection.prepareStatement(sql);
        stm.setInt(1, empID); 
        return stm.executeUpdate() > 0;
    }    
    
    //--------------------------------------------------------------------------------------------------------------------
    
    
    
    
    public ArrayList<Message> getMessbyId(String user) {
        ArrayList<Message> list = new ArrayList<>();
        try {
            String sql = "select * from MessageTBL\n"
                        + "Where [to] = ?";
            Connection conn = new DBContext().getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, user);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){ 
                Message m = new Message( 
                    rs.getInt(1),
                    rs.getString(2),
                    rs.getString(3),
                    rs.getString(4),
                    rs.getString(5),
                    rs.getString(6), 
                    rs.getInt(7));
                list.add(m);
            }
        } catch (Exception ex) {
            Logger.getLogger(DAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }
}
