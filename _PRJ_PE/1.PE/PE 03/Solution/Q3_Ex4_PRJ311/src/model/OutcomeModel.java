/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import entity.Outcome;
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
public class OutcomeModel {
    public List<Outcome> getOutcomeByShipName(String shipName) throws ClassNotFoundException, SQLException{
        Connection conn= com.context.DBcontext.getConnect();
        PreparedStatement pstmt;
        String select = "Select * From Outcomes Where ship like ? ";
        pstmt = conn.prepareStatement(select);
        pstmt.setString(1, "%"+shipName+"%");
        
        List<Outcome> list = new ArrayList<>();
        ResultSet rs = pstmt.executeQuery();
        while(rs.next()){
            list.add(new Outcome(rs.getString("ship"), rs.getString("battle"), rs.getString("result")));
        }
        return list;
    }
}
