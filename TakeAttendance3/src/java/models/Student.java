/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

/**
 *
 * @author DELL
 */
public class Student {
    private int studentId;
    private String roll;
    private String firstName;
    private String midName; 
    private String lastName;

    public Student() {
    }

    public Student(int studentId, String roll, String firstName, String midName, String lastName) {
        this.studentId = studentId;
        this.roll = roll;
        this.firstName = firstName;
        this.midName = midName;
        this.lastName = lastName;
    }
 

    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public String getRoll() {
        return roll;
    }

    public void setRoll(String roll) {
        this.roll = roll;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    
    public String getMidName() {
        return midName;
    }

    public void setMidName(String midName) {
        this.midName = midName;
    }
    
    public String getFulltName() {
        if (midName==null) {
            midName = "";
        }
        return lastName+" "+midName+" "+firstName;
    }

    @Override
    public String toString() {
        return "Student{" + "studentId=" + studentId + ", roll=" + roll + ", firstName=" + firstName + ", midName=" + midName + ", lastName=" + lastName + '}';
    }

    
}
