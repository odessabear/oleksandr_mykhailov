package com.epam.spring.webprovider.controller.dto;

import com.epam.spring.webprovider.service.model.Role;
import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;

@Data
@Builder
public class UserDTO {

    private Role role;

    private String email;

    private BigDecimal accountState;

    private boolean isBlocked;
}
