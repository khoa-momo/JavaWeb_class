/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import models.Employee;
import models.Job;

/**
 *
 * @author DELL
 */
public class JobDAO extends DBContext{
    public void addJob(String name, String salary, String date, int activated){
        try{
            String sql = "insert into Jobs(Name, Salary, Datecreated, Activated) "
                    + "values (?,?,?,?)";
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setString(1, name);
            stm.setString(2, salary);
            stm.setString(3, date);
            stm.setInt(4, activated); 
            stm.executeUpdate();
        }
        catch(SQLException ex){
            Logger.getLogger(DBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public ArrayList<Job> getAllJobss(){
        ArrayList<Job> list = new ArrayList<>();
        try{
            String sql = "Select * From Jobs";
            PreparedStatement ps = connection.prepareStatement(sql);  
            ResultSet rs = ps.executeQuery();
            while (rs.next()){
                Job j = new Job(
                    rs.getInt("ID"), 
                    rs.getString("name"), 
                    rs.getString("salary"),
                    rs.getDate("dateCreated"), 
                    rs.getString("activated"));
                list.add(j);
            }
        }
        catch(SQLException ex){
            Logger.getLogger(DBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }
    
    //job
    List<Job> getJobsByeid(String eid) {
        try {
            List<Job> list = new ArrayList<>();
            //mo ket noi 
            String sql = "Select j.* \n" +
                    "From JobEmployee je join Jobs j\n" +
                    "On je.Jobid = j.ID\n" +
                    "Where Empid = ?";    
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, eid);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Job job = new Job(rs.getInt(1));
                list.add(job);
            }
            return list;
        } catch (Exception ex) {
            ex.printStackTrace(System.out);
        }
        return null;
    }
    
    public List<Employee> getAllEmp(int jobid) { 
        int isemp = 0;
        try {
            List<Employee> list = new ArrayList<>();
            //mo ket noi 
            String sql = "Select * from Employee";
            PreparedStatement ps = connection.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                List<Job> listjobs = getJobsByeid(rs.getString(1));//list cac id
//                String a = rs.getString(1);
                System.out.println("-start-");
                for (Job listjob : listjobs) {
                    isemp = 0;
                    if(jobid == listjob.getJobId()){
                        isemp = 1;
                        System.out.println("True");
                        System.out.println("List job: "+listjob.getJobId());
                        System.out.println("isemp: "+isemp);
                        break;
                    }  
                }
                System.out.println("-end-");
                Employee e = new Employee(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), isemp);
                list.add(e);
            }
            return list;
        } catch (Exception ex) {
            ex.printStackTrace(System.out);
        }
        return null;
    }
    
    public List<Employee> getAllEmployees() {
        try {
            List<Employee> list = new ArrayList<>();
            //mo ket noi 
            String sql = "Select * from Employee";
            PreparedStatement ps = connection.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) { 
                Employee e = new Employee(
                        rs.getString(1), 
                        rs.getString(2), 
                        rs.getString(3), 
                        rs.getString(4));
                list.add(e);
            }
            return list;
        } catch (Exception ex) {
            ex.printStackTrace(System.out);
        }
        return null;
    }
    
    public void insertAssign(String eid, int jid){
        try{
            String sql = "insert into JobEmployee(Empid, Jobid) \n" +
                        "values (?, ?);";
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setString(1, eid);
            stm.setInt(2, jid);
            stm.executeUpdate();
        }
        catch(SQLException ex){
            Logger.getLogger(DBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
} 