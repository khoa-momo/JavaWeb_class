/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import com.context.DBContext;
import entity.ProjectMember;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Tuan Anh
 */
public class Controll {
    public static List<ProjectMember> getAll() throws ClassNotFoundException, SQLException{
        Connection conn = DBContext.getConnect();
        PreparedStatement pstmt;
        String select = "Select * From ProjectMember";
        pstmt = conn.prepareStatement(select);
        ResultSet rs = pstmt.executeQuery();
        
        List<ProjectMember> list = new ArrayList<>();
        while(rs.next()){
            list.add(new ProjectMember(rs.getInt(1), rs.getString(2), rs.getBoolean(3), rs.getInt(4)));
        }
        return list;
    }
    public static List<ProjectMember> getByEmployeeID(String employeeID) throws ClassNotFoundException, SQLException{
        Connection conn = DBContext.getConnect();
        PreparedStatement pstmt;
        String select = "Select * From ProjectMember Where Employeeid like ?";
        pstmt = conn.prepareStatement(select);
        pstmt.setString(1, "%"+employeeID+"%");
        ResultSet rs = pstmt.executeQuery();
        
        List<ProjectMember> list = new ArrayList<>();
        while(rs.next()){
            list.add(new ProjectMember(rs.getInt(1), rs.getString(2), rs.getBoolean(3), rs.getInt(4)));
        }
        return list;
    }
    public static List<ProjectMember> getTop2ByEmployeeID(String employeeID) throws ClassNotFoundException, SQLException{
        Connection conn = DBContext.getConnect();
        PreparedStatement pstmt;
        String select = "Select top 2 * From ProjectMember Where Employeeid like ? Order by Hours desc";
        pstmt = conn.prepareStatement(select);
        pstmt.setString(1, "%"+employeeID+"%");
        ResultSet rs = pstmt.executeQuery();
        
        List<ProjectMember> list = new ArrayList<>();
        while(rs.next()){
            list.add(new ProjectMember(rs.getInt(1), rs.getString(2), rs.getBoolean(3), rs.getInt(4)));
        }
        return list;
    }
}
