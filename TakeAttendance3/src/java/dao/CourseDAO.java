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
import java.sql.Statement;
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
    
    //------------------------get all subject--------------------------
    public ArrayList<Subject> getAllSubjects(){
        ArrayList<Subject> list = new ArrayList<>();
        try{
            String sql = "Select distinct s.*\n" +
                        "From SUBJECTS s full join COURSES c\n" +
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
    
    public ArrayList<Subject> getSubjectByName(String code){
        ArrayList<Subject> list = new ArrayList<>();
        try{
            String sql = "Select distinct s.*\n" +
                        "From SUBJECTS s full join COURSES c\n" +
                        "On s.subjectid = c.subjectid\n" +
                        "Where s.SubjectCode like ?";
            PreparedStatement ps = connection.prepareStatement(sql); 
            ps.setString(1, "%"+code+"%"); 
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
    
    //---------------------------------getCourseBySubject-------------------------------
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
                        "Where c.CourseId = ?\n" +
                        "Order by cs.TeachingDate, slot";
            PreparedStatement ps = connection.prepareStatement(sql);  
            ps.setInt(1, cId); 
            ResultSet rs = ps.executeQuery();
            while (rs.next()){
                Course_Schedules cs = new Course_Schedules(
                    rs.getInt("teachingScheduleId"), 
                    rs.getInt("courseId"),
                    rs.getDate("teachingDate").toLocalDate(), 
                    rs.getInt("slot"), 
                    rs.getInt("roomId"));  
                list.add(cs);
            } 
        }
        catch(SQLException ex){
            Logger.getLogger(DBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    } 
    
    //------------------------------------------------------------------------------
    public ArrayList<Course_Schedules> getSlot(){//not used
        ArrayList<Course_Schedules> list = new ArrayList<>();
        try{
            String sql = "Select distinct cs.slot\n" +
                        "From COURSES c join COURSE_SCHEDULES cs \n" +
                        "On c.CourseId = cs.CourseId";
            PreparedStatement ps = connection.prepareStatement(sql);   
            ResultSet rs = ps.executeQuery();
            while (rs.next()){
                Course_Schedules cs = new Course_Schedules(
                    rs.getInt("teachingScheduleId"), 
                    rs.getInt("courseId"),
                    rs.getDate("teachingDate").toLocalDate(), 
                    rs.getInt("slot"), 
                    rs.getInt("roomId"));  
                list.add(cs);
            } 
        }
        catch(SQLException ex){
            Logger.getLogger(DBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    } 
    
    
    //-----------------------------------------------------------------------------------------
    public ArrayList<Roll_Call_Books> getRollCallByCourse(int cId, String date, int slot){
        ArrayList<Roll_Call_Books> list = new ArrayList<>();
        try{
            String sql = "Select rc.*, cs.*, s.*\n" +
                        "From STUDENTS s full join ROLL_CALL_BOOKS rc\n" +
                        "On s.StudentId = rc.StudentId full join COURSE_SCHEDULES cs\n" +
                        "On rc.TeachingScheduleId = cs.TeachingScheduleId \n" +
                        "Where cs.CourseId = ? and TeachingDate like ? and slot = ?";
            PreparedStatement ps = connection.prepareStatement(sql);  
            ps.setInt(1, cId); 
            ps.setString(2, "%"+date+"%"); 
            ps.setInt(3, slot); 
            ResultSet rs = ps.executeQuery();
            while (rs.next()){
                Student s = new Student(
                    rs.getInt("studentId"),  
                    rs.getString("roll#"), 
                    rs.getString("firstName"), 
                    rs.getString("midName"), 
                    rs.getString("lastName"));
                Roll_Call_Books std = new Roll_Call_Books(
                    rs.getInt("rollCallBookId"), 
                    rs.getInt("teachingScheduleId"),  
                    rs.getInt("studentId"), 
                    rs.getInt("isAbsent"),
                    rs.getString("comment"),
                    s);  
                list.add(std);
            } 
        }
        catch(SQLException ex){
            Logger.getLogger(DBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }  
     
    
    //update 
    public void updateRollCall(int rollcallId, int abbsent, String comment){
        try{ 
            String sql = "UPDATE ROLL_CALL_BOOKS\n" +
                        "SET IsAbsent = ?, comment = ?\n" +
                        "WHERE RollCallBookId = ?";
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setInt(1, abbsent);
            stm.setString(2, comment); 
            stm.setInt(3, rollcallId); 
           
            stm.executeUpdate();
        }
        catch(SQLException ex){
            Logger.getLogger(DBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    //insert
    public void InsertRollCall(int TeachingScheduleId, int StudentId, int IsAbsent, String comment){
        try{
            String sql = "insert into ROLL_CALL_BOOKS(TeachingScheduleId, StudentId, IsAbsent, Comment) values (?, ?, ?, ?)";
            PreparedStatement ps = connection.prepareStatement(sql); 
            ps.setInt(1, TeachingScheduleId);
            ps.setInt(2, StudentId);
            ps.setInt(3, IsAbsent);  
            ps.setString(4, comment);  
            ps.executeUpdate(); 
        }
        catch(SQLException ex){
            Logger.getLogger(DBContext.class.getName()).log(Level.SEVERE, null, ex);
        } 
    }
    
    //Student list for insert
    public ArrayList<Course_Schedules> getStudentByCourse(int cId, String date, int slot){//Student
        ArrayList<Course_Schedules> list = new ArrayList<>();
        try{
            String sql = "Select  s.*, cs.*, c.SubjectId\n" +
                        "From COURSE_SCHEDULES cs join COURSES c\n" +
                        "On cs.CourseId = c.CourseId join STUDENT_COURSE sc\n" +
                        "On c.CourseId = sc.CourseId join STUDENTS s\n" +
                        "On sc.StudentId = s.StudentId\n" +
                        "Where c.CourseId = ? and cs.TeachingDate like ? and slot = ?\n" +
                        "Order by cs.TeachingDate";
            PreparedStatement ps = connection.prepareStatement(sql);   
            ps.setInt(1, cId); 
            ps.setString(2, "%"+date+"%"); 
            ps.setInt(3, slot); 
            ResultSet rs = ps.executeQuery();
            while (rs.next()){
                Student s = new Student(
                    rs.getInt("studentId"),  
                    rs.getString("roll#"), 
                    rs.getString("firstName"), 
                    rs.getString("midName"), 
                    rs.getString("lastName"));
                Course_Schedules cs = new Course_Schedules(
                    rs.getInt("teachingScheduleId"), 
                    rs.getInt("courseId"),
                    rs.getDate("teachingDate").toLocalDate(), 
                    rs.getInt("slot"), 
                    rs.getInt("roomId"),
                    s);  
                list.add(cs); 
            } 
        }
        catch(SQLException ex){
            Logger.getLogger(DBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }  
    
//----------------------------------------------------------------------------------------------     
    
    public ArrayList<Student> getAllStudent(){
        ArrayList<Student> list = new ArrayList<>();
        try{
            String sql = "Select * From STUDENTS";
            PreparedStatement ps = connection.prepareStatement(sql);   
            ResultSet rs = ps.executeQuery();
            while (rs.next()){
                Student std = new Student(
                    rs.getInt("studentId"), 
                    rs.getString("Roll#"),  
                    rs.getString("FirstName"), 
                    rs.getString("MidName"), 
                    rs.getString("LastName")); 
                list.add(std);
            } 
        }
        catch(SQLException ex){
            Logger.getLogger(DBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    } 
      
    public int insertCourses(String courseCode, String courseDes, int subid, int inid, int teid, int campid){
        try{
            String sql = "Insert into COURSES(CourseCode, CourseDescription, Subjectid, Instructorid, Termid, CampusID)\n"
                    + "values (?,?,?,?,?,?)";
            PreparedStatement ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, courseCode);
            ps.setString(2, courseDes);
            ps.setInt(3, subid);
            ps.setInt(4, inid);
            ps.setInt(5, teid);
            ps.setInt(6, campid); 
            ps.executeUpdate();
            ResultSet rs = ps.getGeneratedKeys();
            if (rs.next()){
                int courseid = Integer.parseInt(rs.getString(1));
                return courseid;
            }
        }
        catch(SQLException ex){
            Logger.getLogger(DBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return -1;
    }
     
    
    public void insertStudent_Courses(int CourseId, String Studentid){
        try{
            String sql = "Insert into STUDENT_COURSE(CourseId, Studentid)\n" +
                        "values (?,?)";
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setInt(1, CourseId);
            stm.setString(2, Studentid); 
            stm.executeUpdate();
        }
        catch(SQLException ex){
            Logger.getLogger(DBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
    } 
    
    
    public ArrayList<Student> getSessionStudent(List<String> Ids){
        String studentStr = Ids.toString();
//        studentStr = '(' + studentStr.substring(1);
        studentStr = '(' + studentStr.substring(1, studentStr.length()-1) + ')';
        ArrayList<Student> list = new ArrayList<>();
        try{
            String sql = "Select * From STUDENTS s\n" +
                        "Where s.StudentId in "+studentStr;
            PreparedStatement ps = connection.prepareStatement(sql);   
            ResultSet rs = ps.executeQuery();
            while (rs.next()){
                Student std = new Student(
                    rs.getInt("studentId"), 
                    rs.getString("Roll#"),  
                    rs.getString("FirstName"), 
                    rs.getString("MidName"), 
                    rs.getString("LastName")); 
                list.add(std);
            }
        }
        catch(SQLException ex){
            Logger.getLogger(DBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }
    

    
//------------------------------------------For small util----------------------------------------
    public String getCourseName(int cId){ 
        try{
            String sql = "Select CourseCode\n" +
                        "From COURSES\n" +
                        "Where CourseId = ?";
            PreparedStatement ps = connection.prepareStatement(sql);  
            ps.setInt(1, cId); 
            ResultSet rs = ps.executeQuery();
            while (rs.next()){  
                String courseCode = rs.getString(1);
                return courseCode;
            } 
        }
        catch(SQLException ex){
            Logger.getLogger(DBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    } 
    
    public Instructor getInstructorName(int code){ 
        try{
            String sql = "Select i.*\n" +
                        "From INSTRUCTORS i\n" +
                        "Where i.InstructorId = ?";
            PreparedStatement ps = connection.prepareStatement(sql); 
            ps.setInt(1, code); 
            ResultSet rs = ps.executeQuery();
            while (rs.next()){
                Instructor i = new Instructor(
                    rs.getString("InstructorLastName"), 
                    rs.getString("InstructorMidName"),  
                    rs.getString("InstructorFirstName"));
                return i;
            }
        }
        catch(SQLException ex){
            Logger.getLogger(DBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }    
    
    public String getSubjectNameById(int code){
        ArrayList<Subject> list = new ArrayList<>();
        try{
            String sql = "Select * From SUBJECTS s\n" +
                        "Where s.SubjectId = ?";
            PreparedStatement ps = connection.prepareStatement(sql); 
            ps.setInt(1, code); 
            ResultSet rs = ps.executeQuery();
            while (rs.next()){
                String subName = rs.getString("SubjectName"); 
                return subName; 
            } 
        }
        catch(SQLException ex){
            Logger.getLogger(DBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    
    //-----------------------------test
    public ArrayList<Student> getStudentByCourseTest(int cId){//Student
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
                Student s = new Student(
                    rs.getInt("studentId"),  
                    rs.getString("roll#"), 
                    rs.getString("firstName"), 
                    rs.getString("midName"), 
                    rs.getString("lastName")); 
                list.add(s); 
            } 
        }
        catch(SQLException ex){
            Logger.getLogger(DBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }  
}
