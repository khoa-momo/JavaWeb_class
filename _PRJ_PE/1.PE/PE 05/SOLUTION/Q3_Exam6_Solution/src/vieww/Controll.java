/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vieww;

import com.context.DBContext;
import entity.ProjectMemberr;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Tuan Anh
 */
public class Controll {
    
    public List<ProjectMemberr> getAll(){
        List<ProjectMemberr> list = new ArrayList<>();
        DBContext dbcontext = new DBContext();
        try {
            Connection conn = dbcontext.getConnect();
            PreparedStatement pstmt;
            String select = "Select * From ProjectMember ";
            pstmt = conn.prepareStatement(select);
            ResultSet rs = pstmt.executeQuery();
            while(rs.next()){
                list.add(new ProjectMemberr(rs.getInt(1), rs.getString(2), rs.getBoolean(3), rs.getInt(4)));
            }
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(Controll.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }
    
    public List<ProjectMemberr> getProJectMemberByProjectID(int projectID, boolean isFull){
        List<ProjectMemberr> list = new ArrayList<>();
        DBContext dbcontext = new DBContext();
        try {
            Connection conn = dbcontext.getConnect();
            PreparedStatement pstmt;
            String select = "Select * From ProjectMember Where Projectid = ? ";
            pstmt = conn.prepareStatement(select);
            pstmt.setInt(1, projectID);
            ResultSet rs = pstmt.executeQuery();
            while(rs.next()){
                if(!isFull){
                    list.add(new ProjectMemberr(rs.getInt(1), rs.getString(2), rs.getBoolean(3), rs.getInt(4)));
                }else{
                    if(rs.getBoolean(3)){
                        list.add(new ProjectMemberr(rs.getInt(1), rs.getString(2), rs.getBoolean(3), rs.getInt(4)));
                    }
                }
            }
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(Controll.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }
    
    public List<ProjectMemberr> getProJectMemberByEmployeeID(String employeeID, boolean isFull){
        List<ProjectMemberr> list = new ArrayList<>();
        DBContext dbcontext = new DBContext();
        try {
            Connection conn = dbcontext.getConnect();
            PreparedStatement pstmt;
            String select = "Select * From ProjectMember Where Employeeid like  ? ";
            pstmt = conn.prepareStatement(select);
            pstmt.setString(1, "%"+employeeID+"%");
            ResultSet rs = pstmt.executeQuery();
            while(rs.next()){
                if(!isFull){
                    list.add(new ProjectMemberr(rs.getInt(1), rs.getString(2), rs.getBoolean(3), rs.getInt(4)));
                }else{
                    if(rs.getBoolean(3)){
                        list.add(new ProjectMemberr(rs.getInt(1), rs.getString(2), rs.getBoolean(3), rs.getInt(4)));
                    }
                }
            }
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(Controll.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }
}
