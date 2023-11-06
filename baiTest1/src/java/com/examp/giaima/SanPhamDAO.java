package com.examp.giaima;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Lonely
 */
public class SanPhamDAO {

    private Connection conn = null;
    private PreparedStatement stmt = null;
    private ResultSet rs = null;
    private ConnectDB connectdb;

    public SanPhamDAO() {
        connectdb = new ConnectDB();
    }

    public ArrayList<SanPham> getAllProducts() {
        ArrayList<SanPham> list = new ArrayList();
        String sql = "SELECT * FROM db_bai3.sanpham";
        try {
            rs = connectdb.getStatement().executeQuery(sql);
            while (rs.next()) {
                String id = rs.getString("id");
                String name = rs.getString("name");
                String company = rs.getString("company");
                double price = rs.getDouble("price");
                SanPham sp = new SanPham(id, name, company, price);
                list.add(sp);
            }
        } catch (Exception e) {
            System.out.println("Please check getAllProduct index.jsp in SanPhamDAO");
        }
        connectdb.closeConnect();
        return list;
    }

    public boolean insertNew(SanPham sp) throws SQLException {
        String sql = "INSERT INTO `db_bai3`.`sanpham` (`id`, `name`, `company`, `price`) VALUES (?, ?, ?, ?);";
        stmt = connectdb.openConnect().prepareStatement(sql);
        stmt.setString(1, sp.getID());
        stmt.setString(2, sp.getName());
        stmt.setString(3, sp.getCompany());
        stmt.setDouble(4, sp.getPrice());
        return stmt.executeUpdate() > 0;
    }

    public boolean updateOld(SanPham sp) throws SQLException {
        String sql = "UPDATE `db_bai3`.`sanpham` SET `name`=?, `company`=?, `price`=? WHERE `id`=?;";
        stmt = connectdb.openConnect().prepareStatement(sql);
        stmt.setString(1, sp.getName());
        stmt.setString(2, sp.getCompany());
        stmt.setDouble(3, sp.getPrice());
        stmt.setString(4, sp.getID());
        return stmt.executeUpdate() > 0;
    }

    public boolean delete(String id) throws SQLException {
        String sql = "DELETE FROM `db_bai3`.`sanpham` WHERE `id`=?";
        stmt = connectdb.openConnect().prepareStatement(sql);
        stmt.setString(1, id);
        return stmt.executeUpdate() > 0;
    }

    public SanPham getSanPhamID(String id) throws SQLException {
        String sql = "SELECT * FROM SanPham WHERE id=?";
        stmt = connectdb.openConnect().prepareStatement(sql);
        stmt.setString(1, id);
        rs = stmt.executeQuery();
        SanPham sp = null;
        while (rs.next()) {
            String idsp = rs.getString("id");
            String name = rs.getString("name");
            String company = rs.getString("company");
            double price = rs.getDouble("price");
            sp = new SanPham(idsp, name, company, price);
        }
        return sp;
    }
}
