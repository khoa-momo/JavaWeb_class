/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Myjava;

import java.io.Serializable;

/**
 *
 * @author DELL
 */
public class Student implements Serializable{
    private String roll;
    private String name;
    private String phone;
    private String email;

    public Student() {
    }

    public Student(String roll, String name, String phone, String email) {
        this.roll = roll;
        this.name = name;
        this.phone = phone;
        this.email = email;
    }

    public String getRoll() {
        return roll;
    }

    public void setRoll(String roll) {
        this.roll = roll;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    
    
}
