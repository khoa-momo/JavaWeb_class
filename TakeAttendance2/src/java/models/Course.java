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
public class Course {
    private int courseId;
    private String code;
    private int termId; 
    private Subject subject;
    private Instructor instructor; 
    
    public Course() {
    }

    public Course(int courseId, String code, int termId, Subject subject, Instructor instructor) {
        this.courseId = courseId;
        this.code = code;
        this.termId = termId;
        this.subject = subject;
        this.instructor = instructor;
    }

    public Course(int courseId, String code, int termId, Subject subject) {
        this.courseId = courseId;
        this.code = code;
        this.termId = termId;
        this.subject = subject;
    }

    public Course(int courseId, String code) {
        this.courseId = courseId;
        this.code = code;
    }

    public int getCourseId() {
        return courseId;
    }

    public void setCourseId(int courseId) {
        this.courseId = courseId;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public int getTermId() {
        return termId;
    }

    public void setTermId(int termId) {
        this.termId = termId;
    }

    public Subject getSubject() {
        return subject;
    }

    public void setSubject(Subject subject) {
        this.subject = subject;
    }

    public Instructor getInstructor() {
        return instructor;
    }

    public void setInstructor(Instructor instructor) {
        this.instructor = instructor;
    }

    @Override
    public String toString() {
        return "Course{" + "courseId=" + courseId + ", code=" + code + ", termId=" + termId + ", subject=" + subject + ", instructor=" + instructor + '}';
    }

    
    

    
    
    
}
