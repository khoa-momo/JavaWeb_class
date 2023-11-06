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
public class Instructor {
    private int instructorId;
    private String instructorLName;
    private String instructorFName;

    public Instructor() {
    }

    public Instructor(int instructorId, String instructorLName, String instructorFName) {
        this.instructorId = instructorId;
        this.instructorLName = instructorLName;
        this.instructorFName = instructorFName;
    }

    public int getInstructorId() {
        return instructorId;
    }

    public void setInstructorId(int instructorId) {
        this.instructorId = instructorId;
    }

    public String getInstructorLName() {
        return instructorLName;
    }

    public void setInstructorLName(String instructorLName) {
        this.instructorLName = instructorLName;
    }

    public String getInstructorFName() {
        return instructorFName;
    }

    public void setInstructorFName(String instructorFName) {
        this.instructorFName = instructorFName;
    }
    
    
}
