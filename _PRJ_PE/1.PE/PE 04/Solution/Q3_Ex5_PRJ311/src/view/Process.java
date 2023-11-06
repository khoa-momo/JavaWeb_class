/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import com.contex.DBcontect;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Tuan Anh
 */
public class Process {
    
    public static Book getBook(String user) throws ClassNotFoundException, SQLException{
        Connection conn = DBcontect.getConnection();
        PreparedStatement pstmt;
        String select = "Select * From Users Where UserName = ? ";
        pstmt = conn.prepareStatement(select);
        pstmt.setString(1, user);
        ResultSet rs = pstmt.executeQuery();
        Book b = new Book();
        while(rs.next()){
            String userName = rs.getString("UserName");
            String name = rs.getString("DisplayName");
            String pass = rs.getString("Password");
            String des = rs.getString("Description");
            b.setUsername(userName);
            b.setName(name);
            b.setPass(pass);
            b.setDes(des);
        }
        
        return b;
    }
    
    public static void update(String user,String displayName, String pass, String des) throws ClassNotFoundException, SQLException{
        Connection conn = DBcontect.getConnection();
        PreparedStatement pstmt;
        String select = "Update Users Set DisplayName = ? , Password = ? , Description = ? Where UserName = ?";
        pstmt = conn.prepareStatement(select);
        pstmt.setString(1, displayName);
        pstmt.setString(2, pass);
        pstmt.setString(3, des);
        pstmt.setString(4, user);
        pstmt.executeUpdate();
    }
}
