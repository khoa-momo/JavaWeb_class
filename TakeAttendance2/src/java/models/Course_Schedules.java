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
    private String teachingDate;
    private int slot;
    private int roomId;

    public Course_Schedules() {
    }

    public Course_Schedules(int teachingScheduleId, int courseId, String teachingDate, int slot, int room) {
        this.teachingScheduleId = teachingScheduleId;
        this.courseId = courseId;
        this.teachingDate = teachingDate;
        this.slot = slot;
        this.roomId = room;
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

    public String getTeachingDate() {
        return teachingDate;
    }

    public void setTeachingDate(String teachingDate) {
        this.teachingDate = teachingDate;
    }

    public int getSlot() {
        return slot;
    }

    public void setSlot(int slot) {
        this.slot = slot;
    }

    public int getRoom() {
        return roomId;
    }

    public void setRoom(int room) {
        this.roomId = room;
    }
    
    
}
