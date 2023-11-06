/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package technical;

import java.util.List;
import java.util.ArrayList;

/**
 *
 * @author DELL
 */
public class java {
    public static void main(String[] args) {
        
        List<Integer> myNumbers = new ArrayList<Integer>();
        myNumbers.add(1);
        myNumbers.add(2);
        myNumbers.add(3);
        myNumbers.add(4);
        myNumbers.add(5);
        System.out.print("list 1: ");
        for (int i : myNumbers) {
          System.out.print(" "+i);
        }
        
        System.out.print("\n\n\n");
        List<Integer> myNumbers2 = new ArrayList<Integer>();
        myNumbers2.add(2);
        myNumbers2.add(4); 
        System.out.print("list 2: ");
        for (int i : myNumbers2) {
            System.out.print(" "+i);
        }
        
        System.out.print("\n\n\n");
        
        System.out.println("list two in one:");
//        for (int i = 0; i < 10; i++) {
//            
//        }
        
//        for (int i : myNumbers) {
//            for (int j : myNumbers2) {
//                System.out.println("i: "+i);
//                System.out.println("j: "+j);
//                if (myNumbers.get(i)==myNumbers2.get(j)) {
//                    System.out.print(" "+j);
//                } 
//            }
//        }

        for (int i = 0; i < myNumbers.size(); i++) {
            for (int j = 0; j < myNumbers2.size(); j++) {
                if (myNumbers.get(i)==myNumbers2.get(j)) {
                    System.out.print(" "+j);
                }
            }
        }
        
//        for (int i : myNumbers) {
//            for (int j : myNumbers2) {
//                if (myNumbers.get(i)==myNumbers2.get(j)) {
//                    System.out.print(" "+j);
//                } 
//            }
//        }
        
//        for (int j : myNumbers2) {
//            for (int i : myNumbers) {
//                System.out.println("i: "+i);
//                if (myNumbers.get(j)==myNumbers2.get(i)) {
//                    System.out.print(" "+j);
//                } 
//            } 
//        }
        
        
        System.out.print("\n\n\n");
    }
}
