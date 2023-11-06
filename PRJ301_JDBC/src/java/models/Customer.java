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
public class Customer {
    private int ID;
    private String LastName;
    private String FirstName;
    private int Sex;
    private String state;

    public Customer() {
    }

    public Customer(int ID, String LastName, String FirstName, int Sex, String state) {
        this.ID = ID;
        this.LastName = LastName;
        this.FirstName = FirstName;
        this.Sex = Sex;
        this.state = state;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getLastName() {
        return LastName;
    }

    public void setLastName(String LastName) {
        this.LastName = LastName;
    }

    public String getFirstName() {
        return FirstName;
    }

    public void setFirstName(String FirstName) {
        this.FirstName = FirstName;
    }

    public int getSex() {
        return Sex;
    }

    public void setSex(int Sex) {
        this.Sex = Sex;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }
    
    
}
