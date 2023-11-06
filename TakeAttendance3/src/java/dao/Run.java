/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;
import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.text.SimpleDateFormat;
import java.time.LocalDate; 

import java.time.ZoneId;
import java.util.Date;
import java.util.List;
import java.util.Scanner; 
import models.Course; 
import models.Roll_Call_Books;
import models.Student;
import models.Subject;

/**
 *
 * @author DELL
 */
public class Run { //for checking log
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in); 
        CourseDAO dao = new CourseDAO();  
        
//        List<Product> olist = dao.getAllProducts();
//        for (Product list : olist) {
//            System.out.println(list);
//        }
//        System.out.println("---------------------");
        
//        List<Course> olist2 = dao.getCourseBySubject(225);
//        for (Course list2 : olist2) {
//            System.out.println(list2);
//        }
//        System.out.println("---------------------");  
//        String date = "2011-07-26";
        
//        List<Roll_Call_Books> olist3 = dao.getRollCallByCourse(1, date, 3); //id, date, slot
//        for (Roll_Call_Books list3 : olist3) {
//            System.out.println(list3);
//        }
//        System.out.println("---------------------");
        
//        ArrayList<Student> olist4 = dao.getStudentByCourse(4);
//        for (Student list3 : olist4) {
//            System.out.println(list3);
//        }
//        System.out.println("---------------------"); 
        
//        String code = dao.getCourseName(1);
//        System.out.println("code: "+code);
        
        ArrayList<Subject> olist5 = dao.getSubjectByName("CF");
        for (Subject list3 : olist5) {
            System.out.println(list3);
        }
        System.out.println("---------------------"); 
        
        int cid = dao.insertCourses("SE1610", "SE1610",225, 4, 4, 1);
        System.out.println("cid: "+cid);
    }
}
