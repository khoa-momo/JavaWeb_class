/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;
import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.text.SimpleDateFormat;
import java.time.LocalDate; 

import java.time.ZoneId;
import java.util.Date;
import java.util.List;
import java.util.Scanner;  
import models.Account;

/**
 *
 * @author DELL
 */
public class Run { //for checking log
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in); 
        AccountDAO dao = new AccountDAO();  
         
        
//        ArrayList<Account> olist5 = dao.getAllAccounts();
//        for (Account list3 : olist5) {
//            System.out.println(list3);
//        }
        
        Account a = dao.checkLogin("user1", "123456");
        if (a!=null) {
            System.out.println("acc: "+a);
        }else{
            System.out.println("Wrong");
        }
        
        System.out.println("---------------------"); 
    }
}
