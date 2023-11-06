/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import models.Account;
import models.Image;
import models.Location;
import models.Room;

/**
 *
 * @author DELL
 */
public class RoomDAO extends DBContext{
    //-------------------------------------------------------Get list--------------------------------------------------
    public ArrayList<Room> getAllRoom(){
        ArrayList<Room> list = new ArrayList<>();
        try{
            String sql = "Select r.*, rt.roomTypeName, l.provinceName+' '+l.districtName+' '+l.streetName as [Address], a.username\n" +
                        "From Room r join RoomType rt\n" +
                        "On r.roomTypeId = rt.roomTypeId join Location l\n" +
                        "On r.locationId = l.locationId join Account a\n" +
                        "On r.accountId = a.accountId";
            PreparedStatement ps = connection.prepareStatement(sql);   
            ResultSet rs = ps.executeQuery();
            while (rs.next()){
                String url = get1stImage(rs.getString(1)); 
                Room r = new Room( 
                    rs.getInt("roomId"), 
                    rs.getString("title"), 
                    rs.getString("description"), 
                    rs.getInt("area"), 
                    rs.getInt("cost"), 
                    rs.getInt("status"), 
                    rs.getDate("dateCreated").toLocalDate(), 
                    rs.getString("note"), 
                    rs.getString("Address"), 
                    rs.getString("roomTypeName"), 
                    rs.getString("username"),
                    url);
                list.add(r);
            }
        }
        catch(SQLException ex){
            Logger.getLogger(DBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }
    
    public ArrayList<Location> getAllProvince(){
        ArrayList<Location> list = new ArrayList<>();
        try{
            String sql = "Select distinct l.provinceName\n" +
                        "From Location l";
            PreparedStatement ps = connection.prepareStatement(sql);   
            ResultSet rs = ps.executeQuery();
            while (rs.next()){
                Location l = new Location( 
                    rs.getString("provinceName"));  
                list.add(l);
            }
        }
        catch(SQLException ex){
            Logger.getLogger(DBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }
    
    public ArrayList<Location> getAllDistrict(){
        ArrayList<Location> list = new ArrayList<>();
        try{
            String sql = "Select distinct l.districtName\n" +
                    "From Location l";
            PreparedStatement ps = connection.prepareStatement(sql);   
            ResultSet rs = ps.executeQuery();
            while (rs.next()){
                Location l = new Location( 
                    rs.getString("districtName"));  
                list.add(l);
            }
        }
        catch(SQLException ex){
            Logger.getLogger(DBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }
    public ArrayList<Location> getDistrictByCity(String cname){
        ArrayList<Location> list = new ArrayList<>();
        try{
            String sql = "Select distinct l.districtName \n" +
                        "From Location l\n" +
                        "Where provinceName = N'"+cname+"'\n" +
                        "order by l.districtName ";
            PreparedStatement ps = connection.prepareStatement(sql);    
            ResultSet rs = ps.executeQuery();
            while (rs.next()){
                Location l = new Location( 
                    rs.getString("districtName"));  
                list.add(l);
            }
        }
        catch(SQLException ex){
            Logger.getLogger(DBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }
    
    //-------------------------------Detail-------------------------------
    public Room getRoomByID(String roomid){ 
        try{
            String sql = "Select r.*, rt.roomTypeName, l.provinceName+' '+l.districtName+' '+l.streetName as [Address], a.username\n" +
                        "From Room r join RoomType rt\n" +
                        "On r.roomTypeId = rt.roomTypeId join Location l\n" +
                        "On r.locationId = l.locationId join Account a\n" +
                        "On r.accountId = a.accountId  \n" +
                        "Where r.roomId = ?";
            PreparedStatement ps = connection.prepareStatement(sql);   
            ps.setString(1, roomid);
            ResultSet rs = ps.executeQuery();
            while (rs.next()){
                String url = get1stImage(rs.getString(1)); 
                Room r = new Room(
                    rs.getInt("roomId"), 
                    rs.getString("title"), 
                    rs.getString("description"), 
                    rs.getInt("area"), 
                    rs.getInt("cost"), 
                    rs.getInt("status"), 
                    rs.getDate("dateCreated").toLocalDate(), 
                    rs.getString("note"), 
                    rs.getString("Address"), 
                    rs.getString("roomTypeName"), 
                    rs.getString("username"),
                    url);
                return r;
            }
        }
        catch(SQLException ex){
            Logger.getLogger(DBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
     
    public ArrayList<Room> getRoomByAccount(String account){
        ArrayList<Room> list = new ArrayList<>();
        try{
            String sql = "Select r.*, rt.roomTypeName, l.provinceName+' '+l.districtName+' '+l.streetName as [Address], a.username\n" +
                        "From Room r join RoomType rt\n" +
                        "On r.roomTypeId = rt.roomTypeId join Location l\n" +
                        "On r.locationId = l.locationId join Account a\n" +
                        "On r.accountId = a.accountId \n" +
                        "Where a.username = ?";   
            PreparedStatement ps = connection.prepareStatement(sql);   
            ps.setString(1, account); 
            ResultSet rs = ps.executeQuery();
            while (rs.next()){
                String url = get1stImage(rs.getString(1));
                Room r = new Room( 
                    rs.getInt("roomId"), 
                    rs.getString("title"), 
                    rs.getString("description"), 
                    rs.getInt("area"), 
                    rs.getInt("cost"), 
                    rs.getInt("status"), 
                    rs.getDate("dateCreated").toLocalDate(), 
                    rs.getString("note"), 
                    rs.getString("Address"), 
                    rs.getString("roomTypeName"), 
                    rs.getString("username"),
                    url);
                list.add(r);
            }
        }
        catch(SQLException ex){
            Logger.getLogger(DBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }
    
    public Account getAccountByRID(String roomid){ 
        try{
            String sql = "Select a.*\n" +
                        "From Room r join RoomType rt\n" +
                        "On r.roomTypeId = rt.roomTypeId join Account a\n" +
                        "On r.accountId = a.accountId  \n" +
                        "Where r.roomId = ?";
            PreparedStatement ps = connection.prepareStatement(sql);   
            ps.setString(1, roomid);
            ResultSet rs = ps.executeQuery();
            while (rs.next()){
                Account acc = new Account(
                    rs.getInt("accountId"), 
                    rs.getString("fullname"), 
                    rs.getString("email"), 
                    rs.getString("gender"), 
                    rs.getString("phone"));
                return acc;
            } 
        }
        catch(SQLException ex){
            Logger.getLogger(DBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
//-------------------------------------------------------Paging--------------------------------------------------
    //------------------Paging All-----------------
    public ArrayList<Room> getAllRoomPaging(int page, int PAGE_SIZE){
        ArrayList<Room> list = new ArrayList<>();
        try{
            String sql = "Select r.*, rt.roomTypeName, l.provinceName+' '+l.districtName+' '+l.streetName as [Address], a.username\n" +
                        "From Room r join RoomType rt\n" +
                        "On r.roomTypeId = rt.roomTypeId join Location l\n" +
                        "On r.locationId = l.locationId join Account a\n" +
                        "On r.accountId = a.accountId\n" +  
                        "Order By roomId \n" +
                        "offset (?-1)*? row fetch next ? rows only";   
            PreparedStatement ps = connection.prepareStatement(sql);   
            ps.setInt(1, page);
            ps.setInt(2, PAGE_SIZE);
            ps.setInt(3, PAGE_SIZE);
            ResultSet rs = ps.executeQuery();
            while (rs.next()){
                String url = get1stImage(rs.getString(1));
                Room r = new Room( 
                    rs.getInt("roomId"), 
                    rs.getString("title"), 
                    rs.getString("description"), 
                    rs.getInt("area"), 
                    rs.getInt("cost"), 
                    rs.getInt("status"), 
                    rs.getDate("dateCreated").toLocalDate(), 
                    rs.getString("note"), 
                    rs.getString("Address"), 
                    rs.getString("roomTypeName"), 
                    rs.getString("username"),
                    url);
                list.add(r);
            }
        }
        catch(SQLException ex){
            Logger.getLogger(DBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }
    
    public int getTotalRoomPaging() {
        try {
            String sql = "Select count(*)\n" +
                        "From Room r join RoomType rt\n" +
                        "On r.roomTypeId = rt.roomTypeId join Location l\n" +
                        "On r.locationId = l.locationId join Account a\n" +
                        "On r.accountId = a.accountId";  
            PreparedStatement ps = connection.prepareStatement(sql); 
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                return rs.getInt(1);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 0;
    }   
    //------------------Paging Filter-----------------
    public ArrayList<Room> getAllRoomFilterPaging(String provinceName, String districtName, String streetName, 
            int areaLower, int areaUpper, int costLower, int costUpper, int page, int PAGE_SIZE){
        ArrayList<Room> list = new ArrayList<>();
        try{
            String sql = 
                        "Select r.*, rt.roomTypeName, l.provinceName+' '+l.districtName+' '+l.streetName as [Address], a.username\n" +
                        "From Room r join RoomType rt\n" +
                        "On r.roomTypeId = rt.roomTypeId join Location l\n" +
                        "On r.locationId = l.locationId join Account a\n" +
                        "On r.accountId = a.accountId \n" +
                        "Where l.provinceName like " + "N'%"+provinceName +"%'"+"\n"+
                        "and l.districtName like " + "N'%"+districtName +"%'"+"\n"+
                        "and l.streetName like " + "N'%"+streetName +"%'"+"\n"+
                        "and r.area between ? and ?\n" +
                        "and r.cost between ? and ?\n" +
                        "Order by roomId\n" +
                        "offset (?-1)*? row fetch next ? rows only";   
            PreparedStatement ps = connection.prepareStatement(sql);   
//            ps.setString(1, "%"+provinceName+"%"); 
//            ps.setString(2, "%"+districtName+"%"); 
//            ps.setString(3, "%"+streetName+"%"); 
            ps.setInt(1, areaLower);
            ps.setInt(2, areaUpper);
            ps.setInt(3, costLower); 
            ps.setInt(4, costUpper); 
            ps.setInt(5, page);
            ps.setInt(6, PAGE_SIZE);
            ps.setInt(7, PAGE_SIZE);
            ResultSet rs = ps.executeQuery();
            while (rs.next()){
                String url = get1stImage(rs.getString(1));
                Room r = new Room( 
                    rs.getInt("roomId"), 
                    rs.getString("title"), 
                    rs.getString("description"), 
                    rs.getInt("area"), 
                    rs.getInt("cost"), 
                    rs.getInt("status"), 
                    rs.getDate("dateCreated").toLocalDate(), 
                    rs.getString("note"), 
                    rs.getString("Address"), 
                    rs.getString("roomTypeName"), 
                    rs.getString("username"),
                    url);
                list.add(r);
            }
        }
        catch(SQLException ex){
            Logger.getLogger(DBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }
    
    public int getTotalRoomFilterPaging(String provinceName, String districtName, String streetName, 
            int areaLower, int areaUpper, int costLower, int costUpper) {
        try {
            String sql = 
                        "Select count(*)\n" +
                        "From Room r join RoomType rt\n" +
                        "On r.roomTypeId = rt.roomTypeId join Location l\n" +
                        "On r.locationId = l.locationId join Account a\n" +
                        "On r.accountId = a.accountId \n" +
                        "Where l.provinceName like " + "N'%"+provinceName +"%'"+"\n"+
                        "and l.districtName like " + "N'%"+districtName +"%'"+"\n"+
                        "and l.streetName like " + "N'%"+streetName +"%'"+"\n"+
                        "and r.area between ? and ?\n" +
                        "and r.cost between ? and ?\n";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, areaLower);
            ps.setInt(2, areaUpper);
            ps.setInt(3, costLower); 
            ps.setInt(4, costUpper); 
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                return rs.getInt(1);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 0;
    }   
//==========================Special filter================================
public ArrayList<Room> getRoomLatest(){
        ArrayList<Room> list = new ArrayList<>();
        try{
            String sql = "Select Top 10 r.*, rt.roomTypeName, l.provinceName+' '+l.districtName+' '+l.streetName as [Address], a.username\n" +
                        "From Room r join RoomType rt\n" +
                        "On r.roomTypeId = rt.roomTypeId join Location l\n" +
                        "On r.locationId = l.locationId join Account a\n" +
                        "On r.accountId = a.accountId \n" +
                        "Order by r.dateCreated desc";   
            PreparedStatement ps = connection.prepareStatement(sql);    
            ResultSet rs = ps.executeQuery();
            while (rs.next()){
                String url = get1stImage(rs.getString(1));
                Room r = new Room( 
                    rs.getInt("roomId"), 
                    rs.getString("title"), 
                    rs.getString("description"), 
                    rs.getInt("area"), 
                    rs.getInt("cost"), 
                    rs.getInt("status"), 
                    rs.getDate("dateCreated").toLocalDate(), 
                    rs.getString("note"), 
                    rs.getString("Address"), 
                    rs.getString("roomTypeName"), 
                    rs.getString("username"),
                    url);
                list.add(r);
            }
        }
        catch(SQLException ex){
            Logger.getLogger(DBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }    
        
//---------------------------------------image------------------------------------
    public ArrayList<Image> getFirstImage(String roomid){
        ArrayList<Image> list = new ArrayList<>();
        try{
            String sql = "Select ir.*\n" +
                        "From Room r join Image_Room ir\n" +
                        "On r.roomId = ir.roomId\n" +
                        "Where r.roomId = ?";
            PreparedStatement ps = connection.prepareStatement(sql);  
            ps.setString(1, roomid);
            ResultSet rs = ps.executeQuery();
            while (rs.next()){
                Image i = new Image( 
                    rs.getInt("imageId"),  
                    rs.getString("imageLink"));  
                list.add(i);
            }
        }
        catch(SQLException ex){
            Logger.getLogger(DBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }
    
    public String get1stImage(String roomid){ 
        try{
            String sql = "Select top 1 ir.imageLink\n" +
                        "From Room r join Image_Room ir\n" +
                        "On r.roomId = ir.roomId\n" +
                        "Where r.roomId = ?";
            PreparedStatement ps = connection.prepareStatement(sql);  
            ps.setString(1, roomid);
            ResultSet rs = ps.executeQuery();
            while (rs.next()){
                return rs.getString("imageLink");
            }
        }
        catch(SQLException ex){
            Logger.getLogger(DBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

//-------------------------------------------------------CRUD--------------------------------------------------
    
    public void deleteRoom(String id){
        try{
            String sql = "Delete From Image_Room\n" +
                        "Where roomId = ?\n" +
                        "Delete From Room\n" +
                        "Where roomId = ?";
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setString(1, id); 
            stm.setString(2, id); 
            stm.executeUpdate();
        }
        catch(SQLException ex){
            Logger.getLogger(DBContext.class.getName()).log(Level.SEVERE, null, ex);
        }   
    }
    
    public int InsertLocationReturnKey(String provinceName, String districtName, String streetName){
        try{
            String sql = "insert into Location (provinceName, districtName, streetName) "
                    + "values ("
                    + "N'"+provinceName+"',"
                    + "N'"+districtName+"',"
                    + "N'"+streetName+"')";
            PreparedStatement ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS); 
//                ps.setString(1, provinceName);
//                ps.setString(2, districtName);
//                ps.setString(3, streetName); 
                ps.executeUpdate();
            ResultSet rs = ps.getGeneratedKeys();
            if (rs.next()){
                int loId = Integer.parseInt(rs.getString(1));
                return loId;
            }
        }
        catch(SQLException ex){
            Logger.getLogger(DBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return -1;
    }
    
    public int addRoom(String title, String description, int area, int cost, String status, 
            String note, int locationId, String accountId){
        try{
            String sql = "insert into Room (title, [description], area, cost, [status], dateCreated, note, locationId, roomTypeId, accountId) "
                    + "values (" 
                    + "N'"+title+"',"
                    + "N'"+description+"'," 
                    + "?,?,?,getDate(),"
                    + "N'"+note+"',"
                    + "?,1,?)";
            PreparedStatement stm = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);   
            stm.setInt(1, area);
            stm.setInt(2, cost); 
            stm.setString(3, status);  
            stm.setInt(4, locationId);  
            stm.setString(5, accountId); 
            stm.executeUpdate();
            ResultSet rs = stm.getGeneratedKeys();
            if (rs.next()){
                int roId = Integer.parseInt(rs.getString(1));
                return roId;
            }
        }
        catch(SQLException ex){
            Logger.getLogger(DBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return -1;
    }
    
    public void addImage(String url, int roomid){
        try{
            String sql = "insert into Image_Room (imageLink,roomId) values (?,?)";
            PreparedStatement stm = connection.prepareStatement(sql); 
            stm.setString(1, url);  
            stm.setInt(2, roomid);   
            stm.executeUpdate();
        }
        catch(SQLException ex){
            Logger.getLogger(DBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
    public String getAccId(String username){ 
        try{
            String sql = "Select a.accountid \n" +
                        "From Account a\n" +
                        "Where a.username = ?";
            PreparedStatement ps = connection.prepareStatement(sql);  
            ps.setString(1, username);
            ResultSet rs = ps.executeQuery();
            while (rs.next()){ 
                return rs.getString("accountid");
            }
        }
        catch(SQLException ex){
            Logger.getLogger(DBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
     
    
    
    //==========================================================================
    public ArrayList<Room> getRoomSpecial(String provinceName, String districtName, String streetName, 
            Integer areaLower, Integer areaUpper, Integer costLower, Integer costUpper, Integer page, Integer PAGE_SIZE){
        ArrayList<Room> list = new ArrayList<>(); 
            String sql = 
                " Select r.*, rt.roomTypeName, l.provinceName+' '+l.districtName+' '+l.streetName as [Address], a.username\n" +
                " From Room r join RoomType rt " +
                " On r.roomTypeId = rt.roomTypeId join Location l " +
                " On r.locationId = l.locationId join Account a " +
                " On r.accountId = a.accountId " +
                " Where 1=1 ";
            
            
                System.out.println("-----------------getRoomSpecialDAO------------------");
                if(provinceName!=null && !provinceName.equals("")){ 
                    System.out.println("###provinceName: "+provinceName);
                    sql += " and l.provinceName like " + "N'%"+provinceName +"%'";
                }
                if(districtName!=null && !districtName.equals("")){
                    System.out.println("###districtName: "+districtName);
                    sql += " and l.districtName like " + "N'%"+districtName +"%'";
                }
                if(streetName!=null && !streetName.equals("")){
                    System.out.println("###streetName: "+streetName);
                    sql += " and l.streetName like " + "N'%"+streetName +"%'";
                }   
                System.out.println("###areaLower: "+areaLower);
                System.out.println("###areaUpper: "+areaUpper);
                System.out.println("###costLower: "+costLower);
                System.out.println("###costUpper: "+costUpper); 
                
                
            HashMap<Integer, Object[]> params = new HashMap<>();
            Integer index = 0; 
            if (areaLower != null) {
                sql += " and r.area >= ? ";
                System.out.println("--areaLowerareaLowerareaLower--"+areaLower);
                index++;
                Object[] param = new Object[2];
                param[0] = "INT";
                param[1] = areaLower;
                params.put(index, param);
            }
            if (areaUpper != null) {
                sql += " and r.area <= ? ";
                index++;
                Object[] param = new Object[2];
                param[0] = "INT";
                param[1] = areaUpper;
                params.put(index, param);
            }
            if (costLower != null) {
                System.out.println("r.cost >= ?");
                sql += " and r.cost >= ? ";
                index++;
                Object[] param = new Object[2];
                param[0] = "INT";
                param[1] = costLower;
                params.put(index, param);
            }
            if (costUpper != null) {
                sql += " and r.cost <= ? ";
                index++;
                Object[] param = new Object[2];
                param[0] = "INT";
                param[1] = costUpper;
                params.put(index, param);
            }
            
            if(page!= null){
                sql += " Order By roomId \n" +
                        " offset (?-1)*";
                index++;
                Object[] param = new Object[2];
                param[0] = "INT";
                param[1] = page;
                params.put(index, param);
            } 
            if(PAGE_SIZE!= null){
                sql += " ? row fetch next";
                index++;
                Object[] param = new Object[2];
                param[0] = "INT";
                param[1] = PAGE_SIZE;
                params.put(index, param);
            }
            if(PAGE_SIZE!= null){
                sql += " ? rows only";
                index++;
                Object[] param = new Object[2];
                param[0] = "INT";
                param[1] = PAGE_SIZE;
                params.put(index, param);
            }   
        try{    
            PreparedStatement ps = connection.prepareStatement(sql);    
            for (Map.Entry<Integer, Object[]> entry : params.entrySet()) {
                Integer key = entry.getKey();
                System.out.println("#entry.getKey()---"+entry.getKey());
                Object[] value = entry.getValue();
                System.out.println("#entry.getValue()---"+Arrays.toString(entry.getValue()));
                switch (value[0].toString()) {
                    case "INT":
                        ps.setInt(key, (int) value[1]);
                        System.out.println("Case-int: "+key+"---"+(int) value[1]);
                        break;
                    case "STRING":
                        ps.setString(key, value[1].toString());
                        System.out.println("Case-string: "+key+"---"+value[1].toString());
                        break;
                    case "BOOLEAN":
                        ps.setBoolean(key, (boolean) value[1]);
                        break;
                    case "DATE":
                        ps.setDate(key, (Date) value[1]);
                        break;
                }
            }
            ResultSet rs = ps.executeQuery();
            while (rs.next()){
                String url = get1stImage(rs.getString(1));
                Room r = new Room( 
                    rs.getInt("roomId"), 
                    rs.getString("title"), 
                    rs.getString("description"), 
                    rs.getInt("area"), 
                    rs.getInt("cost"), 
                    rs.getInt("status"), 
                    rs.getDate("dateCreated").toLocalDate(), 
                    rs.getString("note"), 
                    rs.getString("Address"), 
                    rs.getString("roomTypeName"), 
                    rs.getString("username"),
                    url);
                list.add(r);
            }
        }
        catch(SQLException ex){
            Logger.getLogger(DBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }
    
    public int getCountRoomSpecial(String provinceName, String districtName, String streetName, 
            Integer areaLower, Integer areaUpper, Integer costLower, Integer costUpper){ 
            String sql = 
                " Select count(*)\n" +
                " From Room r join RoomType rt " +
                " On r.roomTypeId = rt.roomTypeId join Location l " +
                " On r.locationId = l.locationId join Account a " +
                " On r.accountId = a.accountId " +
                " Where 1=1 ";
               
                if(provinceName!=null && !provinceName.equals("")){ 
                    sql += " and l.provinceName like " + "N'%"+provinceName +"%'";
                }
                if(districtName!=null && !districtName.equals("")){
                    sql += " and l.districtName like " + "N'%"+districtName +"%'";
                }
                if(streetName!=null && !streetName.equals("")){
                    sql += " and l.streetName like " + "N'%"+streetName +"%'";
                }    
            HashMap<Integer, Object[]> params = new HashMap<>();
            Integer index = 0; 
            if (areaLower != null) {
                sql += " and r.area >= ?"; 
                index++;
                Object[] param = new Object[2];
                param[0] = "INT";
                param[1] = areaLower;
                params.put(index, param);
            }
            if (areaUpper != null) {
                sql += " and r.area <= ?";
                index++;
                Object[] param = new Object[2];
                param[0] = "INT";
                param[1] = areaUpper;
                params.put(index, param);
            }
            if (costLower != null) {
                sql += " and r.cost >= ?";
                index++;
                Object[] param = new Object[2];
                param[0] = "INT";
                param[1] = costLower;
                params.put(index, param);
            }
            if (costUpper != null) {
                sql += " and r.cost <= ?";
                index++;
                Object[] param = new Object[2];
                param[0] = "INT";
                param[1] = costUpper;
                params.put(index, param);
            }
             
        try{    
            PreparedStatement ps = connection.prepareStatement(sql);    
            for (Map.Entry<Integer, Object[]> entry : params.entrySet()) {
                Integer key = entry.getKey();
                System.out.println("entry.getKey()-"+entry.getKey());
                Object[] value = entry.getValue();
                System.out.println("entry.getValue()-"+Arrays.toString(entry.getValue()));
                switch (value[0].toString()) {
                    case "INT":
                        ps.setInt(key, (int) value[1]);
                        System.out.println("??: "+key+"--"+(int) value[1]);
                        break;
                    case "STRING":
                        ps.setString(key, value[1].toString());
                        break;
                    case "BOOLEAN":
                        ps.setBoolean(key, (boolean) value[1]);
                        break;
                    case "DATE":
                        ps.setDate(key, (Date) value[1]);
                        break;
                }
            }
            ResultSet rs = ps.executeQuery();
            while (rs.next()){
                return rs.getInt(1);
            }
        }
        catch(SQLException ex){
            Logger.getLogger(DBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 0;
    }
        
    
    
    
    
    
    
     
}
 
