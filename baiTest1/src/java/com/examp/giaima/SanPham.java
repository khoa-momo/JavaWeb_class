package com.examp.giaima;

/**
 *
 * @author Lonely
 */
public class SanPham {

    private String ID;
    private String name;
    private String company;
    private double price;

    public SanPham(String ID, String name, String company, double price) {
        this.ID = ID;
        this.name = name;
        this.company = company;
        this.price = price;
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

}
