/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

/**
 *
 * @author Tuan Anh
 */
public class ProjectMemberr {
    private int projectID;
    private String employeeID;
    private boolean isFullTime;
    private int hours;

    public ProjectMemberr() {
    }

    public ProjectMemberr(int projectID, String employeeID, boolean isFullTime, int hours) {
        this.projectID = projectID;
        this.employeeID = employeeID;
        this.isFullTime = isFullTime;
        this.hours = hours;
    }

    public int getProjectID() {
        return projectID;
    }

    public void setProjectID(int projectID) {
        this.projectID = projectID;
    }

    public String getEmployeeID() {
        return employeeID;
    }

    public void setEmployeeID(String employeeID) {
        this.employeeID = employeeID;
    }

    public boolean isIsFullTime() {
        return isFullTime;
    }

    public void setIsFullTime(boolean isFullTime) {
        this.isFullTime = isFullTime;
    }

    public int getHours() {
        return hours;
    }

    public void setHours(int hours) {
        this.hours = hours;
    }
    
    
}
