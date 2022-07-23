package com.epam.spring.webprovider.service.model;

import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.List;

@Data
@Builder
public class Order {

    private Integer id;
    private User user;
    private List<Tariff> tariffList;
    private BigDecimal orderCost;
    private Timestamp createDate;
    private Timestamp updateDate;
    private OrderStatus orderStatus;
}
