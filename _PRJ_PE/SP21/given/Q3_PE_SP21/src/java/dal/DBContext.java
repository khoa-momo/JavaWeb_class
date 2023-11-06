/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dal;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author area1
 */
public class DBContext {

    protected Connection connection;

    public DBContext() {   
        try {
            String user = "khoa";
            String password = "123";
            String url = "jdbc:sqlserver://DESKTOP-GLQH2EO\\SQLEXPRESS:1433;databaseName=PRJ321_FA20_B5";
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            connection = DriverManager.getConnection(url, user, password);              
        }catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(DBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
