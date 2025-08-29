package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {


    @Autowired
    private OrderRepository orderRepository;


    public OrderEntity setOrderStaus(int orderId, OrderStatus orderStatus) {
        return orderRepository.setOrderStaus(orderId, orderStatus);
    }

    public OrderEntity getOrderById(int orderId) {
        return orderRepository.getOrderById(orderId);
    }

    public synchronized void createOrder(List<String> items) {
        orderRepository.createOrder(items);
    }

}
