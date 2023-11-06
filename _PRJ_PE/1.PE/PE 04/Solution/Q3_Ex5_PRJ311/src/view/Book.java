/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

/**
 *
 * @author Tuan Anh
 */
public class Book {
    private String username;
    private String name;
    private String pass;
    private String des;

    public Book() {
    }

    public Book(String username, String name, String pass, String des) {
        this.username = username;
        this.name = name;
        this.pass = pass;
        this.des = des;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public String getDes() {
        return des;
    }

    public void setDes(String des) {
        this.des = des;
    }

    @Override
    public String toString() {
        return "Book{" + "username=" + username + ", name=" + name + ", pass=" + pass + ", des=" + des + '}';
    }
    
}
