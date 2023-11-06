/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.context;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Tuan Anh
 */
public class DBcontext {
    public static Connection getConnect() throws ClassNotFoundException, SQLException{
        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        return DriverManager.getConnection("jdbc:sqlserver://DESKTOP-615832F\\MSSQLSERVER01:1433;"
                + "databaseName=PRJ311", "sa","tuantom99");
    }   
}
