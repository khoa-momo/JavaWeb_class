/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.text.SimpleDateFormat;
import java.time.LocalDate; 

import java.time.ZoneId;
import java.util.Date;
import java.util.List;
import java.util.Scanner;
import models.Department;
import models.Student;

/**
 *
 * @author DELL
 */
public class Run {
    private static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    public static Date checkDate(String msg, String err, String format, String ignore) {
        while (true) {
            try {
                System.out.println(msg);
                String str = in.readLine();
                if (ignore != null && str != null && str.trim().equals(ignore)) {
                    return null;
                }
                SimpleDateFormat sdf = new SimpleDateFormat(format);
                sdf.setLenient(false);
                Date date = sdf.parse(str);
                return date;
            } catch (Exception e) {
                System.out.println(err);
            }
        }
    }
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in); 
        StudentDAO studentDAODAO = new StudentDAO();
//        EmployeeDAO empdao = new EmployeeDAO();
        
        List<Student> slist = studentDAODAO.getAllStudents();
        for (Student list : slist) {
            System.out.println(list);
        }
        System.out.println("---------------------");
//        List<Employee> emplist = empdao.getAllEmployeesByDeptId(1);
//        for (Employee emps : emplist) {
//            System.out.println(emps);
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
         
        String empname;
        String sex;
        String position;
        Date dob1;
        Date dob2;
        int depid; 
            
        System.out.print("name: ");
        empname = sc.nextLine();       
        System.out.print("sex: ");
        sex = sc.nextLine();      
        System.out.print("position: ");
        position = sc.nextLine();    
        
        dob1 = checkDate("Enter dob1: ", "DOB invalid", "yyyy-MM-dd", null); 
        dob2 = checkDate("Enter dob2: ", "DOB invalid", "yyyy-MM-dd", null); 
        
        System.out.print("depid: ");
        depid = sc.nextInt();       
            
//        Date input = new Date();
        LocalDate dateFrom = dob1.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        LocalDate dateTo = dob2.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();

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
