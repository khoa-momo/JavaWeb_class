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
    private String courseCode;
    private String courseDes;
 
    private int termId; 
    private Subject subject;
    private Instructor instructor;  
    
    private String subjectname;
    
    public Course() {
    }

    public Course(String courseCode, String courseDes, int termId, Subject subject, Instructor instructor) {
        this.courseCode = courseCode;
        this.courseDes = courseDes;
        this.termId = termId;
        this.subject = subject;
        this.instructor = instructor;
    }
    
     public Course(String courseCode, String courseDes, int termId, String subjectname, Instructor instructor) {
        this.courseCode = courseCode;
        this.courseDes = courseDes;
        this.termId = termId;
        this.subjectname = subjectname;
        this.instructor = instructor;
    }

    
    public Course(int courseId, String courseCode, int termId, Subject subject, Instructor instructor) {
        this.courseId = courseId;
        this.courseCode = courseCode;
        this.termId = termId;
        this.subject = subject;
        this.instructor = instructor;
    }

    public Course(int courseId, String courseCode, int termId, Subject subject) {
        this.courseId = courseId;
        this.courseCode = courseCode;
        this.termId = termId;
        this.subject = subject;
    }

    public Course(int courseId, String courseCode) {
        this.courseId = courseId;
        this.courseCode = courseCode;
    }

    public int getCourseId() {
        return courseId;
    }

    public void setCourseId(int courseId) {
        this.courseId = courseId;
    }

    public String getCourseCode() {
        return courseCode;
    }

    public void setCourseCode(String courseCode) {
        this.courseCode = courseCode;
    }

    public String getCourseDes() {
        return courseDes;
    }

    public void setCourseDes(String courseDes) {
        this.courseDes = courseDes;
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
    
    public String getSubjectname() {
        return subjectname;
    }

    //==================
    public void setSubjectname(String subjectname) {    
        this.subjectname = subjectname;
    }

    @Override
    public String toString() {
        return "Course{" + "courseId=" + courseId + ", courseCode=" + courseCode + ", termId=" + termId + ", subject=" + subject + ", instructor=" + instructor + '}';
    }

    
    

    
    
    
}
