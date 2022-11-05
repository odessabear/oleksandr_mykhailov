package com.epam.spring.webprovider.controller.dto;

import com.epam.spring.webprovider.controller.dto.group.OnCreate;
import com.epam.spring.webprovider.controller.dto.group.OnUpdate;
import com.epam.spring.webprovider.service.constraints.Password;
import com.epam.spring.webprovider.service.model.Role;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;
import java.math.BigDecimal;

@Data
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class UserDTO {

    @NotNull(message = "Insert the role. This field shouldn't be empty", groups = OnCreate.class)
    private Role role;

    @NotBlank(message = "'login' shouldn't be empty", groups = {OnCreate.class, OnUpdate.class})
    private String login;

    @Email
    @Null(message = "'email' shouldn't be absent in request", groups = {OnUpdate.class})
    @NotBlank(message = "'email' shouldn't be empty", groups = {OnCreate.class})
    private String email;

    @Password(groups = OnCreate.class)
    @Null(message = "'password' should be absent in request", groups = OnUpdate.class)
    @NotBlank(message = "'password' shouldn't be empty", groups = OnCreate.class)
    private String password;

    @NotNull(message = "'accountState' shouldn't be empty", groups = {OnCreate.class, OnUpdate.class})
    private BigDecimal accountState;

    @Null(message = "'isBlocked' should be absent in request", groups = {OnCreate.class, OnUpdate.class})
    private Boolean isBlocked;
}
