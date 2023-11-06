/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import java.time.LocalDate;
import java.util.List;

/**
 *
 * @author DELL
 */
public class Employee {
    private int id;
    private String name;
//    private int isCer;
    private List<Integer> isCer;
    private List<Certificate> listCers;

    public Employee(int id, String name, List<Integer> isCer, List<Certificate> listCers) {
        this.id = id;
        this.name = name;
        this.isCer = isCer;
        this.listCers = listCers;
    }

    public List<Integer> getIsCer() {
        return isCer;
    }

    public void setIsCer(List<Integer> isCer) {
        this.isCer = isCer;
    }
 
    

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    } 

    public List<Certificate> getListCers() {
        return listCers;
    }

    public void setListCers(List<Certificate> listCers) {
        this.listCers = listCers;
    }

    @Override
    public String toString() {
        return "Employee{" + "id=" + id + ", name=" + name + ", isCer=" + isCer + ", listCers=" + listCers + '}';
    }
 
    
    
    
}
