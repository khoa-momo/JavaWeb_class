/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import context.DBContext;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import models.Certificate;
import models.Employee;

/**
 *
 * @author DELL
 */
public class DAO extends DBContext{
    public List<Certificate> getAllCert() {
        try {
            List<Certificate> list = new ArrayList<>();
            //mo ket noi 
            String sql = "Select * From Certificate";    
            Connection connection = new DBContext().getConnection();
            PreparedStatement ps = connection.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Certificate certificate = new Certificate(
                        rs.getInt(1),
                        rs.getString(2));
                list.add(certificate);
            }
            return list;
        } catch (Exception ex) {
            ex.printStackTrace(System.out);
        }
        return null;
    }
    
    public List<Certificate> getCertificatesByeid(int id) {
        try {
            List<Certificate> list = new ArrayList<>();
            //mo ket noi 
            String sql = "Select c.id, c.name\n" +
                        "From [Certificate] c join Employee_Certificate ec\n" +
                        "on c.id = ec.cid join Employee e\n" +
                        "on ec.eid = e.id\n" +
                        "Where e.id = ?";    
            Connection connection = new DBContext().getConnection();
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Certificate certificate = new Certificate(
                        rs.getInt(1),
                        rs.getString(2));
                list.add(certificate);
            }
            return list;
        } catch (Exception ex) {
            ex.printStackTrace(System.out);
        }
        return null;
    }
 
    public List<Employee> getAllEmpNN() { 
        int isemp = 0;
        try {
            List<Employee> list = new ArrayList<>();
            //mo ket noi 
            String sql = "Select * from Employee";
            Connection connection = new DBContext().getConnection();
            PreparedStatement ps = connection.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                List<Certificate> listCer = getAllCert();
                List<Integer> isCert = new ArrayList();
                int checkid = rs.getInt("id");
                System.out.println("-checkid: "+checkid);
                List<Certificate> listC = getCertificatesByeid(rs.getInt("id"));//list cac id -> 1,2,3,4...
                System.out.println("-start-");
                
                for (int i = 0; i < listCer.size(); i++) {
                    isCert.add(0); 
                }
               
                for (int i = 0; i < listC.size(); i++) {
                    for (int j = 0; j < listCer.size(); j++) {
//                        isemp = 0;
                        if(listC.get(i).getCid() == listCer.get(j).getCid()){
                            isCert.set(i, 1);
//                            isCert.add(isemp);
//                            System.out.println("c.getCid(): "+c.getCid());
                            System.out.println("isemp: "+isemp);
                            break;
                        }
                    }
                }
                 
                System.out.println("-end-");
                Employee e = new Employee(rs.getInt(1), rs.getString(2), isCert, listCer);
                list.add(e);
            }
            return list;
        } catch (Exception ex) {
            ex.printStackTrace(System.out);
        }
        return null;
    }
}
