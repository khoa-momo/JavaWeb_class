/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models; 
import java.util.Date; 

/**
 *
 * @author DELL
 */
public class Job {
    private int jobId;
    private String name;
    private String salary;
    private Date dateCreated;
    private String activate;  

    public Job(int jobId, String name, String salary, Date dateCreated, String activate) {
        this.jobId = jobId;
        this.name = name;
        this.salary = salary;
        this.dateCreated = dateCreated;
        this.activate = activate;
    }

    public Job(int jobId) {
        this.jobId = jobId;
    }
    
    
     
    public int getJobId() {
        return jobId;
    }

    public void setJobId(int jobId) {
        this.jobId = jobId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSalary() {
        return salary;
    }

    public void setSalary(String salary) {
        this.salary = salary;
    }

    public Date getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(Date dateCreated) {
        this.dateCreated = dateCreated;
    }

    

    public String getActivate() {
        return activate;
    }

    public void setActivate(String activate) {
        this.activate = activate;
    }

    @Override
    public String toString() {
        return "Job{" + "jobId=" + jobId + ", name=" + name + ", salary=" + salary + ", dateCreated=" + dateCreated + ", activate=" + activate + '}';
    }
 
    
    
}
