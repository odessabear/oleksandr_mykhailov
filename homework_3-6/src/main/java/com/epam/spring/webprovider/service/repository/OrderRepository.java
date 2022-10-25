package com.epam.spring.webprovider.service.repository;

import com.epam.spring.webprovider.service.model.Order;

import java.util.List;

public interface OrderRepository {
    Order getOrder(Integer id);

    List<Order> orderList();

    Order createOrder(Order order);

    Order updateOrder(Integer id, Order order);
}
