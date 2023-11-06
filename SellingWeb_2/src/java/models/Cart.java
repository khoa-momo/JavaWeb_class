/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
/**
 *
 * @author DELL
 */
@Builder
@Getter
@Setter
@ToString
public class Cart {
    private Product product ;
    private OrderDetail orderDetail;
    private int quantity;  

    public Cart() {
    }

    public Cart(Product product, int quantity) {
        this.product = product;
        this.quantity = quantity;
    }
    
    

    public Cart(Product product, OrderDetail orderDetail, int quantity) {
        this.product = product;
        this.orderDetail = orderDetail;
        this.quantity = quantity;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public OrderDetail getOrderDetail() {
        return orderDetail;
    }

    public void setOrderDetail(OrderDetail orderDetail) {
        this.orderDetail = orderDetail;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
    
    
}
