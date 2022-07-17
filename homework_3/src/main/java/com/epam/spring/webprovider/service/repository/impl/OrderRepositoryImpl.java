package com.epam.spring.webprovider.service.repository.impl;

import com.epam.spring.webprovider.service.model.Order;
import com.epam.spring.webprovider.service.repository.OrderRepository;
import org.springframework.stereotype.Repository;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Repository
public class OrderRepositoryImpl implements OrderRepository {
    private final List<Order> orderList = new ArrayList<>();

    @Override
    public Order getOrder(Integer id) {
        return orderList().stream()
                .filter(order -> order.getId().equals(id))
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Order doesn't exist!"));
    }

    @Override
    public List<Order> orderList() {
        return new ArrayList<>(orderList);
    }

    @Override
    public Order createOrder(Order order) {
        order.setCreateDate(Timestamp.valueOf(LocalDateTime.now()));
        order.setUpdateDate(Timestamp.valueOf(LocalDateTime.now()));
        order.setId(orderList.size() + 1);
        orderList.add(order);
        return order;
    }

    @Override
    public Order updateOrder(Integer id, Order order) {
        Order currentOrder = orderList.stream()
                .filter(o -> o.getId().equals(id))
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Order wasn't found"));
        orderList.remove(currentOrder);
        order.setCreateDate(currentOrder.getCreateDate());
        order.setId(currentOrder.getId());
        order.setUpdateDate(Timestamp.valueOf(LocalDateTime.now()));
        orderList.add(order);
        return order;
    }
}
