/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import java.sql.Date; 

/**
 *
 * @author Dell
 */
public class Employee extends Department{
    private int id;
    private String name;
    private Date dob;
    private String sex;  
    private Department department;

    public Employee(int id, String name, Date dob, String sex) {
        this.id = id;
        this.name = name;
        this.dob = dob;
        this.sex = sex; 
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public Date getDob() {
        return dob;
    }
    public void setDob(Date dob) {
        this.dob = dob;
    }
    public String getSex() {
        return sex;
    }
    public void setSex(String sex) {
        this.sex = sex;
    }

    public Department getDepartment() {
        return department;
    }
    public void setDepartment(Department department) {
        this.department = department;
    }
    
    
    public void addDepartment1(int id){
        Department d = new Department(id);
        this.department = d;
    }
    public void addDepartment(int id, String deptName){
        Department d = new Department(id, deptName);
        this.department = d;
    }

    
}
