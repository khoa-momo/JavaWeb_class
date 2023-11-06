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
import models.Course;
import models.Course_Schedules;
import models.Instructor;
import models.Roll_Call_Books;
import models.Subject;
import models.Student;

/**
 *
 * @author DELL
 */
public class CourseDAO extends DBContext{
    public ArrayList<Subject> getAllSubjects(){
        ArrayList<Subject> list = new ArrayList<>();
        try{
            String sql = "Select distinct s.*\n" +
                        "From SUBJECTS s join COURSES c\n" +
                        "On s.subjectid = c.subjectid";
            PreparedStatement ps = connection.prepareStatement(sql);  
            ResultSet rs = ps.executeQuery();
            while (rs.next()){
                Subject s = new Subject(
                    rs.getInt(1), 
                    rs.getString(2),  
                    rs.getString(3));
                list.add(s);
            }
        }
        catch(SQLException ex){
            Logger.getLogger(DBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }    
    
    
    public ArrayList<Course> getCourseBySubject(int subId){
        ArrayList<Course> list = new ArrayList<>();
        try{
            String sql = "Select s.*, c.* \n" +
                        "From SUBJECTS s join COURSES c\n" +
                        "On s.subjectid = c.subjectid\n" +
                        "Where c.SubjectId = ?";
            PreparedStatement ps = connection.prepareStatement(sql);  
            ps.setInt(1, subId); 
            ResultSet rs = ps.executeQuery();
            while (rs.next()){
                Subject s = new Subject(
                    rs.getInt("SubjectId"), 
                    rs.getString("SubjectCode"),  
                    rs.getString("SubjectName")); 
                Course c = new Course(
                    rs.getInt("courseId"), 
                    rs.getString("courseCode"), 
                    rs.getInt("termId"), 
                    s); 
                list.add(c);
            }
        }
        catch(SQLException ex){
            Logger.getLogger(DBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    } 
    
    //---------getDateByCourse------
    public ArrayList<Course_Schedules> getDateByCourse(int cId){
        ArrayList<Course_Schedules> list = new ArrayList<>();
        try{
            String sql = "Select cs.*\n" +
                        "From COURSES c join COURSE_SCHEDULES cs\n" +
                        "On c.CourseId = cs.CourseId\n" +
                        "Where c.CourseId = ?";
            PreparedStatement ps = connection.prepareStatement(sql);  
            ps.setInt(1, cId); 
            ResultSet rs = ps.executeQuery();
            while (rs.next()){
                Course_Schedules cs = new Course_Schedules(
                    rs.getInt("teachingScheduleId"), 
                    rs.getInt("courseId"),
                    rs.getString("teachingDate"), 
                    rs.getInt("courseId"), 
                    rs.getInt("courseId"));  
                list.add(cs);
            } 
        }
        catch(SQLException ex){
            Logger.getLogger(DBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    } 
    
    //--------
    public ArrayList<Roll_Call_Books> getRollCallByCourse(int cId, String date){
        ArrayList<Roll_Call_Books> list = new ArrayList<>();
        try{
            String sql = "Select rc.*, cs.*, s.*\n" +
                            "From STUDENTS s full join ROLL_CALL_BOOKS rc\n" +
                            "On s.StudentId = rc.StudentId full join COURSE_SCHEDULES cs\n" +
                            "On rc.TeachingScheduleId = cs.TeachingScheduleId \n" +
                            "Where cs.CourseId = ? and TeachingDate like ?";
            PreparedStatement ps = connection.prepareStatement(sql);  
            ps.setInt(1, cId); 
            ps.setString(2, "%"+date+"%"); 
            ResultSet rs = ps.executeQuery();
            while (rs.next()){
                Roll_Call_Books std = new Roll_Call_Books(
                    rs.getInt("rollCallBookId"), 
                    rs.getInt("teachingScheduleId"),  
                    rs.getInt("studentId"), 
                    rs.getInt("isAbsent"),
                    rs.getString("comment"));  
                list.add(std);
            } 
        }
        catch(SQLException ex){
            Logger.getLogger(DBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    } 
    
    
//----------------------------------------------------------------------------------------------    
    public ArrayList<Student> getStudentByCourse(int cId){
        ArrayList<Student> list = new ArrayList<>();
        try{
            String sql = "Select std.*, c.*\n" +
                        "From Courses c join STUDENT_COURSE sc\n" +
                        "On c.Courseid = sc.Courseid join Students std\n" +
                        "On sc.studentid = std.studentid\n" +
                        "Where c.CourseId = ?";
            PreparedStatement ps = connection.prepareStatement(sql);  
            ps.setInt(1, cId); 
            ResultSet rs = ps.executeQuery();
            while (rs.next()){
                Student std = new Student(
                    rs.getInt("courseId"), 
                    rs.getString("Roll#"),  
                    rs.getString("FirstName"), 
                    rs.getString("LastName")); 
                Course c = new Course(
                    rs.getInt("courseId"), 
                    rs.getString("courseCode")); 
                list.add(std);
            } 
        }
        catch(SQLException ex){
            Logger.getLogger(DBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    } 
}
