package com.epam.spring.webprovider.service.model;

import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;

@Data
@Builder
public class User {

    private Integer id;
    private Role role;
    private String email;
    private String password;
    private BigDecimal accountState;
    private boolean isBlocked;
}
