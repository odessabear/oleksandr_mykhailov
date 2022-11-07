package com.epam.spring.webprovider.controller;

import com.epam.spring.webprovider.controller.dto.OrderDTO;
import com.epam.spring.webprovider.controller.dto.group.OnCreate;
import com.epam.spring.webprovider.service.OrderService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/order")
@RequiredArgsConstructor
@Slf4j
public class OrderController {

    private final OrderService orderService;

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/{email}")
    public List<OrderDTO> getOrdersByUserEmail(@PathVariable String email) {
        log.info("get Tariffs by user email {}", email);
        return orderService.getOrdersByUserEmail(email);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public OrderDTO makeOrder(@RequestBody @Validated(OnCreate.class) OrderDTO orderDTO) {
        log.info(this.getClass().getSimpleName() + " makeOrder method");
        return orderService.makeOrder(orderDTO);
    }

    @ResponseStatus(HttpStatus.OK)
    @PostMapping("/{id}/canceled")
    public void cancelOrder(@PathVariable Integer id) {
        log.info("cancel order by id {}", id);
        orderService.cancelOrder(id);
    }

    @ResponseStatus(HttpStatus.OK)
    @PostMapping("/{id}/paid")
    public void payOrder(@PathVariable Integer id) {
        log.info("pay order by id {}", id);
        orderService.payOrder(id);
    }
}
