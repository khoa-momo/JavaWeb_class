/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author DELL
 */
public class InsertN_NTable {

    public ArrayList<Skill> getSkills() {
        try {
            ArrayList<Skill> skills = new ArrayList<>();

            String sql = "SELECT [id]\n"
                    + "      ,[name]\n"
                    + "  FROM [Skill]";
            PreparedStatement stm = connection.prepareStatement(sql);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                Skill s = new Skill();
                s.setId(rs.getInt("id"));
                s.setName(rs.getString("name"));
                skills.add(s);
            }
            return skills;
        } catch (SQLException ex) {
            Logger.getLogger(DAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public void setEmployee(Employee employee) {
        try {
            String sql = "INSERT INTO[Employee]\n"
                    + "           ([id]\n"
                    + "           ,[name]\n"
                    + "           ,[dob]\n"
                    + "           ,[gender])\n"
                    + "     VALUES\n"
                    + "           (?, ? ,? ,?)";
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setInt(1, employee.getId());
            stm.setString(2, employee.getName());
            stm.setDate(3, employee.getDob());
            stm.setBoolean(4, employee.isGender());
            stm.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(DAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void setEmployeeSkills(int eId, int sId) {
        try {
            String sql = "INSERT INTO [Employee_Skill]\n"
                    + "           ([eid]\n"
                    + "           ,[sid])\n"
                    + "     VALUES (?, ?)";
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setInt(1, eId);
            stm.setInt(2, sId);
            
            stm.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(DAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    //////////////////////////////////////////////////////////////////////////////////////////

    
     public void addCharacter(String cid, String name, boolean gender) {
        try {
            //mo ket noi
            Connection conn = new DBContext().getConnection();
            String sql = "INSERT INTO [dbo].[Characters]\n"
                    + "           ([cid]\n"
                    + "           ,[name]\n"
                    + "           ,[gender]\n"
                    + "           ,[created_date])\n"
                    + "     VALUES\n"
                    + "           (?,?,?,getDate())";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, cid);
            ps.setString(2, name);
            ps.setBoolean(3, gender);
            ps.executeUpdate();

        } catch (Exception ex) {
            ex.printStackTrace(System.out);
        }
    }

    public void addCharacterSkill(String cid, String[] skills) {
        try {
            //mo ket noi
            Connection conn = new DBContext().getConnection();
            String sql = "INSERT INTO [dbo].[Character_Skill]\n"
                    + "           ([cid]\n"
                    + "           ,[sid])\n"
                    + "     VALUES\n"
                    + "           (?,?)";
            PreparedStatement ps = conn.prepareStatement(sql);
            for (String skill : skills) {
                ps.setString(1, cid);
                ps.setInt(2, Integer.parseInt(skill));
                ps.executeUpdate();
            }

        } catch (Exception ex) {
            ex.printStackTrace(System.out);
        }
    }

    
}
