/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dal;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.text.SimpleDateFormat;
import java.time.LocalDate; 

import java.time.ZoneId;
import java.util.Date;
import java.util.List;
import java.util.Scanner;
import models.Account;
import models.Room; 

/**
 *
 * @author DELL
 */
public class Run {
    
    
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in); 
        RoomDAO dao = new RoomDAO(); 
        AccountDAO dao2 = new AccountDAO(); 
            
//        List<Employee> emplistFillter = empdao.getEmployeesByFillter2(empname, dob1, dob2, sex, position, depid);
//        List<Room> emplistFillter = dao.getRoomByType("Single");
//        for (Room efillter : emplistFillter) {
//            System.out.println(efillter);
//        }
//        System.out.println("---------------------");
        Account a = dao2.checkLogin("user1", "123456");
        
        System.out.println("acc: "+a);
        
        System.out.println("");
    }
}
