/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dal;

import java.sql.Connection;

/**
 *
 * @author DELL
 */
public class DBContext {
    protected Connection connection;
    public DBContext(){
        try {
           String url="jdbc:sqlserver:(local):1433;databaseName="; 
        } catch (Exception e) {
         
        }
    }
    
}
