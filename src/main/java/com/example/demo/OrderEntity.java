package com.example.demo;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.util.List;

enum OrderStatus{
    PLACED,
    CONFIRMED,
    CANCELLED
}

public class OrderEntity {
    private int orderID;
    private OrderStatus orderStatus;
    private List<String> items;


    public OrderEntity(int orderID, List<String> items) {
        this.orderID = orderID;
        this.orderStatus = OrderStatus.PLACED;
        this.items = items;
    }

    public int getOrderID() {
        return orderID;
    }

    public void setOrderID(int orderID) {
        this.orderID = orderID;
    }

    public OrderStatus getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(OrderStatus orderStatus) {
        this.orderStatus = orderStatus;
    }

    public List<String> getItems() {
        return items;
    }

    public void setItems(List<String> items) {
        this.items = items;
    }
}
