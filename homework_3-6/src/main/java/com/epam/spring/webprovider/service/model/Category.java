package com.epam.spring.webprovider.service.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Category {

    private Integer id;
    private String name;
}
