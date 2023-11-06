/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import java.util.List;

/**
 *
 * @author DELL
 */
public class Employee {
    private String empID;
    private String fullName;
    private String hireDate;
    private String city; 
    private int isemp; 
//    private List<Skill> listSkills; 
    
    public Employee(String empID, String fullName, String hireDate, String city) {
        this.empID = empID;
        this.fullName = fullName;
        this.hireDate = hireDate;
        this.city = city;
    }

    public Employee(String empID, String fullName, String hireDate, String city, int isemp) {
        this.empID = empID;
        this.fullName = fullName;
        this.hireDate = hireDate;
        this.city = city;
        this.isemp = isemp;
    } 
    
    public String getEmpID() {
        return empID;
    }

    public void setEmpID(String empID) {
        this.empID = empID;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getHireDate() {
        return hireDate;
    }

    public void setHireDate(String hireDate) {
        this.hireDate = hireDate;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    } 

    public int getIsemp() {
        return isemp;
    }

    public void setIsemp(int isemp) {
        this.isemp = isemp;
    }

    @Override
    public String toString() {
        return "Employee{" + "empID=" + empID + ", fullName=" + fullName + ", hireDate=" + hireDate + ", city=" + city + ", isemp=" + isemp + '}';
    }

    
    
    
    
    
}
