package com.epam.spring.webprovider.controller;

import com.epam.spring.webprovider.api.OrderApi;
import com.epam.spring.webprovider.controller.dto.OrderDTO;
import com.epam.spring.webprovider.service.OrderService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@Slf4j
public class OrderController implements OrderApi {

    private final OrderService orderService;

    public List<OrderDTO> getOrdersByUserEmail(String email) {
        log.info("get Tariffs by user email {}", email);
        return orderService.getOrdersByUserEmail(email);
    }

    public OrderDTO makeOrder(OrderDTO orderDTO) {
        log.info(this.getClass().getSimpleName() + " makeOrder method");
        return orderService.makeOrder(orderDTO);
    }

    public void cancelOrder(Integer id) {
        log.info("cancel order by id {}", id);
        orderService.cancelOrder(id);
    }

    public void payOrder(Integer id) {
        log.info("pay order by id {}", id);
        orderService.payOrder(id);
    }
}
