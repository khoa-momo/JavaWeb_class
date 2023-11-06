/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author DELL
 */
public class OrderDetail {
    private int orderId; 
    private int productId; 
    private int quantity; 
    private double unitPrice; 
    

    private HashMap<Integer, Integer> orderDetails;
    
    public OrderDetail() {
        orderDetails = new HashMap<>();
    }

    public OrderDetail(int orderId, int productId, int quantity, double unitPrice) {
        this.orderId = orderId;
        this.productId = productId;
        this.quantity = quantity;
        this.unitPrice = unitPrice;
    }
    
    public OrderDetail(int productId, int quantity) { 
        this.productId = productId;
        this.quantity = quantity; 
    }
    
     
    
//    public void addToCart(String product, int quantity){ 
//        if(products.get(product) != null){
//            int n = products.get(product);
//            products.replace(product, n + quantity);
//        }else{
//            products.put(product, quantity);
//        }
//    }
//
//    public Map<String, Integer> getProducts() {
//        return products;
//    }
    
    

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(double unitPrice) {
        this.unitPrice = unitPrice;
    }

    @Override
    public String toString() {
        return "OrderDetail{" + "orderId=" + orderId + ", productId=" + productId + ", quantity=" + quantity + ", unitPrice=" + unitPrice + '}';
    }
    
}
