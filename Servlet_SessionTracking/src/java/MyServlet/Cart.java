/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MyServlet;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author DELL
 */
public class Cart {
    private Map<String, Integer> products;
    
    public Cart(){
        products = new HashMap<>();
    }
    
    public void addToCart(String product, int quantity){ 
        if(products.get(product) != null){
            int n = products.get(product);
            products.replace(product, n + quantity);
        }else{
            products.put(product, quantity);
        }
    }

    public Map<String, Integer> getProducts() {
        return products;
    }
    
}
