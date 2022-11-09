package com.epam.spring.webprovider.api;

import com.epam.spring.webprovider.controller.dto.OrderDTO;
import com.epam.spring.webprovider.controller.dto.group.OnCreate;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api(tags = "Orders management API")
@RequestMapping("api/v1/orders")
public interface OrderApi {

    @ApiImplicitParams({
            @ApiImplicitParam(name = "email", paramType = "path", required = true, value = "User Email")
    })
    @ApiOperation("Get users orders")
    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/{email}")
    List<OrderDTO> getOrdersByUserEmail(@PathVariable String email);

    @ApiOperation("Make order")
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    OrderDTO makeOrder(@RequestBody @Validated(OnCreate.class) OrderDTO orderDTO);

    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", paramType = "path", required = true, value = "Order ID")
    })
    @ApiOperation("Cancel order")
    @ResponseStatus(HttpStatus.OK)
    @PostMapping("/{id}/canceled")
    void cancelOrder(@PathVariable Integer id);

    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", paramType = "path", required = true, value = "Order ID")
    })
    @ApiOperation("Pay order")
    @ResponseStatus(HttpStatus.OK)
    @PostMapping("/{id}/paid")
    void payOrder(@PathVariable Integer id);
}
