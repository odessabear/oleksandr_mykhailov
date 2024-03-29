package com.epam.spring.webprovider.service.mapper;

import com.epam.spring.webprovider.controller.dto.OrderDTO;
import com.epam.spring.webprovider.service.model.Order;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface OrderMapper {

    OrderMapper INSTANCE = Mappers.getMapper(OrderMapper.class);

    OrderDTO orderToOrderDTO(Order order);

    Order orderDTOToOrder(OrderDTO orderDTO);
}
