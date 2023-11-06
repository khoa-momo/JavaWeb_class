/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dal;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author DELL
 */
public class DBConnect { 
    protected Connection connection;
    public DBConnect(){
        try{
            String user="khoa";
            String pass="123";
            String url="jdbc:sqlserver://DESKTOP-GLQH2EO\\SQLEXPRESS:1433; databaseName=IOT1601";
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            connection = DriverManager.getConnection(url, user, pass);
        }catch(Exception ex){
            Logger.getLogger(DBConnect.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
//    public Connection getConnection()throws Exception {
//        String url = "jdbc:sqlserver://"+serverName+":"+portNumber + "\\" + instance +";databaseName="+dbName;
//        if(instance == null || instance.trim().isEmpty()){
//            url = "jdbc:sqlserver://"+serverName+":"+portNumber +";databaseName="+dbName;
//        }
//        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
//        return DriverManager.getConnection(url, userID, password);
//    }    
//    private final String userID = "khoa";
//    private final String password = "123";       
//    private final String serverName = "DESKTOP-GLQH2EO\\SQLEXPRESS";
//    private final String dbName = "IOT1601";
//    private final String portNumber = "1433";
//    private final String instance="";//LEAVE THIS ONE EMPTY IF YOUR SQL IS A SINGLE INSTANCE      
}
