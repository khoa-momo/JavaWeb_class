/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import models.Department;
import models.Student;

/**
 *
 * @author DELL
 */
public class StudentDAO {
    public List<Student> getAllStudents() {
        List<Student> list = new ArrayList<>();
        try {
            String sql = "Select s.*, d.dname\n" +
                        "From Students s join Departments d\n" +
                        "On s.did = d.did";
            Connection conn = new DBContext().getConnection(); 
            PreparedStatement ps = conn.prepareStatement(sql); 
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Department department = Department.builder()
                        .did(rs.getInt("did"))
                        .dname(rs.getString("dname")).build(); 
                Student student = Student.builder()
                        .sid(rs.getInt(1))
                        .sname(rs.getString(2))
                        .dob(rs.getDate(3).toLocalDate())
                        .gender(rs.getInt(4))
                        .department(department).build(); 
                list.add(student);
            }
        } catch (Exception ex) {
            Logger.getLogger(StudentDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }
    
    public List<Student> getStudentByDept(int did) {
        List<Student> list = new ArrayList<>();
        try {
            String sql = "Select s.*, d.dname\n" +
                        "From Students s join Departments d\n" +
                        "On s.did = d.did\n" +
                        "Where s.did = ?";
            Connection conn = new DBContext().getConnection(); 
            PreparedStatement ps = conn.prepareStatement(sql); 
            ps.setInt(1, did);
            ResultSet rs = ps.executeQuery(); 
            while (rs.next()) {
                Department department = Department.builder()
                        .did(rs.getInt("did"))
                        .dname(rs.getString("dname")).build(); 
                Student student = Student.builder()
                        .sid(rs.getInt(1))
                        .sname(rs.getString(2))
                        .dob(rs.getDate(3).toLocalDate())
                        .gender(rs.getInt(4))
                        .department(department).build(); 
                list.add(student);
            }
        } catch (Exception ex) {
            Logger.getLogger(StudentDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }
}
