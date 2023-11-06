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
public class Shipper {
    private int shipperId;
    private String companyName;

    public Shipper() {
    }

    public Shipper(int shipperId, String companyName) {
        this.shipperId = shipperId;
        this.companyName = companyName;
    }

    public Shipper(int shipperId) {
        this.shipperId = shipperId; 
    }

    public int getShipperId() {
        return shipperId;
    }

    public void setShipperId(int shipperId) {
        this.shipperId = shipperId;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    @Override
    public String toString() {
        return "Shipper{" + "shipperId=" + shipperId + ", companyName=" + companyName + '}';
    }
}
