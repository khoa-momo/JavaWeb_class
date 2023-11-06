/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logic;

import dao.OrderDAO;
import dao.OrderDetailDAO;
import models.Order;
import java.util.ArrayList;
import models.OrderDetail;
/**
 *
 * @author DELL
 */
public class OrderLogic { //Cart
    Order order;
    ArrayList<OrderDetail> details;

    public OrderLogic() {
    }

    public OrderLogic(Order order, ArrayList<OrderDetail> details) {
        this.order = order;
        this.details = details;
    }
    
    public void Insert2Order(){
        OrderDAO orderDAO = new OrderDAO();
        OrderDetailDAO orderDetailDAO = new OrderDetailDAO(); 
//        int orderid = orderDAO.InsertOrderReturnKey(order);//return auto key orderID for order
        
//        for (OrderDetail detail : details) {
//            detail.setOrderId(orderid);
//            orderDetailDAO.InsertOrderDetail(detail);
////            orderDetailDAO.saveCartOD(detail);
//        }
    }
    
}
