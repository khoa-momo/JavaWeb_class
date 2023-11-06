/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;
 
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.text.SimpleDateFormat;
import java.time.LocalDate; 

import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;
import models.Account;
import models.Location;
import models.Room; 
import models.Image; 

/**
 *
 * @author DELL
 */
public class Run {
    
    
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in); 
        RoomDAO dao = new RoomDAO(); 
        AccountDAO dao2 = new AccountDAO(); 
            
        
        ArrayList<Location> lo = dao.getDistrictByCity("Hà Nội"); 
        for (Location a : lo) {
            System.out.println(a);
        }
        System.out.println("------------@@@@@@---------");
        
        
        ArrayList<Account> acc = dao2.getAllAccounts(); 
        for (Account a : acc) {
            System.out.println(a);
        }
        System.out.println("------------@@@@@@---------");
//        Account a = dao2.checkLogin("user1", "123456");
//        System.out.println("acc: "+a);
//        System.out.println("");
//        List<Room> emplistFillter2 = dao.getAllRoomPaging(1, 6);
//        for (Room efillter : emplistFillter2) {
//            System.out.println(efillter);
//        }
        
//        String url = dao.get1stImage("1"); 
//        List<Image> image = dao.getFirstImage("1");
//        System.out.println("image "+image);
//
//        Room r = dao.getRoomByID("1");
//        System.out.println("r "+r);
//        System.out.println("------------------------------------------");
//        List<Room> emplistFillter2 = dao.getAllRoomFilterPaging("Hà Nội", "Ba Đình", "Chí", 50, 60, 700000, 3000000, 1, 20);
//        for (Room efillter : emplistFillter2) {
//            System.out.println(efillter);
//        }
//        int a = null;
        
       Account account = dao2.getAccountByID("user1");
       String role = account.getRole();
        System.out.println("--role-"+role);
        
        
        String provinceName = "Hà Nội"; 
        String districtName = "";
        String streetName = "";
        Integer larea = null;
        Integer uarea = null;
        Integer lcost = null;
        Integer ucost = null;
         
        System.out.println("------------------------------------------");
        List<Room> Fillter2 = dao.getRoomByAccount("user2");
        
        for (Room rfillter : Fillter2) {
            System.out.println(rfillter);
        }
        
        
        System.out.println("------------------------------------------");
        List<Room> Fillter = dao.getRoomSpecial
        (provinceName, districtName, streetName, larea, uarea, lcost, ucost, 1 ,10);
        for (Room rfillter : Fillter) {
            System.out.println(rfillter);
        }
        
        int a = dao.getCountRoomSpecial(provinceName, districtName, streetName, larea, uarea, lcost, ucost);
        System.out.println("Count: "+a);
        
        
        
        
//        Account a = dao2.getAccountByID("user1");
//        System.out.println("a "+a);
//
//        String acid = dao.getAccId("user1");
//        System.out.println("acid "+acid);



//        int count = dao.getTotalRoomFilterPaging("Hà Nội", "Ba Đình", "Chí", "10", "60", "700000", "3000000");
//        System.out.println("count "+count);
        
        
//        List<Location> provinceList = dao.getAllProvince();
//        System.out.println(provinceList);
        
//        List<Location> districtList = dao.getAllDistrict();
//        System.out.println("districtList: "+districtList);
    }
}
