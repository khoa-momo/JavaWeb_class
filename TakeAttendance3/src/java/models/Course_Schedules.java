/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import java.time.LocalDate;

/**
 *
 * @author DELL
 */
public class Course_Schedules {
    private int teachingScheduleId;
    private int courseId;
    private LocalDate teachingDate;
    private int slot;
    private int roomId;
    private Student student;

    public Course_Schedules() {
    }

    public Course_Schedules(int teachingScheduleId, int courseId, LocalDate teachingDate, int slot, int roomId) {
        this.teachingScheduleId = teachingScheduleId;
        this.courseId = courseId;
        this.teachingDate = teachingDate;
        this.slot = slot;
        this.roomId = roomId;
    }

    public Course_Schedules(int teachingScheduleId, int courseId, LocalDate teachingDate, int slot, int roomId, Student student) {
        this.teachingScheduleId = teachingScheduleId;
        this.courseId = courseId;
        this.teachingDate = teachingDate;
        this.slot = slot;
        this.roomId = roomId;
        this.student = student;
    } 
     
    public int getTeachingScheduleId() {
        return teachingScheduleId;
    }

    public void setTeachingScheduleId(int teachingScheduleId) {
        this.teachingScheduleId = teachingScheduleId;
    }

    public int getCourseId() {
        return courseId;
    }

    public void setCourseId(int courseId) {
        this.courseId = courseId;
    }

    public LocalDate getTeachingDate() {
        return teachingDate;
    }

    public void setTeachingDate(LocalDate teachingDate) {
        this.teachingDate = teachingDate;
    }

    public int getSlot() {
        return slot;
    }

    public void setSlot(int slot) {
        this.slot = slot;
    }

    public int getRoomId() {
        return roomId;
    }

    public void setRoomId(int roomId) {
        this.roomId = roomId;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }
    
    
}
