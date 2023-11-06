/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dal;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import models.Customer;

/**
 *
 * @author DELL
 */ 
public class CustomerDAO extends DBConnect{ 
    
    public ArrayList<Customer> getAllCustomer(){
        ArrayList<Customer> cuslist = new ArrayList<>();
        try{
            String sql = "Select ID, LastName, FirstName, Sex, from Customer";
            PreparedStatement stm = connection.prepareStatement(sql);
            ResultSet rs = stm.executeQuery();
            while(rs.next()){
                Customer c = new Customer(
                    rs.getInt("ID"), 
                    rs.getString("LastName"),
                    rs.getString("FirstName"),
                    rs.getInt("Sex"),
                    rs.getString("state"));
                cuslist.add(c);
            }
        }catch(Exception ex){
            Logger.getLogger(DBConnect.class.getName()).log(Level.SEVERE, null, ex);
        }
        return cuslist;
    } 
}