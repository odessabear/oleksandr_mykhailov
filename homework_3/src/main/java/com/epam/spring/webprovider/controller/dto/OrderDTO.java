package com.epam.spring.webprovider.controller.dto;

import com.epam.spring.webprovider.service.model.OrderStatus;
import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.List;

@Data
@Builder
public class OrderDTO {

    private Integer id;

    private UserDTO userDTO;

    private List<TariffDTO> tariffDTOList;

    private BigDecimal orderCost;

    private Timestamp createDate;

    private Timestamp updateDate;

    private OrderStatus orderStatus;
}
