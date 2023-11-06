/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dal;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.text.SimpleDateFormat;
import java.time.LocalDate; 

import java.time.ZoneId;
import java.util.Date;
import java.util.List;
import java.util.Scanner;
import model.Skill; 
import model.Student;

/**
 *
 * @author DELL
 */
public class Run { 
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in); 
        DAO dao = new DAO(); 
        
//        Student s = dao.getSCreated("10001");
//        System.out.println("s: "+s);
//        String ss = s.getCreatedby();
//        System.out.println("ss "+ss);
//        List<Skill> deptlist = dao.getAllSkill();
//        for (Skill dept : deptlist) {
//            System.out.println(dept);
//        } 
//        
//        System.out.println("---------------------");
//        Department dept0 = departmentDAO.getDepartmentBy1();
//        System.out.println(dept0.toString());
        
    
//        Employee emp1 = empdao.getEmployeeByIdNoName(empid);
//        System.out.println(emp1.toString());
//        System.out.println(emp1.Empdisplay());

//        Employee emp2 = empdao.getEmployeeById(empid);
//        System.out.println(emp2.toString());
         
          

//        System.out.print(empname+" "+date+" "+sex+" "+position);
//        Employee e = new Employee(0, empname, date, sex, position);
//        e.setDepartment(new Department(depid)); 
//        empdao.updateEmployee(e, empid);
        
//        System.out.println("---------------------");
//        System.out.print("Enter empid: ");
//        int empid = sc.nextInt(); 
        
//        List<Employee> emplistFillter = empdao.getEmployeesByFillter(empname, dateFrom, dateTo, sex, position, depid);
//        for (Employee efillter : emplistFillter) {
//            System.out.println(efillter);
//        }
//        System.out.println("---------------------");


//        List<Employee> emplistFillter = empdao.getEmployeesByFillter2(empname, dob1, dob2, sex, position, depid);
//        List<Employee> emplistFillter = empdao.getEmployeesByFillter2(empname, dob1, dob2, sex, position, depid);
//        for (Employee efillter : emplistFillter) {
//            System.out.println(efillter);
//        }
//        System.out.println("---------------------");
        
//        
//        List<Employee> emplistFillter2 = empdao.getAllEmployeesByName(empname, date, sex, position);
//        for (Employee efillter : emplistFillter2) {
//            System.out.println(efillter);
//        }
//        System.out.println("---------------------");
        
//        List<Employee> emplistFillter3 = empdao.getEmployeesByFillter1(empname, sex, position, depid);
//        for (Employee efillter : emplistFillter3) {
//            System.out.println(efillter);
//        }
//        System.out.println("---------------------");
    }
}
