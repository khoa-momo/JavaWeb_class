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
    private String instructorMName;
    private String instructorFName;

    public Instructor() {
    }

    public Instructor(String instructorLName, String instructorMName, String instructorFName) {
        this.instructorLName = instructorLName;
        this.instructorMName = instructorMName;
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

    public String getInstructorMName() {
        return instructorMName;
    }

    public void setInstructorMName(String instructorMName) {
        this.instructorMName = instructorMName;
    } 

    public String getInstructorFName() {
        return instructorFName;
    }

    public void setInstructorFName(String instructorFName) {
        this.instructorFName = instructorFName;
    }
    
    public String getFulltName() {
        if (instructorMName==null) {
            instructorMName = "";
        }
        return instructorLName+" "+instructorMName+" "+instructorFName;
    }
    
}
