package com.yahooInterview.controller;

import java.util.Collection;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.yahooInterview.model.Order;
import com.yahooInterview.service.OrderService;

@RestController
@RequestMapping("/api/orders")
public class OrderController {

    @Autowired
    private OrderService orderService;
    
    // 創建一個新的訂單項目 /yahooInterview/api/orders
//    {
//        "memId": "1",
//        "ordSubtotal": "123",
//        "ordTotal": "123",
//        "ordStatus": "0",
//        "ordRecipient": "leoblue",
//        "ordRecipientPhone": "0911123456",
//        "ordPayment": "1",
//        "ordDelivery": "1",
//        "ordAddress": "台北"
//    }
    @PostMapping
    public ResponseEntity<Order> createOrder(@RequestBody Order order) {
    	System.out.println("createOrder");
        Order createdOrder = orderService.createOrder(order);
        return new ResponseEntity<>(createdOrder, HttpStatus.CREATED);
    }
    // 檢索所有訂單項目的列表 /yahooInterview/api/orders
    @GetMapping
    public ResponseEntity<Collection<Order>> getAllOrders() {
    	System.out.println("getAllOrders");
        return new ResponseEntity<>(orderService.getAllOrders(), HttpStatus.OK);
    }
    // 檢索特定訂單項目的詳細信息 /yahooInterview/api/orders/{id}
    //  /yahooInterview/api/orders/1
    @GetMapping("/{id}")
    public ResponseEntity<Order> getOrderById(@PathVariable String id) {
    	System.out.println("getOrderById");
        Optional<Order> order = orderService.getOrderById(id);
        return order.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                    .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }
    // 更新特定訂單項目的內容 /yahooInterview/api/orders/{id}
//  {
//  "memId": "1",
//  "ordSubtotal": "123",
//  "ordTotal": "123",
//  "ordStatus": "0",
//  "ordRecipient": "leo",
//  "ordRecipientPhone": "0911123456",
//  "ordPayment": "1",
//  "ordDelivery": "1",
//  "ordAddress": "桃園"
//}
    @PutMapping("/{id}")
    public ResponseEntity<Order> updateOrder(@PathVariable String id, @RequestBody Order updatedOrder) {
    	System.out.println("updateOrder");
        Order order = orderService.updateOrder(id, updatedOrder);
        if (order != null) {
            return new ResponseEntity<>(order, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    // 刪除特定訂單項目 /yahooInterview/api/orders/{id}
    //  /yahooInterview/api/orders/2
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteOrder(@PathVariable String id) {
    	System.out.println("deleteOrder");
        if (orderService.deleteOrder(id)) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }  
}
