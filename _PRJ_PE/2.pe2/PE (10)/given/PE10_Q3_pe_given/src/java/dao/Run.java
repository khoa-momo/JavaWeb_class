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
import models.Certificate;
import models.Employee; 

/**
 *
 * @author DELL
 */
public class Run { 
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);  
        DAO empdao = new DAO();
        
//        List<Department> deptlist = departmentDAO.getAllDepartments();
//        for (Department dept : deptlist) {
//            System.out.println(dept);
//        }
//        System.out.println("---------------------");
//        List<Job> emplist = empdao.getJobsByeid("EMP01");
//        for (Job emps : emplist) {
//            System.out.println(emps);
//        }
        
//        List<Certificate> emplist2 = empdao.getAllCert();
//        for (Certificate emps : emplist2) {
//            System.out.println(emps);
//        } 
        List<Employee> emplist3 = empdao.getAllEmpNN();
        for (Employee emps : emplist3) {
            System.out.println(emps);
        }
//        List<Certificate> listC = empdao.getCertificatesByeid(1001);
//        System.out.println(listC);
//        
//        List<Certificate> listC2 = empdao.getAllCert();
//        System.out.println(listC2);
//        List<Employee> emplist2 = empdao.getAllEmp(1);
//        for (Employee emps : emplist2) {
//            System.out.println(emps);
//        }


//        System.out.println("---------------------");
//        Department dept0 = departmentDAO.getDepartmentBy1();
//        System.out.println(dept0.toString());
         
    }
}
