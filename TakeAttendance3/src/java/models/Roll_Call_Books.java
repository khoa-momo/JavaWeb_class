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
public class Roll_Call_Books {
    private int rollCallBookId;
    private int teachingScheduleId;
    private int studentId;
    private int isAbsent;
    private String comment; 
    //
    private Student student;
    
    public Roll_Call_Books() {
    }
    
    public Roll_Call_Books(int rollCallBookId, int teachingScheduleId, int studentId, int isAbsent, String comment, Student student) {
        this.rollCallBookId = rollCallBookId;
        this.teachingScheduleId = teachingScheduleId;
        this.studentId = studentId;
        this.isAbsent = isAbsent;
        this.comment = comment;
        this.student = student;
    }

    public Roll_Call_Books(int rollCallBookId, int teachingScheduleId, int studentId, int isAbsent, String comment) {
        this.rollCallBookId = rollCallBookId;
        this.teachingScheduleId = teachingScheduleId;
        this.studentId = studentId;
        this.isAbsent = isAbsent;
        this.comment = comment;
    }

    public int getRollCallBookId() {
        return rollCallBookId;
    }

    public void setRollCallBookId(int rollCallBookId) {
        this.rollCallBookId = rollCallBookId;
    }

    public int getTeachingScheduleId() {
        return teachingScheduleId;
    }

    public void setTeachingScheduleId(int teachingScheduleId) {
        this.teachingScheduleId = teachingScheduleId;
    }

    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public int getIsAbsent() {
        return isAbsent;
    }

    public void setIsAbsent(int isAbsent) {
        this.isAbsent = isAbsent;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    
    
    @Override
    public String toString() {
        return "Roll_Call_Books{" + "rollCallBookId=" + rollCallBookId + ", teachingScheduleId=" + teachingScheduleId + ", studentId=" + studentId + ", isAbsent=" + isAbsent + ", comment=" + comment + '}';
    }
 
    
    
}
