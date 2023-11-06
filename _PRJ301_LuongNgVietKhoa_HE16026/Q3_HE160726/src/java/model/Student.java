/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.sql.Date;
import java.time.LocalDate;

/**
 *
 * @author DELL
 */
public class Student {
    private int studentId;
    private String name;
    private LocalDate date;
    private int gender;
    private String createdby;

    public Student(int studentId, String name, LocalDate date, int gender) {
        this.studentId = studentId;
        this.name = name;
        this.date = date;
        this.gender = gender;
    }

    public Student(String createdby) {
        this.createdby = createdby;
    }

    
    
    public String getCreatedby() {
        return createdby;
    }

    public void setCreatedby(String createdby) {
        this.createdby = createdby;
    }
    

    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public int getGender() {
        return gender;
    }

    public void setGender(int gender) {
        this.gender = gender;
    }

    @Override
    public String toString() {
        return "Student{" + "studentId=" + studentId + ", name=" + name + ", date=" + date + ", gender=" + gender + '}';
    }
        
}
