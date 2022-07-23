package com.epam.spring.webprovider.service.model;

import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;

@Data
@Builder
public class Tariff {

    private Integer id;
    private String name;
    private String description;
    private BigDecimal price;
    private Category category;
}
