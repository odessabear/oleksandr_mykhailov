package com.epam.spring.webprovider.service;

import com.epam.spring.webprovider.controller.dto.OrderDTO;

import java.util.List;

public interface OrderService {

    List<OrderDTO> getOrdersByUserEmail(String email);

    OrderDTO makeOrder(OrderDTO orderDTO);

    void cancelOrder(Integer id);

    void payOrder(Integer id);
}
