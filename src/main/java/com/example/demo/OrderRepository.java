package com.example.demo;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Repository
public class OrderRepository {

    private Map<Integer, OrderEntity> orderStore = new ConcurrentHashMap<>();


    private static int id = 0;

    public OrderEntity setOrderStaus(int orderId, OrderStatus orderStatus) {

        OrderEntity existingOrder = orderStore.get(orderId);
        existingOrder.setOrderStatus(orderStatus);
        return existingOrder;
    }

    public OrderEntity getOrderById(int orderId) {
        return orderStore.get(orderId);
    }

    public synchronized void createOrder(List<String> items) {
        id+=1;
        OrderEntity newOrder = new OrderEntity(id, items);
        orderStore.put(id, newOrder);
    }

}
