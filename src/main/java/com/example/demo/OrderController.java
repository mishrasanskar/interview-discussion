package com.example.demo;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController("order")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @PatchMapping ("update-status/{id}")
    public ResponseEntity<?> setOrderStaus(@RequestBody OrderStatus status, @PathVariable int id) {
        try{
            return new ResponseEntity(orderService.setOrderStaus(id, status), HttpStatus.CREATED);
        }
        catch (Exception e){
            return ResponseEntity.badRequest().build();
        }
    }

    @GetMapping("{orderId}")
    public OrderEntity getOrderById(@PathVariable int orderId) {
        return orderService.getOrderById(orderId);
    }



    @PostMapping("create")
    public synchronized void createOrder(@RequestBody List<String> items) {
        orderService.createOrder(items);
    }
}
